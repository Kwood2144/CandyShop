package Game;

public class Candy {
	public String Name;
	public double Cost;
	public double Price;
	public int ShelfLife;
	
	public Candy(String name, double cost) {
		super();
		Name = name;
		Cost = cost;
		Price = Cost * 2;
		ShelfLife = 3;
	}

	@Override
	public String toString() {
		return Name +
			", Cost: " + Cost +
			", Price: " + Price +
			", Expires in: " + ShelfLife;
	}
	
	public boolean isExpired() {
		ShelfLife--;
		return ShelfLife <= 0;
	}
	
}
