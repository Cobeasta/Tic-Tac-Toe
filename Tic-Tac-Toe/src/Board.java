import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Board {
	int gameWidth, lineOne, lineTwo;
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
	Piece[][] board;
	int turn;
	public Board(){
		turn = 1;
		board = new Piece[3][3];
		
		
		
		gameWidth = Values.frameWidth.getValue();
		lineOne = Values.lineOnePosition.getValue();
		lineTwo = Values.lineTwoPosition.getValue();
		
		//Initialize board array
		init();
			
		
	}
	/**
	 * Clears the board and initializes the values for the array.
	 */
	public void init(){
		int placeX = 0; int placeY = 0;

		for(int i = 0; i < 3; i++){
			for(int temp = 0; temp < 3; temp++){
				board[i][temp] = new Piece(placeX, placeY);
				placeY += 300;
			}
			placeY = 0;
			placeX += 300;

		}
	}
	
	
	public void addPiece(int x, int y, Piece.ENUM team){
		
	
	Piece p = board[x][y];
	 p.setTeam(team);
	 
	
	}
	
	
	public void drawParts(Graphics g){
		for(int i = 0; i < 3; i++){
			for (int temp = 0; temp < 3; temp++){
				Piece p;
				p = board[i][temp];
				p.draw(g);
				p.getTeam();
				
			}
		}
	}
	
	
	public void drawTurns(Graphics g){
		String s;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Dialog", 0, 30));
		if(turn == 1){
			s = "Your turn";
		}
		else{
			s = "Computer's turn";
		}
		g.drawString(s, gameWidth + centerValue, boxPos5);
	}
	public int getTurn(){
		return turn;
	}
	public void setTurn(int turn){
		this.turn = turn;
	}
	
	
	
	
	
}
