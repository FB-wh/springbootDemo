package org.fb.model;

import java.io.Serializable;

/**
 * 
 * DateTime: 2017年4月27日下午9:46:47
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 */
	private String psnid;
	
	/**
	 * 用户名
	 */
	private String psnname;

	public String getPsnid() {
		return psnid;
	}

	public void setPsnid(String psnid) {
		this.psnid = psnid;
	}

	public String getPsnname() {
		return psnname;
	}

	public void setPsnname(String psnname) {
		this.psnname = psnname;
	}
}
