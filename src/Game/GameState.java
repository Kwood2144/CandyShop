package Game;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class GameState {
	public int Day;
	public double Bank;
	public double Debt;
	public DefaultListModel<Candy> Warehouse;
	public DefaultListModel<Candy> Shop;
	public TopPanel infoPanel;
	
	public int warehouseSelectedIndex = -1;
	public int shopSelectedIndex = -1;
	
	public GameState() {
		super();
		this.Day = 1;
		this.Bank = 20;
		this.Debt = 0;
		
		this.Warehouse = new DefaultListModel<Candy>();
		this.Warehouse.addElement(new Candy("Jawbreaker", 0.05));
		this.Warehouse.addElement(new Candy("Bubble Gum", 0.05));
		this.Warehouse.addElement(new Candy("Gummy Bears", 0.40));
		this.Warehouse.addElement(new Candy("Chocolate Bar", 1.25));
		
		this.Shop = new DefaultListModel<Candy>();
	}
	
	public void registerTopPanel(TopPanel panel) {
		this.infoPanel = panel;
	}
	
	public void updateTopPanel() {
		this.infoPanel.updateValues();
	}
	
	public boolean buyCandy() {
		Candy purchased = this.Warehouse.getElementAt(warehouseSelectedIndex);
		System.out.println("Buying candy" + purchased.Name);
		
		if (this.Bank < purchased.Cost) {
			return false;
		}
		
		this.Bank = this.Bank - purchased.Cost;

		this.Shop.addElement(new Candy(purchased.Name, purchased.Cost));
		
		this.shopSelectedIndex = 0;
		updateTopPanel();
		return true;
	}
	
	// removeCandy function
	public boolean removeCandy() {
		// logic
		Candy removed = this.Shop.getElementAt(shopSelectedIndex);
		System.out.println("Removing candy " + removed.toString());
		// remove it, then update money
		this.Shop.removeElementAt(shopSelectedIndex);
		this.Bank += removed.Cost;
		updateTopPanel();
		return true;
	}
	
	public void sellCandy(int index) {
		Candy removed = this.Shop.getElementAt(index);
		System.out.println("Selling candy " + removed.toString());
		this.Shop.removeElementAt(index);
		this.Bank += removed.Price;
	}

	// next Day function 
	public void nextDay() {

		this.Day++;
		

		for (int i = this.Shop.size() - 1; i >= 0; i--) {
			// generate a random number between 0 and 1
			// if number is above a threshold, sell the item
			
			if (this.Shop.getElementAt(i).isExpired()) {
				// delete it
				System.out.println(this.Shop.getElementAt(i).Name + " has expired.");
				this.Shop.removeElementAt(i);
			} else {
				int threshold = RandomIntInRange(30, 95);
				
				if (RandomIntInRange(1, 100) >= threshold) {
					sellCandy(i);
				}
			}
			
			
		}
		
		updateTopPanel();
	}
	
	public int RandomIntInRange(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
