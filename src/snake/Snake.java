package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Snake {
	private Play play;
	private boolean collision = false;
	private int WIDTH = 10, HEIGHT = 10;
	private int ya = 0;
	private int xa = 0;
	private int dots = 3;
	private int up, down, left, right;
	private int dSize = 10;
	private int panelWidth = 585, panelHeight = 545;
	private final int xd[] = new int[3600];
	private final int yd[] = new int[3600];
	
	Snake(Play play, int up, int down, int left, int right) {
		this.play = play;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		
		for (int z = 0; z < dots; z++) {
            xd[z] = 50 - z * 10;
            yd[z] = 50;
		}
	}
	
	public void update() {

        for (int z = dots; z > 0; z--) {
            xd[z] = xd[(z - 1)];
            yd[z] = yd[(z - 1)];
        }

        if (xa == -2) {
            xd[0] -= dSize;
        }

        if (xa == 2) {
            xd[0] += dSize;
        }

        if (ya == -2) {
            yd[0] -= dSize;
        }

        if (ya == 2) {
            yd[0] += dSize;
        }
        checkCollision();
    }
	
	public boolean checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (xd[0] == xd[z]) && (yd[0] == yd[z])) {
            	collision = true;
            }
        }

        if (yd[0] >= panelHeight) {
        	collision = true;
        }

        if (yd[0] < 0) {
        	collision = true;
        }

        if (xd[0] >= panelWidth) {
        	collision = true;
        }

        if (xd[0] < 0) {
        	collision = true;
        }
        return collision;
    } 

	
	public void pressed(int keyCode) {
	        if (keyCode == up) {
	        	xa = 0;
	            ya = -2;
	        } else if (keyCode == down) {
	        	xa = 0;
	        	ya = 2;
	        } else if (keyCode == left) {
	        	ya = 0;
	        	xa = -2;
	        } else  {
	        	ya = 0;
	        	xa = 2;
	        }     
	    }

	public void released(int keyCode) {
	        if (keyCode == up || keyCode == down)
	            ya = 0;
	        if (keyCode == left || keyCode == right)
	        	xa = 0;
	    }
	
	public int getDots() {
		return dots;
	}
	
	public void setDots(int d) {
		dots = d;
	}
	
	public Ellipse2D.Double getBounds() {
        return new Ellipse2D.Double(xd[0], yd[0], WIDTH, HEIGHT);
    }
	
	public void paint(Graphics g) {
		for(int i = 0; i < dots; i++) {
			g.setColor(Color.GREEN);
			g.fillOval(xd[i], yd[i], WIDTH, HEIGHT);
		}
    }
}
