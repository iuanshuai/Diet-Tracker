package me.syus.diettracker.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MessageSQSService {

    private AmazonSQS sqs;

//    @Value("${jms.queue.name}")
//    private String sqsName;
//    private String sqsName;
//            = System.getProperty("jms.queue.name");

    private String queueUrl;

    public String getQueueUrl(String queueName) {
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }

    public MessageSQSService(@Autowired AmazonSQS sqs,  @Value("${jms.queue.name}") String sqsName) {
        this.sqs = sqs;
        this.queueUrl = getQueueUrl(sqsName);

    }

    public void sendMessage(String message, int delay) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(this.queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(delay);
        sqs.sendMessage(send_msg_request);
    }

}
