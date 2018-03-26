package com.kata;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckSumTest {
	public double calculatePrice(String goods) {
		CheckSum co = new CheckSum(givenPriceRuleSet());
		for (int i = 0; i < goods.length(); i++) {
			co.scan(String.valueOf(goods.charAt(i)));
		}
		return co.total();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void totals() {
        assertEquals(0, calculatePrice(""), 0.1);
        assertEquals(40, calculatePrice("A"), 0.1);
        assertEquals(90, calculatePrice("AB"), 0.1);
        assertEquals(135, calculatePrice("CDBA"), 0.1);
        assertEquals(80, calculatePrice("AA"), 0.1);
        assertEquals(120, calculatePrice("AAA"), 0.1);
        assertEquals(160, calculatePrice("AAAA"), 0.1);
        assertEquals(200, calculatePrice("AAAAA"), 0.1);
        assertEquals(240, calculatePrice("AAAAAA"), 0.1);
        assertEquals(170, calculatePrice("AAAB"), 0.1);
        assertEquals(220, calculatePrice("AAABB"), 0.1);
        assertEquals(240, calculatePrice("AAABBD"), 0.1);
        assertEquals(240, calculatePrice("DABABA"), 0.1);
    }
	
	@Test
    public void incremental() {
        CheckSum co = new CheckSum(givenPriceRuleSet());
        assertEquals(0, co.total(), 0.1);
        co.scan("A"); assertEquals(40, co.total(), 0.1);
        co.scan("B"); assertEquals(90, co.total(), 0.1);
        co.scan("A"); assertEquals(130, co.total(), 0.1);
        co.scan("A"); assertEquals(170, co.total(), 0.1);
        co.scan("B"); assertEquals(220, co.total(), 0.1);
    }

	private DiscountPriceSet givenPriceRuleSet() {
		Map<String, SpecialDiscount> priceRules = new HashMap<>();
		priceRules.put("A", new SpecialDiscount(40, 3, 100));
		priceRules.put("B", new SpecialDiscount(50, 2, 80));
		priceRules.put("C", new SpecialDiscount(25));
		priceRules.put("D", new SpecialDiscount(20));
		return new DiscountPriceSet(priceRules);
	}
}
