package com.splitwiseExample.model.split;

import com.splitwiseExample.model.User;

public abstract class Split {

	private User user;
	private double amount;
	private String note;
	private long uId;
	
	private static long NEW_UID = 0;
	
	
	
	public Split(User user) {
		setUser(user);
		setuId();
		
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getuId() {
		return uId;
	}
	public void setuId() {
		this.uId = NEW_UID ++;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}


//interface - if you have set of behaviour
//abstact - if you have entity 