package com.eintrusty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintrusty.dao.IUserInfoDAO;
import com.eintrusty.entity.UserInfo;

@Service
public class UserInfoService implements IUserInfoService {

	@Autowired
	private IUserInfoDAO userInfoDAO;
	
	@Override
	public UserInfo getActiveUser(String userName) {
		// TODO Auto-generated method stub
		return userInfoDAO.getActiveUser(userName);
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		// TODO Auto-generated method stub
		List<UserInfo> all = userInfoDAO.getAllUserInfo();
		return all;
	}

	@Override
	public int addUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		int ok = userInfoDAO.addUserInfo(user);
		if(ok == 1) {
		   return 1;
		}else {
		    return 0;
		}
		
	}

}
