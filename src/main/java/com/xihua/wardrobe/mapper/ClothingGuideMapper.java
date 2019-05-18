package com.xihua.wardrobe.mapper;

import java.util.List;

import com.xihua.wardrobe.pojo.ClothingGuide;

public interface ClothingGuideMapper {
	
	ClothingGuide selectByLevel(Integer level);

	List<ClothingGuide> list();
}
