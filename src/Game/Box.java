package Game;

import Chess.*;

public class Box {
	int x;
	int y;
	private Piece piece;

	public Box(int x, int y) {
		this.x = x;
		this.y = y;
		setPiece(null);
	}

	public void occupyBox(Piece piece) {		
		this.setPiece(piece);
	}

	public boolean isOccupied() {
		if (getPiece() != null) {
			return true;
		}
		return false;
	}

	public Piece releaseBox() {
		Piece releasedPiece = this.getPiece();
		this.setPiece(null);
		return releasedPiece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}