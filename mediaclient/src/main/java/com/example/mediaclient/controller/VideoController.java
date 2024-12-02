package com.example.mediaclient.controller;

import com.example.mediaclient.dto.VideoDto;
import com.example.mediaclient.service.VideoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xproce.lab.Creator;
import org.xproce.lab.UploadVideoRequest;


@RestController
public class VideoController {
    @Autowired
    private VideoServiceClient videoService;

    @PostMapping("addVideo")
    public VideoDto uploadVideo() {
        Creator creator = Creator.newBuilder()
                .setName("Xproce")
                .setEmail("hirchoua.badr@gmail.com")
                .setId("2")
                .build();
        UploadVideoRequest request = UploadVideoRequest.newBuilder()
                .setTitle("grpc 101")
                .setDescription("The gRPC 101 is an introductory course to master Grpc")
                .setUrl("https://github.com/badrhr/gRPC101")
                .setDurationSeconds(380)
                .setCreator(creator)
                .build();
        return videoService.uploadVideo(request);
    }

    @GetMapping("/{id}")
    public VideoDto getVideo(@PathVariable String id) {
        return videoService.getVideo(id);
    }
}
