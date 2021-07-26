package com.shashi.userapiv1;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetUserbyIdTest {

    private static String input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = "U1";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testGetUserbyId() {
        GetUserbyId handler = new GetUserbyId();
        Context ctx = createContext();

        User output = handler.handleRequest(input, ctx);
        System.out.println(output);
        // TODO: validate output here if needed.
        Assert.assertEquals(input, output.getId());
    }
}
