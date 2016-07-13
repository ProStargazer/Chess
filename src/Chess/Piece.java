package Chess;

//import Game.*;
import Game.Board;

public class Piece {
	private int x;
	private int y;
	private String name;
	private String Player;

	public Piece(int x, int y, String Player) {
		this.x = x;
		this.y = y;
		this.setPlayer(Player);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public String getPlayer() {
		return Player;
	}

	public void setPlayer(String player) {
		Player = player;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		if (toX == fromX && toY == fromY)
			return false; // cannot move nothing
		if (toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7
				|| fromY < 0 || fromY > 7)
			return false;
		int iX;
		int iY;
		// Axial Movement checks
		// Horizontal-Left
		if ((toX - fromX < 0) && toY == fromY) {
			for (int i = fromX - 1; i > toX; i--) {
				if (gameBoard.getBox(i, toY).isOccupied()) {
					return false;
				}
			}
		}
		// Horizontal-Right
		if ((toX - fromX > 0) && toY == fromY) {
			for (int i = fromX + 1; i < toX; i++) {
				if (gameBoard.getBox(i, toY).isOccupied()) {
					return false;
				}
			}
		}
		// Vertical-Up
		if ((toY - fromY < 0) && toX == fromX) {
			for (int i = fromY - 1; i > toY; i--) {
				if (gameBoard.getBox(toX, i).isOccupied()) {
					return false;
				}
			}
		}
		// Vertical-Down
		if ((toX - fromX > 0) && toY == fromY) {
			for (int i = fromY + 1; i < toY; i++) {
				if (gameBoard.getBox(toX, i).isOccupied()) {
					return false;
				}
			}
		}
		// Diagonal Movement Checks
		// Diagonal-UpLeft
		if (toX - fromX < 0 && toY - fromY < 0) {
			iX = fromX - 1;
			iY = fromY - 1;
			while (iX > toX) {
				if (gameBoard.getBox(iX, iY).isOccupied()) {
					return false;
				} else {
					iX--;
					iY--;
				}
			}
		}
		// Diagonal-UpRight
		if (toX - fromX > 0 && toY - fromY < 0) {
			iX = fromX + 1;
			iY = fromY - 1;
			while (iX < toX) {
				if (gameBoard.getBox(iX, iY).isOccupied()) {
					return false;
				} else {
					iX++;
					iY--;
				}
			}
		}
		// Diagonal-DownLeft
		if (toX - fromX < 0 && toY - fromY > 0) {
			iX = fromX - 1;
			iY = fromY + 1;
			while (iX > toX) {
				if (gameBoard.getBox(iX, iY).isOccupied()) {
					return false;
				} else {
					iX--;
					iY++;
				}
			}
		}
		// Diagonal-DownRight
		if (toX - fromX > 0 && toY - fromY > 0) {
			iX = fromX + 1;
			iY = fromY + 1;
			while (iX < toX) {
				if (gameBoard.getBox(iX, iY).isOccupied()) {
					return false;
				} else {
					iX++;
					iY++;
				}
			}
		}
		return true;
	}

}
