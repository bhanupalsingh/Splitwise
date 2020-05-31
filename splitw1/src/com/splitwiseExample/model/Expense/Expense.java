package com.splitwiseExample.model.Expense;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.splitwiseExample.model.User;
import com.splitwiseExample.model.split.Split;

public abstract class Expense {

	private long uId;
	private String name;
	private Date date;
	private User addedBy ;
	private User paidBy;
	private String category;
	private Double totalAmount;
	private List<Split> splits;
	
	
	
//	private Image image;
//	private Location location;
	
	
	public long getuId() {
		return uId;
	}

	public void setuId() {
		this.uId = NEW_UID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Split> getSplits() {
		return splits;
	}

	private static long NEW_UID  = 0;
	
	public Expense(String name, Date date, User addedBy, User paidBy, String category,Double totalAmount) {
		super();
		//todo builder pattern
		this.uId = NEW_UID++;
		this.name = name;
		this.date = date;
		this.addedBy = addedBy;
		this.paidBy = paidBy;
		this.category = category;
		this.totalAmount = totalAmount;
	}
	
	boolean validate() {
		
		double sum = 0;
		
		for(Split s:splits) {
			sum += s.getAmount();
		}
		
		if( totalAmount - sum <= 0.001)  {
			return true;
		}
		return false;
	}
	
	
	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}
	
	abstract void updateBalance();
	
	public void removeSplit(Split s) {
		splits.remove(s);
		updateBalance();
		//recalculate
	}
	
	
	
}
