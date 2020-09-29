package com.biz.iolist.service;

import java.util.List;

public interface GenericService<VO, PK> {
	public List<VO> selectAll();
	public VO findBySeq(PK seq); // ID = PK라는 개념으로 생성하는 method
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK io_pcode);

}
