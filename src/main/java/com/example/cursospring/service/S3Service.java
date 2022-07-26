package com.example.cursospring.service;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S3Service {
    private final String BUCKET="nombre_bucket";

    @Autowired
    private AmazonS3Client amazonS3Client;




}
