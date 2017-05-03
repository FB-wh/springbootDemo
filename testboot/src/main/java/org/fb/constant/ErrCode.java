package org.fb.constant;

import org.apache.commons.lang3.StringUtils;
/**
 * 错误码定义，00：成功，10：参数错误；90:系统异常;20:业务错误
 * 
 * @author wh
 * @version 1.0
 * @Copyright (c) 2017, fb  All Rights Reserved.
 */
public enum ErrCode {
	SUCCESS("00","成功"),
	FAIL("55","失败"),
	UNKNOW("9998","未知错误"),
	//绑卡错误
	PARAMERR("1000","参数错误");
	
	
	public String code;
	public String desc;
	private String otherCode;
	private ErrCode(String code,String desc,String otherCode){
		this.code = code;
		this.desc = desc;
		this.otherCode = otherCode;
	}
	private ErrCode(String code,String desc){
		this.code = code;
		this.desc = desc;
	}
	public static ErrCode tf(String otherCode){
		if(StringUtils.isBlank(otherCode)){
			return UNKNOW;
		}
		for(ErrCode cc:ErrCode.values()){
			if(StringUtils.isBlank(cc.otherCode)){
				continue;
			}
			if(cc.otherCode.equals(otherCode)){
				return cc;
			}
		}
		return UNKNOW;
	}
}
