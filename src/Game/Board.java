package Game;

import Chess.*;

public class Board {
	private int wKingX;
	private int wKingY;
	private int bKingX;
	private int bKingY;

	private Box[][] board = new Box[8][8];

	public Board() {
		setwKingX(4);
		setwKingY(7);
		setbKingX(4);
		setbKingY(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = new Box();
			}
		}
	}

	public Box getBox(int x, int y) {
		return board[x][y];
	}

	public int returnSize() {
		return board.length;
	}

	public void initBoard() {
		//for (int i = 0; i < 8; i++) {
		//	getBox(i, 6).occupyBox(new Pawn("White"));

		//}
		getBox(3, 7).occupyBox(new Queen("White"));
		getBox(4, 7).occupyBox(new King("White"));
		getBox(1, 7).occupyBox(new Knight("White"));
		getBox(6, 7).occupyBox(new Knight("White"));
		getBox(2, 7).occupyBox(new Bishop("White"));
		getBox(5, 7).occupyBox(new Bishop("White"));
		getBox(0, 7).occupyBox(new Rook("White"));
		getBox(7, 7).occupyBox(new Rook("White"));

	//	for (int i = 0; i < 8; i++) {
		//	getBox(i, 1).occupyBox(new Pawn("Black"));

	//	}
		getBox(3, 0).occupyBox(new Queen("Black"));
		getBox(4, 0).occupyBox(new King("Black"));
		getBox(1, 0).occupyBox(new Knight("Black"));
		getBox(6, 0).occupyBox(new Knight("Black"));
		getBox(2, 0).occupyBox(new Bishop("Black"));
		getBox(5, 0).occupyBox(new Bishop("Black"));
		getBox(0, 0).occupyBox(new Rook("Black"));
		getBox(7, 0).occupyBox(new Rook("Black"));
	}

	public int getwKingX() {
		return wKingX;
	}

	public void setwKingX(int wKingX) {
		this.wKingX = wKingX;
	}

	public int getwKingY() {
		return wKingY;
	}

	public void setwKingY(int wKingY) {
		this.wKingY = wKingY;
	}

	public int getbKingX() {
		return bKingX;
	}

	public void setbKingX(int bKingX) {
		this.bKingX = bKingX;
	}

	public int getbKingY() {
		return bKingY;
	}

	public void setbKingY(int bKingY) {
		this.bKingY = bKingY;
	}

}