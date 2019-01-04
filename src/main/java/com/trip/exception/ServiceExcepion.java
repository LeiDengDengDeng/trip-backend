package com.trip.exception;

/**
 * @author fjj
 * @date 2019/1/5 上午12:42
 */
public class ServiceExcepion extends RuntimeException {
    private int errCode;
    private String message;

    public ServiceExcepion(int errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.message = message;
    }

    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setErrCode(final int errCode) {
        this.errCode = errCode;
    }

    public void setMessage(final String message) {
        this.message = message;
    }


}

