package com.kata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DiscountPriceSet {
	private Map<String, SpecialDiscount> discountRules;

	public DiscountPriceSet(Map<String, SpecialDiscount> discountRules) {
		this.discountRules = discountRules;
	}

	public double calculateTotalPrice(Collection<String> skus) {
		double res = 0;
		for (String str : skus) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c : str.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				res += calculatePriceForSpecificUnit(Character.toString(entry.getKey()), entry.getValue());
			}
		}
		return res;
		
	}

	private double calculatePriceForSpecificUnit(String name, long quantity) {
		if (!discountRules.containsKey(name)) {
			throw new IllegalArgumentException(String.format("No price rule found for '%s'", name));
		}

		SpecialDiscount price = discountRules.get(name);

		int specialGroupSize = price.getGroupSize();
		double specialPrice = price.getGroupPrice();
		double unitPrice = price.getUnitPirce();

		int batchCount = specialGroupSize == 0 ? 0 : (int) (quantity / specialGroupSize);
		long remainder = specialGroupSize == 0 ?  quantity : (long) (quantity % specialGroupSize);

		return batchCount * specialPrice + remainder * unitPrice;
	}

}
