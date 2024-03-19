import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sqs.model.SendMessageRequest;

@RestController
public class TransactionController<AmazonSQS> {

    @Autowired
    private AmazonSQS sqsClient;

    @PostMapping("/transactions")
    public String createTransaction(@RequestBody Transaction transaction) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl("")
                .withMessageBody(transaction.toString());
        sqsClient.sendMessage(sendMessageRequest);
        return "Transaction received and enqueued successfully";
    }
}
