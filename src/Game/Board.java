package Game;

import Chess.*;
import java.util.*;



public class Board{
private List<Piece> piecePos = new ArrayList<>();
private Box[][] board = new Box[8][8];
public Board() {
	
	for(int i=0; i <board.length; i++){
		for(int j=0; j<board.length; j++){
			this.board[i][j] = new Box(i, j);
		}
	}
}
	public Box getBox(int x, int y) {
		return board[x][y];
	}
	public int returnSize(){
		return board.length;
	}
	
	public void initBoard(){
		for (int i = 0; i < 8; i++) {
			getPiecePos().add(new Pawn(i, 6, "White"));
			
		}
		getPiecePos().add(new Queen(3, 7, "White"));
		getPiecePos().add(new King(4, 7, "White"));
		getPiecePos().add(new Knight(1, 7, "White"));
		getPiecePos().add(new Knight(6, 7, "White"));
		getPiecePos().add(new Bishop(2, 7, "White"));
		getPiecePos().add(new Bishop(5, 7, "White"));
		getPiecePos().add(new Rook(0, 7, "White"));
		getPiecePos().add(new Rook(7, 7, "White"));

		for (int i = 0; i < 8; i++) {
			getPiecePos().add(new Pawn(i, 1, "Black"));
		}
		getPiecePos().add(new Queen(4, 0, "Black"));
		getPiecePos().add(new King(3, 0, "Black"));
		getPiecePos().add(new Knight(1, 0, "Black"));
		getPiecePos().add(new Knight(6, 0, "Black"));
		getPiecePos().add(new Bishop(2, 0, "Black"));
		getPiecePos().add(new Bishop(5, 0, "Black"));
		getPiecePos().add(new Rook(0, 0, "Black"));
		getPiecePos().add(new Rook(7, 0, "Black"));

	}
	
	
	public void mapBoard(){
		for(int i = 0; i < getPiecePos().size(); i++)
	getBox(getPiecePos().get(i).getX(), getPiecePos().get(i).getY()).occupyBox(getPiecePos().get(i));
	}
	
	public List<Piece> getPiecePos() {
		return piecePos;
	}
	
	public void setPiecePos(List<Piece> piecePos) {
		this.piecePos = piecePos;
	}
}