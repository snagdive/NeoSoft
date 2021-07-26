package com.shashi.userapiv1;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetUserbyId implements RequestHandler<Object, User> {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);
	
	@Override
    public User handleRequest(Object userId, Context context) {
        context.getLogger().log("Input: " + userId);
        
        User user = mapper.load(User.class, userId);
        
        return user;
    }

}
