package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 3;
	
	private int playerX = 310;
	
	private int ballposX = 180;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	public Gameplay() {
		map = new MapGenerator(7, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// Background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// Border
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// Map
		map.draw((Graphics2D)g);
		
		// Paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 800, 8);
		
		// Ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		g.dispose();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 800, 8))) {
				ballYdir = -ballYdir;
			}
			
			int sum = 0;
			
			for(int i = 0; i < map.map.length; i++) {
				for(int j = 0; j < map.map[0].length; j++) {
					// Deal with the intersection with the bricks here.
					sum += map.map[i][j];
					if(map.map[i][j] == 1) {
						Rectangle brick = new Rectangle(j * map.brickWidth + 80, i*map.brickHeight + 50, map.brickWidth, map.brickHeight);
						Rectangle ball = new Rectangle(ballposX, ballposY, 20, 20);
						if(ball.intersects(brick)) {
							ballYdir = -ballYdir;
							map.map[i][j] = 0;
							repaint();
						}
					}
				}
			}
			
			if(sum == 0) {
				play = false;
				
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
			}
		}
		
		repaint();
		// This method is called automatically and this is responsible for repainting the screen whenever an action is performed.
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}else {
				moveLeft();
			}
		}
		
	}
	
	public void moveRight() {
		play = true;
		playerX += 40;
	}

	public void moveLeft() {
		play = true;
		playerX -= 40;
	}


}
