package 택진이형;

public class TV extends Product{
	private int inch;
	private String type;
	
	public TV() { super(); }
	
	public TV(int id, String name, int price, int count, int inch, String type) {
		super(id, name, price, count);
		this.inch = inch;
		this.type = type;
	}
	
	public int getInch() { return inch; }

	public String toString() {
		return super.toString()+" / 인치: "+inch+" / 타입: "+type;
	}
}
