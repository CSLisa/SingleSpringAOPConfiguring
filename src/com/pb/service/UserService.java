package com.pb.service;

import org.springframework.stereotype.Component;

import com.pb.entity.User;

public class UserService {
	public boolean addUser(User user){
		System.out.println("正在执行添加用户的业务操作");
		int i = 10/0;//用来抛出异常
		return true;
	}
}

