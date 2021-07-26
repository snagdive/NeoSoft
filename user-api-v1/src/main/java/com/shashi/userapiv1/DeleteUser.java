package com.shashi.userapiv1;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteUser implements RequestHandler<Object, Object> {

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);
    
	@Override
	public Object handleRequest(Object input, Context context) {
		
		String userId = input.toString();
		
		User user = mapper.load(User.class, userId);
		if(user == null)
			throw new NotFoundException("No User Found with ID: "+userId);
		mapper.delete(user);
		
		return "User Deleted!";
	}

}
