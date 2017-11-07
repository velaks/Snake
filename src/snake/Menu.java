package snake;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private JMenu mainMenu;
	private JMenu newGame;
	private JMenuItem easyDif;
	private JMenuItem medDif;
	private JMenuItem hardDif;
	private JMenuItem exit;
	
	Menu(Play play){
		
		mainMenu = new JMenu("Menu");

		newGame = new JMenu("New game");
		mainMenu.add(newGame);
		
		easyDif = new JMenuItem("Easy");
		newGame.add(easyDif);
		easyDif.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                play.getPanel().startNew(150);
            }           
        });
		
		medDif = new JMenuItem("Medium");
		newGame.add(medDif);
		medDif.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                play.getPanel().startNew(100);
            }           
        });
		
		hardDif = new JMenuItem("Hard");
		newGame.add(hardDif);
		hardDif.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                play.getPanel().startNew(50);
            }           
        });
		
		exit = new JMenuItem("Exit");
		mainMenu.add(exit);
		exit.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                System.exit(0);             
            }           
        });

		setOpaque(true);
		add(mainMenu);
        setPreferredSize(new Dimension(600, 20));
	}
}
