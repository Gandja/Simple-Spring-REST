package com.dgcorp.simplecrudapp.controller;

import com.dgcorp.simplecrudapp.dao.AddressRepository;
import com.dgcorp.simplecrudapp.dao.ClientRepository;
import com.dgcorp.simplecrudapp.model.Address;
import com.dgcorp.simplecrudapp.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class provides CRUD methods for {@link Address} entity
 */
@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ClientRepository clientRepository;

    /**
     * Add new address
     *
     * @param address
     * @return address which we added
     */
    @PostMapping("/address")
    public Address addAddress(Address address) {
        address.setClient(clientRepository.findById(address.getId()).orElse(null));
        addressRepository.save(address);
        return address;
    }

    /**
     * Get all addresses
     *
     * @return all addresses
     */
    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    /**
     * Get address by id which provides in request
     *
     * @param id
     * @return founded address
     */
    @GetMapping("/address/{id}")
    public Optional<Address> getAddressById(@PathVariable("id") int id) {
        return addressRepository.findById(id);
    }

    /**
     * Delete address by id which provides in request
     *
     * @param id
     * @return
     */
    @DeleteMapping("/address/{id}")
    public String deleteAddressById(@PathVariable("id") int id) {
        addressRepository.delete(addressRepository.getOne(id));
        return "deleted";
    }
}
