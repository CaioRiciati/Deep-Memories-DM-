package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[] [];
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxScreenCol] [gp.maxScreenCol];
		getTileImage();
		loadMap();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.gif"));
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bricks.jpg"));
			
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.gif"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap() {
	    try {
	        InputStream is = getClass().getResourceAsStream("/maps/mapa1.txt");
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));

	        int row = 0;
	        while(row < gp.maxScreenRow) {
	            String line = br.readLine();
	            String[] numbers = line.split(" ");

	            for(int col = 0; col < gp.maxScreenCol; col++) {
	                int num = Integer.parseInt(numbers[col]);
	                mapTileNum[col][row] = num;
	            }

	            row++;
	        }

	        br.close();

	    } catch(Exception e) {
	        e.printStackTrace(); // Mostre o erro se houver
	    }
	}
	
	public void draw(Graphics2D g2) {
		//lado  , altura
		//g2.drawImage(tile[1].image, 0, 0, 300, 300, null);
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			
			int tileNum = mapTileNum[col] [row];
			
			g2.drawImage(tile[tileNum].image , x, y , 250, 250, null);
			
			col++;
			x+= 250;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x= 0;
				row++;
				y+= 250;
				
			}
			
		}

	}
}
