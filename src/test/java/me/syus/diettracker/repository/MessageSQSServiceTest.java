package me.syus.diettracker.repository;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import me.syus.diettracker.Service.MessageSQSService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSQSServiceTest {

//    @Autowired
    private MessageSQSService messageSQSService;

    @Test
    public void sendMessageTest() {
        AmazonSQS client = AmazonSQSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        messageSQSService = new MessageSQSService(client);
        messageSQSService.sendMessage();
    }

}
