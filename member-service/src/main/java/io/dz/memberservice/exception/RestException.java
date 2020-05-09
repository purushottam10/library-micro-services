package io.dz.memberservice.exception;

import org.springframework.http.HttpStatus;

public class RestException  extends ServiceException{

    protected HttpStatus httpStatus;

    public RestException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public RestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public RestException(String message, Throwable cause,HttpStatus httpStatus){
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public RestException(Throwable cause, HttpStatus httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                         HttpStatus httpStatus) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }

}
