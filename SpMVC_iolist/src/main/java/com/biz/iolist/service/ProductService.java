package com.biz.iolist.service;

import com.biz.iolist.model.ProductVO;

public interface ProductService extends GenericService<ProductVO, String> {

	ProductVO findById(String io_pcode);
	

}
