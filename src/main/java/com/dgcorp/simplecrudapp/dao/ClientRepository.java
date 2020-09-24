package com.dgcorp.simplecrudapp.dao;

import com.dgcorp.simplecrudapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
