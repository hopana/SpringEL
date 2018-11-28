package com.zhangguo.SpringEL.spel02;

/**
 * 用户类
 */
public class User {
	public User() {
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
