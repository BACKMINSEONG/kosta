package com.my.repository;

import java.util.List;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;

public interface ProductRepository {
	/**
	 * 상품을 추가한ㄷ.
	 * @param product
	 * @throws AddException
	 */
	public void insert(Product product) throws AddException;
	/**
	 * 상품전체조회한다.
	 * @return
	 * @throws FindException
	 */
	public List<Product> selectAll() throws FindException;
	/**
	 * 상품 번호로상품검색한다.
	 * 
	 * @param search
	 * @return
	 * @throws FindException
	 */
	public Product selectByProdNo(String prodNo) throws FindException;
	/**
	 *상품이름,번호로 검색한다.
	 * @param search
	 * @return
	 * @throws FindException
	 */
	public List<Product> searchWord(String search) throws FindException;
}

