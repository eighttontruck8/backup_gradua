package com.example.s3test.video.controller;

import com.example.s3test.video.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class S3TestController {

    private final S3UploadService s3UploadService;

    @PostMapping("/upload-local")
    public String uploadLocal() {

        String localPath = "C:/Users/dsino/Desktop/test1.mp4";

        return s3UploadService.uploadLocalVideo(localPath);
    }
}
