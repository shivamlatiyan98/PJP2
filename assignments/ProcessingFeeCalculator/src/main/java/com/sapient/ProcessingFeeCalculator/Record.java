package com.sapient.ProcessingFeeCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

	public String transactionId;
	public String clientId;
	public String securityId;
	public String transactionType;
	public Date transactionDate;
	public double marketValue;
	public String priorityFlag;
	public double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	
	public String getKey() {
		return this.clientId 
				+ "|" + this.securityId
				+ "|" + DateToSTring();
	}
	
	public String DateToSTring() {
		return new SimpleDateFormat("mm/dd/yyyy").format(transactionDate);
	}
	
	
	@Override
	public String toString() {
		
		return clientId+transactionId+transactionType+DateToSTring();
	}
	
	
}
