
package com.shashi.userapiv1;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetAllUsersTest {

    private static String input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = "001";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testGetUserbyId() {
    	GetAllUsers handler = new GetAllUsers();
        Context ctx = createContext();

        List<User> users = handler.handleRequest(input, ctx);
        for(User output:users)
        	System.out.println(output);
        // TODO: validate output here if needed.
        Assert.assertEquals(input, input);
    }
}
