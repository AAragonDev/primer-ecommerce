package com.ecommerce.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private Date creationDate;
	private Date receiptDate;
	private double total;
	
	@ManyToOne
	private Usuario user;
	
	@OneToMany(mappedBy = "order")
	private List<DetailOrder> detailorder;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String number, Date creationDate, Date receiptDate, double total) {
		super();
		this.id = id;
		this.number = number;
		this.creationDate = creationDate;
		this.receiptDate = receiptDate;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	

	public List<DetailOrder> getDetailorder() {
		return detailorder;
	}

	public void setDetailorder(List<DetailOrder> detailorder) {
		this.detailorder = detailorder;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", creationDate=" + creationDate + ", receiptDate="
				+ receiptDate + ", total=" + total + "]";
	}
	
	
}
