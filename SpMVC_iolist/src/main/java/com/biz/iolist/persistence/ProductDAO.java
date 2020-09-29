package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.model.ProductVO;

public interface ProductDAO extends GenericDAO<ProductVO, String> {

	public List<ProductVO> selectAll();

	public List<ProductVO> findById(String io_pcode);
}
