import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This class manages the game variables and status. The score,
 * piece positions, and whose turn it is is all stored here.
 * @author Coby
 *
 */
public class Game {
	/**
	 * 
	 */
	ArrayList<Piece> playerList;
	int playerScore;
	int AIScore;
	int[][] playerArray;
	int[][] AIArray;
	int turn;
	int playerTurns;
	int AITurns;
	ArrayList<Piece> AIList;
	/**
	 * Constructor for Game.
	 */
	public Game(){
		AIList = new ArrayList<Piece>();
		playerList = new ArrayList<Piece>();
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
			playerList.add(piece);
		}
		if(piece.getTeam() == 2){
			AIList.add(piece);
		}
			
		}
		//TODO Add code to update array.
		//TODO Add code to call drawPlayer in Screen.
	
	
	/**
	 * Figures out whose turn it is.
	 *TODO Figure out how to update whose turn it is.
	 */
	public void updateTurn(){
		if(playerList.size() > AIList.size()){
			turn = 2;
		}
		if(playerList.size() < AIList.size()){
			turn = 1;
		}
		else{
		}
	}
	
	
		
	
	/**
	 * Returns which player won, if any. 
	 * Returns 0 if nobody.
	 * returns 1 if player.
	 * returns 2 if AI.
	 * @return
	 */
	public int checkForWins(){
		int sum = 0;
		for(int[] temp: playerArray){
			for(int i: temp){
				sum += temp[i];
			}
			if(sum == 3){
				return 1;
			}
			else{
				sum = 0;
			}
			
		}
		for(int i = 0; i < 3; i++){	
			for(int temp = 0; temp < 3; temp++){
				sum += playerArray[i][temp];
				
			}
			if(sum == 3){
				return 1;
			}
			else{
				sum = 0;
			}
		}
		for(int i = 0; i < 3; i++){
			sum+= playerArray[i][i];
		}
		if(sum == 3){
			return 1;
		}
		
		
		for(int[] temp: AIArray){
			for(int i: temp){
				sum += temp[i];
			}
			if(sum == 3){
				return 2;
			}
			else{
				sum = 0;
			}
			
		}
		for(int i = 0; i < 3; i++){	
			for(int temp = 0; temp < 3; temp++){
				sum += AIArray[i][temp];
				
			}
			if(sum == 3){
				return 2;
			}
			else{
				sum = 0;
			}
		}
		for(int i = 0; i < 3; i++){
			sum+= AIArray[i][i];
		}
		if(sum == 3){
			return 2;
		}		
		else{
			return 0;
		}
		
	}
	public void drawPieces(Graphics g){
		for(Piece p: playerList){
			System.out.println("Drawing piece.");

			p.draw(g);
		}
		for(Piece p: AIList){
			p.draw(g);
		}
	}
	
	public boolean checkForDuplicates(){
		Set<Piece> seenValues = new HashSet();
		 for(Piece p : playerList){
		        if(seenValues.contains(p)){
		        	System.out.println("Duplicate");
		            return true;
		        }
		        else{
		        	
		            seenValues.add(p);
		        }
		    }
		    return false;
		
		
	}
	
}
