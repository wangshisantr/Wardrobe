package com.xihua.wardrobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.Classification;
import com.xihua.wardrobe.service.ClassificationService;
import com.xihua.wardrobe.util.WResult;

@Controller
public class ClassificationController {

	@Autowired
	ClassificationService classificationService;
	
	@ResponseBody
	@RequestMapping("/classification/listparent")
	public WResult listParent() {
		List<Classification> list = classificationService.listParent();
		return WResult.build(1, "ok", list);
	}
	
	@ResponseBody
	@RequestMapping("/classification/listChild")
	public WResult listChild(Integer parentId) {
		List<Classification> list = classificationService.listChildByParentId(parentId);
		return WResult.build(1, "ok", list);
	}
}
