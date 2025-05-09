package com.webage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.webage.domain.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerAPITests {
    
    @Autowired TestRestTemplate template;

    
    @Test
    //@Disabled
    public void testGetList() {

        Customer[] customers = 
            template.getForObject("/customers", Customer[].class);

        assertNotNull(customers);
        assertNotNull(customers[0]);
        assertNotNull(customers[0].getId());
        assertTrue(customers.length>0);
    }

 
    @Test
    //@Disabled
    public void testGet() {

        Customer customer = 
            template.getForObject("/customer/{id}", Customer.class, 1);

        assertNotNull(customer);
        assertNotNull(customer.getId());
    }


    @Test
    //@Disabled
    public void testPost() {

        Customer customer = new Customer();
        customer.setName("Test");
        customer.setEmail("test@test.com");

        URI location = template.postForLocation("/customers", customer, Customer.class);
        assertNotNull(location);

        customer = template.getForObject(location, Customer.class);
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals("Test", customer.getName());
        assertEquals("test@test.com", customer.getEmail());
    }


    @Test
    //@Disabled
    public void testPut() {

        String path = "/customers/2";
        String newValue = "NewValue" + Math.random();

        Customer customer = template.getForObject(path, Customer.class );

        customer.setName(newValue);
        template.put(path, customer);

        customer = template.getForObject(path, Customer.class );

        assertEquals(newValue, customer.getName());
    }

}
