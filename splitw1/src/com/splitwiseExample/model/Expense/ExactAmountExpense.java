package com.splitwiseExample.model.Expense;

import java.util.Date;

import com.splitwiseExample.model.User;

public class ExactAmountExpense extends Expense {

	public ExactAmountExpense(String name, Date date, User addedBy, User paidBy, String category, Double totalAmount) {
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
