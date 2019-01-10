package com.handy.tax.exercise.taxexercise.model;

import java.math.BigDecimal;

public enum Tax {
	FOODBEVERAGE(1, "Food & Beverage", true), TOBBACO(2, "Tobbaco", false), ENTERTAINMENT(3, "Entertainment", false);
	private final Integer code;
	private final String type;
	private final boolean refundable;
	private final BigDecimal onePercent = BigDecimal.valueOf(0.01);
	private final BigDecimal twoPercent = BigDecimal.valueOf(0.02);
	private final BigDecimal tenPercent = BigDecimal.valueOf(0.1);
	private final BigDecimal ten = BigDecimal.valueOf(10);
	private final BigDecimal hundred = BigDecimal.valueOf(100);

	private Tax(Integer code, String type, boolean refundable) {
		this.code = code;
		this.type = type;
		this.refundable = refundable;
	}

	public Integer getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	/**
	 * Method to get Tax.
	 *
	 * @param code
	 */
	public static Tax valueOf(Integer code) {
		Tax tax = null;
		if (code != null) {
			for (Tax toTax : values()) {
				if (toTax.getCode().compareTo(code) == 0) {
					tax = toTax;
					break;
				}
			}
		}
		return tax;
	}

	public boolean isRefundable() {
		return refundable;
	}

	public BigDecimal calculateTax(Tax tax, BigDecimal price) {
		switch (tax) {
		case FOODBEVERAGE:
			return price.multiply(tenPercent);
		case TOBBACO:
			return ten.add(price.multiply(twoPercent));
		case ENTERTAINMENT:
			if (price.compareTo(BigDecimal.ZERO) >= 0 && price.compareTo(hundred) < 0) {
				return BigDecimal.ZERO;
			} else if (price.compareTo(hundred) >= 0) {
				return price.subtract(hundred).multiply(onePercent);
			}
		default:
			return null;
		}
	}
}
