package Game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PurchaseList extends JList<Candy> implements ListSelectionListener {

	private GameState gameState;
	private String listType;
	
	public PurchaseList(ListModel<Candy> dataModel, GameState state, String newListType) {
		super(dataModel);
		this.gameState = state;
		setPreferredSize(new Dimension(325, 500));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listType = newListType;
		this.addListSelectionListener(this);
		this.setSelectedIndex(0);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(this.getSelectedIndex());
		if (this.listType == "warehouse") {
			this.gameState.warehouseSelectedIndex = this.getSelectedIndex();	
		} else {
			this.gameState.shopSelectedIndex = this.getSelectedIndex();
		}
	}
}
