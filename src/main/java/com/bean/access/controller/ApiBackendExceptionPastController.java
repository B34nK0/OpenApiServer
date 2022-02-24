package com.bean.access.controller;

import com.bean.constant.Constant;
import com.bean.constant.ErrorEnum;
import com.bean.entity.Response;
import java.net.ConnectException;
import java.net.SocketException;
import java.util.concurrent.TimeoutException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
* 处理后端服务异常(网关调用后端服务，后端服务发生异常)的后控制器，产生fallback响应
*/
@RestController
public class ApiBackendExceptionPastController {

    @RequestMapping(Constant.BACKEND_EXCEPTION_PATH)
    public Mono<Response> processExceptionRequest(ServerWebExchange exchange)
    {
    		Throwable ex = (Throwable)exchange.getAttributes().get(Constant.BACKEND_EXCEPTION_ATTR_NAME);
    		if(ex instanceof ConnectException) {
		    return Mono.just(new Response(ErrorEnum.BACKEND_CONNREFUSED,ex));
		}
		else if(ex instanceof TimeoutException) {
			return Mono.just(new Response(ErrorEnum.BACKEND_TIMEOUT,ex));
		}
		else if(ex instanceof SocketException) {
			return Mono.just(new Response(ErrorEnum.BACKEND_COMEXCEPTION,ex));
		}
		else if(ex instanceof WebClientResponseException) {
			//http status code: 4xx or 5xx
			return Mono.just(new Response(ErrorEnum.BACKEND_4XX_5XX,ex));
		}
		else {
			return Mono.just(new Response(ErrorEnum.OTHER,ex));
		}
    }
}
