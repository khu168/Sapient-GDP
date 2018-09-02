package com.junits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.constant.Constant;
import com.exceptions.ReadPropertyDataException;

public class ExchangeRateTest {
	
	@Test
	public void testGetExchangeRateUSD() throws ReadPropertyDataException {
		assertTrue(Constant.getExchangeRate("100", "USD") == 100.00);
	}
	@Test
	public void testGetExchangeRateUSDFail() throws ReadPropertyDataException {
		assertFalse(Constant.getExchangeRate("100", "USD") == 101.00);
	}
	@Test
	public void testGetExchangeRateINR() throws ReadPropertyDataException {
		assertTrue(Constant.getExchangeRate("100", "INR") == 1.45);
	}
}
