package com.juliamakeup1.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "ClientForm")
public class ClientForm {

    private String nameClient;

    private int phoneNumberClient;

    private int dniClient;

    private String dateMakeUpClient;

    @Id
    private String idClient;

}
