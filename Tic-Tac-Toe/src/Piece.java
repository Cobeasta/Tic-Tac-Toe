import java.awt.Color;
import java.awt.Graphics;

public class Piece {
	int xPos;
	int yPos;
	public int team;
	
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
	public void setTeam(int team){
		this.team = team;
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
		
		if(team == 1) {
			g.setColor(blue);
			g.fillRect(xPos, yPos, 300, 300);

		}
		if(team == 2){
			g.setColor(red);
			g.fillRect(xPos, yPos, 300, 300);

		}
		else{
			
		}
	}
	
}
