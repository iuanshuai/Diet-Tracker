//package me.syus.diettracker.repository;
//
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
//import me.syus.diettracker.Service.MessageSQSService;
//import me.syus.diettracker.config.AppConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import static org.mockito.Mockito.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//
//@ContextConfiguration(classes = {AppConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("unit")
//@WebAppConfiguration
//public class MessageSQSServiceTest {
//
//    @Autowired
//    private MessageSQSService messageSQSService;
//
//    @Test
//    public void sendMessageTest() {
//        AmazonSQS sqs = mock(AmazonSQS.class);
//        MessageSQSService messageSQSService = new MessageSQSService(sqs,"testsqs");
//        messageSQSService.sendMessage("test", 5);
//        verify(sqs, times(1)).sendMessage(any());
//
//
//    }
//
//
//
//
//}
