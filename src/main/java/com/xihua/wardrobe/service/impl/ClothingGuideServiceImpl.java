package com.xihua.wardrobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.ClothingGuideMapper;
import com.xihua.wardrobe.pojo.ClothingGuide;
import com.xihua.wardrobe.service.ClothingGuideService;

@Service
public class ClothingGuideServiceImpl implements ClothingGuideService {
	
	@Autowired
	ClothingGuideMapper clothingGuideMapper;
	
	@Override
	public  ClothingGuide selectByLevel(Integer level) {
		return clothingGuideMapper.selectByLevel(level);
		
	}

	@Override
	public List<ClothingGuide> list() {
		return clothingGuideMapper.list();
	}

}
