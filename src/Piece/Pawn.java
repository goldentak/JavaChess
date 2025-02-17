package Piece;

public class Pawn extends Piece{
    int x; int y;
    int sign;
    public Pawn(int x, int y, String type, int team){
        this.x = x;
        this.y = y;
        this.type = type;
        this.moves = 0;
        this.team = team;
    }

    public int getTeam(){
        return this.team;
    }
    public void setPos(int x, int y){
        super.setPos(x, y);
    };

    int team = 0;


    public void render(){
        switch(this.type){
            case "WP":
                System.out.print("♙");
                this.sign = 1;
                break;
            case "BP":
                System.out.print("♟");
                this.sign = -1;
                break;
        }
    }

    @Override
//    public boolean canMove(int x, int y){
//        if((this.x == x - sign) && this.y == y){
//            this.x = x;
//            this.y = y;
//            moves++;
//            return true;
//        }
//        if(moves == 0 && (this.x == x - 2*sign) && this.y == y){
//            this.x = x;
//            this.y = y;
//            moves ++;
//            return true;
//        }
//        return false;
//    }
    public boolean canMove(int x, int y, int enemyIndex){

        if(enemyIndex == 2) return false;

        if((this.y == y + sign) && this.x == x){
            this.y = y;
            this.x = x;
            moves++;
            return true;
        }
        if(moves == 0 && (this.y == y + 2*sign) && this.x == x){
            this.y = y;
            this.x = x;
            moves++;
            return true;
        }
        return false;
    }

}
