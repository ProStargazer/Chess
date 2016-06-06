package Chess;

import Game.Board;

//import Game.*;
public class King extends Piece {

	public King(int x, int y, String PieceColour) {
		super(x, y, PieceColour);
		this.setName("K");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;

		if ((Math.sqrt(Math.pow(Math.abs((toX - fromX)), 2)
				+ Math.pow(Math.abs((toY - fromY)), 2)) == Math.sqrt(2))
				|| (Math.abs(toX - fromX) == 1 && toY == fromY)
				|| (Math.abs(toY - fromY) == 1) && toY == fromY) {
			return true;
		}
		return false;
	}

}
