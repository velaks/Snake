package snake;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Play extends JFrame {
	private PlayPanel panel;
	private Menu menuBar;
	
	Play() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(600, 600);
		setTitle("Snake");
		
		menuBar = new Menu();
        setJMenuBar(menuBar);
        
		panel = new PlayPanel(this);
		add(panel);
		
		setLocationRelativeTo(null);
		
	}
	
	public PlayPanel getPanel() {
		return panel;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Play();
			}
		});
	}

}
