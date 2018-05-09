package com.nfky.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfky.IDao.IUserDao;
import com.nfky.entity.User;
import com.nfky.service.UserService;

/**
* 
* @author liyc
* @version 创建时间：2018年5月4日 上午11:07:05
*/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public List<User> loadList() {
		List<User> list=userDao.loadList();
		return list;
	}

}
