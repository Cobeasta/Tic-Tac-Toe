package src;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ticTacToe.Game;

public class Frame extends JFrame{
	public static int diX = 900;
	public static int diY = 900;
	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int x1 = 300;
	public static int y1 = 300;
	public static int x2 = 600;
	public static int y2 = 600;
	
	public Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe!");
		setResizable(false);
		init();

		
	}
	//Method called on Screen Creation
	private  void init(){
		Game game = new Game();
		setLayout(new GridLayout(1, 1, 0, 0));
		setSize(diX, diY);
		setLocation(width/4, 0);
		setVisible(true);
		add(game);
	}
	//Called on application start
	public static void main(String[] args) {
		new Frame();
	}

}
