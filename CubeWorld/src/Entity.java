import java.awt.Graphics2D;

public abstract class Entity {
	protected int x;
	protected int y;
	protected Tile currentTile;
	
	protected int hp;
	protected WorldGrid worldGrid;
	
	abstract public void update(Graphics2D g2);
	
	abstract public void draw(Graphics2D g2);
	
	
}
