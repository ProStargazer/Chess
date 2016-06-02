package Chess;

import Game.Board;

//import Game.*;
public class Bishop extends Piece{

	public Bishop(int x, int y, String Player) {
		super(x, y, Player);
		this.setName("B");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;
		if (toX - fromX == toY - fromY) {
			return true;
		}
		return false;
	}

}
