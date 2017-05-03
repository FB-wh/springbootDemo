package org.fb.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 基础请求类型
 * DateTime: 2017年4月27日下午9:52:41
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class BaseRequestVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="请求流水不能为空")
	private String reqId;

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

}
