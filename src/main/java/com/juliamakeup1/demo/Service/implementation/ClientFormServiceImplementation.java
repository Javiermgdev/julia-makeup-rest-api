package com.juliamakeup1.demo.Service.implementation;

import com.juliamakeup1.demo.Model.ClientForm;
import com.juliamakeup1.demo.Repository.ClientRepository;
import com.juliamakeup1.demo.Service.ClientFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFormServiceImplementation implements ClientFormService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientForm> getAllClientForm() {
        return clientRepository.findAll();
    }

    @Override
    public String saveClientForm(ClientForm clientForm) {
        clientRepository.save(clientForm);
        return "saved";
    }
}
