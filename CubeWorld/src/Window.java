import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;


public class Window extends JPanel implements Runnable{
	private static final long serialVersionUID = 5259700796854880162L;
	private final int scale = 5;
	private final int tileSize = 10* scale;
	private final int tileGridX = 20;
	private final int tileGridY = 10;
	
	private final int screenX = tileGridX*tileSize;
	private final int screenY = tileGridY*tileSize;
	
	private final int fps = 60;
	
	protected WorldGrid worldGrid;
	protected ArrayList<Entity> entitysList;
	
	public Thread gameThread;
	
	Graphics2D g2;
	
	
	public Window() {
		this.setPreferredSize(new Dimension(screenX, screenY));
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		
		worldGrid = new WorldGrid(tileGridX, tileGridY, tileSize);
		worldGrid.populateGrid();
		
		entitysList = new ArrayList<Entity>();
		Entity rb1 = new Rabbit(4, 3, g2, worldGrid);
		entitysList.add(rb1);
		Entity rb2 = new Rabbit(4, 3, g2, worldGrid);
		entitysList.add(rb2);
		Entity rb3 = new Rabbit(4, 3, g2, worldGrid);
		entitysList.add(rb3);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void paintGrid(Graphics g, WorldGrid wg){
		g2 = (Graphics2D) g;
	    for(int y =0; y<tileGridY; y++) {
	    
		    for(int x =0; x<tileGridX; x++) {
			    Tile t = wg.tiles.get(y).get(x);
			    g2.setColor(Color.BLACK);
			    g2.drawRect(t.tileX, t.tileY, 50, 50);
			    g2.setColor(Color.GREEN);
			    g2.fillRect(t.tileX,t.tileY, 50, 50);
			    
		    }
	    	  	
	      }
	}

	
	

	
	public void paintComponent(Graphics g)
	   {  
	      // Recover Graphics2D 
		  g2 = (Graphics2D) g;
		  
	     
	      
	      for(int i =0; i<entitysList.size(); i++) {
	    	  	entitysList.get(i).draw(g2);
	      }
	   }
	
	public void update() {
	      for(int i =0; i<entitysList.size(); i++) {
	    	  	entitysList.get(i).update(g2);
	      }
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			paintGrid(getGraphics(), worldGrid);
			update();
			paintComponent(getGraphics());
			
		}

		
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

}
