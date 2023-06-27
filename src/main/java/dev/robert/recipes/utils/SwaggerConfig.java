package dev.robert.recipes.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Recipes Application",
                "Comprehensive Recipes Application",
                "1.0",
                "Terms of service",
                new Contact("Robert", "www.robert.co.ke", "dev@robert"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.robert.recipes.controller"))
                .build();
    }


}
