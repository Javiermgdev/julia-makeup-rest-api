package com.juliamakeup1.demo.Repository;

import com.juliamakeup1.demo.Model.ClientForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository <ClientForm, String> {
}
