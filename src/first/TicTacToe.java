package first;

import java.util.ArrayList;


public class TicTacToe {

	static String move;

	public static void main(String[] args) {
	
	//askUser();
	TicTacToe obj = new TicTacToe();	
	Board board=new Board();
	board.placePiece("00", "O");
//	String aMove=obj.decision(board).getNextMove();
	
//	while(!board.isTerminal()){
//		askUser();
//		board.placePiece(move, "O");
//		String aMove=obj.decision(board).getNextMove();
//		board.placePiece(aMove, "X");
//	}
	
	String aMove=obj.decision(board).getNextMove();
	System.out.println(aMove);
	}
	
	public TicTacToe(){
		
	}
	
	public Board decision(Board state){
		Board v = maxValue(state);
		return v;
	}
	
	public Board maxValue(Board state){
		if(state.isTerminal()){
			return state;
		}
		Board bestMove=new Board();
		bestMove.setUtility(-5);
		ArrayList<String> moves=state.getListOfMoves();
		for(int i=0; i<moves.size(); i++){//for each child
			Board child=new Board(state.getBoard(), moves.get(i), state.getNextPiece());
			Board currentMove = minValue(child);
			if(bestMove.getUtility() < currentMove.getUtility()){
				bestMove=currentMove;
				bestMove.setNextMove(moves.get(i));
			}
		}
		return bestMove;
	}
	
	public Board minValue(Board state){
		if(state.isTerminal()){
			return state;
		}
		Board bestMove=new Board();
		bestMove.setUtility(5);
		ArrayList<String> moves=state.getListOfMoves();
		for(int i=0; i<moves.size(); i++){//for each child
			Board child = new Board(state.getBoard(), moves.get(i), state.getNextPiece());
			Board currentMove = maxValue(child);
			if(bestMove.getUtility() > currentMove.getUtility()){
				bestMove=currentMove;
				bestMove.setNextMove(moves.get(i));
			}
		}
		return bestMove;
	}
	
	private static void askUser(){
		View view=new View();
		move=view.getMove();
	}
	
}
