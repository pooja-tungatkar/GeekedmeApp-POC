package com.example.demo.Dto;

import org.springframework.stereotype.Component;


public class OrderResponseDto 
{
	private double amount;
    private int invoiceNumber;
    private int orderId;
    private String orderDesc;
	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderResponseDto(double amount, int invoiceNumber, int orderId, String orderDesc) {
		super();
		this.amount = amount;
		this.invoiceNumber = invoiceNumber;
		this.orderId = orderId;
		this.orderDesc = orderDesc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	@Override
	public String toString() {
		return "OrderResponseDto [amount=" + amount + ", invoiceNumber=" + invoiceNumber 
				+ ", orderId=" + orderId + ", orderDesc=" + orderDesc + "]";
	}
     
}
