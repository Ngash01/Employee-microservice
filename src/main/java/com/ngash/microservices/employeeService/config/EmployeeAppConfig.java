package com.ngash.microservices.employeeService.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfig {

    @Value("${addressservice.base.url}")
    private String baseUrl;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }


//    @Bean
//    public WebClient webClient(){
//        return WebClient.builder()
//                .baseUrl(baseUrl)
//                .build();
//    }
}
