package com.lxx.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxx.common.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       String resourceName,
                       BlockException e) throws Exception {
        response.setStatus(429); // too many requests
        response.setContentType("application/json;charset=utf-8");

        PrintWriter writer = response.getWriter();
        ResultData error = ResultData.fail("500",
                resourceName + "被Sentinel限流了" + e.getClass().getSimpleName());

        String jsonStr = objectMapper.writeValueAsString(error);

        writer.write(jsonStr);
        writer.flush();
        writer.close();
    }
}
