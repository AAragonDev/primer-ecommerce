package com.ecommerce.models;

public class DetailOrder {
	
	private Integer id;
	private String name;
	private double amount;
	private double price;
	private double total;
	
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

	@Override
	public String toString() {
		return "DetailOrder [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + ", total="
				+ total + "]";
	}
	
	

}
