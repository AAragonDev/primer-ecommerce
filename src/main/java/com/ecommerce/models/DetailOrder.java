package com.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detailsOrder")
public class DetailOrder {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double amount;
	private double price;
	private double total;
	
	@ManyToOne
	private Order order;
	@ManyToOne
	private Product product;
	
	public DetailOrder() {
		// TODO Auto-generated constructor stub
	}

	public DetailOrder(Integer id, String name, double amount, double price, double total) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "DetailOrder [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + ", total="
				+ total + "]";
	}
	
	

}
