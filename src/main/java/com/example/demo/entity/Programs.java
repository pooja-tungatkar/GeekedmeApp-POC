package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Programs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String ptype;
	private double price;
	private int availableQty;
	
	public Programs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programs(int pid, String ptype, double price, int availableQty) {
		super();
		this.pid = pid;
		this.ptype = ptype;
		this.price = price;
		this.availableQty = availableQty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	@Override
	public String toString() {
		return "Programs [pid=" + pid + ", ptype=" + ptype + ", price=" + price + ", availableQty=" + availableQty
				+ "]";
	}
	
}
