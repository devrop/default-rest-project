package com.eintrusty.dao;

import com.eintrusty.entity.UserInfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		System.out.println("Input username " + userName+"--------------------------------------------------");
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
			
		}
		System.out.println("Username " + activeUserInfo.getUserName());
		System.out.println("Ini dijalankan --------------------------------------------------------------");
		System.out.println("Ini dijalankan --------------------------------------------------------------");
		return activeUserInfo;
	}
	@Override
	public List<UserInfo> getAllUserInfo() {
		List<UserInfo> allUser = entityManager.createQuery("Select k from UserInfo k").getResultList();
		return allUser;
	}
	@Override
	public int addUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		return 1;
	}

}
