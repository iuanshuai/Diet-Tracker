package me.syus.diettracker.repository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import me.syus.diettracker.Service.StorageService;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class StorageServiceTest {


    @Test
    public void putObjectTest() {

//        AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
        AmazonS3 s3 = mock(AmazonS3.class);
        StorageService ss = new StorageService(s3);
        ss.setBucket("xxxx-xxxx");
        File testFile = new File("xxx");
        ss.putObject(null, testFile);
        verify(s3, times(0)).putObject(anyString(), anyString(), any(File.class));
        ss.putObject(testFile.getName(), testFile);
        verify(s3, times(1)).putObject(ss.getBucket(), testFile.getName(), testFile);

    }


    @Test
    public void getObjectTest() {

        AmazonS3 s3 = mock(AmazonS3.class);
        StorageService ss = new StorageService(s3);
        ss.setBucket("xxxx-xxxx");
        String key = "dummyKey";

//        S3Object resultObject = new S3Object();
        S3Object resultObject = mock(S3Object.class);
        when(resultObject.getKey()).thenReturn(key);
        resultObject.setKey(key);

        //stubbing
        when(s3.getObject(ss.getBucket(), key)).thenReturn(resultObject);
        // invoke function therefore we invoke stubbing function
        S3Object s3Object = ss.getObject(key);
        verify(s3, times(1)).getObject(ss.getBucket(), key);
        assertNotNull(s3Object.getKey());
        assertEquals(s3Object, resultObject);

    }


}