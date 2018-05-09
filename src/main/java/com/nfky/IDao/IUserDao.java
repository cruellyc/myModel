package com.nfky.IDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nfky.entity.User;

/**
* 
* @author liyc
* @version 创建时间：2018年5月4日 上午11:07:36
*/
@Repository
public interface IUserDao {
	public List<User> loadList();
}
