package pro;

public interface IProductMgr {

	void add(Product product);
	
	Product[] allProducts();
	
	Product findBytitle(String title);
	
	Product[] findByname(String name); 
	
	Product[] findTV();
	
	Product[] findRefrigerator();
	
	boolean eraseByNum(String title);
	
	int sum();
	
	//파라메터로 Tv인지 냉장고인지 전달받아 각 제품의 재고 금액을 리턴하는 기능
	int getPriceByType(String type);
	
	
	//파라메터로 Tv인지 냉장고인지 전달받아 각 제품의 재고 수량을 리턴하는 기능
	int getStockByType(Product p);
	
	//Tv 재고의 평균 인치를 리턴하는 기능
	double average_inch();
	
	//냉장고의 리터 합계를 리턴
	int sum_liter();
	
	//파라메터로 상품명과 금액을 전달, 상품명 포함 && 금액보다 적은 정보리턴.
	Product[] title_price(String name, int price);
	
}
