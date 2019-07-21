package me.syus.diettracker.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;

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


//    public void getObject(String bucket, String S3Key, File file) {
//        s3.putObject(bucket, S3Key, file);
//    }

    public S3Object getObject(String S3key) {
        return s3.getObject(bucket, S3key);
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
