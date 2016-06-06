package MoveCheck;

import Game.*;

public class BlockedMove{// extends MoveChecker {
	public boolean blockedMove(Board gameBoard, int fromX, int fromY, int toX,
			int toY) {
		int iX;
		int iY;
		// Axial Movement checks
		// Horizontal-Left
		if ((toX - fromX < 0) && toY == fromY) {
			for (int i = fromX - 1; i > toX; i--) {
				if (gameBoard.getBox(i, toY).isOccupied()) {
					return true;
				}
			}
		}
		// Horizontal-Right
		if ((toX - fromX > 0) && toY == fromY) {
			for (int i = fromX + 1; i < toX; i++) {
				if (gameBoard.getBox(i, toY).isOccupied()) {
					return true;
				}
			}
		}
		// Vertical-Up
		if ((toY - fromY < 0) && toX == fromX) {
			for (int i = fromY - 1; i > toY; i--) {
				if (gameBoard.getBox(toX, i).isOccupied()) {
					return true;
				}
			}
		}
		// Vertical-Down
		if ((toX - fromX > 0) && toY == fromY) {
			for (int i = fromY + 1; i < toY; i++) {
				if (gameBoard.getBox(toX, i).isOccupied()) {
					return true;
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
					return true;
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
					return true;
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
					return true;
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
					return true;
				} else {
					iX++;
					iY++;
				}
			}
		}
		return false;
	}
}
