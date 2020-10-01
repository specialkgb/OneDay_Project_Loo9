package com.biz.iolist.service;

import java.util.List;

import com.biz.iolist.model.ProductVO;

public interface ProductService {

	public List<ProductVO> selectAll();
	
	public ProductVO findBySeq(long seq);
	
	public int insert(ProductVO vo);
	
	public int update(ProductVO vo);
	
	public int delete(long seq);
	


	

}
