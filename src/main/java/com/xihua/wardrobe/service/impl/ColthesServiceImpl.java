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
	public List<Clothes> listClothes() {
		ClothesExample example  = new ClothesExample();
		List<Clothes> clothesList = clothesMapper.selectByExample(example);
		return clothesList;
	}

	@Override
	public Clothes queryById(Long id) {
		return clothesMapper.selectByPrimaryKey(id);
	}
	
	
}
