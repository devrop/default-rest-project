package com.eintrusty.dao;

import java.util.List;

import com.eintrusty.entity.UserInfo;

public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
	List<UserInfo> getAllUserInfo();
	int addUserInfo(UserInfo user);
}
