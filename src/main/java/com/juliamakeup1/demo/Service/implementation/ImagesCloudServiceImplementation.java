package com.juliamakeup1.demo.Service.implementation;

import com.juliamakeup1.demo.Model.ImagesCloud;
import com.juliamakeup1.demo.Repository.ImagesCloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesCloudServiceImplementation {

    @Autowired
    ImagesCloudRepository imagesCloudRepository;

    public List<ImagesCloud> getImagesCloud(){
        return imagesCloudRepository.findAll();
    }


    public void saveImagesCloud(ImagesCloud imagesCloud) {
        imagesCloudRepository.save(imagesCloud);
    }


    public void updateImagesCloud(String idImagesCloud, String linkImagesCloud) {
        Optional<ImagesCloud> oldImagesCloud = imagesCloudRepository.findById(idImagesCloud);
        oldImagesCloud.get().setLinkImagesCloud(linkImagesCloud);
        imagesCloudRepository.save(oldImagesCloud.get());
    }


}
