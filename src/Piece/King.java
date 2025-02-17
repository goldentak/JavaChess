package Piece;

public class King extends Piece{
    int x; int y;
    public King(int x, int y, String type, int team){
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
            case "WK":
                System.out.print("♔");
                break;
            case "BK":
                System.out.print("♚");
                break;
        }
    }

    public int getTeam(){
        return this.team;
    }
    @Override
//    public boolean canMove(int x, int y){
//
//        if((this.x == x - 1 || this.x == x + 1) || (this.y == y - 1 || this.y == y + 1) && !(this.x == x && this.y == y)){
//            this.x = x;
//            this.y = y;
//            moves++;
//            return true;
//        }
//        return false;
//    }
    public boolean canMove(int x, int y, int enemyIndex){

        if(enemyIndex == 2) return false;

        if((this.y == y - 1 || this.y == y + 1) || (this.x == x - 1 || this.x == x + 1) && !(this.y == y && this.x == x)){
            this.y = y;
            this.x = x;
            moves++;
            return true;
        }
        return false;
    }

}