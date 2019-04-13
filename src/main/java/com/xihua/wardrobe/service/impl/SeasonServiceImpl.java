package com.xihua.wardrobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.SeasonMapper;
import com.xihua.wardrobe.pojo.Season;
import com.xihua.wardrobe.pojo.SeasonExample;
import com.xihua.wardrobe.service.SeasonService;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	SeasonMapper seasonMapper;
	
	@Override
	public List<Season> listSeason() {
		SeasonExample example = new SeasonExample();
		return seasonMapper.selectByExample(example);
	}

}
