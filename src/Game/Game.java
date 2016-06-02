package Game;

public class Game {
	public static void main(String[] args) {
		Board gameBoard = new Board();
		gameBoard.initBoard();
		gameBoard.mapBoard();

		for (int i = 0; i < gameBoard.returnSize(); i++) {
			for (int j = 0; j < gameBoard.returnSize(); j++) {
				if(gameBoard.getBox(j, i).piece != null){
				System.out.print("|"+gameBoard.getBox(j, i).piece.getName()+"-"+gameBoard.getBox(j, i).piece.Player);
			}else{
				System.out.print("| ");
			}
			}
			System.out.println("|");
		}
	}
}
