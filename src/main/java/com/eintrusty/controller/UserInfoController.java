package com.eintrusty.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eintrusty.entity.UserInfo;
import com.eintrusty.service.IUserInfoService;
/***
 * 
 * 
 * @author Ahmad Ropandi
 *
 */

@Controller
@RequestMapping()
public class UserInfoController {
	
	@Autowired
	IUserInfoService userService;
	
	@GetMapping("user/{name}")
	public ResponseEntity<UserInfo> getArticleById(@PathVariable("name") String name) {
		UserInfo activeUser= userService.getActiveUser(name);
		return new ResponseEntity<UserInfo>(activeUser, HttpStatus.OK);
	}
	
	@GetMapping("users")
	public ResponseEntity<List<UserInfo>> getAllUserInfo() {
		System.out.println("users");
		List<UserInfo> all = userService.getAllUserInfo();
		return new ResponseEntity<List<UserInfo>>(all, HttpStatus.OK);
	}
	
    @PostMapping("user")
    public ResponseEntity<Void> addArticle(@RequestBody UserInfo userInfo, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{name}").buildAndExpand(userInfo.getUserName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}
   
}
