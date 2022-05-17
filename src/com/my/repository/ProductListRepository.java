package com.my.repository;

import java.util.ArrayList;
import java.util.List;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;

public class ProductListRepository implements ProductRepository{
	private List<Product> products;
	public ProductListRepository() { // 생성자 초기화.
		products = new ArrayList<>(); // Constructs an empty list with an initial capacity of ten.
	}
	
	public ProductListRepository(int size) {
		products = new ArrayList<>(size); // size 개수의 index 가 제공.
	}
	public void insert(Product product) throws AddException{
		String prodNo = product.getProdNo();
		int i = 0;
		for(; i < products.size(); i++) {
//			Product p = products.get(i);
//			if(prodNo.equals(p.getProdNo())) {
//				break;
//			}
			if(product.equals(products.get(i))) {
				break;
			}
		}
		if( i == products.size()) {
			products.add(product);
		}else {
//			System.out.println("이미 존재하는 상품입니다");
			throw new AddException("이미 존재하는 상품입니다");
		}
		//product의 prodNo와
		//products저장소 각요소의 prodNo가 같으면
		// syso 이미존재하는 상품 아니면 products.add(product);
		
		
		
	}
	public List<Product> selectAll() throws FindException {
		if(products.size()==0) {
			throw new FindException("상품이 없습니다");
		}
		return products;
		
	}
	public Product selectByProdNo(String prodNo) throws FindException{
//		for(int i =0; i<products.size(); i++) {
//			Product p = products.get(i);
		for(Product p : products) {
			if(p.getProdNo().equals(prodNo)) {
				return p;
			}
		}
		throw new FindException("상품이 없습니다");
	}
	public List<Product> searchWord(String search) throws FindException{
		List<Product> searchList = new ArrayList<>();
		for(int i = 0 ; i < products.size(); i++) {
			Product p = products.get(i);
			String prodNo = p.getProdNo();
			String prodName = p.getProdName();
			if(prodNo.contains(search) || prodName.contains(search)) {
				searchList.add(p);
			}
		}
		if(searchList.isEmpty()) {
			throw new FindException("상품이 없습니다");
		}
		throw new FindException("상품이 없습니다.");
	}
	
	
}
