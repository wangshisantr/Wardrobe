package com.xihua.wardrobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.Color;
import com.xihua.wardrobe.service.ColorService;
import com.xihua.wardrobe.util.WResult;

@Controller
public class ColorController {

	@Autowired
	ColorService colorService;
	
	@ResponseBody
	@RequestMapping("color/list")
	public WResult listColor() {
		List<Color> list = colorService.listColor();
		return WResult.build(1, "ok", list);
	}
}
