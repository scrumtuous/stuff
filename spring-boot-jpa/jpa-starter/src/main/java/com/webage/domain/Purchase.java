package com.webage.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//	PART 4:
//	Use an annotation to mark this class as a JPA entity.
//	Use a separate annotation to override the table name to be "PURCHASES".
//	Use an annotation to mark the id field as the primary key.
//  Also mark it with @GeneratedValue(strategy=GenerationType.IDENTITY).
//	Use an annotation to mark the customer field as a @ManyToOne relationship.

public class Purchase {

	private int id;

	private Customer customer;

	private Date purchaseDate;

	private String product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
