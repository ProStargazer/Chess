package Game;

import java.util.Scanner;

import Chess.King;
import Chess.Piece;

public class Game {
	private Scanner user_input;
	private static String currentPlayer;

	public static void main(String[] args) {
		boolean game = true;
		Board gameBoard = new Board();
		gameBoard.initBoard();
		gameBoard.mapBoard();
		currentPlayer = "White";
		while (game) {
			printBoard(gameBoard);
			game = false;
		}
	}

	public static void printBoard(Board gameBoard) {
		for (int i = 0; i < gameBoard.returnSize(); i++) {
			for (int j = 0; j < gameBoard.returnSize(); j++) {
				if (gameBoard.getBox(j, i).getPiece() != null) {
					System.out.print("|"
							+ gameBoard.getBox(j, i).getPiece().getName() + "-"
							+ gameBoard.getBox(j, i).getPiece().getPlayer());
				} else {
					System.out.print("|       ");
				}
			}
			System.out.println("|");
		}

	}

	public void move(Board gameBoard) {
		user_input = new Scanner(System.in);
		boolean move = true;
		start: while (move) {
			System.out.println("It is " + getCurrentPlayer() + " turn!");
			System.out
					.println("Please enter the co-ordinates of the piece you want to move!");
			System.out.println("X: ");
			int fromX = user_input.nextInt();
			System.out.println("Y: ");
			int fromY = user_input.nextInt();
			if (gameBoard.getBox(fromX, fromY).getPiece().getPlayer() != currentPlayer) {
				System.out.println("This is not your piece, please try again");
				continue start;
			}
			System.out
					.println("Please enter the co-ordinates of the square you want to move to!");
			System.out.println("X: ");
			int toX = user_input.nextInt();
			System.out.println("Y: ");
			int toY = user_input.nextInt();
			if(moveCheck(gameBoard, fromX, fromY, toX, toY)){
				
				
			}
			//begin move validation
			
		}

	}
	public boolean moveCheck(Board gameBoard, int fromX, int fromY, int toX,
			int toY){
		Piece selected = gameBoard.getBox(fromX, fromY).getPiece();
		boolean validMove = selected.isValid(gameBoard, fromX, fromY, toX, toY);
		boolean inCheck = .check(gameBoard);
		
		return true;
	}
	
	public String getCurrentPlayer() {
		return currentPlayer;
	}

}
