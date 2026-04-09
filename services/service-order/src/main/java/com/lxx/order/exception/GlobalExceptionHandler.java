package com.lxx.order.exception;


import com.lxx.common.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResultData handle(Throwable e) {
        return ResultData.fail("500", e.getMessage());
    }
}
