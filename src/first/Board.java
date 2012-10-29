package first;

import java.util.ArrayList;

public class Board {

	private String[][] board = new String[3][3];
	private String winner;
	private int utility;
	private String nextPiece;
	private String nextMove;
	
	/**
	 * Constructor used for creating a blank board object with not utility.
	 * The utility gets set based on the method calling it
	 */
	Board(){
		utility=0;
	}
	
	/**
	 * Creates a board from another given board, adds to that board the given piece at the given place
	 * @param brd
	 * @param place
	 * @param piece
	 */
	Board(String[][] brd, String place, String piece){
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				board[row][column]=brd[row][column];
			}	
		}
		placePiece(place, piece);
	}
	
	/**
	 * Places the given piece at the given location on the board.  Sets the next piece to be placed on the board
	 * @param spot
	 * @param piece
	 */
	public void placePiece(String spot, String piece){
		if(piece.equals("O")){
			nextPiece="X";
		}
		else{
			nextPiece="O";
		}
		
		//Parses the String coordinates to integers for use in the board[][]
		int row=Character.getNumericValue(spot.charAt(0));
		int column=Character.getNumericValue(spot.charAt(1));;
		
		if(board[row][column]==null){
			board[row][column]=piece;
		}
		else{
			System.out.println("A player already controls this spot");
		}
	}
	
	/**
	 * Returns the list position that are still open on the board
	 * @return
	 */
	public ArrayList<String> getListOfMoves(){
		ArrayList<String> possibleMoves=new ArrayList<String>();
		
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				if(board[row][column]==null){
					String move = Integer.toString(row)+Integer.toString(column);
					possibleMoves.add(move);
				}
			}	
		}
		return possibleMoves;
	}
	
	/**
	 * ONLY USED FOR DEBUGGING
	 * Prints the state of the board
	 */
	public void printBoard(){
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				if(board[row][column]!=null){
					System.out.print("  "+board[row][column]+"  ");
				}
				else{
				System.out.print(board[row][column]+" ");
				}
			}
			System.out.println("");
		}
		System.out.println();
	}
	
	public void setNextMove(String move){
		nextMove=move;
	}
	
	public String getNextMove(){
		return nextMove;
	}
	
	public void setUtility(int util){
		utility=util;
	}
	
	public String getNextPiece(){
		return nextPiece;
	}

	public String[][] getBoard(){
		return board;
	}
	
	public int getUtility(){
		return utility;
	}
	
	public String getWinner(){
		return winner;
	}
	
	/**
	 * Checks if the board has reached a terminal state.  
	 * If terminal it sets the winner equal to the piece that won or to - for a draw
	 * @return
	 */
	public boolean isTerminal(){
		//Is the board terminal(has a winner or is a draw)
			//rows
		if(board[0][0]!=null && board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
			{if(board[0][0].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
		else if(board[1][0]!=null && (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])))
			{if(board[1][0].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
		else if(board[2][0]!=null && (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])))
			{if(board[2][0].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
			//columns
		else if(board[0][0]!=null && (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])))
			{if(board[0][0].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
		else if(board[0][1]!=null && (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])))
			{if(board[0][1].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
		else if(board[0][2]!=null && (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])))
			{if(board[0][2].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
			//diagonals
		else if(board[0][0]!=null && (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])))
			{if(board[0][0].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
		else if(board[0][2]!=null && (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])))
			{if(board[0][2].equals("X")){winner="X"; utility=1;}else{winner="O"; utility=-1;}
			return true;}
			//tie
		else if(isFull()){
			utility=0;
			winner="-";
			return true;
		}
		else{return false;}
	}
	
	/**
	 * Returns true if the board is full
	 * @return
	 */
	private boolean isFull(){
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				if(board[row][column]==null){
					return false;
				}
			}
		}
		return true;
	}


}
