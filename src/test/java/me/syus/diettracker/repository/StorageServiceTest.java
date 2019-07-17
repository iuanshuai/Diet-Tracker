package me.syus.diettracker.repository;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import me.syus.diettracker.Service.StorageService;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

public class StorageServiceTest {


    @Test
    public void putObjectTest() {

//        AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
        AmazonS3 s3 = Mockito.mock(AmazonS3.class);
        StorageService ss = new StorageService(s3);
        ss.setBucket("diettracker-dev");
        File testFile = new File("/Users/shuaiyuan/Downloads/airhost.zip");
        ss.putObject(testFile.getName(), testFile);


    }


}