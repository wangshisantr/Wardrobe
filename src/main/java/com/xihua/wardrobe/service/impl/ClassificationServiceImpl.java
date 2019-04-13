package com.xihua.wardrobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.ClassificationMapper;
import com.xihua.wardrobe.pojo.Classification;
import com.xihua.wardrobe.pojo.ClassificationExample;
import com.xihua.wardrobe.service.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Autowired
	ClassificationMapper classificationMapper;
	
	@Override
	public List<Classification> listParent() {
		ClassificationExample example = new ClassificationExample();
		ClassificationExample.Criteria criteria = example.createCriteria();
		criteria.andIsParentEqualTo((byte) 1);
		criteria.andStatusEqualTo((byte) 1);
		return classificationMapper.selectByExample(example);
	}

	@Override
	public List<Classification> listChildByParentId(Integer parentId) {
		ClassificationExample example = new ClassificationExample();
		ClassificationExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo((byte) 1);
		return classificationMapper.selectByExample(example);
	}

}
