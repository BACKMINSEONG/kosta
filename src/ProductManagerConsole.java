import java.util.List;
import java.util.Scanner;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.repository.ProductFileRepository;

public class ProductManagerConsole {
//	//TODO완성하세요
//	//ProductListRepository도 완성하세요
	private ProductFileRepository repository;
	
	ProductManagerConsole(){
		repository = new ProductFileRepository(); //여기만 file 로 바꿔주면 된다.
		}
	
	private static Scanner sc = new Scanner(System.in);
	
	
	private void add() {
		System.out.println(">>상품등록<<");
		System.out.print("상품번호를 입력하세요: ");
		String prodNo = sc.nextLine();
		System.out.print("상품명을 입력하세요 : ");
		String prodName = sc.nextLine();
		System.out.print("상품가격을 입력하세요 : ");
		String strPrice = sc.nextLine();
		int prodPrice = Integer.parseInt(strPrice);
		Product p = new Product(prodNo, prodName, prodPrice);
		try {
			repository.insert(p);
		}catch(AddException ae) {
			System.out.println(ae.getMessage());
		}
	}
	
	private void findAll() {
		System.out.println(">>상품 전체조회<<");
		try {
			List<Product> allProduct = repository.selectAll();
			for(int i = 0 ; i < allProduct.size(); i++) {
				Product p = allProduct.get(i);
				System.out.println(p);
			}
		} catch(FindException fe) {
				System.out.println(fe.getMessage());
			}
		}
		
	private void findByProdNo() {
		System.out.println(">>상품번호로 조회<<");
		System.out.print("상품번호를 입력하세요: ");
		String prodNo = sc.nextLine();
		try {
			Product p = repository.selectByProdNo(prodNo);
			System.out.println(p);
		}catch(FindException fe){
			System.out.println(fe.getMessage());
		}

	}
	
	private void findByProdNoOrName() {
		System.out.println(">>상품번호나 이름으로 조회<<");
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine();
		try {
			List<Product> list = repository.searchWord(search);
			for(Product p : list ) {
				System.out.println(p);
			}
		} catch (FindException fe) {
			System.out.println(fe.getMessage());
		}
	}
	private void modify() {
		System.out.println(">>상품 수정<<");
		System.out.print("상품번호를 입력하세요: ");
		String prodNo = sc.nextLine();
		try {
			Product p = repository.selectByProdNo(prodNo);
			System.out.println(p);
			System.out.print("상품명["+p.getProdName()+"]변경하려면 입력해 주시고, 변경안하려면 enter를 누르세요: ");
			String prodName=sc.nextLine();
			
			if(!prodName.isEmpty()) {
				p.setProdName(prodName);	
			}
			System.out.print("가격은["+p.getProdName()+"]변경하려면 입력해 주시고, 변경안하려면 enter를 누르세요: ");
			String strPrice=sc.nextLine();
			if(!strPrice.isEmpty()) {
				int prodPrice = Integer.parseInt(strPrice);
				p.setProdPrice(prodPrice);
			}
		}catch(FindException fe){
			System.out.println(fe.getMessage());
		}
	}	
		
	
	
	public static void main(String[] args) {
		ProductManagerConsole managerConsole = new ProductManagerConsole();
		
		while(true) {
			System.out.println("작업구분 :상품등록-1, 상품전체조회-2, 상품번호로 조회-3, 검색어로 조회-4, 상품수정-5, 종료-9");

			String opt = sc.nextLine();
			switch(opt) {
			case "1": 
				managerConsole.add();
				break;
			case "2":
				managerConsole.findAll();
				break;
			case "3":
				managerConsole.findByProdNo();
				break;
			case "4":
				managerConsole.findByProdNoOrName();
				break;
			case "5":
				managerConsole.modify();
				break;
			case "9":
				System.exit(0);
			}
		}
	}

}
