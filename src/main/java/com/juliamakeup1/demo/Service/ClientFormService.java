package com.juliamakeup1.demo.Service;

import com.juliamakeup1.demo.Model.ClientForm;

import java.util.List;

public interface ClientFormService {

    List<ClientForm> getAllClientForm();

    String saveClientForm(ClientForm clientForm);

}
