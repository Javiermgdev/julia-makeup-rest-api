package com.juliamakeup1.demo.Controller;

import com.juliamakeup1.demo.Model.ImagesCloud;
import com.juliamakeup1.demo.Service.implementation.CloudinaryServiceImplementation;
import com.juliamakeup1.demo.Service.implementation.ImagesCloudServiceImplementation;
import com.juliamakeup1.demo.dto.ImagesCloudDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/imagesCloud")
@CrossOrigin("*")
public class ImagesCloudController {

    @Autowired
    ImagesCloudServiceImplementation imagesCloudServiceImplementation;

    @Autowired
    CloudinaryServiceImplementation cloudinaryServiceImplementation;

    @GetMapping("/get")
    public List<ImagesCloud> getAllImagesCloud(){
        return imagesCloudServiceImplementation.getImagesCloud();
    }



    @PostMapping("/create")
    public String addImagesCloud(@RequestBody ImagesCloud imagesCloud){
        imagesCloudServiceImplementation.saveImagesCloud(imagesCloud);
        return "saved";
    }

    @PostMapping(
            path = "{idImagesCloud}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadWork(@RequestParam("file") MultipartFile file,
                                        @PathVariable("idImagesCloud") String idImagesCloud) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        if(bufferedImage == null){
            return new ResponseEntity(new ImagesCloudDto("Invalid Image"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryServiceImplementation.upload(file);
        String imageUrl = (String) result.get("url");
        imagesCloudServiceImplementation.updateImagesCloud(idImagesCloud, imageUrl);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/image/upload")
    public ResponseEntity<?> uploadImageCloud(@RequestParam("file") MultipartFile file) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        if(bufferedImage == null){
            return new ResponseEntity(new ImagesCloudDto("Invalid Image"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryServiceImplementation.upload(file);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
