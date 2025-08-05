package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloAppTest {

    @Test
    public void testGreet() {
        assertEquals("Hello DevOps World!", HelloApp.greet());
    }
}
