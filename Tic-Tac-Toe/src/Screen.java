import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Screen {
private int gameWidth;
private int lineOne, lineTwo;
private int boxSize;

	
	public Screen(){
		gameWidth = Values.frameWidth.getValue();
		lineOne = Values.lineOnePosition.getValue();
		lineTwo = Values.lineTwoPosition.getValue();
		boxSize = 300;
		
	}
	/**
	 * Fills the main area with white. 
	 * This could be used to erase all marks when new game is started.
	 */
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
		g.drawString("Score", gameWidth + 150, 100);
	}
	/**
	 * Puts a number on the score in the score place.
	 * @param g Graphics
	 * @param s  String value of number to pass in.
	 */
	public void putScore(Graphics g, String s){
		//XXX Center this string.
		g.setColor(Color.DARK_GRAY);
		g.fillRect(gameWidth, 150, 300, 200);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Dialog", 0, 30));
		g.drawString(s, gameWidth + 150, 200);
	}
	/**
	 * Adds a number to a place saved for score on the game bar.
	 * @param g
	 * @param num
	 */
	
	public void putScore(Graphics g, int num){
		//XXX Center This string.
		String string;
		string = String.valueOf(num);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(gameWidth, 150, 300, 100);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Dialog", 0, 30));
		g.drawString(string, gameWidth, 200);
	}
	/**
	 * Draws the grid that will be played on.
	 * @param g
	 */
	public void drawGrid(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine(0, lineOne, gameWidth, lineOne);
		g.drawLine(0, lineTwo, gameWidth, lineTwo);
		g.drawLine(lineOne, 0, lineOne, gameWidth);
		g.drawLine(lineTwo, 0, lineTwo, gameWidth);
	}
	
	public void drawPosition(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.setFont(new Font("Dialog", 0, 30));

		g.drawRect(x, y, 300, 300);
	}
	
	
}
