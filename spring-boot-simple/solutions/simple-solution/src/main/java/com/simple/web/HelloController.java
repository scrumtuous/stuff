package com.simple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.domain.Customer;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    } 
    
    @GetMapping("/customer")
    public Customer getCustomer() {
        var customer = new Customer();
        customer.setId(1);
        customer.setName("Srinivas");
        customer.setEmail("mail@mail.com");

        return customer;
    } 
    
    
}
