package com.xihua.wardrobe.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.CollocationMapper;
import com.xihua.wardrobe.pojo.Collocation;
import com.xihua.wardrobe.pojo.CollocationExample;
import com.xihua.wardrobe.pojo.RankingVO;
import com.xihua.wardrobe.service.CollocationService;

@Service
public class CollocationServiceImpl implements CollocationService {

	@Autowired
	CollocationMapper collocationMapper;
	
	@Override
	public List<Collocation> list(String openId) {
		CollocationExample example = new CollocationExample();
		example.setOrderByClause("date desc");
		CollocationExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		return collocationMapper.selectByExample(example);
	}

	@Override
	public List<Collocation> listByDate(Date creatDate, String openId) {
		CollocationExample example = new CollocationExample();
		CollocationExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		criteria.andDateEqualTo(creatDate);
		return collocationMapper.selectByExample(example);
	}

	@Override
	public Collocation queryById(Long id) {
		return collocationMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteById(Long id) {
		collocationMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public boolean insert(Collocation collocation) {
		collocationMapper.insert(collocation);
		return true;
	}

	@Override
	public List<RankingVO> listRanking() {
		return collocationMapper.listRanking();
	}

	@Override
	public boolean updateByGivelike(Long id) {
		collocationMapper.updateByGivelike(id);
		return true;
	}

}
