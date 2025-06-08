import java.util.Scanner;

/**
 *
 * @author Brandon Gray
 * Project Deliverable 2
 * Connect4 Console UI Class - extends Connect4 Game Logic
 *
 */
public class Connect4TextConsole extends Connect4Logic {

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	char[][] board = new char[6][8];

	/*
	 * Creates empty String spaces
	 * to display on board with 'gameDisplay' method.
	 */
	for (int row = 0; row < board.length; row++) {
	    for (int column = 0; column < board[0].length; column++) {
		board[row][column] = ' ';
	    }
	}

	boolean playerWon = false;
	char player = 'X';

	while (playerWon == false) {

	    boolean validMove; //Checks if the chosen index piece location is empty
	    int playerPiece;
	    do {
		System.out.println("Player" + player + "-your turn."
		+ " Choose a column number from 1-7 \n");
		gameDisplay(board);
		playerPiece = in.nextInt();
		validMove = checkBoard(playerPiece, board);

	    } while (validMove == false);

	    for (int row = board.length - 1; row >= 0; row--) {
		if (board[row][playerPiece] == ' ') {
		    board[row][playerPiece] = player;
		    break;
		}
	    }

	    playerWon = checkWin(player, board);

	    if (player == 'X') {
		player = 'O';
	    } else {
		player = 'X';
	    }
	}

	/*
	 * Displays board after 4 concurrent
	 * pieces have been placed
	 */
	gameDisplay(board);

	if (playerWon == true) {
	    if (player == 'X') {
		System.out.println("Player O Won the Game");
	    } else {
		System.out.println("Player X Won the Game");
	    }
	}
    }

}
