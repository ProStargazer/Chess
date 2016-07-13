package Chess;

import Game.Board;

//import Game.*;
public class King extends Piece {


	public King(String Player) {
		super(Player);
		this.setName("W");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (super.isValid(gameBoard, fromX, fromY, toX, toY) == false)
			return false;

		if ((Math.sqrt(Math.pow(Math.abs(toX - fromX), 2)
				+ Math.pow(Math.abs(toY - fromY), 2)) == Math.sqrt(2))
				|| (Math.abs(toX - fromX) == 1) && toY == fromY
				|| (Math.abs(toY - fromY) == 1) && toX == fromX) {
			return true;
		}
		return false;
	}
	//check for check on king
	@Override
	public boolean check(Board gameBoard, int kX, int kY) {
		for (int i = 0; i < gameBoard.returnSize(); i++) {
			for (int j = 0; j < gameBoard.returnSize(); j++) {
				if (gameBoard.getBox(j, i).getPiece() != null
						&& gameBoard.getBox(j, i).getPiece().getPlayer() != this
								.getPlayer()) {
					if (gameBoard.getBox(j, i).getPiece()
							.isValid(gameBoard, j, i, kX, kY)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
