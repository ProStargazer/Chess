package Chess;

import Game.Board;

//import Game.*;
public class Pawn extends Piece {

	public Pawn(int x, int y, String Player) {
		super(x, y, Player);

		this.setName("P");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;
		if (this.getPlayer() == "White" && (toY - fromY == 1)) {
			return true;
		}
		if (this.getPlayer() == "Black" && (toY - fromY == -1)) {
			return true;
		}
		return false;
	}

	public boolean promoCheck(int toX, int toY) {
		if ((this.getPlayer() == "White" && toY == 0)) {
			return true;
		}
		if ((this.getPlayer() == "Black" && toY == 7)) {
			return true;
		}
		return false;
	}
	

}
