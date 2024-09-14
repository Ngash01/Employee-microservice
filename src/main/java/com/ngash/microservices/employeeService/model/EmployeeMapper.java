package com.ngash.microservices.employeeService.model;

import lombok.*;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMapper {

    private int id;
    private String name;
    private String blood_group;
    private String position;
    private ResponseEntity<AddressMapper> address;
}



