package com.example.demo.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ProgramsCart;

public class OrderDto
{
	 	private String orderDescription;
	    private List<ProgramsCart> cartItems;
	    private String studentEmail;
	    private String studentName;
		public OrderDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderDto(String orderDescription, List<ProgramsCart> cartItems, String studentEmail,
				String studentName) {
			super();
			this.orderDescription = orderDescription;
			this.cartItems = cartItems;
			this.studentEmail = studentEmail;
			this.studentName = studentName;
		}
		public String getOrderDescription() {
			return orderDescription;
		}
		public void setOrderDescription(String orderDescription) {
			this.orderDescription = orderDescription;
		}
		public List<ProgramsCart> getCartItems() {
			return cartItems;
		}
		public void setCartItems(List<ProgramsCart> cartItems) {
			this.cartItems = cartItems;
		}
		public String getStudentEmail() {
			return studentEmail;
		}
		public void setStudentEmail(String studentEmail) {
			this.studentEmail = studentEmail;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		@Override
		public String toString() {
			return "OrderDto [orderDescription=" + orderDescription + ", cartItems=" + cartItems + ", studentEmail="
					+ studentEmail + ", studentName=" + studentName + "]";
		}
	    
}
