package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

	private String[][] board = new String[3][3];
	private String winner;
	private int utility;
	private String nextPiece;
	private String nextMove;
	
	Board(){
		utility=0;
	}
	
	Board(String place, String piece){
		board = new String[3][3];
		placePiece(place, piece);
	}
	
	Board(String[][] brd, String place, String piece){
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				board[row][column]=brd[row][column];
			}	
		}
		placePiece(place, piece);
	}
	
	public void placePiece(String spot, String piece){
		if(piece.equals("O")){
			nextPiece="X";
		}
		else{
			nextPiece="O";
		}
	
		int row=Character.getNumericValue(spot.charAt(0));
		int column=Character.getNumericValue(spot.charAt(1));;
		
		if(board[row][column]==null){
			board[row][column]=piece;
		}
		else{
			System.out.println("A player already controls this spot");
		}
	}
	
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
	
	public boolean isTerminal(){
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
		else if(isDraw()){
			utility=0;
			winner="-";
			return true;
		}
		else{return false;}
	}
	
	private boolean isDraw(){
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
