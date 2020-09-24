package com.dgcorp.simplecrudapp.dao;

import com.dgcorp.simplecrudapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
