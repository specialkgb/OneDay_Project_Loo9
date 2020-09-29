package com.biz.iolist.persistence;

import java.util.List;

public interface GenericDAO<VO, PK> {
	public List<VO> selectAll();
	public VO findBySeq(PK seq); // ID = PK라는 개념으로 생성하는 method
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);


}
