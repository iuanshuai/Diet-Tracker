package me.syus.diettracker.Service;

import com.amazonaws.services.s3.AmazonS3;

import java.io.File;

public class StorageService {

    private AmazonS3 s3;
    private String bucket;

    public StorageService(AmazonS3 s3) {
        this.s3 = s3;
    }


    public void putObject(String S3Key, File file) {
        s3.putObject(bucket, S3Key, file);
    }


    public void putObject(String bucket, String S3Key, File file) {
        s3.putObject(bucket, S3Key, file);
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
