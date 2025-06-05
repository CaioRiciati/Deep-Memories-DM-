package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	// Screen settings
	final int originalTileSize = 16;
	final int scale = 3;

	final int tileSize = originalTileSize * scale;

	final int maxScreenCol = 25;
	final int maxScreenRow = 15;
	final int screenWidth = tileSize * maxScreenCol; //769pixels
	final int screenHeight = tileSize * maxScreenRow;//576pixels
	
	//FPS
	int FPS = 60;
	
	KeyHandler KeyH = new KeyHandler();
	Thread gameThread;
	
	//set Player's default position
	int playerX= 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.LIGHT_GRAY);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {

			
			 
			//System.out.println("The game loop is running");
			//Update: information such as character positions
			update();
			//Draw: draw the screen with the updated information
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		if(KeyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		else if(KeyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if(KeyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if(KeyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
	}
	
}
