package com.Geekster.EmployeeAddress.Controllers;

import com.Geekster.EmployeeAddress.Models.Address;
import com.Geekster.EmployeeAddress.Services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //Add an address
    @PostMapping
    public Address createAddress(@Valid @RequestBody Address address){
        return addressService.saveAddress(address);
    }


    //Get all addresses
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    //Get an address by a specific ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    //Delete an address by specific ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }

    //update an address by using a specific ID
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @Valid @RequestBody Address addressReq){
        return addressService.updateAddress(id,addressReq);
    }
}
