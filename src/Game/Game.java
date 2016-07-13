package Game;

import java.util.Scanner;

import Chess.Piece;

public class Game {
	private Scanner user_input;
	private String currentPlayer;

	public static void main(String[] args) {
		Game runGame = new Game();
		Board gameBoard = new Board();
		gameBoard.initBoard();
		runGame.move(gameBoard);

	}

	public void printBoard(Board gameBoard) {
		System.out.println("");
		for (int i = 0; i < gameBoard.returnSize(); i++) {
			for (int j = 0; j < gameBoard.returnSize(); j++) {
				if (gameBoard.getBox(j, i).getPiece() != null) {
					System.out.print("|"
							+ gameBoard.getBox(j, i).getPiece().getName()
							+ "-"
							+ gameBoard.getBox(j, i).getPiece().getPlayer()
									.substring(0, 1));
				} else {
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("");

	}

	public void move(Board gameBoard) {
		setCurrentPlayer("White");
		int wX = gameBoard.getwKingX();
		int wY = gameBoard.getwKingY();
		int bX = gameBoard.getbKingX();
		int bY = gameBoard.getbKingY();
		boolean check = false;
		int kX;
		int kY;
		user_input = new Scanner(System.in);
		boolean gameOver = true;
		start: while (gameOver) {
			printBoard(gameBoard);
			System.out.println("It is " + getCurrentPlayer() + "'s turn!");
			if (check) {
				System.out.println("You are currently in check!");
			}
			System.out
					.println("Please enter the co-ordinates of the piece you want to move!");
			System.out.print("X: ");
			int fromX = user_input.nextInt();
			System.out.print("Y: ");
			int fromY = user_input.nextInt();
			if (gameBoard.getBox(fromX, fromY).getPiece() == null) {
				System.out
						.println("This is an empty space, please select one of your pieces.");
				continue start;
			} else if (gameBoard.getBox(fromX, fromY).getPiece().getPlayer() != getCurrentPlayer()) {
				System.out.println("This is not your piece, please try again.");
				continue start;
			}
			System.out
					.println("Please enter the co-ordinates of the square you want to move to!");
			System.out.print("X: ");
			int toX = user_input.nextInt();
			System.out.print("Y: ");
			int toY = user_input.nextInt();
			if (getCurrentPlayer() == "White") {
				kX = wX;
				kY = wY;
			} else {
				kX = bX;
				kY = bY;
			}
			// begin move validation
			if (!moveLogic(gameBoard, fromX, fromY, toX, toY, kX, kY, check)) {
				System.out.println("failed at logic");
				continue start;
			} else {
				if (currentPlayer == "White") {
					if (gameBoard.getBox(bX, bY).getPiece()
							.check(gameBoard, bX, bY)) {
						check = true;
					} else {
						check = false;
					}
					currentPlayer = "Black";
				} else {
					if (gameBoard.getBox(wX, wY).getPiece()
							.check(gameBoard, wX, wY)) {
						check = true;
					} else {
						check = false;
					}
					currentPlayer = "White";
				}

			}
			// need checkmate/stalemate check here
			continue start;

		}

	}

	public boolean moveLogic(Board gameBoard, int fromX, int fromY, int toX,
			int toY, int kX, int kY, boolean check) {
		Piece selected = gameBoard.getBox(fromX, fromY).getPiece();
		if (!selected.isValid(gameBoard, fromX, fromY, toX, toY)) {
			// check for truth to continue, else return to piece selection
			System.out
					.println("Invalid move: Piece moving outside board or blocked! Please select the piece again.");
			return false;
		}
		// can't take same colour
		if (gameBoard.getBox(toX, toY).getPiece() != null) {
			if (gameBoard.getBox(toX, toY).getPiece().getPlayer() == currentPlayer) {
				System.out
						.println("You selected to move to a place occupied by your piece, please select again.");
				return false;
			}
		}
		if (check) {
			// check true
			Piece tempFrom = gameBoard.getBox(fromX, fromY).releaseBox();
			Piece tempTo = gameBoard.getBox(toX, toY).releaseBox();
			gameBoard.getBox(toX, toY).occupyBox(tempFrom);
			if (gameBoard.getBox(kX, kY).getPiece().check(gameBoard, kX, kY)) {
				System.out
						.println("Invalid move: Your King is in check, and this move doesn't remove it! Please select again.");
				gameBoard.getBox(fromX, fromY).occupyBox(tempFrom);
				gameBoard.getBox(toX, toY).occupyBox(tempTo);
				return false;
			}
		} else {// valid move, commit move
			gameBoard.getBox(toX, toY).occupyBox(
					gameBoard.getBox(fromX, fromY).releaseBox());
		}
		// promocheck

		return true;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
