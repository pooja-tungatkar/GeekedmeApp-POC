package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgramsCart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	private int programId;
	private String programName;
	private int quantity;
	private double amount;
	public ProgramsCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProgramsCart(int cartid, int programId, String programName, int quantity, double amount) {
		super(); 
		this.cartid = cartid;
		this.programId = programId;
		this.programName = programName;
		this.quantity = quantity;
		this.amount = amount;
	}
	public int getcartid() {
		return cartid;
	}
	public void setcartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ProgramsCart [cartid=" + cartid + ", programId=" + programId + ", programName=" + programName + ", quantity="
				+ quantity + ", amount=" + amount + "]";
	}
	
}
