package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class MidPanel extends JPanel {
	private JPanel LeftPanel;
	private JPanel CenterPanel;
	private JPanel RightPanel;
	
	private GameActionButton btnAdd;
	private GameActionButton btnRemove;
	private GameActionButton btnNextDay;
	
	private PurchaseList lstWarehouse;
	private PurchaseList lstShop;
	
	private GameState gameState;
	
	public MidPanel(GameState state) {
		super();
		this.gameState = state;
		setPreferredSize(new Dimension(800, 575));
		
		
		this.LeftPanel = new JPanel();

		this.lstWarehouse = new PurchaseList(this.gameState.Warehouse, this.gameState, "warehouse");
		JScrollPane warehouseScroll = new JScrollPane(lstWarehouse);
		warehouseScroll.setPreferredSize(new Dimension(325, 500));
		this.LeftPanel.add(warehouseScroll, BorderLayout.CENTER);
		
		this.CenterPanel = new JPanel();
		this.CenterPanel.setLayout(new BoxLayout(this.CenterPanel, BoxLayout.Y_AXIS));
		
		this.btnAdd = new GameActionButton("Add", this.gameState, "add");
		this.CenterPanel.add(this.btnAdd);
		
		this.btnRemove = new GameActionButton("Remove", this.gameState, "remove");
		this.CenterPanel.add(this.btnRemove);
		
		this.btnNextDay = new GameActionButton("Next Day", this.gameState, "next");
		this.CenterPanel.add(this.btnNextDay);
		
		this.RightPanel = new JPanel();
		this.lstShop = new PurchaseList(this.gameState.Shop, this.gameState, "shop");
		JScrollPane shopScroll = new JScrollPane(lstShop);
		shopScroll.setPreferredSize(new Dimension(325, 500));
		this.RightPanel.add(shopScroll);
		
		
		add(this.LeftPanel, BorderLayout.PAGE_START);
		add(this.CenterPanel, BorderLayout.CENTER);
		add(this.RightPanel, BorderLayout.PAGE_END);
	}
}
