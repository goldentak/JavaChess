package Piece;
import java.lang.Math;
public class Knight extends Piece{
    int x; int y;
    public Knight(int x, int y, String type, int team){
        this.x = x;
        this.y = y;
        this.type = type;
        this.moves = 0;
        this.team = team;
    }
    int team = 0;

    public void setPos(int x, int y){
        super.setPos(x, y);
    };

    public void render(){
        switch(this.type){
            case "WN":
                System.out.print("♘");

                break;
            case "BN":
                System.out.print("♞");

                break;
        }
    }

    public int getTeam(){
        return this.team;
    }
    @Override
//    public boolean canMove(int x, int y){
//
//        if((Math.abs(x - this.x) == 2 && Math.abs(y - this.y) == 1) || (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 1)){
//            this.x = x;
//            this.y = y;
//            moves++;
//            return true;
//        }
//        return false;
//    }
    public boolean canMove(int x, int y, int enemyIndex){

        if(enemyIndex == 2) return false;

        if((Math.abs(y - this.y) == 2 && Math.abs(x - this.x) == 1) || (Math.abs(y - this.y) == 1 && Math.abs(x - this.x) == 1)){
            this.y = y;
            this.x = x;
            moves++;
            return true;
        }
        return false;
    }

}