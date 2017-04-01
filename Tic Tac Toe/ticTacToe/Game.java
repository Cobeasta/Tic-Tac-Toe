package ticTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import src.Frame;
/**
 * Main Game class. Manages all aspects of the game.
 * @author Coby
 *
 */
public class Game extends JPanel implements Runnable{
	boolean running = false;
	Frame f;
	Thread t;
	JPanel panel;
	/**
	 * Game class constructor
	 * 
	 * Starts game loop and paints when needed.
	 */
	public Game(){
		
		setSize(new Dimension(Frame.diX, Frame.diY));
		setFocusable(true);
		System.out.println("Created Game Class");
		start();
	}
	
	
	
	/**
	 * Called repeatedly as app runs.
	 * Updates OI and game.
	 */
	public void tick(){
		repaint();
	}
	/**
	 * Main Screen painting
	 * Called every app cycle and draws points on 
	 * screen.
	 * TODO Put paint uses into class to use for game loop simplifying code.
	 * <P> WARNING: Must erase elements after paint is done.
	 */
	public void paint(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Frame.diX, Frame.diY);
		drawLines(g);
		
	}
	/**
	 * Draws Grid
	 * @param g Graphics g.
	 */
	public void drawLines(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine(0, Frame.y1, Frame.diX, Frame.y1);
		g.drawLine(0, Frame.y2, Frame.diX, Frame.y2);
		g.drawLine(Frame.x1, 0, Frame.x1, Frame.diY);
		g.drawLine(Frame.x2, 0, Frame.x2, Frame.diY);
	}
	
	/**
	 * Called on game loop creation.
	 * initializes thread and sets running to true.
	 */
	public void start(){
		t = new Thread(this, "game loop");
		t.start();
		
		System.out.println("Starting");
		running = true;
	}
	
	/**
	 * Loops while running is true
	 * repaints and calls tick() which updates elements.
	 */
	@Override
	public void run() {
		
		while(running){
			repaint();
		}
	}
		
	}
	