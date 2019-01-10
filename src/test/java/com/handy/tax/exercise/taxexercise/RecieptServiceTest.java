package com.handy.tax.exercise.taxexercise;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.handy.tax.exercise.taxexercise.model.Tax;
import com.handy.tax.exercise.taxexercise.service.impl.ReceiptServiceImpl;

public class RecieptServiceTest {

	@InjectMocks
	ReceiptServiceImpl recieptService;

	@Test
	public void testCalculateTaxFoodAndBeverage() {
		BigDecimal price = BigDecimal.valueOf(1000);
		BigDecimal taxValue = Tax.FOODBEVERAGE.calculateTax(Tax.FOODBEVERAGE, price);
		Assert.assertTrue(taxValue.compareTo(BigDecimal.valueOf(100)) == 0);
	}

	@Test
	public void testCalculateTaxTobbaco() {
		BigDecimal price = BigDecimal.valueOf(1000);
		BigDecimal taxValue = Tax.TOBBACO.calculateTax(Tax.TOBBACO, price);
		Assert.assertTrue(taxValue.compareTo(BigDecimal.valueOf(30)) == 0);
	}

	@Test
	public void testCalculateTaxEntertainment() {
		BigDecimal price = BigDecimal.valueOf(1000);
		BigDecimal taxValue = Tax.ENTERTAINMENT.calculateTax(Tax.ENTERTAINMENT, price);
		Assert.assertTrue(taxValue.compareTo(BigDecimal.valueOf(9)) == 0);

		price = BigDecimal.valueOf(10);
		taxValue = Tax.ENTERTAINMENT.calculateTax(Tax.ENTERTAINMENT, price);
		Assert.assertTrue(taxValue.compareTo(BigDecimal.ZERO) == 0);
	}

}
