package 택진이형;

public class Refrigerator extends Product{
	private String size;

	public Refrigerator() { super(); }
	
	public Refrigerator(int id, String name, int price, int count, String size) {
		super(id, name, price, count);
		this.size = size;
	}
	
	public String getSize() { return size; }
	
	public String toString() {
		return super.toString()+" / 용량: "+size;
	}
}
