package com.nfky.entity;
/**
* 用户
* @author liyc
* @version 创建时间：2018年5月4日 上午11:03:31
*/
public class User {
	private long id;
	private String name;//名称
	private int age;//年龄
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
