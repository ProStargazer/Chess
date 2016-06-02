package Game;

//import Chess.*;
import java.util.*;

import Chess.Bishop;
import Chess.King;
import Chess.Knight;
import Chess.Pawn;
import Chess.Piece;
import Chess.Queen;
import Chess.Rook;

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
			piecePos.add(new Pawn(i, 1, "White"));
		}
		piecePos.add(new Queen(3, 0, "White"));
		piecePos.add(new King(4, 0, "White"));
		piecePos.add(new Knight(1, 0, "White"));
		piecePos.add(new Knight(6, 0, "White"));
		piecePos.add(new Bishop(2, 0, "White"));
		piecePos.add(new Bishop(5, 0, "White"));
		piecePos.add(new Rook(0, 0, "White"));
		piecePos.add(new Rook(7, 0, "White"));

		for (int i = 0; i < 8; i++) {
			piecePos.add(new Pawn(i, 6, "Black"));
		}
		piecePos.add(new Queen(4, 7, "Black"));
		piecePos.add(new King(3, 7, "Black"));
		piecePos.add(new Knight(1, 7, "Black"));
		piecePos.add(new Knight(6, 7, "Black"));
		piecePos.add(new Bishop(2, 7, "Black"));
		piecePos.add(new Bishop(5, 7, "Black"));
		piecePos.add(new Rook(0, 7, "Black"));
		piecePos.add(new Rook(7, 7, "Black"));

	}
	
	
	public void mapBoard(){
		for(int i = 0; i < piecePos.size(); i++)
	getBox(piecePos.get(i).getX(), piecePos.get(i).getY()).occupyBox(piecePos.get(i));
	}
}