package com.study;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/9
 * Time: 16:48
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 文档信息对象
                .apiInfo(apiInfo())
                .select()
                // 被注解的包路径
                .apis(RequestHandlerSelectors.basePackage("com.study.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("Spring Boot 利用 swagger 构建 API 文档")
                // Api 文档描述
                .description("简单优雅的 restful 风格，为我所用")
//
//                .termsOfServiceUrl("myself")
//                // 文档作者信息
//                .contact(new Contact("Studer", "#", "xxx@XX"))
//                // 文档版本
                .version("1.0")
                .build();
    }
}
