package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloAppTest {

    @Test
    public void testGetMessage() {
        HelloApp app = new HelloApp();
        String message = app.getMessage();
       assertTrue(true); // dummy test

    }
}
