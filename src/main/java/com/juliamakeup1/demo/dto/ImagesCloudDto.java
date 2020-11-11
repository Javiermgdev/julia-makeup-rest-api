package com.juliamakeup1.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImagesCloudDto {

    private String messageImagesCloud;

    public ImagesCloudDto(String messageImagesCloud) {
        this.messageImagesCloud = messageImagesCloud;
    }
}
