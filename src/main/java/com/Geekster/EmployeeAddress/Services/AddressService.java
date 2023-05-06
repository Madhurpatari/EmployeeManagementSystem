package com.Geekster.EmployeeAddress.Services;

import com.Geekster.EmployeeAddress.Models.Address;
import com.Geekster.EmployeeAddress.Models.Employee;
import com.Geekster.EmployeeAddress.Repositories.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private IAddressRepo addressRepo;

    //Save a new Address
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    //Get all addresses
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    //Get address by ID
    public ResponseEntity<Address> getAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            return new ResponseEntity<>(address, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete address by ID
    public ResponseEntity<Void> deleteAddress(Long id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if(optionalAddress.isPresent()){
            addressRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //update address by id
    public ResponseEntity<Address> updateAddress(Long id, Address addressReq) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setStreet(addressReq.getStreet());
            address.setCity(addressReq.getCity());
            address.setState(addressReq.getState());
            address.setZipcode(addressReq.getZipcode());
            Address updatedaddress = addressRepo.save(address);
            return new ResponseEntity<>(updatedaddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
