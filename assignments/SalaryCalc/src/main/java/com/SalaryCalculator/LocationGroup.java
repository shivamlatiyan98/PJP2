package com.SalaryCalculator;

public class LocationGroup {

	public String name;
	public int Count;
	private char gender;
	private double avgIncome;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(double avgIncome) {
		this.avgIncome = avgIncome;
	}
	
	public void increment() {
		Count++;
	}
	
	
	
	
	
}
