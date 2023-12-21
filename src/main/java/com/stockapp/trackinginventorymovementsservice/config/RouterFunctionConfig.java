package com.stockapp.trackinginventorymovementsservice.config;

import com.stockapp.trackinginventorymovementsservice.handler.CommonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> customerRoutes(CommonHandler commonHandler) {
        return RouterFunctions
                .route(GET("/tracking/general/getPaginated/{pageNumber}/{pageSize}")
                        .and(accept(APPLICATION_JSON)), commonHandler::getPaginated)
                .andRoute(GET("/tracking/errors/getAll"), commonHandler::getAll);


    }

    @Bean
    public RouterFunction<ServerResponse> errorRoutes(CommonHandler commonHandler) {
        return RouterFunctions
                .route(GET("/tracking/errors/getAll"), commonHandler::getAll);
    }

    @Bean
    public RouterFunction<ServerResponse> saleRoutes(CommonHandler commonHandler) {
        return RouterFunctions
                .route(GET("/tracking/sale/getRetails"), commonHandler::getAllRetails)
                .andRoute(GET("/tracking/sale/getWhosale"), commonHandler::getAllWhosale);
    }

}
