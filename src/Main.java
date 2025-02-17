import java.util.Scanner;
import Piece.Piece;
import Piece.Rook;
import Piece.King;
import Piece.Knight;
import Piece.Queen;
import Piece.Bishop;
import Piece.Pawn;

public class Main {
    public static void main(String[] args) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        Piece[][] board = new Piece[8][8];
        board[0][0] = new Rook(0, 0, "BR", 1);
        board[0][1] = new Knight(1, 0, "BN", 1);
        board[0][2] = new Bishop(2, 0, "BB", 1);
        board[0][3] = new Queen(3, 0, "BQ", 1);
        board[0][4] = new King(4, 0, "BK", 1);
        board[0][5] = new Bishop(5, 0, "BB", 1);
        board[0][6] = new Knight(6, 0, "BN", 1);
        board[0][7] = new Rook(7, 0, "BR", 1);

        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(col, 1, "BP", 1); // Black Pawns
            board[6][col] = new Pawn(col, 6, "WP", 0); // White Pawns
        }

        board[7][0] = new Rook(0, 7, "WR", 0);
        board[7][1] = new Knight(1, 7, "WN", 0);
        board[7][2] = new Bishop(2, 7, "WB", 0);
        board[7][3] = new Queen(3, 7, "WQ", 0);
        board[7][4] = new King(4, 7, "WK", 0);
        board[7][5] = new Bishop(5, 7, "WB", 0);
        board[7][6] = new Knight(6, 7, "WN", 0);
        board[7][7] = new Rook(7, 7, "WR", 0);

        // logic (below)
        int cntMove = 0;



        while(true) {

            System.out.println("A  B  C  D  E  F  G  H");
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(board[i][j] == null) {
                        if(i % 2 == j % 2){
                            System.out.print("\u25A0  ");
                        }
                        else {
                            System.out.print("\u25A2  ");
                        }
                    }
                    else {
                         board[i][j].render();
                         System.out.print("  ");
                    }

                }
                System.out.print(i + 1);
                System.out.println("");
            }
            System.out.println("A  B  C  D  E  F  G  H");
            String from = scanner.next();
            String to = scanner.next();
            int enemyIndex = 0; //0 - null, 1 - enemy, 2 - teammate
            try {
                int x1 = from.charAt(0) - 96 - 1;
                int y1 = from.charAt(1) - '0' - 1;

                int x2 = to.charAt(0) - 96 - 1;
                int y2 = to.charAt(1) - '0' - 1;
                System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

                if(board[y2][x2] == null) {
                    enemyIndex = 0;
                }
                else if(board[y1][x1].getTeam() != board[y2][x2].getTeam()){
                    enemyIndex = 1;
                }
                else if(board[y1][x1].getTeam() == board[y2][x2].getTeam()){
                    enemyIndex = 2;
                }


                if ((0 <= x1 && x1 < 8 && 0 <= y1 && y1 < 8) && (0 <= x2 && x2 < 8 && 0 <= y2 && y2 < 8)) {
                    boolean canMove = board[y1][x1] != null && board[y1][x1].canMove(x2, y2, enemyIndex) && (cntMove % 2 ==  board[y1][x1].getTeam());
                    boolean castling = board[y1][x1].getType().charAt(1) == 'K' && board[y2][x2].getType().charAt(1) == 'R' && board[y2][x2].getMoves() == 0 && board[y1][x1].getMoves() == 0;

                    if(castling){
                        int k = (y1 > y2) ? -1 : 1;
                        for (int i = y1 + k; i != y2; i += k) {
                            if(board[i][x1] != null) castling = false;
                        }
                    }

                    System.out.println(canMove);
                    if (canMove) {
                        board[y2][x2] = board[y1][x1];
                        board[y1][x1] = null;
                        cntMove++;
                        System.out.println("Piece moved");
                    }

                } else {
                    System.out.println("Coordinates out of bounds");
                }
            } catch (NullPointerException e) {
                System.out.println("Error: seems, one of cells of the board is empty. Check initial data.");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("There was an unexpected error: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }
}