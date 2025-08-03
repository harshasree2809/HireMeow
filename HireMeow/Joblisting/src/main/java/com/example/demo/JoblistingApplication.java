package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JoblistingApplication {
	// This makes Swagger work in our project
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2) // Use Swagger 2
	            .select() // Start setting which APIs to include
	            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) 
	            // Only show classes that have @RestController
	            .paths(PathSelectors.any()) 
	            // Show all API paths (URLs)
	            .build() // Finish setup
	            .apiInfo(apiInfo()) 
	            // Add extra info like title, version (from the method below)
	            .useDefaultResponseMessages(false); 
	            // Don’t show default messages like 401, 403 in docs
	}

	// This sets extra info shown in Swagger UI
	@Bean
	public ApiInfo apiInfo() {
	    final ApiInfoBuilder builder = new ApiInfoBuilder(); 
	    return builder.build(); // Create and return the info
	}


	public static void main(String[] args) {
		SpringApplication.run(JoblistingApplication.class, args);
	}

}
