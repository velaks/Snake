package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Apple {
	
	private final int WIDTH = 10, HEIGHT = 10;
	private int x, y;
	private int dotSize = 10;
	private Random random;
	
	Apple() {
		random = new Random();
	}
	
	public void update() {
		x = random.nextInt(58) * dotSize;
		y = random.nextInt(54) * dotSize;
	}
	
	public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		
	}

}
