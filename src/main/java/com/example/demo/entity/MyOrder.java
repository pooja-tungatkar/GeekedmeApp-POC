package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class MyOrder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String description;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="stud_id", referencedColumnName = "sid")
	private Student student;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id", referencedColumnName = "cartid")
	private List<ProgramsCart> ProgramsCart;
	
	private boolean coupens;
	private double enrollfee;
	
	public MyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyOrder(int oid, String description, Student student, List<ProgramsCart> ProgramsCart, boolean coupens,
			double enrollfee) {
		super();
		this.oid = oid;
		this.description = description;
		this.student = student;
		this.ProgramsCart = ProgramsCart;
		this.coupens = coupens;
		this.enrollfee = enrollfee;
		
	}
	public MyOrder(List<com.example.demo.entity.ProgramsCart> cartItems, Student student1, String orderDescription) {
		// TODO Auto-generated constructor stub
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<ProgramsCart> getProgramsCart() {
		return ProgramsCart;
	}
	public void setProgramsCart(List<ProgramsCart> ProgramsCart) {
		this.ProgramsCart = ProgramsCart;
	}
	public boolean isCoupens() {
		return coupens;
	}
	public void setCoupens(boolean coupens) {
		this.coupens = coupens;
	}
	public double getEnrollfee() {
		return enrollfee;
	}
	public void setEnrollfee(double enrollfee) {
		this.enrollfee = enrollfee;
	}
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", description=" + description + ", student=" + student + ", ProgramsCart=" + ProgramsCart
				+ ", coupens=" + coupens + ", enrollfee=" + enrollfee + "]";
	}
	

}
