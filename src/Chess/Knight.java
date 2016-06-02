package Chess;

import Game.Board;

//import Game.*;
public class Knight extends Piece {

	public Knight(int x, int y, String Player) {
		super(x, y, Player);
		this.setName("N");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;

		if ((Math.abs(toX - fromX) == Math.abs((toY - fromY)+1)) && Math.abs(toX - fromX) == 2) {
			return true;
		}
		if ((Math.abs(toY - fromY) == Math.abs((toX - fromX)+1)) && Math.abs(toY - fromY) == 2){
			return true;
		}
		return false;
	}

}
