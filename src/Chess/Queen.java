package Chess;

import Game.Board;

//import Game.*;
public class Queen extends Piece {

	public Queen(String Player) {
		super(Player);
		this.setName("Q");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;

		if (Math.abs(toX - fromX) == Math.abs(toY - fromY)) {
			return true;
		}
		if (toX == fromX || toY == fromY) {
			return true;
		}
		return false;
	}
}
