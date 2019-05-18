package com.xihua.wardrobe.service;

import java.util.Date;
import java.util.List;

import com.xihua.wardrobe.pojo.Collocation;
import com.xihua.wardrobe.pojo.RankingVO;

public interface CollocationService {

	/**
	 * 查询用户所有搭配，注意这里需要按照搭配的日期递减排列
	 * @param openId
	 * @return
	 */
	List<Collocation> list(String openId);

	/**
	 * 通过时间查询
	 * @param creatDate
	 * @param openId
	 * @return
	 */
	List<Collocation> listByDate(Date creatDate, String openId);
	
	Collocation queryById(Long id);

	boolean deleteById(Long id);
	
	boolean insert(Collocation collocation);
	
    List<RankingVO> listRanking ();
    
    boolean updateByGivelike (Long id); 
}
