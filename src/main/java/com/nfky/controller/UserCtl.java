package com.nfky.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nfky.entity.User;
import com.nfky.service.UserService;
import com.nfky.util.Profile;
import com.nfky.util.RespMsg;

/**
* 用户信息
* @author liyc
* @version 创建时间：2018年5月4日 上午11:09:05
*/
@Controller
@RequestMapping("/user")
public class UserCtl {
	@Autowired
	private UserService userService;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private Profile profile;
	/**
	 * 查询用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadList")
	public RespMsg<List<User>> loadList(){
		logger.info("loadList() start");
		List<User> list=userService.loadList();
		RespMsg<List<User>> rem=new RespMsg<>("加载成功",true);
		rem.setCont(list);
		logger.info("loadList() end");
		return rem;
		
	}
	/**
	 * 登录
	 * @param uname
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login")
	public RespMsg<String> login(@RequestParam(value="uname",required=true) String uname,
			@RequestParam(value="password",required=true) String password){
		logger.info("login() start");
		if(uname.equals("admin")&&password.equals("123456")){
			profile.setId(1);
			profile.setMobile("14569874586");
			logger.info("mobile=14569874586");
		}else{
			return new RespMsg<>("登录失败",false);
		}
		logger.info("login() end");
		return new RespMsg<>("登录成功",true);
		
	}
	/**
	 * 退出
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logout")
	public RespMsg<String> logout(){
		logger.info("logout() start");
		profile.logout();
		logger.info("logout() end");
		return new RespMsg<>("退出成功",true);
		
	}
}
