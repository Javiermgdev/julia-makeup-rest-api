package com.juliamakeup1.demo.Repository;

import com.juliamakeup1.demo.Model.ImagesCloud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesCloudRepository extends MongoRepository <ImagesCloud, String> {
}
