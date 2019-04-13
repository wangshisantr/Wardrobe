package com.xihua.wardrobe.service;

import java.util.List;

import com.xihua.wardrobe.pojo.Classification;

public interface ClassificationService {

	/**
	 *   列出顶级分类
	 * @return
	 */
	List<Classification> listParent();
	
	/**
	 *  根据ParentId列出所有子分类
	 * @return
	 */
	List<Classification> listChildByParentId(Integer parentId);
}
