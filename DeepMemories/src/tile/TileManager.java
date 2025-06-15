package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[] [];
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		 
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol] [gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world1.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = new ImageIcon(getClass().getResource("/tiles/grass.gif")).getImage();
			tile[0].animated = true;
			tile[0].animation = new ImageIcon(getClass().getResource("/tiles/grass.gif"));
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bricks.jpg"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.gif"));
			tile[2].animated = true;
			tile[2].animation = new ImageIcon(getClass().getResource("/tiles/water.gif"));
			tile[2].collision = true;			
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/treeLittle.png"));
			tile[5].collision = true;	
			
			// 0 é grama , 1 é tijolos, 2 é agua, 3 é terra, 4 é areia e 5 são arbustos
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
	    try {
	        InputStream is = getClass().getResourceAsStream(filePath);
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));

	        int col= 0;
	        int row = 0;
	        
	        while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
	        	
	        	String line = br.readLine();
	        	
	        	while(col< gp.maxWorldCol) {
	        	
	        		String numbers[] = line.split(" ");
	        		
	        		int num = Integer.parseInt(numbers[col]);
	        		
	        		mapTileNum[col][row] = num;
	        		col++;
	        		
	        	}
	        	if(col == gp.maxWorldCol) {
	        		col = 0;
	        		row++;
	        	}
	        }

	        br.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
		
	
	
	public void draw(Graphics2D g2) {
	    // lado , altura
	    // g2.drawImage(tile[1].image, 0, 0, 300, 300, null);
		
	    int worldCol = 0;
	    int worldRow = 0;

	    while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

	        int tileNum = mapTileNum[worldCol][worldRow];

	        // fique de olho!! talvez vc tenha q mudar os numeros do world x e worldY pq vc usou tileSize
	        int worldX = worldCol * gp.tileSize;
	        int worldY = worldRow * gp.tileSize;
	        int screenX = worldX - gp.player.worldX + gp.player.screenX;
	        int screenY = worldY - gp.player.worldY + gp.player.screenY;

	        // originalmente aki n deveria ter os 120
	        // mas como mudei algumas coisas no tileSize vai ficar assim.
	        if (worldX + (gp.tileSize + 120) > gp.player.worldX - gp.player.screenX &&
	            worldX - (gp.tileSize + 120) < gp.player.worldX + gp.player.screenX &&
	            worldY + (gp.tileSize + 120) > gp.player.worldY - gp.player.screenY &&
	            worldY - (gp.tileSize + 120) < gp.player.worldY + gp.player.screenY) {

	            // Se for animado, desenha a imagem da animação
	            if (tile[tileNum].animated && tile[tileNum].animation != null) {
	                g2.drawImage(tile[tileNum].animation.getImage(), screenX, screenY, gp.tileSize, gp.tileSize, null);
	            } else {
	                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	            }
	        }

	        worldCol++;

	        if (worldCol == gp.maxWorldCol) {
	            worldCol = 0;
	            worldRow++;
	        }
	    }
	}

}
