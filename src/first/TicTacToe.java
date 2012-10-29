package first;

import java.util.ArrayList;


public class TicTacToe {
	
	/**
	 * Starts the minimax
	 * @param state
	 * @return
	 */
	public Board decision(Board state){
		Board v = maxValue(state);
		return v;
	}
	
	/**
	 * Determines the best possible move for the X player given a list of optimal moves that could be chosen by player O
	 * @param state
	 * @return
	 */
	public Board maxValue(Board state){
		if(state.isTerminal()){
			return state;
		}
		
		//creates a empty board with a utility outside the minimum range of possible utilities for a board
		//This bestMove will be used as a holder for the best possible move for player  X
		Board bestMove=new Board();
		bestMove.setUtility(-5);
		
		//list of empty spaces on the board
		ArrayList<String> moves=state.getListOfMoves();
		
		for(int i=0; i<moves.size(); i++){//for each child
			
			//create a child board that equals the parent plus one of its possible moves
			Board child=new Board(state.getBoard(), moves.get(i), state.getNextPiece());
			
			//gets the minimum value of that child
			Board currentMove = minValue(child);
			
			//chooses the best move possible based on the boards utility
			if(bestMove.getUtility() < currentMove.getUtility()){
				bestMove=currentMove;
				bestMove.setNextMove(moves.get(i));
			}
		}
		return bestMove;
	}
	
	/**
	 * Determines the best move for player O trying to minimize player X's likelihood of winning
	 * given a list of optimal moves that could be chosen by player X
	 * @param state
	 * @return
	 */
	public Board minValue(Board state){
		if(state.isTerminal()){
			return state;
		}
		
		//creates a empty board with a utility outside the maximum range of possible utilities for a board
		//This bestMove will be used as a holder for the best possible move for player O
		Board bestMove=new Board();
		bestMove.setUtility(5);
		
		//list of empty spaces on the board
		ArrayList<String> moves=state.getListOfMoves();
		
		for(int i=0; i<moves.size(); i++){//for each child
			
			//create a child board that equals the parent plus one of its possible moves
			Board child = new Board(state.getBoard(), moves.get(i), state.getNextPiece());
			
			//gets the maximum value of the child
			Board currentMove = maxValue(child);
			
			//chooses the move most likely to hurt player X based on the boards utility
			if(bestMove.getUtility() > currentMove.getUtility()){
				bestMove=currentMove;
				bestMove.setNextMove(moves.get(i));
			}
		}
		return bestMove;
	}
	
}//End of TicTacToe Class
