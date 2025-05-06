package com.webage.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.webage.domain.Customer;


@Repository
public class ApiClientCustomersDao implements CustomersDao {

	@Value("${api.server.port}")
	String apiServerPort;

	@Value("${api.server.url}")  
	String apiServerUrl;

	private String apiUrl() {
		String url =  String.format(apiServerUrl,apiServerPort);
		System.out.println("API URL: " + url);
		return url;
	}

	
	@Override
	public List<Customer> getAllCustomers() {

		RestClient restClient = RestClient.create(apiUrl());
		Customer[] customers = restClient
			.get()
			.retrieve()
			.body(Customer[].class);
			
		return Arrays.asList(customers);
	}

}
