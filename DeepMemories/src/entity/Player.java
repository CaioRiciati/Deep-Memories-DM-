package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try{
			up = ImageIO.read(getClass().getResourceAsStream("/player/default-up.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/default-up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/default-up2.png"));
			
			down = ImageIO.read(getClass().getResourceAsStream("/player/default-down.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/default-down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/default-down2.png"));
			
			left = ImageIO.read(getClass().getResourceAsStream("/player/default-left.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/default-left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/default-left2.png"));
			
			right = ImageIO.read(getClass().getResourceAsStream("/player/default-right.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/default-right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/default-right2.png"));
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void update() {

	    if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

	        if(keyH.upPressed) {
	            direction =  "up";
	            y -= speed;
	        }
	        if(keyH.downPressed) {
	            direction =  "down";
	            y += speed;
	        }
	        if(keyH.leftPressed) {
	            direction =  "left";
	            x -= speed;
	        }
	        if(keyH.rightPressed) {
	            direction =  "right";
	            x += speed;
	        }

	        spriteCounter++;
	        if (spriteCounter > 10) {
	            spriteNum++;
	            if (spriteNum > 3) {
	                spriteNum = 1;
	            }
	            spriteCounter = 0;
	        }

	    } else {
	        // Quando o jogador está parado, volta ao sprite 1
	        spriteNum = 1;
	    }

	}
		
	
	
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		
		switch (direction) {
		case "up": 
			if(spriteNum == 1) {
			image = up;
			}
			if(spriteNum == 2) {
			image = up1;
			}
			if(spriteNum == 3) {
			image = up2;
			}
			break;
			
		case "down":
			if(spriteNum == 1) {
			image = down;
			}
			if(spriteNum == 2) {
				image = down1;
			}
			if(spriteNum == 3) {
				image = down2;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
			image = left;
			}
			if(spriteNum == 2) {
				image = left1;
			}
			if(spriteNum == 3) {
				image = left2;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
			image = right;
			}
			if(spriteNum == 2) {
				image = right1;
			}
			if(spriteNum == 3) {
				image = right2;
			}
			break;
			
		}
		g2.drawImage(image,x,y, 180, 180, null);
	}
}