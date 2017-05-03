package org.fb.vo.person;

import org.fb.vo.BaseRequestVo;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * DateTime: 2017年4月27日下午9:54:38
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class GetPersonRequestVo extends BaseRequestVo{

	private static final long serialVersionUID = 5789701944625222849L;
	
	@NotEmpty(message="psnid不能为空")
	private String psnid;

	public String getPsnid() {
		return psnid;
	}

	public void setPsnid(String psnid) {
		this.psnid = psnid;
	}

}
