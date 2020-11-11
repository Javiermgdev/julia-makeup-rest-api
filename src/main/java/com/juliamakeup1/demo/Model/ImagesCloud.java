package com.juliamakeup1.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "imagesCloud")
public class ImagesCloud {

        @Id
        private String idImagesCloud;
        private String nameImagesCloud;
        private String linkImagesCloud;

    }

