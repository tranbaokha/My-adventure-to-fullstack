package com.too.tired.TooTired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Tran Bao Kha", "api.com", "kha.tran1509@hcmut.edu.vn");
  public static final ApiInfo API_INFO = new ApiInfo("This is the main Documentation", "Documentation Spring boot", "1.0", "urn:tos",
          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	@Bean
	public Docket Api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO);
	}
}
