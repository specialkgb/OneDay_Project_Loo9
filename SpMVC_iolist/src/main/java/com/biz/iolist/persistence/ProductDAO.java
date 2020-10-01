package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.model.ProductVO;

public interface ProductDAO  {
	
	
	public List<ProductVO> selectAll();
	
	public ProductVO findBySeq(long seq);
	
	public int insert(ProductVO vo);
	
	public int update(ProductVO vo);
	
	public int delete(long seq);


}
