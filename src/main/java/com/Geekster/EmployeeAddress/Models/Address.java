package com.Geekster.EmployeeAddress.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
    @NotEmpty
    private String zipcode;

}
