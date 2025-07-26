package com.sanjo.backend.service;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.regions.Regions;
import com.sanjo.backend.exception.OurException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class AwsS3Service {

    //Injecting from env file
    @Value("${bucket-name}")
    private  String bucketName;

    @Value("${aws.s3.access.key}")
    private  String accessKey;

    @Value("${aws.s3.secret.key}")
    private  String secretKey;

    public String saveImageToS3(MultipartFile photo){
        String s3LocationImage=null;

        try {

            String s3FileName = photo.getOriginalFilename();

            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,secretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(Regions.US_EAST_2)
                    .build();

            InputStream inputStream =photo.getInputStream();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpeg");

            PutObjectRequest putObjectRequest =new PutObjectRequest(bucketName,s3FileName,inputStream,metadata);
            s3Client.putObject(putObjectRequest);
            return  "https://"+bucketName+".s3.amazonaws.com/"+s3FileName;

        }catch (Exception e){
            e.printStackTrace();
            throw new OurException("Unable to Upload image" + e.getMessage());
        }
    }



}
