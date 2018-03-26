package com.kata;

public class SpecialDiscount {
	public double getUnitPirce() {
		return unitPirce;
	}
	
	public int getGroupSize() {
		return groupSize;
	}
	
	public double getGroupPrice() {
		return groupPrice;
	}
	
	public SpecialDiscount() {
	}

	private double unitPirce;
	private int groupSize;
	private double groupPrice;
	public SpecialDiscount(double unitPirce, int groupSize, double groupPrice) {
		this.unitPirce = unitPirce;
		this.groupSize = groupSize;
		this.groupPrice = groupPrice;
	}
	
	public SpecialDiscount(double unitPirce) {
		this.unitPirce = unitPirce;
	}
	
	
}
