package com.xihua.wardrobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.ClothesMapper;
import com.xihua.wardrobe.pojo.Clothes;
import com.xihua.wardrobe.pojo.ClothesExample;
import com.xihua.wardrobe.service.ClothesService;

@Service
public class ColthesServiceImpl implements ClothesService {

	@Autowired
	ClothesMapper clothesMapper;

	@Override
	public List<Clothes> queryByOpenId(String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria= example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		
		return clothesMapper.selectByExample(example);
	}

	@Override
	public boolean insertClothes(Clothes clothes) {
		clothesMapper.insert(clothes);
		return true;
	}

	@Override
	public boolean deleteClothes(String openId, Long id) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		criteria.andIdEqualTo(id);
		clothesMapper.deleteByExample(example);
		return true;
	}

	@Override
	public Clothes queryById(Long id) {
		return clothesMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteById(Long id) {
		clothesMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public int queryNumberByParentClassificationName(String parentName, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 模糊查询条件需要自己设置
		if(!parentName.equals("") && !parentName.isEmpty()){ 
			parentName = "%" + parentName + "%";
		}
		criteria.andClassificationLike(parentName);
		criteria.andOpenIdEqualTo(openId);
		return clothesMapper.countByExample(example);
	}

	@Override
	public int queryNumberByChildClassificationName(String childName, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		criteria.andClassificationEqualTo(childName);
		criteria.andOpenIdEqualTo(openId);
		return clothesMapper.countByExample(example);
	}

	@Override
	public List<Clothes> listByClassificationName(String classificationName, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andOpenIdEqualTo(openId);
		criteria.andClassificationEqualTo(classificationName);
		return clothesMapper.selectByExample(example);
	}

	@Override
	public int queryNumnerByColor(String Color, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andColorEqualTo(Color);
		criteria.andOpenIdEqualTo(openId);
		return clothesMapper.countByExample(example);
	}

	@Override
	public int queryNumnerBySeason(String season, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andSeasonEqualTo(season);
		criteria.andOpenIdEqualTo(openId);
		return clothesMapper.countByExample(example);
	}

	@Override
	public List<Clothes> listBySeason(String seasonName, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andOpenIdEqualTo(openId);
		criteria.andSeasonEqualTo(seasonName);
		return clothesMapper.selectByExample(example);
	}

	@Override
	public List<Clothes> listByColornName(String colorName, String openId) {
		ClothesExample example = new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andOpenIdEqualTo(openId);
		criteria.andColorEqualTo(colorName);
		return clothesMapper.selectByExample(example);
	}

	@Override
	public List<Clothes> adviceBySeasonAndLevel(Clothes clothes) {
		
		return clothesMapper.adviceBySeasonAndLevel(clothes);
	}
	
	
	
}
