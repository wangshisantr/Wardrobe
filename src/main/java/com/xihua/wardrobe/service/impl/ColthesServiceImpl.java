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
	
	
}
