package BrickBreaker;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		Gameplay gamePlay = new Gameplay();
		
		JFrame obj = new JFrame();
		
		obj.add(gamePlay);
		
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Arkanoid");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
