package com.klu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reunion")
public class Student {
	@Id
	@Column(name = "Student Id")
	Long id;
	
	@Column(name="Student Name")
	String name;
	
	@Column(name="Student Number")
	String number;
	
	@Column(name="Amount Paid")
	int amount;
	
	@Column(name="Status")
	String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", amount=" + amount + ", status="
				+ status + "]";
	}
	
	

}
