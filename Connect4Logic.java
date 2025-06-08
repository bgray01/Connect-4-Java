/**
 *
 * @author Brandon Gray
 * Project Deliverable 2
 * Connect4 Game Logic Class
 *
 */
public class Connect4Logic {
/*
 * Logic class for Connect4 game. Contains methods for
 * program logic and board display.
 */
    public static void gameDisplay(char[][] board) {

	for(int row = 0; row < board.length; row++) {
	    System.out.print("|");

	    for(int column = 1; column < board[0].length; column++) {
		System.out.print(board[row][column]);
		System.out.print("|");
	    }

	    System.out.println();
	    System.out.println("");
	}

	System.out.println();
    }

/**
 * Method checks board for possible edge case game setups.
 * @param column
 * @param board
 * @return true / false
 */
    public static boolean checkBoard(int column, char[][] board) {

	if (column > board[0].length)
	    return false;

	return true;
    }

    public static boolean checkWin(char player, char[][] board) {

	/*
	 * Nested for loops traverses matrix and checks indices
	 * for 4 concurrent across pieces of current players piece.
	 */
	for (int row = 0; row < board.length; row++) {
	    for (int column = 1; column < board[0].length - 3; column++) {
		if (board[row][column] == player && board[row][column + 1] == player && board[row][column + 2] == player
			&& board[row][column + 3] == player) {
		    return true;
		}
	    }
	}

	/*
	 * Nested for loops traverses matrix and checks indices
	 * for 4 concurrent up/down pieces of current players piece.
	 */
	for (int row = 0; row < board.length - 3; row++) {
	    for (int column = 1; column < board[0].length; column++) {
		if (board[row][column] == player && board[row + 1][column] == player && board[row + 2][column] == player
			&& board[row + 3][column] == player) {
		    return true;
		}
	    }
	}

	/*
	 * Nested for loops traverses matrix and checks indices
	 * for 4 concurrent diagonal pieces of current players piece.
	 */
	for (int row = 3; row < board.length; row++) {
	    for (int column = 1; column < board[0].length - 3; column++) {
		if (board[row][column] == player && board[row - 1][column + 1] == player && board[row - 2][column + 2] == player
			&& board[row - 3][column + 3] == player) {
		    return true;
		}
	    }
	}
	return false;
    }
}