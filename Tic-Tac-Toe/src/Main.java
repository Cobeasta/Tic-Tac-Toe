import javax.swing.JFrame; 


public class Main extends JFrame{
	
	
	JFrame frame;
	public Main(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Values.frameWidth.getValue() + 300, Values.frameHeight.getValue());
		create();
		
		
	}
	
	public void create(){
		setResizable(false);
		System.out.println("Setting up");
		GameLoop loop = new GameLoop();
		setLocation(Values.screenWidth.getValue()/3, 0);
		setVisible(true);
		
		add(loop);
	}
	public static void main(String[] args) {
		new Main();
	}

}

