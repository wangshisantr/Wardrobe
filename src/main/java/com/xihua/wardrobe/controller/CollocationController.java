package com.xihua.wardrobe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.Collocation;
import com.xihua.wardrobe.service.CollocationService;
import com.xihua.wardrobe.util.WResult;

@Controller
@RequestMapping("collocation")
public class CollocationController {

	@Autowired
	CollocationService collocationService;

	@ResponseBody
	@RequestMapping("insert")
	public WResult insert(Collocation collocation) {
		collocationService.insert(collocation);
		return WResult.build(1, "ok");
	}

	@ResponseBody
	@RequestMapping("list")
	public WResult listClothes(String openId) {
		List<Collocation> list = collocationService.list(openId);
		for (Collocation collocation : list) {
			// 把创建搭配的日期和穿的日期转化为字符串
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dressDateSting = simpleDateFormat.format(collocation.getDate());
			String createDate = simpleDateFormat.format(collocation.getCreatDate());
			collocation.setDressDateString(dressDateSting);
			collocation.setCreatDateString(createDate);
		}
		return WResult.build(1, "ok", list);
	}

	@ResponseBody
	@RequestMapping("listByDate")
	public WResult listByDate(String creatDate, String openId) throws ParseException {
		// yyyy-MM-dd HH:mm:ss
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(creatDate);
		List<Collocation> list = collocationService.listByDate(date, openId);
		for (Collocation collocation : list) {
			// 把创建搭配的日期和穿的日期转化为字符串
			String dressDateSting = simpleDateFormat.format(collocation.getDate());
			String createDate = simpleDateFormat.format(collocation.getCreatDate());
			collocation.setDressDateString(dressDateSting);
			collocation.setCreatDateString(createDate);
		}
		return WResult.build(1, "ok", list);
	}

	@ResponseBody
	@RequestMapping("queryById")
	public WResult queryById(Long id) {
		Collocation collocation = collocationService.queryById(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 把创建搭配的日期和穿的日期转化为字符串
		String dressDateSting = simpleDateFormat.format(collocation.getDate());
		String createDate = simpleDateFormat.format(collocation.getCreatDate());
		collocation.setDressDateString(dressDateSting);
		collocation.setCreatDateString(createDate);
		return WResult.build(1, "ok", collocation);
	}

	@ResponseBody
	@RequestMapping("deleteById")
	public WResult deleteById(Long id) {
		collocationService.deleteById(id);
		return WResult.build(1, "ok");
	}
}
