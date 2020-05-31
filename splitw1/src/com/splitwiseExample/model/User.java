package com.splitwiseExample.model;

import java.util.List;

import com.splitwiseExample.model.Expense.Expense;

public class User {
	private String name;
	private String email;
	private String phoneNumber;
	private long uId;
	private List<Expense> expenses;
	
	private static long NEW_UID = 0;
	
	
	public User(String name,String email , String phNo) {
		
		setuId(NEW_UID);
		setName(name);
		setEmail(email);
		setPhoneNumber(phNo);
		
	}

	

	public long getuId() {
		return uId;
	}



	private void setuId(long uId) {
		synchronized(this) 
        { 
            this.uId = NEW_UID ++; 
        } 
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
