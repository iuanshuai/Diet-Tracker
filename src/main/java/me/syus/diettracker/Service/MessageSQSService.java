package me.syus.diettracker.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class MessageSQSService {

    private AmazonSQS sqs;

    public MessageSQSService(AmazonSQS sqs) {
        this.sqs = sqs;
    }

    public void sendMessage() {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl("https://sqs.us-east-1.amazonaws.com/685997799509/diettracker-dev")
                .withMessageBody("hello world")
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }

}
