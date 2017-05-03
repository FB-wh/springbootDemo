package org.fb.exception;

import org.fb.constant.ErrCode;

/**
 * 
 * DateTime: 2017年4月27日下午9:46:47
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 2117696342602045628L;
    private ErrCode errCode;
    private String errDesc;
    public ValidateException() {
        super();
    }
    public ValidateException(ErrCode err) {
        super();
        this.setErrCode(err);
    }
    public ValidateException(ErrCode err,String errDesc){
    	super();
    	this.setErrCode(err);
    	if(null == errDesc){
    		this.setErrDesc(err.desc);
    	}else{
    		this.setErrDesc(errDesc);
    	}
    }
   
	public ErrCode getErrCode() {
		return errCode;
	}
	public void setErrCode(ErrCode errCode) {
		this.errCode = errCode;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
}
