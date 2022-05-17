package com.my.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;

public class ProductFileRepository implements ProductRepository{
	private String fileName = "products.txt";
	public void insert(Product product) throws AddException{
		/*
		 * 자원 : products.txxt
		 * FileWriter
		 */
		File file = new File(fileName); //굳이없어도됨.
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		FileWriter fw = null;
		String prodNo = product.getProdNo();
		String prodName = product.getProdName();
		int prodPrice = product.getProdPrice();
		String stuff = prodNo+":"+prodName+":"+prodPrice+"\n";
		
		try { // 만약상품이 있는거면 추가못하게하고싶은데..
			fw = new FileWriter(fileName, true);
			fw.write(stuff);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
		}
			
	public List<Product> selectAll() throws FindException {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			List<Product> all = new ArrayList<>();
			while(sc.hasNextLine()) {// hasNextLine = 읽어올 다음줄이있으면 true 아니면 false.
				String line = sc.nextLine();
				String[] arr = line.split(":",3);
				String prodNo = arr[0];
				String prodName = arr[1];
				int prodPrice = Integer.parseInt(arr[2]);
				Product p = new Product(prodNo, prodName, prodPrice);
				all.add(p);
			}
			if(all.size() == 0) {
				throw new FindException("상품이 없습니다");
			}
			return all;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FindException("상품이 없습니다");
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

	public Product selectByProdNo(String prodNo) throws FindException{
		Scanner sc = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			sc = new Scanner(new FileInputStream(fileName)); 
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] arr = line.split(":",3);
				if(arr[0].equals(prodNo)) {
					String prodName = arr[1];
					int prodPrice = Integer.parseInt(arr[2]);
					Product product = new Product(prodNo, prodName, prodPrice);
					return product;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) {
				try {
					sc.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		throw new FindException ("상품이 없습니다.");
		
	}
	public List<Product> searchWord(String search) throws FindException{
		Scanner sc = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			
			sc = new Scanner(fr);
//			sc = new Scanner(new FileInputStream(fileName));
			List<Product> keyWord = new ArrayList<>();
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] arr = line.split(":",3);
				String prodNo = arr[0];
				String prodName = arr[1];
				int prodPrice = Integer.parseInt(arr[2]);
				Product p = new Product(prodNo, prodName, prodPrice);
				if(prodNo.contains(search) || prodName.contains(search)) {
					keyWord.add(p);
					return keyWord;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(sc != null) {
				sc.close();
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		throw new FindException("상품이 없습니다.");
				
	}
	}


