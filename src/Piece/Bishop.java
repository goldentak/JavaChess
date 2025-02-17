package Piece;

public class Bishop extends Piece{
    int x; int y;
    public Bishop(int x, int y, String type, int team){
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
            case "WB":
                System.out.print("♗");
                this.team = 1;
                break;
            case "BB":
                System.out.print("♝");
                this.team = 2;
                break;
        }
    }
    public int getTeam(){
        return this.team;
    }
    @Override
//    public boolean canMove(int x, int y){
//
//        if(((this.x - x  == this.y - y) || (this.x + x  == this.y + y)) && !(this.x == x && this.y == y)){
//            this.x = x;
//            this.y = y;
//            moves++;
//            return true;
//        }
//        return false;
//    }
    public boolean canMove(int x, int y, int enemyIndex){

        if(enemyIndex == 2) return false;

        if(Math.abs(this.x - x) == Math.abs(this.y - y) && !(this.x == x && this.y == y)){
            this.x = x;
            this.y = y;
            moves++;
            return true;
        }
        return false;
    } // abs added, condition replaced
}
