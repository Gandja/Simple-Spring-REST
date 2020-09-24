package com.dgcorp.simplecrudapp.controller;

import com.dgcorp.simplecrudapp.dao.ClientRepository;
import com.dgcorp.simplecrudapp.model.Address;
import com.dgcorp.simplecrudapp.model.Client;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class provides CRUD methods for {@link Client} entity
 */
@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Add new client
     *
     * @param client
     * @return client which we added
     */
    @PostMapping("/client")
    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    /**
     * Get client by id which provides in request
     *
     * @param id
     * @return founded client
     */
    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable("id") int id) {
        return clientRepository.findById(id);
    }

    /**
     * Get all clients
     *
     * @return all clients
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Delete client by id which provides in request
     *
     * @param id
     * @return String as a result that {@link Client} was deleted
     */
    @DeleteMapping("/client/{id}")
    public String deleteClientById(@PathVariable("id") int id) {
        Client client = clientRepository.getOne(id);
        clientRepository.delete(client);
        return "deleted";
    }

    @PutMapping("/client/address/{id}")
    public Client addAddressToClient(@PathVariable("id") int id, @RequestParam("name") String name) {
        Client client = clientRepository.findById(id).orElse(null);
        Address address = new Address();
        address.setClient(client);
        address.setName(name);
        client.getAddressList().add(address);
        clientRepository.save(client);
        return client;
    }
}
