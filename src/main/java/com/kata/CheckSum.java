package com.kata;

import java.util.LinkedList;
import java.util.List;

public class CheckSum {
	private final DiscountPriceSet ruleSet;
	private List<String> skus = new LinkedList<>();

	public CheckSum(DiscountPriceSet ruleSet) {
	        this.ruleSet = ruleSet;
	    }

	public void scan(String s) {
		skus.add(s);
	}

	public double total() {
		return ruleSet.calculateTotalPrice(skus);
	}
}
