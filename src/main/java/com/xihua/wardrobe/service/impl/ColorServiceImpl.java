package com.xihua.wardrobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.ColorMapper;
import com.xihua.wardrobe.pojo.Color;
import com.xihua.wardrobe.pojo.ColorExample;
import com.xihua.wardrobe.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	ColorMapper colorMapper;
	
	@Override
	public List<Color> listColor() {
		ColorExample example = new ColorExample();
		return colorMapper.selectByExample(example);
	}

}
