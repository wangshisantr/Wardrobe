package com.xihua.wardrobe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xihua.wardrobe.pojo.ClothingGuide;

@Service
public interface ClothingGuideService {
	ClothingGuide selectByLevel (Integer level);
	
	List<ClothingGuide> list();
}
