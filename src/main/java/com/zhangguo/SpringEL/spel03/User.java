package com.zhangguo.SpringEL.spel03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户类
 */
@Component("user1")
public class User {
	/**
	 * 编号
	 */
	@Value("#{9527+100}")
	private int id;
	/**
	 * 姓名
	 */
	@Value("#{'Hello'.toUpperCase()}")
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
