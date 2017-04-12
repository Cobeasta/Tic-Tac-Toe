import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Screen {
private int gameWidth;
private int lineOne, lineTwo;
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
