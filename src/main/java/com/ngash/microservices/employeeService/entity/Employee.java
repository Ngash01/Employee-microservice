package com.ngash.microservices.employeeService.entity;

import com.ngash.microservices.employeeService.model.AddressMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name ="email" )
    private String email;
    @Column(name = "blood_group")
    private String blood_group;
    private String position;

}


