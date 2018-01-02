package com.oukingtim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket managementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("management")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(or(regex("/management/*.*")))
                .build()
                .apiInfo(apiInfo("management"));
    }

    @Bean
    public Docket v1Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(or(regex("/*.*")))
                .paths(not(regex("/management/*.*")))
                .build()
                .apiInfo(apiInfo("v1"));
    }

    @Bean
    public Docket v2Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v2")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(or(regex("/v2/*.*")))
                .build()
                .apiInfo(apiInfo("v2"));
    }

    private ApiInfo apiInfo(String version) {
        Contact contact = new Contact("-----@qq.com", "", "");
        ApiInfo apiInfo = new ApiInfo("baton api",
                "baton api, all the applications could access the Object model data via JSON.",
                version,
                "NO terms of service",
                contact,
                "The Apache License, Version xxxx",
                "http://www.xxxxx.org/licenses/LICENSE-2.0.html"
        );

        return apiInfo;
    }
}
