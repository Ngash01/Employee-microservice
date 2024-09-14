package com.ngash.microservices.employeeService.controller;

import com.ngash.microservices.employeeService.model.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestEmployeeController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/employee")
    public String getEmployee(){

        //    get address data by hitting this endpoint: http://localhost:8080/address
        String address = restTemplate.getForObject("http://localhost:8080/address", String.class);

//        AddressMapper addressMapper = webClient.get().uri(addressBaseUrl + "/" +id).retrieve().bodyToMono(AddressMapper.class).block();


        return "Name: Abhilash, id: 123, email: abhilash@gmail.com, address: " + address ;
    }


}




