package com.shashi.userapiv1;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SaveUser implements RequestHandler<User, Object> {

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);
    
    
    
	@Override
	public Object handleRequest(User input, Context context) {
		
		User user = (User)input;
		System.out.println(user);
		mapper.save(user);
		return user;
	}

}
