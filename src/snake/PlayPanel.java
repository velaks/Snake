package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayPanel extends JPanel implements ActionListener, KeyListener {
    
	private static final long serialVersionUID = 1L;
	private int speed = 150;
    private Timer timer; //A Swing timer (an instance of javax.swing.Timer) fires one or more action events after a specified delay.
	private Apple apple;
	private Snake snake;
	private int score;
	
	PlayPanel() {
		setBackground(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
		startNew(speed);
    }
	
	 public void startNew(int speed) {
		this.speed = speed;
		score = 0;
		apple = new Apple();
		snake = new Snake(KeyEvent.VK_UP, KeyEvent.VK_DOWN,
					KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);

		timer = new Timer(speed, this);
	    timer.start();
	    locateApple();
	 }
	
	 private void locateApple() {
	        apple.update();
	    }
	 
	 private void locateSnake() {
	        snake.update();
	    }
	 
	 public Apple getApple() {
		 return apple;
	 }
	 
	 public void checkFeed() {
	        if (snake.getBounds().intersects(getApple().getBounds())) {
	        	int d = snake.getDots() + 1;
	        	snake.setDots(d);
	        	locateApple();
	        	score++;
	        }
	   }
	 
	 private void gameOver(Graphics g) {
		   
	     String msg = "Game Over. Your score - ";
	     Font small = new Font("Helvetica", Font.BOLD, 14);
	     FontMetrics metr = getFontMetrics(small);
	     
	     setFocusable(true);
	     
	     g.setColor(Color.white);
	     g.setFont(small);
	     g.drawString(msg + score, (560 - metr.stringWidth(msg)) / 2, 560 / 2);
	    }

	 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		apple.paint(g);
		snake.paint(g);
		if(snake.checkCollision()) {
			timer.stop();
			gameOver(g);
			}
		}

	@Override
	public void keyPressed(KeyEvent e) {
		snake.pressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		;	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		locateSnake();
		repaint();
		checkFeed();
	}
}
