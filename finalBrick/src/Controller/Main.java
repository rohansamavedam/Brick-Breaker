package Controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Model.Gameplay;
import View.WelcomeScreen;

public class Main{
	
	JFrame obj = new JFrame();
	
	JPanel panelCont = new JPanel();
	
	WelcomeScreen welcomeScreen = new WelcomeScreen();
	Gameplay gamePlay = new Gameplay();
	
	
	public Main() {
//		obj.add(welcomeScreen);
		
		obj.add(gamePlay); // Here is where we need to figure out how to switch screens.
		
		obj.setBounds(10, 10, 695, 650);
		obj.setTitle("Arkanoid gameplay");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});	  
	}

}

