package com.bean.entity;


import com.bean.constant.ErrorEnum;

/**
* response model
* 
*/
public class Response {
    int code;
    String message;
    boolean success = false;

    public Response(ErrorEnum error)
    {
        code = error.getCode();
        message = error.getMessage();
    }
    
    public Response(ErrorEnum error, Throwable ex)
    {
        code = error.getCode();
        message = error.getMessage().concat(",").concat(ex.getMessage());
    }
    
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
