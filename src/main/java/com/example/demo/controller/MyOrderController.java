package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.OrderDto;
import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.Dto.OrderResponseDto;
import com.example.demo.entity.MyOrder;
import com.example.demo.entity.ProgramsCart;
import com.example.demo.service.MyOrderService;
import com.example.demo.service.ProgramsService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("myOrder")
public class MyOrderController
{
	
		private MyOrderService orderService;
		private ProgramsService programService;
		private StudentService studentService;
		
		public MyOrderController(MyOrderService orderService, ProgramsService programService,
				StudentService studentService) 
		{
			super();
			this.orderService = orderService;
			this.programService = programService;
			this.studentService = studentService;
		}


		@GetMapping("getorder/{oid}")
		public ResponseEntity<MyOrder> getOrderById(@PathVariable int oid )
		{
			MyOrder order = null;
			try
			{
				 order=orderService.getOrderDetail(oid);
				
			}
			catch (ResourceNotFoundException e)
			{
				new ResourceNotFoundException("user not found with id : "+oid);
			}
			return new ResponseEntity<MyOrder>(order,HttpStatus.OK);

		}
		
		@PostMapping("placeOrder")	
		public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderDto orderdto)
		{
			System.out.println("request payload"+orderdto.toString());
			OrderResponseDto responce=new OrderResponseDto();
			Double amount=orderService.getCartAmount(orderdto.getCartItems());
			System.out.println("cart amount in controller : "+amount);
			
			String email=orderdto.getStudentEmail();
			String studname=orderdto.getStudentName();
		
	
			//Student student1=new Student(email,studname);
			Student student1=new Student();
			student1.setEmail(email);
			student1.setSname(studname);
			student1.setSid(student1.getSid());
			//System.out.println("student1 name and email : "+student1.toString());
			System.out.println("student2 name and email : "+student1.toString());
			
			
			Integer studId=studentService.isStudentPresent(student1);
			if(studId != null)
			{
				student1.setSid(studId);
				System.out.println("student present in database"+ studId);
			}
			else
			{
				student1=studentService.saveStudent(student1);
				System.out.println("student info save in database with id"+student1.getSid());
			}
			
			 List<ProgramsCart> cartItem=orderdto.getCartItems();
			 String desc=orderdto.getOrderDescription();
		
			//MyOrder order=new MyOrder(cartItem,student1,desc);
			MyOrder order=new MyOrder();
			order.setdescription(desc);
			order.setProgramsCart(cartItem);
			order.setStudent(student1);
			
			 order=orderService.saveOrder(order);
			System.out.println("order details: "+order.toString());
			System.out.println("order process successfully....");
			
			responce.setAmount(amount);
			responce.setInvoiceNumber(new Random().nextInt(1000));
			responce.setOrderId(order.getOid());
			responce.setOrderDesc(orderdto.getOrderDescription());
			System.out.println("order place successfully");
			return new ResponseEntity<OrderResponseDto>(responce,HttpStatus.OK);
			
		}
}
