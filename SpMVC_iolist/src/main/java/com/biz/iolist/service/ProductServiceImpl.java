package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.persistence.ProductDAO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service("proServiceV1")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO proDao;

	@Override
	public List<ProductVO> selectAll() {

		return proDao.selectAll();
	}

	@Override
	public ProductVO findBySeq(String seq) {

		return proDao.findBySeq(seq);
	}

	@Override
	public int insert(ProductVO vo) {
		// TODO Auto-generated method stub
		int ret = proDao.insert(vo);

		if (ret > 0) {
			log.debug("INSERT 성공 {} 개 데이터 추가", ret);
		} else {
			log.debug("INSERT 실패 {}", ret);
		}

		return ret;
	}

	@Override
	public int update(ProductVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductVO findById(String io_pcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
