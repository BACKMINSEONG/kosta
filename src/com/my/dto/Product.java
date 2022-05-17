package com.my.dto; //DataTransferObject

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Product implements Serializable{
	private String prodNo;
	private String prodName;
	transient private int prodPrice; // transient 는 직렬화에서 제외한다. 보호한다.
	private String prodInfo;
	private Date prodMfd;

	public Product(String prodNo, String prodName, int prodPrice){
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
//		this.(prodNo, prodName, prodPrice, null, null);
	}
	
	public Product(String prodNo, String prodName, int prodPrice, Date prodMfd){
		this(prodNo, prodName, prodPrice);
		this.prodMfd = prodMfd;
	}
	
	public Product(String prodNo, String prodName, int prodPrice, String prodInfo, Date prodMfd){
		this(prodNo, prodName, prodPrice);
		this.prodMfd = prodMfd;
	}
	
	public void print() {
		System.out.println("상품번호: " + prodNo + " 상품명: " + prodName + " 가격: " 
							+ prodPrice + " 상세정보: " + prodInfo + " 제조일자: " + prodMfd);
	}

	@Override
	public String toString() {
		return "상품번호: " + prodNo + ", 상품명은 " + prodName + ", 가격은 " + prodPrice +" 입니다.";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(prodNo, other.prodNo);
	}

	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public Date getProdMfd() {
		return prodMfd;
	}

	public void setProdMfd(Date prodMfd) {
		this.prodMfd = prodMfd;
	}
	
	
}
