import javax.naming.Context;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.azure.cosmos.implementation.query.ItemType;
import com.mysql.cj.xdevapi.Table;

import jakarta.servlet.RequestDispatcher;

public class SQSProcessorLambda<SQSEvent, AmazonDynamoDB, DynamoDB> implements RequestDispatcher<SQSEvent, Void> {

    private final AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
    private final DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
    private final String tableName = "product-events";

    @Override
    public Void handleRequest(SQSEvent event, Context context) {
        try {
            for (SQSEvent.SQSMessage message : event.getRecords()) {
                String messageBody = message.getBody();
                
                // Salvar dados no DynamoDB
                Table table = ((Object) dynamoDB).getTable(tableName);
                ItemType item = ((Object) new Item())
                        .withPrimaryKey("id", "transactionId")
                        .withString("idempotencyId", "idempotencyIdValue")
                        .withDouble("amount", 100.0) 
                        .withString("type", "credit"); 
                table.putItem(item);
            }
        } catch (Exception e) {
            ((Object) context).getLogger().log("Error processing SQS messages: " + e.getMessage());
        }
        return null;
    }
}
