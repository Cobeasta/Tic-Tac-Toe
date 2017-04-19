import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;




public class GameLoop extends JPanel implements Runnable {
	
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
		private final int gameWidth = Values.frameWidth.getValue();
		static boolean canMove;
	int turns; int blueTeamScore; int redTeamScore;
	
	//Game class components
	Piece piece; 	Board board;	Screen graphics;
	Key key;		AI computer;    Settings settings;
	
	//Gui Elements
	JPanel panel;
	JButton button;
	
	//Game Components
	int xPosition; int yPosition;
	
	//Loop Components
	Thread t;	public boolean running;
	ActionListener l;

/**
 * Constructor
 * @author Coby
 */
	
	//Game Elements
	public GameLoop(){
		l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		button = new JButton();
		button.setLocation(gameWidth, boxPos3);
		button.setText("Do you want go go First?");
		button.setSize(boxWidth, boxWidth);
		//FIXME The code adds to the wrong team when someone wins.
		board = new Board();
		computer = new AI();
		xPosition = 0;
		yPosition = 0;
		key = new Key();
		settings = new Settings();
		graphics = new Screen();
		blueTeamScore = 0;
		redTeamScore = 0;
//		button.set
		button.setBackground(Color.GREEN);
		add(button);
		button.addActionListener(l);
		if(settings.getplayerFirst()){
			turns = 0;
		}
		else{
			turns = 1;
		}
		
		setPreferredSize(new Dimension(Values.frameWidth.getValue(), Values.frameHeight.getValue()));
		setFocusable(true);
		addKeyListener(key);
		start();
		System.out.println("GAME_INFO:     turns = " +turns);

	}
		//initialize the array of pieces.
	
	
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
		
		
		 if(checkForWins() == Piece.ENUM.BLUE){
			System.out.println("GAME_INFO:     Blue Team wins!...     Restarting");
			blueTeamScore++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			board.init();
			
		 }
		 else if(checkForWins() == Piece.ENUM.RED){
			 System.out.println("GAME_INFO:     Red Team  wins...     Restarting");
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 redTeamScore++;
			 board.init();
		 }
		 else if(catsGame() == true){
			 System.out.println("GAME_INFO:     Cats Game...      Restarting!");
			 board.init();
		 }
		 
		 
		 if(turns % 2 == 1){
				computer.move();

			}

		
		
	}
	//Graphics
	@Override
	public void paint(Graphics g){
		super.paintComponents(g);
		drawMain(g);
		drawBar(g);
		
		
		graphics.drawGrid(g);
		board.drawParts(g);

		graphics.drawPosition(g, xPosition, yPosition);
		board.drawTurns(g);
		drawScore(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Dialog", 0, 30));
		g.drawString(String.valueOf(turns), gameWidth, boxPos7);
		if(canMove == false){
			cantMoveIndicator(g);
			canMove = true;
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
	public void drawScore(Graphics g){
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(gameWidth, boxPos7, boxWidth, boxWidth * 2 );
		g.setFont(new Font("dialog", 0, 30));
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf("AI Score:  " +redTeamScore), gameWidth + centerValue, boxPos6);
		g.drawString(String.valueOf("Player Score: " +blueTeamScore), gameWidth + centerValue, boxPos7);

		}
	
	
	
	public void cantMoveIndicator(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, gameWidth, gameWidth);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gameWidth, gameWidth);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void cantMove(){
		canMove = false;
	}
	
	
	
	
	
	
	//Score
	
	public Piece.ENUM checkForWins(){
		//Checks vertically for each team winning.
		for(int i = 0; i < 3; i++){
			int blue = 0; int red = 0;
			for(int temp = 0; temp < 3; temp++){
				if(board.board[i][temp].getTeamEnum() == Piece.ENUM.BLUE){
					blue++;
				}
				else if(board.board[i][temp].getTeamEnum() == Piece.ENUM.RED){
					red++;
				}
				if(blue == 3){
					return Piece.ENUM.BLUE;
				}
				else if(red == 3){
					return Piece.ENUM.RED;
				}
			}
		}
		//Check x for blue and red. Return team that it returns true, if any.
		for(int i = 0; i < 3; i++){
			int blue = 0; int red = 0;
			for(int temp  = 0; temp < 3; temp++){
				if(board.board[temp][i].getTeamEnum() == Piece.ENUM.BLUE) blue++;
				else if(board.board[temp][i].getTeamEnum() == Piece.ENUM.RED) red++;
			}
			if(blue == 3) return Piece.ENUM.BLUE;
			else if(red == 3) return Piece.ENUM.RED;
			
		}
		//Allows me to put blue and red in this scope.
		if(true){
		int blue = 0;
		int red = 0;
		for(int i = 0; i < 3; i++){
			if(board.board[i][i].getTeamEnum() == Piece.ENUM.BLUE){
				blue++;
			
			}
			else if(board.board[i][i].getTeamEnum() == Piece.ENUM.RED){
				red++;
			}
		}
		}
		return Piece.ENUM.NOT_TAKEN;
		
	}
	public boolean catsGame(){
		int j = 0;
		for(int i = 0; i < 3; i++){
			for(int temp = 0; temp < 3; temp++){
				if(board.board[i][temp].getTeamEnum() == Piece.ENUM.BLUE || board.board[i][temp].getTeamEnum() == Piece.ENUM.RED){
					j++;
				}
			}
		}
		if(j == 9){
			return true;
		}
		else{
			return false;
					
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
			if(turns %2 == 0){
				System.out.println("USER_INFO:     Player moved");
				int a = xPosition/300; int b = yPosition/300;
				System.out.println("USER_INFO:      "+a + " " + b);
				board.board[a][b].setTeam(Piece.ENUM.BLUE);
				board.setTurn(2);
				if(canMove == true)				turns++;


			}
		
			
			
			
		}
				
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
	
	
	public class AI {
		//TODO Check for diagonal left to right wins and possibilities.
		
		public AI(){

			
		}
		
		/**
		 * Checks situation and takes action. Filter through moves
		 * possible.
		 */
		public void move(){
			Piece p;
			System.out.println("USER_INFO:    ai move");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ICanWin() != null){
				System.out.println("DECISION:     AI can win");
				p = ICanWin();
			}
			
			else if(oppCanWin() != null){
				p = oppCanWin();
				System.out.println("DECISION:     opposition can win");
				System.out.println("     COORDINATES:     "+oppCanWin().getxPos() + " " +oppCanWin().getyPos());
			}
			
//			else if(oppCanFork() == true);
			
			else if(firstMove() != null){
				System.out.println("DECISION:     First move");
				p = firstMove();
			}
				
			else if(secondMove() != null) {
				System.out.println("DECISION:     second move");
				p = secondMove();
			}
			else if(goRandom() != null){
				System.out.println("DECISION:     random place");
				p = goRandom();
			}
			else{
				p = null;
				System.out.println("GAME_INFO:     Cat's Game!");
			}
			if(p != null){
			p.setTeam(Piece.ENUM.RED);
			board.setTurn(1);
			turns +=1;
			}
		}
		
		
		
		//Methods for checking situation.
		public Piece ICanWin(){
			
			for(int i = 0; i < 3; i++){
				int place = 0;

				for(int temp = 0; temp < 3; temp++){
					Piece p = board.board[i][temp];
					if(p.getTeamEnum() == Piece.ENUM.RED){
						place++;
						
					}
				}
				if(place == 2){
					
					for(int j = 0; j < 3; j++){
						if(board.board[i][j].getTeamEnum() == Piece.ENUM.NOT_TAKEN){
							return board.board[i][j];
						}
					}
				}
			}
			for(int i = 0; i < 3; i++){
				int place = 0;
				Piece p;

				for(int temp = 0; temp < 3; temp++){
					 p = board.board[temp][i];
					if(p.getTeamEnum() == Piece.ENUM.RED){
						place++;
					}
					
				}
				if(place == 2){
				for(int j =0; j < 3; j++){
					if(board.board[j][i].getTeamEnum() == Piece.ENUM.NOT_TAKEN){
						return board.board[j][i];
				}	
					}
				}
			}
			int placement = 0;
			Piece piece;
			for(int i = 0; i < 3; i++){
				if(board.board[i][i].getTeamEnum() == Piece.ENUM.RED){
					placement++;
				}
				
			}
			if(placement == 2){
				for(int z = 0; z < 3; z++){
				if(board.board[z][z].getTeamEnum() == Piece.ENUM.NOT_TAKEN){
					return board.board[z][z];
				}
				}
			}
			
			//TODO Add functionality to Checking for winning.
			System.out.println("DECISION_PROCESS:     AI can't Win");
			return null;
			
		}
		public Piece oppCanWin(){
			int j = 0;
			for(int i = 0; i < 3; i++){
				for(int temp = 0; temp < 3; temp++){
					if( board.board[i][temp].getTeamEnum() == Piece.ENUM.BLUE){
						j+= 1;
					}
					//FIXME Returns the wrong instance of piece when it can win.
					if(j == 2){
						//Returns the piece in the open spot that could be used to block.
						for(int k = 0; k < 3; k++){
								if(board.board[i][k].getTeam() == 0){
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
							return board.board[temp][temp];
						}
					}
				}
				
			
			}
			System.out.println("DECISION_PROCESS:     Player Can't Win");
			return null;
			
		}
		public boolean oppCanFork(){
			//TODO Add functionality to secondary defense(checking for fork)
			return false;
			
		}
		public Piece firstMove(){
			if(turns == 0){
				return board.board[1][1];
			}
			else{
				System.out.println("DECISION_PROCESS:     Not First Move");
				return null;
			}
			
		}
		public Piece secondMove(){
			
			 if(turns == 1){
			return board.board[1][1];
			}
			else{
				return null;
			}
		}
		public void goCorner(){
			
		}
		public void moveSide(){
			
		}
		public void goMiddle(){
			
		}
		public Piece goRandom(){
			for(int i = 0; i < 3; i++){
				for(int temp = 0; temp < 3; temp++){
					if(board.board[i][temp].getTeamEnum() == Piece.ENUM.NOT_TAKEN){
						return board.board[i][temp];
						
					}
				}
			}
			System.out.println("DECISION_PROCESS:     No Spots Left!");
			return null;
		}
		
	}

		
		
	

}
