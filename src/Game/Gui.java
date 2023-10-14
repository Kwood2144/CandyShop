package Game;

import java.awt.*;
import javax.swing.*;


public class Gui extends JFrame {
	
	private JPanel mainPanel;
	private TopPanel topPanel;
	private MidPanel midPanel;
	private GameState gameState;

	public Gui() {
		this.gameState = new GameState();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setMinimumSize(new Dimension(800, 600));
		
		// setup panels
		this.mainPanel = new JPanel();
		this.mainPanel.setPreferredSize(new Dimension(800, 100));

		add(this.mainPanel, BorderLayout.CENTER);
		
		this.topPanel = new TopPanel(this.gameState);
		this.mainPanel.add(this.topPanel, BorderLayout.PAGE_START);
		this.gameState.registerTopPanel(topPanel);
		
		this.midPanel = new MidPanel(this.gameState);
		this.mainPanel.add(this.midPanel, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();
	}

}
