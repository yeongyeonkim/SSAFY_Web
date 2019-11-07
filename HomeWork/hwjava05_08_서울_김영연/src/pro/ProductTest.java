package pro;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr mgr = new ProductMgr();
		Product[] p = new Product[3];

		p = mgr.allProducts();

		mgr.add(new TV("1001", "삼성 QLED", 3800000, 4, 180, "QLED"));
		mgr.add(new TV("1002", "Premium UHD", 1000000, 3, 12, "B&W"));
		mgr.add(new Refrigerator("11201", "셰프컬렉션", 5800000, 5, 300));

		System.out.println("2. 전체 검색");
		for (int i = 0; i < 3; i++)
			System.out.println(p[i]);
		System.out.println();

		System.out.println("3. 상품번호 검색");
		System.out.println(mgr.findBytitle("1001"));

		System.out.println("4. 상품이름 검색");
		p = mgr.findByname("D");
		if (p == null)
			System.out.println("찾을 수 없습니다!");
		else {
			for(Product s : p)
				if(s != null)
					System.out.println(s.toString());
		}
		
		System.out.println("5. TV만 검색");
		p = mgr.findTV();
		if(p == null)
			System.out.println("찾을 수 없습니다!");
		else {
			for(Product s : p)
				if(s != null)
					System.out.println(s.toString());
		}
		
		System.out.println("6. 냉장고만 검색");
		p = mgr.findRefrigerator();
		if(p == null)
			System.out.println("찾을 수 없습니다!");
		else {
			for(Product s : p)
				if(s != null)
					System.out.println(s.toString());
			
		}		
		
		System.out.println("7. 삭제하는 기능");
		
		boolean r = mgr.eraseByNum("1001");
		if(r == false)
			System.out.println("찾을 수 없습니다!");
		else 
			System.out.println("삭제되었습니다");
		System.out.println();
		
		System.out.println("-----삭제한 상품번호 검색-----");
		Product r2 = mgr.findBytitle("1001");
		if(r2 == null)
			System.out.println("찾을 수 없습니다!");
		else
			System.out.println(r2.toString());
		System.out.println();
		
		
		System.out.println("8. 모든 상품의 금액 합계");
		System.out.println(mgr.sum()+"원");
		
		System.out.println("9. 재고금액을 리턴");
		System.out.print("확인할 물품 이름을 입력하세요: ");
		String name = sc.next();
		System.out.println(mgr.getPriceByType(name));
		System.out.println("10. 재고수량을 리턴");
		
		TV t = new TV();
		Refrigerator r1 = new Refrigerator();
		System.out.print("재고수량을 보고싶은 물품 이름을 입력하세요: ");
		String name2 = sc.next();
		if(name2.equals("TV"))
			System.out.println(mgr.getStockByType(t));
		else if(name2.equals("Refrigerator"))
			System.out.println(mgr.getStockByType(r1));
		
		System.out.println("11. TV 재고의 평균 인치를 리턴");
		System.out.println(mgr.average_inch() + "인치");
		System.out.println("12. 냉장고의 리터 합계를 리턴");
		System.out.println(mgr.sum_liter() + "L");
		System.out.println("13. 금액보다 작은 금액들의 상품들의 정보 리턴");

		p = mgr.title_price("D", 4000000);
		if(p == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for(Product s : p)
				if(s != null)
					System.out.println(s.toString());
		}
	}
}