package com.juliamakeup1.demo.Controller;


import com.juliamakeup1.demo.Model.ClientForm;
import com.juliamakeup1.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;


    @GetMapping
    public List<ClientForm> getAllClientForm() {
        return clientRepository.findAll();
    }

    @GetMapping("/{idClient}")
    public Optional<ClientForm> getClientById(@PathVariable String idClient) {
        return clientRepository.findById(idClient);
    }

    @PostMapping("/save")
    public String saveClientForm(@RequestBody ClientForm clientForm) {
        clientRepository.save(clientForm);
        return "Successfully saved";
    }

    /**@PutMapping("{/idClient}")
    public Optional<ClientForm> updateClientById(@PathVariable String idClient) {
        clientRepository.findById (idClient);
        return updateClientById(idClient);
    }**/

    @DeleteMapping("/{idClient}")
    public String deleteById(@PathVariable String idClient) {
        clientRepository.deleteById(idClient);
        return "Successfully deleted";
    }




}
