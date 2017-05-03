package org.fb.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * DateTime: 2017年4月27日下午10:04:40
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class BaseResponseVo implements Serializable{

	private static final long serialVersionUID = -1646874005308414062L;
	
	private Map<String,Object> ajaxObj;

	public Map<String, Object> getAjaxObj() {
		return ajaxObj;
	}

	public void setAjaxObj(Map<String, Object> ajaxObj) {
		this.ajaxObj = ajaxObj;
	}

}
