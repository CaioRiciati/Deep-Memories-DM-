package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	// Screen settings
	final int originalTileSize = 10;
	final int scale = 12;

	public final int tileSize = originalTileSize * scale;

	public final int maxScreenCol = 10;
	public final int maxScreenRow = 6;
	public final int screenWidth = tileSize * maxScreenCol; //769pixels
	public final int screenHeight = tileSize * maxScreenRow;//576pixels
	
	//World setting
	public final int maxWorldCol = 25;
	public final int maxWorldRow = 25;
	public final int worldWith = tileSize * maxWorldCol;
	public final int worldHeight= tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this,keyH);
	

	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.LIGHT_GRAY);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
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

		player.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
}
