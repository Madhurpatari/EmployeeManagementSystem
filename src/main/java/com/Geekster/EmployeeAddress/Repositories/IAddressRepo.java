package com.Geekster.EmployeeAddress.Repositories;

import com.Geekster.EmployeeAddress.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address, Long>{
}
