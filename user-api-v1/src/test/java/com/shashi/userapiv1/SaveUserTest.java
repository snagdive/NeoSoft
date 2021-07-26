
package com.shashi.userapiv1;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class SaveUserTest {

    private static User input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = new User("U3","Mayur","Ghuge","444111", true);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testGetUserbyId() {
    	SaveUser handler = new SaveUser();
        Context ctx = createContext();

        Object output = handler.handleRequest(input, ctx);
        
    	System.out.println(output);
    	
        Assert.assertEquals(input, input);
    }
}
