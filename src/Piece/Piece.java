package Piece;

public abstract class Piece{
    protected String type = null;
    protected int moves;
    protected int x;
    protected int y;
    protected int team = -1;
    public boolean canMove(int x, int y, int enemyIndex){
        return false;
    }

    public String getType(){
        return type;
    }

    public abstract void render();

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;

    };

    public int getTeam(){
        return this.team;
    }

    public int getMoves(){
        return this.moves;
    }
}
