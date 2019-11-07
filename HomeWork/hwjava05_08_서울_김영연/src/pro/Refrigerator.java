package pro;

public class Refrigerator extends Product {

	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Refrigerator() {
		this(null, null, 0, 0, 0);
	}
	public Refrigerator(String title, String name, int price, int stock, int capacity) {
		super(title, name, price, stock);
		this.capacity = capacity;
	}
	

	public String toString() {
		return super.toString() + "\t|" + "용량: " + capacity +"L";
	}	
}
