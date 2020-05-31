package com.splitwiseExample.model.Expense;

import java.util.Date;

import com.splitwiseExample.model.User;

public class PercentExpense extends Expense {

	public PercentExpense(String name, Date date, User addedBy, User paidBy, String category, Double totalAmount) {
		super(name, date, addedBy, paidBy, category, totalAmount);
		// TODO Auto-generated constructor stub
	}
	
	boolean validate() {
		super.validate();

		return true;
	}

	@Override
	void updateBalance() {
		// TODO Auto-generated method stub
		
	}

}
