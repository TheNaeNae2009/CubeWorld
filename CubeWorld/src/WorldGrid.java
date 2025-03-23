import java.awt.Graphics2D;
import java.util.ArrayList;

public class WorldGrid {
	protected int gridX;
	protected int gridY;
	protected int tileSize;
	
	public ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public WorldGrid(int x, int y, int setTileSize) {
		gridX = x;
		gridY = y;
		tileSize = setTileSize;
	}
	
	public void populateGrid() {
		for(int y = 0; y<gridY; y++) {
			tiles.add(new ArrayList<Tile>());
			System.out.println(tiles);
		}
		
		for(int y = 0; y<gridY; y++) {
			for(int x = 0; x<gridX; x++) {
				tiles.get(y).add(new Tile(x*tileSize, y*tileSize));
				System.out.println(x*tileSize + " " + y*tileSize );
			}
		}
		System.out.println(tiles);
	}
	
	public void draw(Graphics2D g2) {

		System.out.print(false);
		for(int y = 0; y<gridY-1; y++) {
			for(int x = 0; x<gridX-1; x++) {
				
				g2.drawRect(x*tileSize, y*tileSize, tileSize, tileSize);
			}
		}
	}
}
