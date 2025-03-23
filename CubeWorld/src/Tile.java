import java.util.ArrayList;

public class Tile {
	protected int tileX;
	protected int tileY;
	
	protected ArrayList<Tile> neighbors;
	protected Entity occupying;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Tile(int x, int y) {
		tileX = x;
		tileY = y;
	}
	
	public int getTileX() {
		return tileX;
		
	}
	
	public int getTileY() {
		return tileY;
		
	}
	
	public void setOccypying(Entity e) {
		occupying = e;
	}
	
	public Entity getOccypying() {
		return occupying;
	}
	
	public ArrayList<Tile>  getNeighbors() {
		return neighbors;
	}
	
	public void setNeighbors(ArrayList<Tile> n) {
		neighbors = n;
	}

}
