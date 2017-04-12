import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {
	//Screen Constants, TODO Store these in ENUM.
		private int boxSize;
		private final int boxWidth = 300;
		private final int boxPos1 = 100;
		private final int boxPos2 = 200;
		private final int boxPos3 = 300;
		private final int boxPos4 = 400;
		private final int boxPos5 = 500;
		private final int boxPos6 = 600;
		private final int boxPos7 = 700;
		private final int boxPos8 = 800;
		private final int boxPos9 = 900;
		private final int centerValue = 40;	
	
	
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
		
		graphics.drawPosition(g, xPosition, yPosition);
		graphics.drawGrid(g);
		board.drawParts(g);
		board.drawTurns(g);		
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
			System.out.println("Left");
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
			
			System.out.println("right");}
		
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			 yPosition -= 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
			System.out.println("up");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			 yPosition += 300;
			 if(xPosition > 600) xPosition = 600;
				if(xPosition < 0) xPosition = 0;
				if(yPosition > 600) yPosition = 600;
				if(yPosition < 0) yPosition = 0;
			
			System.out.println("down");
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(board.turn == 1){
				int a = xPosition/300; int b = yPosition/300;
				System.out.println(a);
				System.out.println(b);
				board.addPiece(a, b, 1);
				

			}
			computer.move();

			
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

		
		
	

}
