package com.handy.tax.exercise.taxexercise.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReceiptNotFoundException extends RuntimeException {

	private String id;

	public ReceiptNotFoundException(String id) {
		super(String.format(" not found : '%s'", id));
		this.id = id;

	}

	public String getId() {
		return this.id;
	}

}