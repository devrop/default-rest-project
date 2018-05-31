package com.eintrusty.service;

import java.util.List;

import com.eintrusty.entity.UserInfo;

public interface IUserInfoService {
	UserInfo getActiveUser(String userName);
	
	List<UserInfo> getAllUserInfo();
	int addUserInfo(UserInfo user);

}
