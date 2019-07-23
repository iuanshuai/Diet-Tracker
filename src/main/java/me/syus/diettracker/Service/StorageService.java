package me.syus.diettracker.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;

import java.io.File;

public class StorageService {

    private AmazonS3 s3;
    private String bucket;

    public StorageService(AmazonS3 s3) {
        this.s3 = s3;
    }


    public void putObject(String s3Key, File file) {
        putObject(s3Key, file, true);
    }

    public void putObject(String s3Key, File file, boolean isPublic){
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, s3Key, file);
        AccessControlList acl = new AccessControlList();
        acl.grantPermission(GroupGrantee.AllUsers, Permission.Read); //all users or authenticated
        putObjectRequest.setAccessControlList(acl);
        s3.putObject(putObjectRequest);
    }



    public S3Object getObject(String S3key) {
        return s3.getObject(bucket, S3key);
    }

    public String getObjectUrl(String S3key) {
        return s3.getUrl(bucket, S3key).toString();

    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }


}
