package com.metacube.get2019;

/**
 * Computes Solution of N Queen's Problem for a given NxN chess board.
 * Input is the  row and dimension of chess board.
 * Output is a binary matrix with 1 as Queen and everything else as 0.
 * @author Kritika
 */
public class NQueen {

	int [][] board;
   
	/**
	 * Initializes the board with value 0
	 * @param boardDimension is the dimension of the board
	 */
	void initializeBoard (int boardDimension) {
		board = new int[boardDimension][boardDimension];
		for(int i = 0 ; i < boardDimension ; i++) {
			for(int j = 0 ; j < boardDimension ; j++) {
				board[i][j] = 0;
			}
		}
	}
   
   /**
    * Computes the Solution for N Queen's Problem
    * @param row is the starting row of board
    * @param boardDimension is the dimension of the board
    * @return true or false indicating whether a solution exists
    */
	Boolean NQueen (int row, int boardDimension){ 
		if (row == boardDimension) {
			return true;  
		}
		for (int j = 0 ; j < boardDimension; j++){
			if (board[row][j] == 0){
				board[row][j] = 1; 
				blockBoxes(row, j, boardDimension);
				row++;
				if(!NQueen(row, boardDimension)) {
					 row--; 
					board[row][j] = 0;
					unblockBoxes(row , j, boardDimension); 
					continue;
				} else {
					return true;
				}
			}
		}

		return false;
	}
   
	/**
	 * Blocks the boxes where a placed queen can attack
	 * @param a is the row of board
	 * @param b is the column of board
	 * @param boardDimension is the dimension of board
	 */
	void blockBoxes (int row, int column , int boardDimension){
		for (int i = 1 ; i < boardDimension ; i++) {
			if ((row + i) < boardDimension) {
				board[row+i][column] += -1;
				if ((column + i) < boardDimension) {
					board[row + i][column + i] += -1;
				}
				if ((column - i) >= 0) {
					board[row + i][column - i] += -1;
				}
			}
		}
	}
   
	/**
	 * Unblocks the boxes blocked by placed queen if that place doesn't lead to solution
	 * @param a is the row of board
	 * @param b is the column of board
	 * @param boardDimension is the dimension of board
	 */
	void unblockBoxes (int row, int column, int boardDimension){
		for (int i = 1 ; i < boardDimension ; i++) {
			if ((row + i) < boardDimension) {
					board[row + i][column] += 1;
					if ((column + i) < boardDimension) {
						board[row + i][column + i] += 1;
					}
					if ((column - i) >= 0) {
						board[row + i][column - i] += 1;
					}
			}
		}
	}

	/**
	* When all the Queens are placed it assigns every other box to 0
	* @param boardDimension is the dimension of board
	*/
	void chgNegValuesZero (int boardDimension) {
		for (int i = 0 ; i < boardDimension ; i++) {
			for (int j = 0; j< boardDimension ; j++) {
				if (board[i][j] < 0) {
					board[i][j] = 0;
				}
			}
		}
	}
				   
	/**
	* Prints the binary matrix i.e board 
	* @param row is the starting row of board
	* @param boardDimension i the dimension of board
	*/
	int[][] showBoard (int row, int boardDimension) {
		initializeBoard (boardDimension);
		boolean result = NQueen(row, boardDimension);
		if (!result) {
			initializeBoard(boardDimension);
			return board;
		} else {
			chgNegValuesZero(boardDimension);
			return board;
		}
	}
}


				
