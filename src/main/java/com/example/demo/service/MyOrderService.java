package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MyOrder;
import com.example.demo.entity.Programs;
import com.example.demo.entity.ProgramsCart;
import com.example.demo.repository.MyOrderRepo;
import com.example.demo.repository.ProgramsRepo;

@Service
public class MyOrderService 
{
	private MyOrderRepo orderrepo;
	private ProgramsRepo programrepo;
	
	public MyOrderService(MyOrderRepo orderrepo, ProgramsRepo programrepo) {
		super();
		this.orderrepo = orderrepo;
		this.programrepo = programrepo;
	}
	
	public MyOrder getOrderDetail(int orderId)
	{
		Optional<MyOrder> order=orderrepo.findById(orderId);
		return order.isPresent()?order.get():null;		
	}

	public double getCartAmount(List<ProgramsCart> programCartList)
	{
		double totalCartAmount = 0;
		double singleCartAmount = 0;
		int availableQty = 0;
		
		for(ProgramsCart cart:programCartList)
		{
			int programId=cart.getProgramId();
			Optional<Programs>proId=programrepo.findById(programId);
			if(proId.isPresent())
			{
				Programs program1=proId.get();
				System.out.println("program id is found...");
				
				if(program1.getAvailableQty()<cart.getQuantity())
				{
					singleCartAmount=program1.getPrice() * program1.getAvailableQty();
					cart.setQuantity(program1.getAvailableQty());
					System.out.println("single cart amount in service : "+singleCartAmount);
				}
				else
				{
					singleCartAmount=cart.getQuantity() * program1.getPrice();
					availableQty= program1.getAvailableQty() - cart.getQuantity();
					System.out.println("single cart amount and available quantity : "+singleCartAmount+"  "+availableQty);

				}
				totalCartAmount=totalCartAmount+ singleCartAmount;
				System.out.println("total cart amount : "+totalCartAmount);
				program1.setAvailableQty(availableQty);
				availableQty=0;
				cart.setProgramName(program1.getPtype());
				cart.setAmount(singleCartAmount);
				programrepo.save(program1);
               
			}
			
		}
		return totalCartAmount;
		
	}
	
	public MyOrder saveOrder(MyOrder order)
	{
		return orderrepo.save(order);
	}
	
}
