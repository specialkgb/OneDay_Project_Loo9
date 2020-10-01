package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.persistence.ProductDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service("proServiceV1")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO proDao;

	@Override
	public List<ProductVO> selectAll() {
		
		List<ProductVO> proList = proDao.selectAll();
		log.debug(proList.toString());
		
		proList = setIOPrice(proList);
		return proList;
	}

	@Override
	public ProductVO findBySeq(long seq) {

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
		int ret = proDao.update(vo);		
		return ret;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		int ret = proDao.delete(seq);
		return ret;
	}
	
	
    private List<ProductVO> setIOPrice(List<ProductVO> proList) {
        int iSum = 0;
        int oSum = 0;
        for (ProductVO proVO : proList) {
            if (proVO.isIo_input()) {
            	proVO.setIo_oprice(proVO.getIo_price() * proVO.getIo_quan());
            	        	
                oSum += (proVO.getIo_price() * proVO.getIo_quan());
                
            } else {
            	proVO.setIo_iprice(proVO.getIo_price() * proVO.getIo_quan());

                iSum += (proVO.getIo_price() * proVO.getIo_quan());
                
            }
            proVO.setIo_iprice_sum(iSum);
            proVO.setIo_oprice_sum(oSum);
        }
        return proList;
    }
}

