package com.ecommerce.models;

public class Product {
	private Integer id;
	private String name;
	private String description;
	private String img;
	private double price;
	private int amount;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, String description, String img, double price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.img = img;
		this.price = price;
		this.amount = amount;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", description=" + description + ", img=" + img + ", price="
				+ price + ", amount=" + amount + "]";
	}
	
	

}
