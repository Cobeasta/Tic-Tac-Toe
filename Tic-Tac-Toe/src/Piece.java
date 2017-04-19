import java.awt.Color;
import java.awt.Graphics;

public class Piece {
	int xPos;
	int yPos;
	public ENUM status;
	
	Color red = Color.RED;
	Color blue = Color.BLUE;
	/**
	 * 
	 * @param x xposition of this.
	 * @param y yposition nof this.
	 * @param player number representing team piece  is for.
	 */
	public Piece(int x, int y){
		status = ENUM.NOT_TAKEN;

		xPos = x;
		yPos = y;
		
		
	}
	public void setTeam(ENUM team){
		if(status == ENUM.NOT_TAKEN){
		if(team == ENUM.RED){
			status = ENUM.RED;
		}
		else if(team == ENUM.BLUE){
			status = ENUM.BLUE;
		}
		}
		else{
			GameLoop.canMove = false;
			System.out.println("ERROR!:     Cannot Go there!");
		}
		
	}
	public ENUM getTeamEnum(){
		return status;
	}
	public int getTeam(){
		return status.getValue();
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void draw(Graphics g){
		
		if(status == ENUM.BLUE) {
			g.setColor(blue);
			g.fillRect(xPos, yPos, 300, 300);

		}
		if(status == ENUM.RED){
			g.setColor(red);
			g.fillRect(xPos, yPos, 300, 300);

		}
		
		else{
			
		}
	}
	
	
	public enum ENUM{
		RED(2){

			@Override
			public int getValue() {
				return 2;
			}
			
		}, NOT_TAKEN(0){

			@Override
			public int getValue() {
				return 0;
			}
			
		}, BLUE(1){

			@Override
			public int getValue() {
				return 1;
			}
			
		};
		
		private ENUM(int m){
			
			
		}
		public abstract int getValue();
	}
	
	
}
