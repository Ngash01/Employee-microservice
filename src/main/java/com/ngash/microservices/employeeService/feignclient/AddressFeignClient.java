package com.ngash.microservices.employeeService.feignclient;

import com.ngash.microservices.employeeService.model.AddressMapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ADDRESSSERVICE", path = "/address-app/api")
public interface AddressFeignClient {

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressMapper> getAddressByEmployeeId(@PathVariable("id") int id);

}




