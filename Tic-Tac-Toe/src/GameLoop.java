import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;



public class GameLoop extends JPanel implements Runnable {
	
		private int boxSize;
		private final int boxWidth = 300;
		private final int boxPos1 = Values.boxHeight1.getValue();
		private final int boxPos2 = Values.boxHeight2.getValue();
		private final int boxPos3 = Values.boxHeight3.getValue();
		private final int boxPos4 = Values.boxHeight4.getValue();
		private final int boxPos5 = Values.boxHeight5.getValue();
		private final int boxPos6 = Values.boxHeight6.getValue();
		private final int boxPos7 = Values.boxHeight7.getValue();
		private final int boxPos8 = Values.boxHeight8.getValue();
		private final int boxPos9 =  Values.boxHeight9.getValue();;
		private final int centerValue = 40;	
	
	int turns;
	int gameWidth, lineOne, lineTwo;
	//Game class components
	Piece piece; 	Board board;	Screen graphics;
	Key key;		AI computer;
	
	//Gui Elements
	JPanel panel;
	
	
	//Game Components
	int xPosition; int yPosition;
	
	//Loop Components
	Thread t;	public boolean running;
/**
 * Constructor
 * @author Coby
 */
	
	
	public GameLoop(){
		turns = 0;
		board = new Board();
		computer = new AI();
		xPosition = 0;
		yPosition = 0;
		key = new Key();
		graphics = new Screen();
		setPreferredSize(new Dimension(Values.frameWidth.getValue(), Values.frameHeight.getValue()));
		setFocusable(true);
		addKeyListener(key);
		//initialize the array of pieces.
	
		start();
		
		
	}
	
	
	public void start(){
		running = true;
		t = new Thread(this, "Game Loop");
		t.start();
	}
	
	/**
	 * Called when a key is pressed to update game.
	 * Manage game here.
	 */
	public void tick(){
		
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paintComponents(g);
		drawMain(g);
		drawBar(g);
		
		graphics.drawGrid(g);
		graphics.drawPosition(g, xPosition, yPosition);

		board.drawTurns(g);	
		board.drawParts(g);

	}
	@Override
	public void run() {
	while(running){
		tick();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	}
	public void drawMain(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, Values.frameWidth.getValue(), Values.frameHeight.getValue());
	}
	/**
	 * Draws the side bar on the screen. 
	 * @param g
	 */
	public void drawBar(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(gameWidth, 0, 300, gameWidth);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Dialog", 0, 30));
		//Adds the word score to label where score is.
		g.drawString("Score", gameWidth + centerValue, boxPos1);
	}
	
	
	
/**
 * This is the key listener that allows the keyboard to control
 * the game.
 * @author Coby
 *
 */
	public class Key implements KeyListener
{


	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			 xPosition -= 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
			 
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			 xPosition += 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			 yPosition -= 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			 yPosition += 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
			
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(board.turn == 1){
				int a = xPosition/300; int b = yPosition/300;
				board.board[a][b].setTeam(Piece.ENUM.BLUE);
				board.setTurn(2);
				turns++;

			}
			computer.move();

			
			
			
		}
				
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
	
	
	public class AI {
		
		
		public AI(){

			
		}
		
		/**
		 * Checks situation and takes action. Filter through moves
		 * possible.
		 */
		public void move(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int move = 0;
			//TODO Call board.add piece() to all the ones needed
			//TODO Check if that spots already taken. If taken move to alternative.
			if (ICanWin() == true);
			
			if(oppCanWin() != null) oppCanWin().setTeam(Piece.ENUM.RED);
			
			if(oppCanFork() == true);
			
			if(firstMove() == true);
			if(secondMove() != null) secondMove().setTeam(Piece.ENUM.RED); 
			board.setTurn(1);
			turns +=1;
		}
		
		
		
		//Methods for checking situation.
		public boolean ICanWin(){
			System.out.println("can't win");
			//TODO Add functionality to Checking for winning.
			return false;
			
		}
		public Piece oppCanWin(){
			int j = 0;
			//TODO Add functionality to defense.
			for(int i = 0; i < 3; i++){
				for(int temp = 0; temp < 3; temp++){
					if( board.board[i][temp].getTeam() ==1){
						j+= 1;
					}
					//FIXME Returns the wrong instance of piece when it can win.
					if(j == 2){
						//Returns the piece in the open spot that could be used to block.
						for(int k = 0; k < 3; k++){
								if(board.board[i][k].getTeam() == 0){
									System.out.println("can win");
									return board.board[i][k];
								}
							
						}
					}
				}
				
				j = 0;
			}
			for(int i = 0; i < 3; i++){
				for(int temp = 0; temp < 3; temp++){
					if( board.board[temp][i].getTeam() ==1){
						j+= 1;
					}
					if(j == 2){
						for(int l = 0; l < 3; l++){
							if(board.board[l][i].getTeam() == 0){
								System.out.println("can win");
								return board.board[l][i];
							}
						}
					}
				}
				j = 0;
				//Check diagonally.
				for(int i1 = 0; i1 < 3; i1++){
					if( board.board[i1][i1].getTeam() ==1){
						j+= 1;
					}
				}
				if (j ==2){
					for(int temp = 0; temp < 3; temp++){
						if(board.board[temp][temp].getTeam() == 0) {
							System.out.println("can win");
							return board.board[temp][temp];
						}
					}
				}
				
			
			}
			System.out.println("cannot win");
			return null;
			
		}
		public boolean oppCanFork(){
			//TODO Add functionality to secondary defense(checking for fork)
			return false;
			
		}
		public boolean firstMove(){
			//TODO Add first move code.
			return false;
			
		}
		public Piece secondMove(){
			if(turns != 1){
				return null;
			}
			else{
			return board.board[1][1];
			}
		}
		public void goCorner(){
			
		}
		public void moveSide(){
			
		}
		public void goMiddle(){
			
		}
		
		
	}

		
		
	

}
