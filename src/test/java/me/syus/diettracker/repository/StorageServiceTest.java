package me.syus.diettracker.repository;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import me.syus.diettracker.Service.StorageService;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

public class StorageServiceTest {


    @Test
    public void putObjectTest() {

//        AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
        AmazonS3 s3 = Mockito.mock(AmazonS3.class);
        StorageService ss = new StorageService(s3);
        ss.setBucket("xxxx-xxxx");
        File testFile = new File("xxx");
        ss.putObject(null, testFile);
        Mockito.verify(s3, times(0)).putObject(anyString(), anyString(), any(File.class));
        ss.putObject(testFile.getName(), testFile);
        Mockito.verify(s3, times(1)).putObject(ss.getBucket(), "xxx", testFile);

    }


}