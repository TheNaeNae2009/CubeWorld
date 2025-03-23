import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Rabbit extends Entity{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Rabbit(int newX,int newY, Graphics2D newG2, WorldGrid wg) {
		
		x=newX;
		y=newY;
		worldGrid = wg;
		currentTile = worldGrid.tiles.get(y).get(x);
	}
	
	
	@Override
	public void update(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.drawRect(currentTile.getTileX(), currentTile.getTileY(), 50, 50);
		g2.setColor(Color.GREEN);
		g2.fillRect(currentTile.getTileX(), currentTile.getTileY(), 50, 50);
		this.wander();
		currentTile = worldGrid.tiles.get(y).get(x);
		
	}



	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.drawRect(currentTile.getTileX(), currentTile.getTileY(), 50, 50);
		g2.setColor(Color.GRAY);
		g2.fillRect(currentTile.getTileX(), currentTile.getTileY(), 50, 50);
		g2.setColor(Color.BLACK);
		g2.fillRect(currentTile.getTileX()+35, currentTile.getTileY()+10, 10, 15);
		g2.fillRect(currentTile.getTileX()+5, currentTile.getTileY()+10, 10, 15);
		g2.setColor(Color.GREEN);
		
	}
	
	public void wander() {
		Random random = new Random();
		int ranX = random.nextInt(2+1)-1;
		int ranY = random.nextInt(2+1)-1;
		
		System.out.println(ranX+" "+ranY);
		if(x+ ranX<worldGrid.gridX && x+ ranX>0) {
			x += ranX;
		}
		
		if(y+ ranY<worldGrid.gridY && y+ ranY>0) {
			y += ranY;
		}

	}

}
