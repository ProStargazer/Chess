package Chess;

import Game.Board;

//import Game.*;
public class Knight extends Piece {

	public Knight(String Player) {
		super(Player);
		this.setName("K");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (toX == fromX && toY == fromY) {

			return false; // cannot move nothing
		}
		if (toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7
				|| fromY < 0 || fromY > 7) {

			return false;
		}
		if ((Math.abs(toX - fromX) == Math.abs((toY - fromY)+1)) && Math.abs(toY - fromY) == 2) {
			return true;
		}
		if ((Math.abs(toY - fromY) == Math.abs((toX - fromX)+1)) && Math.abs(toX - fromX) == 2){
			return true;
		}
		if ((Math.abs(toX - fromX) == Math.abs((fromY - toY)+1)) && Math.abs(toY - fromY) == 2) {
			return true;
		}
		if ((Math.abs(toY - fromY) == Math.abs((fromX - toX)+1)) && Math.abs(toX - fromX) == 2){
			return true;
		}
		return false;
	}

}
