import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngineManager;
import javax.swing.JButton;
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
		GameLoop loop = new GameLoop();
		setLocation(0, 0);
		setVisible(true);
		JFrame panel;
		
		add(loop);
		
		
	}
	public static void main(String[] args) {
		new Main();
	
	}

}

