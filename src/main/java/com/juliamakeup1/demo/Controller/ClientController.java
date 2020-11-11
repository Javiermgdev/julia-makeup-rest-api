package com.juliamakeup1.demo.Controller;


import com.juliamakeup1.demo.Model.ClientForm;
import com.juliamakeup1.demo.Repository.ClientRepository;
import com.juliamakeup1.demo.Service.implementation.ClientFormServiceImplementation;
import com.juliamakeup1.demo.Service.implementation.SmtpMailSenderImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientFormServiceImplementation clientFormServiceImplementation;

    @Autowired
    SmtpMailSenderImplementation smtpMailSenderImplementation;


    @GetMapping
    public List<ClientForm> getAllClientForm() {
        return clientFormServiceImplementation.getAllClientForm();
    }
//
//    @GetMapping("/{idClient}")
//    public Optional<ClientForm> getClientById(@PathVariable String idClient) {
//        return clientRepository.findById(idClient);
//    }

    @PostMapping("/save")
    public String saveClientForm(@RequestBody ClientForm clientForm) throws UnsupportedEncodingException, MessagingException {
        smtpMailSenderImplementation.send(clientForm);
        return clientFormServiceImplementation.saveClientForm(clientForm);
    }

    /**@PutMapping("{/idClient}")
    public Optional<ClientForm> updateClientById(@PathVariable String idClient) {
        clientRepository.findById (idClient);
        return updateClientById(idClient);
    }**/

//    @DeleteMapping("/{idClient}")
//    public String deleteById(@PathVariable String idClient) {
//        clientRepository.deleteById(idClient);
//        return "Successfully deleted";
//    }




}
