package pro;

public class ProductMgr implements IProductMgr {
	Product[] p;
	int idx;

	public ProductMgr() {
		idx = 0;
		p = new Product[3];
	}

	public void add(Product product) {
		p[idx++] = product;
	}

	public Product[] allProducts() {
		return p;
	}

	public Product findBytitle(String title) {
		for (int i = 0; i < idx; i++)
			if (p[i].getTitle().equals(title))
				return p[i];
		return null;
	}

	public Product[] findByname(String name) {
		Product[] p2 = new Product[idx];
		int p_cnt = 0;
		for (int i = 0; i < idx; i++)
			if (p[i].getName().contains(name))
				p2[p_cnt++] = p[i];
		if (p_cnt > 0)
			return p2;
		else
			return null;
	}

	public Product[] findTV() {
		Product[] p2 = new Product[idx];
		int p_cnt = 0;
		for (int i = 0; i < idx; i++)
			if (p[i] instanceof TV)
				p2[p_cnt++] = p[i];
		if (p_cnt > 0)
			return p2;
		else
			return null;
	}

	public Product[] findRefrigerator() {
		Product[] p2 = new Product[idx];
		int p_cnt = 0;
		for (int i = 0; i < idx; i++)
			if (p[i] instanceof Refrigerator)
				p2[p_cnt++] = p[i];
		if (p_cnt > 0)
			return p2;
		else
			return null;
	}

	public boolean eraseByNum(String title) {
		for (int i = 0; i < 5; i++) {
			if (p[i].getTitle() == title) {
				p[i].setName("");
				p[i].setTitle("");
				p[i].setPrice(0);
				p[i].setStock(0);
				return true;
			}
		}
		return false;
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < idx; i++)
			sum += p[i].getPrice();
		return sum;
	}

	public int getPriceByType(String type) {
		int sum = 0;
		if(type.equals("TV")) {
			for(Product s : p) {
				if(s instanceof TV)
					sum += s.getStock() * s.getPrice();
			}
			return sum;
		}
		else if(type.equals("Refrigerator")) {
			for(Product s : p) {
				if(s instanceof TV)
					sum += s.getStock() * s.getPrice();
			}
			return sum;
		}
		return 0;
	}

	public int getStockByType(Product product) {
		int sum = 0;
		if (product instanceof TV) {
			for (Product s : p) {
				if(s instanceof TV)
					sum += s.getStock();
			}
			return sum;
		}
		else if(product instanceof Refrigerator) {
			for(Product s : p) {
				if(s instanceof Refrigerator) 
					sum += s.getStock();
			}
			return sum;
		}
		else
			return 0;
	}

	public double average_inch() {
		int inch = 0;
		int stock = 0;
		for (Product s : p) {
			if (s instanceof TV) {
				stock += s.getStock();
				inch += ((TV) s).getInch() *s.getStock();
			}
		}
		return (double) (inch/stock);
	}

	public int sum_liter() {
		int sum = 0;
		for (Product s : p) {
			if (s instanceof Refrigerator)
				sum += ((Refrigerator) s).getCapacity();
		}
		return sum;
	}

	public Product[] title_price(String name, int price) {
		Product[] p2 = new Product[idx];
		int cnt = 0;
		for (Product s : p) {
			if (s.getName().contains(name) && s.getPrice() < price) {
				p2[cnt++] = s;
			}
		}
		if (cnt == 0)
			return null;
		else
			return p2;
	}
}
