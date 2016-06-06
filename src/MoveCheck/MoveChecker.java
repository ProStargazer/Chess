package MoveCheck;

import Chess.Piece;
import Game.Board;

public class MoveChecker{
	private String Player;
	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private Board gameBoard;
	private Piece piece;
	
	public void moveChecker(Piece piece, String Player, Board gameBoard, int fromX, int fromY, int toX, int toY){
		this.Player = Player;
		this.toX  = toX;
		this.toY = toY;
		this.fromX = fromX;
		this.fromY = fromY;
		this.gameBoard = gameBoard;
		
		blockedMove(gameBoard,fromX,fromY,toX,toY);
	}
}
