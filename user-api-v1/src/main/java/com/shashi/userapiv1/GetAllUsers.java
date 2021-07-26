package com.shashi.userapiv1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetAllUsers implements RequestHandler<Object, List<User>> {
	
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);

	@Override
	public List<User> handleRequest(Object input, Context context) {
		
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":isActive", new AttributeValue().withBOOL(true));
		
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("isActive = :isActive")
				.withExpressionAttributeValues(eav);
		
		List<User> users = mapper.scan(User.class, scanExpression);
		return users;
	}

}
