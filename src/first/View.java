package first;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;



public class View {
	
	String move;
	final Button boxes[][] = new Button[3][3];
	final Label message;
	final Display display;
	Shell shell;
	final Board board;
	final TicTacToe obj;
	
	public static void main(String[] args) {
		new View();
	}
	
	public View(){
		
		obj = new TicTacToe();	
		board=new Board();
		
		display = new Display();
		shell = new Shell(display);
		shell.setSize(260, 280);
		
		//Set position of display to center on screen
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width)/2;
		int y = bounds.y + (bounds.height - rect.width)/2;
		shell.setLocation(x,y);
		
		
		shell.setText("Tic-Tac-Toe");
		shell.setLayout(null);
		
		Label vertLine1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		vertLine1.setBounds(90, 30, 2, 180);
		
		Label vertLine2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		vertLine2.setBounds(150, 30, 2, 180);
		
		Label horzLine1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		horzLine1.setBounds(30, 90, 180, 2);
		
		Label horzLine2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		horzLine2.setBounds(30, 150, 180, 2);
		
		message = new Label(shell, SWT.NONE);
		message.setBounds(5, 220, 250, 30);
		
		createBoxes();
		

		shell.open();
		while(!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
			display.dispose();
		
		
	}
	
public void createBoxes(){
		
		
		for(int row=0; row<3; row++){
			for(int column=0; column<3; column++){
				final int permRow=row;
				final int permColumn=column;
				final String move=Integer.toString(row)+Integer.toString(column);
				
				//creates and places the button
				boxes[row][column] = new Button(shell, SWT.NONE);
				boxes[row][column].setBounds((40+(60*row)), (40+(60*column)), 40, 40);
		
				Listener listener = new Listener() {	
					public void handleEvent(Event arg0) {
						if(boxes[permRow][permColumn].getText().isEmpty() && !board.isTerminal()){
							boxes[permRow][permColumn].setText("O");
							board.placePiece(move, "O");
							if(board.isTerminal()){
								if(board.getWinner().equals("O")){
									message.setText("Congratulations you won!");
								}
								else{
									message.setText("Tie Game.  Thank you for playing");
								}
							}
							else{
								String nextMove=obj.decision(board).getNextMove();
								int newRow=Integer.parseInt(nextMove.substring(0, 1));
								int newColumn=Integer.parseInt(nextMove.substring(1));
								boxes[newRow][newColumn].setText("X");
								board.placePiece(nextMove, "X");
								if(board.isTerminal()){
									if(board.getWinner().equals("X")){
										message.setText("You tried your best. Thank you for playing");
									}
									else{
										message.setText("Tie Game.  Thank you for playing");
									}
								}
							}
						}
					}
				 };
				 boxes[row][column].addListener(SWT.Selection, listener);
			}
		}
	}
}//End of View class
