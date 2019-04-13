package com.xihua.wardrobe.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xihua.wardrobe.mapper.UserMapper;
import com.xihua.wardrobe.pojo.User;
import com.xihua.wardrobe.pojo.UserExample;
import com.xihua.wardrobe.service.UserService;
import com.xihua.wardrobe.util.AesCbcUtil;
import com.xihua.wardrobe.util.HttpRequest;
import com.xihua.wardrobe.util.WResult;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public boolean insertUser(User user) {
		userMapper.insert(user);
		return false;
	}

	@Override
	public List<User> listUser(String openId) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		// 设置条件openid
		criteria.andOpenIdEqualTo(openId);
		List<User> userLsit = userMapper.selectByExample(userExample);
		return userLsit;
	}

	@Override
	public WResult decodeUserInfo(String encryptedData, String iv, String code) {
		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			
			return WResult.build(0, "code 不能为空");
		}

		// 小程序唯一标识 (在微信小程序管理后台获取)
		String wxspAppid = "wx0c10be3636008129";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxspSecret = "380270b6680a468aba1cd06891bcdc76";
		// 授权（必填）
		String grant_type = "authorization_code";

		// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		// 请求参数
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
				+ grant_type;
		// 发送请求
		String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
		// 解析相应内容（转换成json对象）
		JSONObject json = new JSONObject(sr);
		// 获取会话密钥（session_key）
		String session_key = json.get("session_key").toString();
		// 用户的唯一标识（openid）
//		String openid = (String) json.get("openid");

		// 2、对encryptedData加密数据进行AES解密
		Map<Object, Object> userInfo = new HashMap<Object, Object>();
		try {
			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			if (null != result && result.length() > 0) {
				JSONObject userInfoJSON = new JSONObject(result);
				
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				// 解密unionId & openId;

//				userInfo.put("unionId", userInfoJSON.get("unionId"));
			} else {
				return WResult.build(0, "解密失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WResult.build(1, "解密成功", userInfo);
	}

}
