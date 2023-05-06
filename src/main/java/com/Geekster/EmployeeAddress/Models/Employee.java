package com.Geekster.EmployeeAddress.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @NotEmpty(message = "First Name  can't be  empty")
    private String firstName;

    private String lastName;

    @Email(message = "Please enter valid Email address")
    @NotEmpty
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private  Address address;
}
