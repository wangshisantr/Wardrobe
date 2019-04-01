package com.xihua.wardrobe.service;

import java.util.List;

import com.xihua.wardrobe.pojo.Clothes;

public interface ClothesService {

	List<Clothes> listClothes();
	Clothes queryById(Long id);
}
