import java.awt.Color;
import java.awt.Graphics;

public class Piece {
	int xPos;
	int yPos;
	int team;
	Color red = Color.RED;
	Color blue = Color.BLUE;
	/**
	 * 
	 * @param x xposition of this.
	 * @param y yposition nof this.
	 * @param player number representing team piece  is for.
	 */
	public Piece(int x, int y, int player){
		xPos = x;
		yPos = y;
		team = player;
		
	}
	public int getTeam(){
		return team;
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void draw(Graphics g){
		if(team == 1) g.setColor(blue);
		if(team == 2) g.setColor(red);
		g.fillRect(xPos, yPos, 300, 300);
	}
	
}
