package com.lxx.gw.predicate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                ServerHttpRequest request = serverWebExchange.getRequest();
                String first = request.getQueryParams().getFirst(config.getParam());
                return StringUtils.hasText(first) && first.equals(config.getValue());

            }
        };
    }

    /**
     * 短写法配置参数，字段顺序
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "value");
    }

    /**
     * 可以配置的参数
     */
    public static class Config {

        @NotEmpty
        private String param;

        private String value;

        private Predicate<String> predicate;

        public String getParam() {
            return this.param;
        }

        public Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public Config setValue(String value) {
            this.value = value;
            return this;
        }

        public Predicate<String> getPredicate() {
            return this.predicate;
        }

        public Config setPredicate(Predicate<String> predicate) {
            this.predicate = predicate;
            return this;
        }

        @AssertTrue
        public boolean isValid() {
            return !(StringUtils.hasText(this.value) && this.predicate != null);
        }

    }
}
