package pro;

public class Product {
	private String title;
	private String name;
	private int price;
	private int stock;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product(String title, String name, int price, int stock) {
		this.title = title;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "제품번호: " + title + "\t|" + "제품명: " + name + "\t|" + "가격 정보: " + price + "\t|" + "재고수량: " + stock;
	}
	
	
}
