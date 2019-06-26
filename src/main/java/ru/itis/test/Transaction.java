package ru.itis.test;

public class Transaction {
	private String currency;
	private double amount;
	private Type type;

	public Transaction(String currency, double amount, Type type) {
		this.currency = currency;
		this.amount = amount;
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}