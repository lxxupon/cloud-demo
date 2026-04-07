package com.lxx.gw.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RtGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String uri = request.getURI().toString();
        long startTime = System.currentTimeMillis();
        log.info("URI:{}, 请求开始时间:{}...", uri, startTime);
        Mono<Void> filter = chain.filter(exchange) // 放行、异步
                .doFinally(signalType -> {
                    long endTime = System.currentTimeMillis();
                    log.info("URI:{}, 响应结束时间:{}, 耗时:{}...", uri, endTime, endTime - startTime);
                });

        return filter;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
