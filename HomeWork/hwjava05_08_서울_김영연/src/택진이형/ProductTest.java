package 택진이형;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProductTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		ProductMgr pm = ProductMgr.getInstance();
		boolean flag=true;
		
		init1(pm);
		
		while(flag) {
			System.out.println("<<Product 매니저>>");
			System.out.println("1. 재고금액 검색");
			System.out.println("2. 재고수량 검색");
			System.out.println("3. TV 평균 인치");
			System.out.println("4. 냉장고 리터 합계");
			System.out.println("5. 상품명과 가격으로 제품 검색");
			System.out.println("(종료는 'q'입력)");
			char ch=br.readLine().charAt(0);
			System.out.println();
			switch(ch) {
			case '1':
				getPrice(pm);
				break;
			case '2':
				getCount(pm);
				break;
			case '3':
				System.out.println("TV 평균 인치 : "+pm.averInch());
				break;
			case '4':
				System.out.println("냉장고 리터 합계 : "+pm.sumL());
				break;
			case '5':
				search(pm);
				break;
			case 'q':
				flag=false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			System.out.println();
		}
	}
	
	public static void addP(ProductMgr pm) throws Exception {
		System.out.println("<<상품 추가>>");
		System.out.println("1. TV");
		System.out.println("2. 냉장고");
		char ch=br.readLine().charAt(0);
		switch(ch) {
		case '1':
			System.out.print("-제품번호: ");
			int id=Integer.parseInt(br.readLine());
			System.out.print("-제품명: ");
			String name=br.readLine();
			System.out.print("-가격: ");
			int price=Integer.parseInt(br.readLine());
			System.out.print("-재고수량: ");
			int count=Integer.parseInt(br.readLine());
			System.out.print("-인치: ");
			int inch=Integer.parseInt(br.readLine());
			System.out.print("-타입: ");
			String type=br.readLine();
			pm.add(new TV(id, name, price, count, inch, type));
			System.out.println("TV 제품을 추가하였습니다.");
			break;
		case '2':
			System.out.print("-제품번호: ");
			id=Integer.parseInt(br.readLine());
			System.out.print("-제품명: ");
			name=br.readLine();
			System.out.print("-가격: ");
			price=Integer.parseInt(br.readLine());
			System.out.print("-재고수량: ");
			count=Integer.parseInt(br.readLine());
			System.out.print("-인치: ");
			String size=br.readLine();
			pm.add(new Refrigerator(id, name, price, count, size));
			System.out.println("냉장고 제품을 추가하였습니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 초기화면으로 돌아갑니다.");
			break;
		}
	}
	
	public static void findAll(ProductMgr pm) {
		Product[] arr=pm.findAll();
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i].toString());
	}
	
	public static void findByName(ProductMgr pm, String name) {
		Product[] arr=pm.findByName(name);
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void findTV(ProductMgr pm) {
		Product[] arr=pm.findTV();
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void findRef(ProductMgr pm) {
		Product[] arr=pm.findRef();
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void init(ProductMgr pm) {
		TV tv= new TV(12345, "LED고해상도TV", 3200000, 1, 100, "QLED");
		Refrigerator r= new Refrigerator(4321, "미니냉장고", 120000, 1, "800L");
		pm.add(tv);
		pm.add(r);
		System.out.println("샘플 상품 2개를 입력했습니다.");
	} 
	
	public static void getPrice(ProductMgr pm) throws Exception{
		System.out.println("<<재고금액 확인>>");
		System.out.println("1. TV");
		System.out.println("2. 냉장고");
		char ch=br.readLine().charAt(0);
		
		switch(ch) {
		case '1':
			System.out.println("-----------메소드 1-----------");
			System.out.println(pm.getPriceByType("TV"));
			System.out.println("-----------메소드 2-----------");
			System.out.println(pm.getPriceByType(new TV()));
			break;
		case '2':
			System.out.println("-----------메소드 1-----------");
			System.out.println(pm.getPriceByType("냉장고"));
			System.out.println("-----------메소드 2-----------");
			System.out.println(pm.getPriceByType(new Refrigerator()));
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}
	}
	
	public static void getCount(ProductMgr pm) throws Exception{
		System.out.println("<<재고수량 확인>>");
		System.out.println("1. TV");
		System.out.println("2. 냉장고");
		char ch=br.readLine().charAt(0);
		
		switch(ch) {
		case '1':
			System.out.println("-----------메소드 1-----------");
			System.out.println(pm.getCountByType("TV"));
			System.out.println("-----------메소드 2-----------");
			System.out.println(pm.getCountByType(new TV()));
			break;
		case '2':
			System.out.println("-----------메소드 1-----------");
			System.out.println(pm.getCountByType("냉장고"));
			System.out.println("-----------메소드 2-----------");
			System.out.println(pm.getCountByType(new Refrigerator()));
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}
	}
	
	public static void search(ProductMgr pm) throws Exception{
		System.out.println("<<상품 검색>>");
		System.out.print("-상품명: ");
		String name=br.readLine();
		System.out.print("-금액: ");
		int price=Integer.parseInt(br.readLine());
		
		System.out.println(pm.search(name, price));
	}
	
	public static void init1(ProductMgr pm) {
		pm.add(new TV(1001,"좋은 TV",120000, 12, 50, "QLED"));
		pm.add(new Refrigerator(2001, "좋은 냉장고", 100000, 8, "800L"));
		pm.add(new TV(1002,"보통 TV",70000, 13, 30, "LED"));
		pm.add(new Refrigerator(2002, "보통 냉장고", 60000, 10, "500L"));
		pm.add(new TV(1003,"후진 TV",30000, 20, 20, "PDP"));
		pm.add(new Refrigerator(2003, "후진 냉장고", 20000, 13, "300L"));
	}
}