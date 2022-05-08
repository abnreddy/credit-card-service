package com.card.publicis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    public static final Contact contact = new Contact("Brahma", "", "reddy.abnreddy@gmail.com");
    public static final ApiInfo API_INFO = new ApiInfo("Credit Card Service", "Application for Credit Card to Add Credit Card Details And Return All Credit Cards", "1.0",
            "", contact, "", "", List.of());

    @Bean
    public Docket creditCardApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO);
    }

}
