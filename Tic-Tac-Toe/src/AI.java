
public class AI {
	
	
	public AI(){

		
	}
	
	/**
	 * Checks situation and takes action. Filter through moves
	 * possible.
	 */
	public void move(){
		if (ICanWin() == true);
		if(oppCanWin() == true);
		if(oppCanFork() == true);
		if(firstMove() == true);
		if(secondMove() == true) goMiddle();
	}
	
	
	//Methods for checking situation.
	public boolean ICanWin(){
		//TODO Add functionality to Checking for winning.
		return false;
		
	}
	public boolean oppCanWin(){
		//TODO Add functionality to defense.
		return false;
		
	}
	public boolean oppCanFork(){
		//TODO Add functionality to secondary defense(checking for fork)
		return false;
		
	}
	public boolean firstMove(){
		//TODO Add first move code.
		return false;
		
	}
	public boolean secondMove(){
		return true;
		
	}
	public void goCorner(){
		
	}
	public void moveSide(){
		
	}
	public void goMiddle(){
	}
	
	
}
