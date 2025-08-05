package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;  // ✅ Add this line

public class HelloAppTest {

    @Test
    public void testApp() {
        assertTrue(true);  // ✅ JUnit test method
    }
}
