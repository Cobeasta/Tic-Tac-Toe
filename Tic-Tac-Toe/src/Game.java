import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This class manages the game variables and status. The score,
 * piece positions, and whose turn it is is all stored here.
 * @author Coby
 *@deprecated
 */
public class Game {
	/**
	 * 
	 */
	int playerScore;
	int AIScore;
	
	int turn;
	int playerTurns;
	int AITurns;
	/**
	 * Constructor for Game.
	 */
	public Game(){
		turn = 0;
		playerTurns = 0;
		AITurns = 0;
		
	}
	
	/**
	 * Updates game. Call periodically to update the game.
	 */
	public void tick(){
		updateTurn();
		
		if(checkForWins() == 0){
			
		}
		else if(checkForWins() == 1){
			playerScore += 1;
		}
		else if(checkForWins() == 2){
			AIScore += 1;
		}
		
	}
	
	public void add(Piece piece){
		if(piece.getTeam() == 1){
		}
		if(piece.getTeam() == 2){
		}
			
		}
		
		
	
	
	/**
	 * Figures out whose turn it is.
	 *
	 */
	public void updateTurn(){
		
//		if(playerList.size() > AIList.size()){
//			turn = 2;
//		}
//		if(playerList.size() < AIList.size()){
//			turn = 1;
//		}
//		else{
//		}
	}
	
	
		
	
	/**
	 * Returns which player won, if any. 
	 * Returns 0 if nobody.
	 * returns 1 if player.
	 * returns 2 if AI.
	 * @return
	 */
	public int checkForWins(){
		//TODO Create function to allow for checking for wins.
		return 0;
		}
	public void drawPieces(Graphics g){
//		for(Piece p: playerList){
//			System.out.println("Drawing piece.");
//
//			p.draw(g);
//		}
//		for(Piece p: AIList){
//			p.draw(g);
//		}
	}
	
	public boolean checkForDuplicates(){
	//TODO Add function to check for duplicates.
		    return false;
		
		
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public int getAIScore() {
		return AIScore;
	}
	
}
