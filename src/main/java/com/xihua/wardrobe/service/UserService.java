package com.xihua.wardrobe.service;

import java.util.List;

import com.xihua.wardrobe.pojo.User;
import com.xihua.wardrobe.util.WResult;

public interface UserService {

	boolean insertUser(User user);

	List<User> listUser(String openid);
	
	WResult decodeUserInfo(String encryptedData, String iv, String code);
}
