package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket sampledb() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controller"))
				.paths(PathSelectors.regex("/emp.*")).build().apiInfo(metainfo());
	}
	private ApiInfo metainfo() {
		ApiInfo apiInfo=new ApiInfo("Swagger boot implements swagger documentation", "A realtime example of swagger implementaion with springboot using mysql and restwebservice", "2.0", "Terms of service", new Contact("Balram","https://www.facebook.com/","Email:balacse42@gmail.com"), "authorised by bala", "http:www.google.com");
		return apiInfo;
	}
}
