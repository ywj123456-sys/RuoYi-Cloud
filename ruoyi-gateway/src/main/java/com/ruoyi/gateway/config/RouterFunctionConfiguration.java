package com.ruoyi.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import com.ruoyi.gateway.handler.ValidateCodeHandler;

/**
 * 路由配置信息
 * 简单的 Spring WebFlux 配置，用于定义基于函数式编程的路由
 * 定义了一个 Spring WebFlux 的路由配置，当收到一个 HTTP GET 请求到 /code 路径，且请求的 Accept 头部为 text/plain 时，该请求将由 validateCodeHandler 处理
 * 
 * @author ruoyi
 */
@Configuration
public class RouterFunctionConfiguration
{
    //private ValidateCodeHandler validateCodeHandler; 这行代码定义了一个私有字段 validateCodeHandler，类型为 ValidateCodeHandler。
    // 当 Spring 容器创建 RouterFunctionConfiguration 的实例时，它会自动查找并注入一个 ValidateCodeHandler 类型的 bean 到这个字段中。
    @Autowired
    private ValidateCodeHandler validateCodeHandler;

    @SuppressWarnings("rawtypes")
    @Bean
    public RouterFunction routerFunction()
    {
        return RouterFunctions.route(
                RequestPredicates.GET("/code").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                validateCodeHandler);
    }
}
