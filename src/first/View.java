package first;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Event;



public class View {
	
//	static Button button[][] = new Button[3][3];
//	static int clicked[][] = new int[3][3];
//	int rows;
//	int columns;
//	Board board;
	String move;
//	final Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
	final Button boxes[][] = new Button[3][3];
	final Label lbl1;
	Shell shell;
	final Board board;
	final TicTacToe obj;
	
	public static void main(String[] args) {
		new View();
	}
	
	public void createBoxes(){
		
		
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				final int permRow=row;
				final int permColumn=column;
				final String rowStr=Integer.toString(row);
				final String columnStr=Integer.toString(column);
				
				boxes[row][column] = new Button(shell, SWT.NONE);
				boxes[row][column].setBounds((40+(60*row)), (40+(60*column)), 40, 40);
		
				Listener listener = new Listener() {	
					public void handleEvent(Event arg0) {
						if(boxes[permRow][permColumn].getText().isEmpty()){
							boxes[permRow][permColumn].setText("O");
							board.placePiece((rowStr+columnStr), "O");
							if(board.isTerminal()){
								if(board.getWinner().equals("O")){
									lbl1.setText("Congratulations you won!");
								}
								else if(board.getWinner().equals("X")){
									lbl1.setText("You tried your best. Thank you for playing");
								}
								else{
									lbl1.setText("Tie Game.  Thank you for playing");
								}
							}
							else{
								String aMove=obj.decision(board).getNextMove();
								int newRow=Integer.parseInt(aMove.substring(0, 1));
								int newColumn=Integer.parseInt(aMove.substring(1));
								boxes[newRow][newColumn].setText("X");
								board.placePiece(aMove, "X");
							}
						}
					}
				 };
				 boxes[row][column].addListener(SWT.Selection, listener);
			}
		}
	}
	
	public View(){
		
		obj = new TicTacToe();	
		board=new Board();
		
		final Display display = new Display();
		shell = new Shell(display);
		shell.setSize(260, 280);
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width)/2;
		int y = bounds.y + (bounds.height - rect.width)/2;
		shell.setLocation(x,y);
		shell.setText("Tic-Tac-Toe");
		shell.setLayout(null);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(90, 30, 2, 180);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(150, 30, 2, 180);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(30, 90, 180, 2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(30, 150, 180, 2);
		
		lbl1 = new Label(shell, SWT.NONE);
		lbl1.setBounds(5, 220, 250, 30);
		
		createBoxes();
		
//		btn00 = new Button(shell, SWT.NONE);
//		btn00.setBounds(40, 40, 40, 40);
//		
//		btn01 = new Button(shell, SWT.NONE);
//		btn01.setBounds(100, 40, 40, 40);
//		
//		btn02 = new Button(shell, SWT.NONE);
//		btn02.setBounds(160, 40, 40, 40);
//		
//		btn10 = new Button(shell, SWT.NONE);
//		btn10.setBounds(40, 100, 40, 40);
//		
//		btn11 = new Button(shell, SWT.NONE);
//		btn11.setBounds(100, 100, 40, 40);
//		
//		btn12 = new Button(shell, SWT.NONE);
//		btn12.setBounds(160, 100, 40, 40);
//		
//		btn20 = new Button(shell, SWT.NONE);
//		btn20.setBounds(40, 160, 40, 40);
//		
//		btn21 = new Button(shell, SWT.NONE);
//		btn21.setBounds(100, 160, 40, 40);
//		
//		btn22 = new Button(shell, SWT.NONE);
//		btn22.setBounds(160, 160, 40, 40);
//		
//		
//		Listener lis00 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn00.getText().isEmpty()){
//					btn00.setText("O");
//					board.placePiece("00", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		 };
//		 
//		Listener lis01 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn01.getText().isEmpty()){
//					btn01.setText("O");
//					board.placePiece("01", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		 };	
//		 
//		 Listener lis02 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn02.getText().isEmpty()){
//					btn02.setText("O");
//					board.placePiece("02", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//		
//		Listener lis10 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn10.getText().isEmpty()){
//					btn10.setText("O");
//					board.placePiece("10", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//		
//		Listener lis11 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn11.getText().isEmpty()){
//					btn11.setText("O");
//					board.placePiece("11", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//					 
//		Listener lis12 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn12.getText().isEmpty()){
//					btn12.setText("O");
//					board.placePiece("12", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//						 
//		Listener lis20 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn20.getText().isEmpty()){
//					btn20.setText("O");
//					board.placePiece("20", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//							 
//		Listener lis21 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn21.getText().isEmpty()){
//					btn21.setText("O");
//					board.placePiece("21", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};	
//								 
//		Listener lis22 = new Listener() {	
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
//				if(btn22.getText().isEmpty()){
//					btn22.setText("O");
//					board.placePiece("22", "O");
//					if(board.isTerminal()){
//						if(board.getWinner().equals("O")){
//							lbl1.setText("Congratulations you won!");
//						}
//						else if(board.getWinner().equals("X")){
//							lbl1.setText("You tried your best. Thank you for playing");
//						}
//						else{
//							lbl1.setText("Tie Game.  Thank you for playing");
//						}
//					}
//					else{
//						String aMove=obj.decision(board).getNextMove();
//						setMove(aMove);
//						board.placePiece(aMove, "X");
//					}
//				}
//			}
//		};								
//		 btn00.addListener(SWT.Selection, lis00);
//		 btn01.addListener(SWT.Selection, lis01);
//		 btn02.addListener(SWT.Selection, lis02);
//		 btn10.addListener(SWT.Selection, lis10);
//		 btn11.addListener(SWT.Selection, lis11);
//		 btn12.addListener(SWT.Selection, lis12);
//		 btn20.addListener(SWT.Selection, lis20);
//		 btn21.addListener(SWT.Selection, lis21);
//		 btn22.addListener(SWT.Selection, lis22);

		shell.open();
		while(!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
			display.dispose();
		
		
	}
	
	private void setMove(Button button[][], String move){
		if(move.equals("00")){
			button[0][0].setText("X");
		}
		else if(move.equals("01")){
			button[0][1].setText("X");
		}
		else if(move.equals("02")){
			button[0][2].setText("X");
		}
		else if(move.equals("10")){
			button[1][0].setText("X");
		}
		else if(move.equals("11")){
			button[1][1].setText("X");
		}
		else if(move.equals("12")){
			button[1][2].setText("X");
		}
		else if(move.equals("20")){
			button[2][0].setText("X");
		}
		else if(move.equals("21")){
			button[2][1].setText("X");
		}
		else if(move.equals("22")){
			button[2][2].setText("X");
		}
		
	}
	
	public String getMove(){
		return move;
	}
}
