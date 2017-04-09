import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {
	Piece piece;
	JPanel panel;
	Game game;
	int xPosition;
	int yPosition;
	Thread t;
	Screen graphics;
	public boolean running;
	
	Key key;
	public GameLoop(){
		game = new Game();
		xPosition = 0;
		yPosition = 0;
		key = new Key();
		graphics = new Screen();
		setPreferredSize(new Dimension(Values.frameWidth.getValue(), Values.frameHeight.getValue()));
		setFocusable(true);
		addKeyListener(key);
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
		if(xPosition > 600) xPosition = 600;
		if(xPosition < 0) xPosition = 0;
		if(yPosition > 600) yPosition = 600;
		if(yPosition < 0) yPosition = 0;
		//TODO Display turn on right bar.
		//TODO Display score.
		//TODO Check if anyone won.
		//TODO Check whose turn it is.
		repaint();
	}
	
	public void paint(Graphics g){
		super.paintComponents(g);
		graphics.drawMain(g);
		graphics.drawGrid(g);
		graphics.drawBar(g);
		graphics.putScore(g, "15");
		graphics.drawPosition(g, xPosition, yPosition);
		game.drawPieces(g);
				
		}
		
		
	@Override
	public void run() {
	while(running){
		tick();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
		//TODO Add code for what to do here.
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("Left");
			 xPosition -= 300;
			 
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			 xPosition += 300;
			
			System.out.println("right");}
		
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			 yPosition -= 300;
			
			System.out.println("up");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			 yPosition += 300;
			
			System.out.println("down");
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			piece = new Piece(xPosition, yPosition, 1);
			game.add(piece);
			System.out.println("Enter");
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

		
		
	

}
