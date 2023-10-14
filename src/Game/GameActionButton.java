package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameActionButton extends JButton implements ActionListener {

	private GameState State;
	private String btnType; 
	
	public GameActionButton(String text, GameState state, String btntype) {
		super(text);
		
		this.State = state;
		this.btnType = btntype;
		
		this.addActionListener(this);
		this.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnType == "add" ) {
			System.out.println("Add button clicked");
			this.State.buyCandy();	
		} else if (btnType == "remove") {
			this.State.removeCandy();
		} else if (btnType == "next") {
			this.State.nextDay();
		}
	}

}
