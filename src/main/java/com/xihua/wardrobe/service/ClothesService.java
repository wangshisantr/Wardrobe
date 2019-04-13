package com.xihua.wardrobe.service;

import java.util.List;

import com.xihua.wardrobe.pojo.Clothes;

public interface ClothesService {

	boolean insertClothes(Clothes clothes);
	/**
	 *  根据openId和clothes的id删除该用户的指定单品
	 * @param openId
	 * @param id
	 * @return
	 */
	boolean deleteClothes(String openId, Long id);

	List<Clothes> queryByOpenId(String openId);
}
