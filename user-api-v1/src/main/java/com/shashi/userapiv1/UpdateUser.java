package com.shashi.userapiv1;

import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateUser implements RequestHandler<Map<String, Object>, User> {

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);
    
	@Override
	public User handleRequest(Map<String, Object> input, Context context) {
		
		String userId = (String) input.get("id");
		
		Map<String, Object> userMap = (Map<String, Object>) input.get("user");
		
		User user = mapper.load(User.class, userId);
		
		if(user == null)
			throw new NotFoundException("User Not Found with ID: "+ userId);
		
		if(userId.equalsIgnoreCase((String)userMap.get("id")))
		{
			user.setName((String)userMap.get("name"));
			user.setSurname((String)userMap.get("surname"));
			user.setPincode((String)userMap.get("pincode"));
			user.setIsActive((Boolean)userMap.get("isActive"));
			
			mapper.save(user);
			
			return user;
		}
		
		return null;
	}

}
