package com.xihua.wardrobe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xihua.wardrobe.pojo.Classification;
import com.xihua.wardrobe.pojo.ClassificationClothes;
import com.xihua.wardrobe.pojo.Clothes;
import com.xihua.wardrobe.pojo.Color;
import com.xihua.wardrobe.pojo.Season;
import com.xihua.wardrobe.service.ClassificationService;
import com.xihua.wardrobe.service.ClothesService;
import com.xihua.wardrobe.service.ColorService;
import com.xihua.wardrobe.service.SeasonService;
import com.xihua.wardrobe.util.WResult;

@Controller
@RequestMapping("clothes")
public class ClothesController {

	@Autowired
	ClothesService clothesService;
	@Autowired
	ClassificationService classificationService;
	@Autowired
	ColorService colorService;
	@Autowired
	SeasonService seasonService;
	private Logger logger = Logger.getLogger(ClothesController.class);

	@ResponseBody
	@RequestMapping("insert")
	public WResult Insert(Clothes clothes, String openId) {
		clothes.setUseDegree(0);
		clothesService.insertClothes(clothes);
		return WResult.build(1, "ok", clothes);
	}

	@ResponseBody
	@RequestMapping("list")
	public WResult listClothes(String openId) {
		List<Clothes> list = clothesService.queryByOpenId(openId);
		return WResult.build(1, "ok", list);
	}

	/**
	 * 通过分类名查询单品
	 * 
	 * @param openId
	 * @param classificationName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("listByClassificationName")
	public WResult listByClassificationName(String classificationName, String openId) {
		List<Clothes> list = clothesService.listByClassificationName(classificationName, openId);
		return WResult.build(1, "ok", list);
	}
	
	/**
	 * 通过颜色名查询单品
	 * 
	 * @param openId
	 * @param classificationName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("listByColor")
	public WResult listByColor(@RequestParam(value="classificationName")String colorName, String openId) {
		List<Clothes> list = clothesService.listByColornName(colorName, openId);
		return WResult.build(1, "ok", list);
	}
	
	/**
	 * 通过季节名查询单品
	 * 
	 * @param openId
	 * @param classificationName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("listBySeason")
	public WResult listBySeasonName(@RequestParam(value="classificationName")String seasonName, String openId) {
		List<Clothes> list = clothesService.listBySeason(seasonName, openId);
		return WResult.build(1, "ok", list);
	}

	@ResponseBody
	@RequestMapping("queryClothes")
	public WResult queryById(Long id) {
		return WResult.build(1, "ok", clothesService.queryById(id));
	}

	@ResponseBody
	@RequestMapping("deleteById")
	public WResult deleteById(Long id) {
		clothesService.deleteById(id);
		return WResult.build(1, "ok");
	}

	/**
	 * 查询一级分类列表和对应数量
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("parentClassification")
	public WResult queryNumberByParentClassificationName(String openId) {
		// 获取一级分类列表
		List<Classification> cList = classificationService.listParent();
		List<ClassificationClothes> result = new ArrayList<>();

		for (int i = 0; i < cList.size(); i++) {
			Classification classification = cList.get(i);
			// 获取分类名
			String cName = classification.getName();
			// 根据分类名，模糊查询该类单品的数量
			Integer count = clothesService.queryNumberByParentClassificationName(cName, openId);
			// 获取分类id
			Integer id = classification.getId();
			ClassificationClothes parentClassification = new ClassificationClothes(cName, count, id);
			result.add(parentClassification);
		}
		return WResult.build(1, "ok", result);
	}

	/**
	 * 查询二级分类列表和对应数量
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("childClassification")
	public WResult queryNumberByChildClassificationName(Integer parentId, String openId) {
		// 获取二级分类列表
		List<Classification> cList = classificationService.listChildByParentId(parentId);
		List<ClassificationClothes> result = new ArrayList<>();

		for (int i = 0; i < cList.size(); i++) {
			Classification classification = cList.get(i);
			// 获取分类名
			String cName = classification.getName();
			ClassificationClothes parentClassification = new ClassificationClothes(cName,
					clothesService.queryNumberByParentClassificationName(cName, openId));
			result.add(parentClassification);
		}
		return WResult.build(1, "ok", result);
	}
	
	/**
	 * 查询颜色列表和对应数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping("colorClassification")
	public WResult queryNumberByColor(String openId) {
		// 获取颜色分类列表
		List<Color> cList = colorService.listColor();
		List<ClassificationClothes> result = new ArrayList<>();
		
		for (int i = 0; i < cList.size(); i++) {
			Color color = cList.get(i);
			// 获取分类名
			String colorName = color.getName();
			// 根据分类名查询该类单品的数量
			Integer count = clothesService.queryNumnerByColor(colorName, openId);
			// 获取分类id
			Integer id = color.getId();
			ClassificationClothes classificationClothes = new ClassificationClothes(colorName, count, id);
			result.add(classificationClothes);
		}
		return WResult.build(1, "ok", result);
	}

	/**
	 * 查询季节列表和对应数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping("seasonClassification")
	public WResult queryNumberBySeason(String openId) {
		// 获取季节分类列表
		List<Season> cList = seasonService.listSeason();
		List<ClassificationClothes> result = new ArrayList<>();
		
		for (int i = 0; i < cList.size(); i++) {
			Season season = cList.get(i);
			// 获取分类名
			String seasonName = season.getName();
			// 根据分类名查询该类单品的数量
			Integer count = clothesService.queryNumnerBySeason(seasonName, openId);
			// 获取分类id
			Integer id = season.getId();
			ClassificationClothes classificationClothes = new ClassificationClothes(seasonName, count, id);
			result.add(classificationClothes);
		}
		return WResult.build(1, "ok", result);
	}
	
	/**
	 * 上传图片
	 * 
	 * @param request
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file)
			throws IOException {
		System.out.println("执行upload");
		request.setCharacterEncoding("UTF-8");
		logger.info("执行图片上传");
		String user = request.getParameter("user");
		logger.info("user:" + user);
		if (!file.isEmpty()) {
			logger.info("成功获取照片");
			String fileName = file.getOriginalFilename();
			String path = null;
			String type = null;
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
			if (type != null) {
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					String realPath = request.getSession().getServletContext().getRealPath("/");
					// 自定义的文件名称
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					path = realPath + "/images/" + trueFileName;
					logger.info("存放图片文件的路径:" + path);
					file.transferTo(new File(path));
					logger.info("文件成功上传到指定目录下");
					return trueFileName;
				} else {
					logger.info("不是我们想要的文件类型,请按要求重新上传");
					return "error";
				}
			} else {
				logger.info("文件类型为空");
				return path;
			}
		} else {
			logger.info("没有找到相对应的文件");
			return "error";
		}
	}

}
