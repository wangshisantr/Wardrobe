package com.xihua.wardrobe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihua.wardrobe.pojo.User;
import com.xihua.wardrobe.service.UserService;
import com.xihua.wardrobe.util.WResult;

@Controller
public class LoginConrtroller {

	@Autowired
	UserService userService;

	/**
	 * @Title: decodeUserInfo     
	 * @Description: 解密用户敏感数据   
	 * @param
	 * @encryptedData 明文,加密数据
	 * 
	 * @param iv   加密算法的初始向量
	 * @param code 用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取
	 *             session_key api，将 code 换成 openid 和 session_key
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public WResult register(String encryptedData, String iv, String code) {
		// 解密用户数据
		WResult result = userService.decodeUserInfo(encryptedData, iv, code);
		// 解密失败
		if (result.getStatus() == 0) {
			return result;
		}
		Map<Object, Object> map = (Map<Object, Object>) result.getData();
		// 拿到openid
		String opengId = (String) map.get("openId");
		List<User> userList = userService.listUser(opengId);
		if (userList != null) {
			return WResult.build(1, "该用户已经注册",opengId);
		}
		// 封装user
		User user = new User();
		user.setAvatarUrl((String) map.get("avatarUrl"));
		user.setGender(map.get("gender").equals("男") ? false : true);
		user.setOpenId((String) map.get("openId"));
		user.setUsername((String) map.get("nickName"));

		userService.insertUser(user);
		return WResult.build(1, "注册成功");
	}
}
