package 택진이형;

import java.util.ArrayList;

public class ProductMgr {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	private ProductMgr() {}
	
	public static ProductMgr getInstance() { return LH.INSTANCE; }
	
	private static class LH{
		private static final ProductMgr INSTANCE = new ProductMgr();
	}
	
	//상품 추가
	public void add(Product p) {
		products.add(p);
	}
	//상품 전체 검색
	public Product[] findAll() {
		if(products.size() != 0) {
			Product[] arr=new Product[products.size()];
			for(int i=0; i<products.size(); i++)
				arr[i] = products.get(i);
			return arr;
		}
		else {
			System.out.println("등록된 제품이 업습니다.");
			return null;
		}
	}
	//상품번호로 검색
	public Product findById(int id) {
		for(Product p :products) {
			if(p.getId() == id)
				return p;
		}
		System.out.println("해당 제품을 찾을 수 없습니다.");
		return null;
	}
	//상품명으로 상품 검색(부분검색 가능)
	public Product[] findByName(String name) {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p.getName().contains(name))
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else {
			System.out.println("해당 이름이 들어간 제품을 찾을 수 없습니다.");
			return null;
		}
	}
	//TV정보만 검색
	public Product[] findTV() {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p instanceof TV)
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else {
			System.out.println("TV 제품이 없습니다.");
			return null;
		}
	}
	//Refrigerator만 검색
	public Product[] findRef() {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p instanceof Refrigerator)
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else
			return null;
	}
	//상품번호로 삭제
	public void delById(int id) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getId() == id) {
				products.remove(i);
				return;
			}
		}
	}
	
	//전체 재고 상품 금액을 구하는 기능
	public int sum() {
		int sum=0;
		for(Product p :products)
			sum+=p.getPrice()*p.getCount();
		return sum;
	}
	
	public int getPriceByType(String type) {
		int sum=0;
		if(type.equals("TV")) {
			Product[] p=findTV();
			for(int i=0; i<p.length; i++)
				sum += p[i].getPrice() * p[i].getCount();
		}else if(type.equals("냉장고")) {
			Product[] p=findRef();
			for(int i=0; i<p.length; i++)
				sum += p[i].getPrice() * p[i].getCount();
		}
		return sum;
	}
	public int getPriceByType(Product p) {
		int sum=0;
		if(p instanceof TV) {
			Product[] p_arr=findTV();
			for(int i=0; i<p_arr.length; i++)
				sum += p_arr[i].getPrice() * p_arr[i].getCount();
		}
		else if(p instanceof Refrigerator) {
			Product[] p_arr=findRef();
			for(int i=0; i<p_arr.length; i++)
				sum += p_arr[i].getPrice() * p_arr[i].getCount();
		}
		
		return sum;
	}
	public int getCountByType(String type) {
		int count=0;
		if(type.equals("TV")) {
			Product[] p=findTV();
			for(int i=0; i<p.length; i++)
				count += p[i].getCount();
		}else if(type.equals("냉장고")) {
			Product[] p=findRef();
			for(int i=0; i<p.length; i++)
				count += p[i].getCount();
		}
		return count;
	}
	public int getCountByType(Product p) {
		int sum=0;
		if(p instanceof TV) {
			Product[] p_arr=findTV();
			for(int i=0; i<p_arr.length; i++)
				sum += p_arr[i].getCount();
		}
		else if(p instanceof Refrigerator) {
			Product[] p_arr=findRef();
			for(int i=0; i<p_arr.length; i++)
				sum += p_arr[i].getCount();
		}
		
		return sum;
	}
	
	////////////////////////////////////////////////////////////////////////
	//파라메터로 TV인지 냉장고 인지를 전달받아 각 제품의 재고금액을 리턴하는 기능
	public String eachPrice(String s) {
		StringBuilder sb=new StringBuilder();
		if(s.equals("TV")) {
			sb.append("<<TV 제품들의 재고금액>>\n");
			Product[] p=findTV();
			for(int i=0; i<p.length; i++)
				sb.append(p[i].getName()+ " - 재고금액: "+ p[i].getPrice() * p[i].getCount()+"\n");
		}else if(s.equals("냉장고")) {
			sb.append("<<냉장고 제품들의 재고금액>>\n");
			Product[] p=findRef();
			for(int i=0; i<p.length; i++)
				sb.append(p[i].getName()+ " - 재고금액: "+ p[i].getPrice() * p[i].getCount()+"\n");
		}
		else 
			sb.append("잘못된 입력입니다.\n");
		return sb.toString();
	}
	//파라메터로 TV인지 냉장고인지를 전달받아 각 제품의 재고 수량을 리턴하는 기능
	public String eachCount(String s) {
		StringBuilder sb=new StringBuilder();
		if(s.equals("TV")) {
			sb.append("<<TV 제품들의 재고수량>>\n");
			Product[] p=findTV();
			for(int i=0; i<p.length; i++)
				sb.append(p[i].getName()+ " - 재고수량: "+ p[i].getCount()+"\n");
		}else if(s.equals("냉장고")) {
			sb.append("<<냉장고 제품들의 재고수량>>\n");
			Product[] p=findRef();
			for(int i=0; i<p.length; i++)
				sb.append(p[i].getName()+ " - 재고수량: "+ p[i].getCount()+"\n");
		}
		else 
			sb.append("잘못된 입력입니다.\n");
		return sb.toString();
	}
	//TV 재고의 평균 인치
	public double averInch() {
		int sum=0;
		int count=0;
		for(Product p :products) {
			if(p instanceof TV) {
				sum += ((TV) p).getInch();
				count++;
			}
		}
		return sum/count;
	}
	//냉장고 리터 합계
	public double sumL() {
		int sum=0;
		for(Product p :products) {
			if(p instanceof Refrigerator)
				sum += Integer.parseInt(((Refrigerator) p).getSize().replace("L", ""));
		}
		return sum;
	}
	//파라메터(상품명(부분문자열 가능), 금액) 전달 , 상품명을 포함하는 상품 중 금액보다 작은 금액의 상품정보 리턴
	public String search(String name, int price) {
		StringBuilder sb=new StringBuilder();
		sb.append("<<검색된 상품목록>>\n");
		
		for(Product p :products) {
			if(p.getName().contains(name) && p.getPrice() <= price)
				sb.append(p.toString()+'\n');
		}
		return sb.toString();
	}
}