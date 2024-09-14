package com.ngash.microservices.employeeService.service;

import com.ngash.microservices.employeeService.entity.Employee;
import com.ngash.microservices.employeeService.feignclient.AddressFeignClient;
import com.ngash.microservices.employeeService.model.AddressMapper;
import com.ngash.microservices.employeeService.model.EmployeeMapper;
import com.ngash.microservices.employeeService.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${addressservice.base.url}")
    private String addressBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressFeignClient addressFeignClient;


//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//  Fetch an employee
    public ResponseEntity<EmployeeMapper> getEmployee(int id){

//       ResponseEntity<AddressMapper> addressMapper = addressFeignClient.getAddressByEmployeeId(id);

////        get getInstances
//        List<ServiceInstance> instances =  discoveryClient.getInstances("addressservice");
//        System.out.println("All instances: " + instances);
//        ServiceInstance serviceInstance = instances.get(1);
//        System.out.println("One instance: " + serviceInstance);
//
//        String uri = serviceInstance.getUri().toString();
//        System.out.println("uri: " + uri);

//        ServiceInstance serviceInstance = loadBalancerClient.choose("addressservice");
//        String uri = serviceInstance.getUri().toString();
//        System.out.println("uri: " + uri);

//        AddressMapper addressMapper = restTemplate.getForObject("http://ADDRESSSERVICE/address-app/api/address/" + id, AddressMapper.class);


        ResponseEntity<AddressMapper> addressMapper = addressFeignClient.getAddressByEmployeeId(id);

        Employee employee = employeeRepository.findById(id).get();
        EmployeeMapper employeeMapper = modelMapper.map(employee, EmployeeMapper.class);

//      append the address info to the employee;
        employeeMapper.setAddress(addressMapper);

        return new ResponseEntity<>(employeeMapper, HttpStatus.ACCEPTED);
    }
}




