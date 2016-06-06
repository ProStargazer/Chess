package Game;

import Chess.*;

public class Box {
	int x;
	int y;
	Piece piece;

	public Box(int x, int y) {
		this.x = x;
		this.y = y;
		piece = null;
	}

	public void occupyBox(Piece piece) {
		if (this.piece != null) {
			this.piece.setPlay(true);
		}
		this.piece = piece;
	}

	public boolean isOccupied() {
		if (piece != null) {
			return true;
		}
		return false;
	}

	public Piece releaseBox() {
		Piece releasedPiece = this.piece;
		this.piece = null;
		return releasedPiece;
	}
}