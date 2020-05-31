package com.splitwiseExample.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.splitwiseExample.model.Expense.Expense;
import com.splitwiseExample.model.Expense.ExpenseFactory;
import com.splitwiseExample.model.exception.UserNotFoundException;

public class BookKeeper {
	private Map<Long,Expense> expenses;
	private Map<Long,User> users;
	
	private static BookKeeper INSTANCE;
	
	BookKeeper() {
		expenses = new HashMap<>();
		users = new HashMap<>();
	}
	
	public static BookKeeper getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new BookKeeper();
		}
		
		return INSTANCE;
	}
	
	/*
	void addUsers(User user) {
		users.add(user);
	}*/
	
	public User getUser(Long uId) throws UserNotFoundException {
		if(!users.containsKey(uId)) {
			throw new UserNotFoundException("User with this uId does not exists.");
		}
		return users.get(uId);
		
	}
	
	public void AddException(String name,User createdBy , User paidBy , String category, double totalAmount,String type ) {
		//Factory pattern
		Date date = new Date();
		Expense e = ExpenseFactory.createExpense(name, date, createdBy, paidBy, category, totalAmount, type);
	}
	
	
	public void showBalances() {
		//map <User , Double>
		//loop all over all the expenses
		//for each expense loop over splits
		//update the balance for users in map
	}
	
	
	public void showBalances(User user) {
		//map <User , Double>
		//loop all over all the expenses
		//for each expense loop over splits
		//update the balance for users in map for that particular user only
	}
	
	
	
	//add Expense
	//Add User
	//show Balance
	//iterate a
	//show Balance
	//Simplify Expenses
	
	
	
	
}
