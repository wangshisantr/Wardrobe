package com.xihua.wardrobe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.Collocation;
import com.xihua.wardrobe.pojo.RankingVO;
import com.xihua.wardrobe.service.CollocationService;
import com.xihua.wardrobe.util.WResult;

@Controller
@RequestMapping("collocation")
public class CollocationController {

	@Autowired
	CollocationService collocationService;

	@ResponseBody
	@RequestMapping(value = "insert", method = { RequestMethod.POST, RequestMethod.GET })
	public WResult insert(Collocation collocation, @RequestParam(value = "dateString") String dateString, String openId)
			throws ParseException {
		collocation.setStatus(1);
		collocation.setLikeCount((long) 0);
		// 把字符串转化为日期
		if (dateString != null && !dateString.equals("")) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateResult = simpleDateFormat.parse(dateString);
			collocation.setDate(dateResult);
		}
		collocation.setCreatDate(new Date());
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
			String dressDateSting = "";
			if (collocation.getDate() != null) {
				dressDateSting = simpleDateFormat.format(collocation.getDate());
			}
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
	
	@ResponseBody
	@RequestMapping("listRanking")
	public WResult listRanking() {
		List<RankingVO> listCollocation = collocationService.listRanking();
		return WResult.build(1, "ok", listCollocation);
	}
	
	@ResponseBody
	@RequestMapping("updateByGiveLike")
	public WResult updateByGiveLike(Long id) {
		collocationService.updateByGivelike(id);
		return WResult.build(1, "ok");
	}
}
