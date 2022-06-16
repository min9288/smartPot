package multicam6.smartPot.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SqsMessageSender {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsMessageSender(AmazonSQS amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSqs);
    }

    public void sendMessage(String message) {
        Message<String> newMessage = MessageBuilder.withPayload(message).build();
        queueMessagingTemplate.send("MqttMessage", newMessage);
    }

}
