package model.entities;

import model.exceptions.NoBalanceException;
import model.exceptions.WithdrawLimitException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		balance+=amount;
	}
	
	public void withdraw(Double amount) {
		if(amount > withdrawLimit) {
			throw new WithdrawLimitException("Withdraw Limit Error: This operation is not allowed");
		}
		if(amount > balance) {
			throw new NoBalanceException("Not error: Enough cash in balance");
		}
		balance-=amount;
	}
	
}
