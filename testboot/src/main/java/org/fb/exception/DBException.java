package org.fb.exception;

import org.fb.constant.ErrCode;

/**
 * 
 * DateTime: 2017年4月27日下午9:46:47
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class DBException extends RuntimeException {

    private static final long serialVersionUID = 7471443434637232242L;

    private ErrCode errCode;
    
    public DBException() {
        super();
    }
    public DBException(ErrCode err) {
    	super();
        this.errCode = err;
    }
    
    
    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

    protected DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
