package com.example.s3test.video.service;

import com.example.s3test.video.config.S3Props;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final S3Client s3Client;
    private final S3Props props;

    public String uploadLocalVideo(String localFilePath) {

        File file = new File(localFilePath);

        String key = "videos/" + UUID.randomUUID() + "_" + file.getName();

        PutObjectRequest req = PutObjectRequest.builder()
                .bucket(props.getBucket())
                .key(key)
                .contentType("video/mp4")
                .build();

        s3Client.putObject(
                req,
                RequestBody.fromFile(file)
        );

        return key; // S3 저장 경로 반환
    }
}
