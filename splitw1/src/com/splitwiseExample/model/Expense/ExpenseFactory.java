package com.splitwiseExample.model.Expense;

import java.util.Date;
import com.splitwiseExample.model.Expense.ExpenseType;

import com.splitwiseExample.model.User;

public class ExpenseFactory {
	public static Expense createExpense(String name,Date date ,  User addedBy ,User paidBy , String category ,  double totalAmount , String type) {
		
		//todo map based mapping 
		
		switch(ExpenseType.valueOf(type)) {
			case EQUAL:
				return new EqualExpense(name, date, addedBy, paidBy, category, totalAmount);
			case PERCENT:
				return new PercentExpense(name, date, addedBy, paidBy, category, totalAmount);
			case EXACT:
				return new ExactAmountExpense(name, date, addedBy, paidBy, category, totalAmount);
			default:
				return new EqualExpense(name, date, addedBy, paidBy, category, totalAmount);
				
		}
	}
}
