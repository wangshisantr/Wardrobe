package com.xihua.wardrobe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.ClothingGuide;
import com.xihua.wardrobe.service.ClothingGuideService;
import com.xihua.wardrobe.util.ClotheslUtil;
import com.xihua.wardrobe.util.WResult;

@Controller
@RequestMapping("clothingGuide")
public class ClothingGuideController {
	
	@Autowired
	ClothingGuideService clothingGuideControllerService;
	
	@ResponseBody
	@RequestMapping("selectByLevel")
	public WResult selectByLevel(Integer temp) {
		int level = ClotheslUtil.selectByLevel(temp);
		ClothingGuide cg = clothingGuideControllerService.selectByLevel(level);
		return WResult.build(1, "ok", cg);
	}
	
	@ResponseBody
	@RequestMapping("list")
	public WResult list(Integer temp) {
		List<ClothingGuide> list = clothingGuideControllerService.list();
		return WResult.build(1, "ok", list);
	}
}