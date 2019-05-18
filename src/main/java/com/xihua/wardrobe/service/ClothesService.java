package com.xihua.wardrobe.service;

import java.util.List;

import com.xihua.wardrobe.pojo.Clothes;

public interface ClothesService {

	boolean insertClothes(Clothes clothes);

	/**
	 * 根据openId和clothes的id删除该用户的指定单品
	 * 
	 * @param openId
	 * @param id
	 * @return
	 */
	boolean deleteClothes(String openId, Long id);

	boolean deleteById(Long id);

	Clothes queryById(Long id);

	/**
	 * 通过分类名查询单品
	 * 
	 * @param classificationName
	 * @param openId
	 * @return
	 */
	List<Clothes> listByClassificationName(String classificationName, String openId);

	/**
	 * 通过分季节查询单品
	 * 
	 * @param classificationName
	 * @param openId
	 * @return
	 */
	List<Clothes> listBySeason(String seasonName, String openId);

	/**
	 * 通过分颜色查询单品
	 * 
	 * @param classificationName
	 * @param openId
	 * @return
	 */
	List<Clothes> listByColornName(String colorName, String openId);

	List<Clothes> queryByOpenId(String openId);

	/**
	 * 根据一级分类名查询单品数量
	 * 
	 * @return
	 */
	int queryNumberByParentClassificationName(String parentName, String openId);

	/**
	 * 根据二级分类名查询单品分类数量
	 * 
	 * @return
	 */
	int queryNumberByChildClassificationName(String childName, String openId);

	/**
	 * 根据颜色查询单品数量
	 * 
	 * @param Color
	 * @param openId
	 * @return
	 */
	int queryNumnerByColor(String Color, String openId);

	/**
	 * 根据季节查询单品数量
	 * 
	 * @param Color
	 * @param openId
	 * @return
	 */
	int queryNumnerBySeason(String Color, String openId);
	
	/**
	 * 根据穿衣等级和 季节查询单品
	 * @param clothes
	 * @return
	 */
    List<Clothes> adviceBySeasonAndLevel(Clothes clothes);
}
