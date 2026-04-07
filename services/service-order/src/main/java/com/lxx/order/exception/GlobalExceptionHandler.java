package com.lxx.order.exception;


import com.lxx.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public R handle(Throwable e) {
        return R.error(500, e.getMessage());
    }
}
