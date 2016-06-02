package Chess;
//import Game.*;
import Game.Board;

public class Piece {
	private int x;
	private int y;
	private String name;
	public String Player;
	private boolean inPlay;

	public Piece(int x, int y, String Player) {
		this.x = x;
		this.y = y;
		this.Player = Player;
		this.inPlay = false;
	}

	public int getX() {
		return x;
	}
	public void setX(int x){
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public boolean getInPlay(){
		return inPlay;
	}

	public String getName() {
		return name;
	}
	
	public void setPlay(boolean inPlay){
		this.inPlay = true;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isValid(Board gameboard, int fromX, int fromY, int toX, int toY){
        if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false;
        return true;
    }

}
