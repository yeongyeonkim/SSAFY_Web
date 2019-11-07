package pro;

public class TV extends Product {
	private int inch;
	String type;
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public TV() {
		this(null,null,0,0,0,null);
	}
	public TV(String title, String name, int price, int stock, int inch, String type) {
		super(title, name, price, stock);
		this.inch = inch;
		this.type = type;
	}
	public String toString() {
		return super.toString() + "\t|" + inch + "인치\t|" + "타입: " + type;
	}
}