package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Apple {
	
	private final int WIDTH = 10, HEIGHT = 10;
	private int x, y;
	private int dSize = 10;
	private Random random;
	
	Apple() {
		random = new Random();
	}
	
	public void update() {
		x = random.nextInt(58) * dSize;
		y = random.nextInt(54) * dSize;
	}
	
	public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		
	}

}
