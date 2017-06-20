package com.example.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class TestApplicationSwaggerConfiguration {

	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.directModelSubstitute(XMLGregorianCalendar.class, String.class)
                .groupName("WAS BeanStalk")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build()
                .useDefaultResponseMessages(false);                
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Test AWS BeanStalk")
                .description("Test AWS BeanStalk")
                .version("1.0")
                .build();
    }

}
