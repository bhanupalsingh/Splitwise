package com.splitwiseExample.model.Expense;

import java.util.Date;
import java.util.List;

import com.splitwiseExample.model.User;
import com.splitwiseExample.model.split.Split;

public class EqualExpense extends Expense {

	public EqualExpense(String name, Date date, User addedBy, User paidBy, String category, Double totalAmount) {
		super(name, date, addedBy, paidBy, category, totalAmount);
		// TODO Auto-generated constructor stub
	}
	
	boolean validate() {
		super.validate();
		return true;
	}

	@Override
	void updateBalance() {
		
		List<Split> splits = getSplits();
		int size = splits.size();
		for(Split s : splits) {
			s.setAmount(getTotalAmount()/size);
		}
		
		// TODO Auto-generated method stub
		
	}

	

}
