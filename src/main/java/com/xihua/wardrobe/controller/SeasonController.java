package com.xihua.wardrobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.Season;
import com.xihua.wardrobe.service.SeasonService;
import com.xihua.wardrobe.util.WResult;

@Controller
public class SeasonController {

	@Autowired
	SeasonService seasonService;
	
	@RequestMapping("season/list")
	@ResponseBody
	public WResult list() {
		List<Season> list = seasonService.listSeason();
		return WResult.build(1, "ok", list);
	}
}
