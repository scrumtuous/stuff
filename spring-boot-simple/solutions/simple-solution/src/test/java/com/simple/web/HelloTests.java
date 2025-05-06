package com.simple.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HelloTests {
    
    @Test
    public void testHello() {

        var controller = new HelloController();
        String result = controller.hello();

        assertNotNull(result);
        assertTrue(result.contains("ello"));
    }

    @Test
    public void testCustomer() {
        var controller = new HelloController();
        var result = controller.getCustomer();

        assertEquals (result.getId(), 1);
        assertEquals (result.getName(), "Srinivas");
        assertEquals (result.getEmail(), "mail@mail.com");
    }
}
