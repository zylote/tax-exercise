package com.handy.tax.exercise.taxexercise.service;

import java.util.List;

import com.handy.tax.exercise.taxexercise.model.Receipt;
import com.handy.tax.exercise.taxexercise.model.ReceiptData;

public interface ReceiptService {
	public ReceiptData findById(Integer id);

	public List<ReceiptData> findByName(String name);

	public void saveReceipt(Receipt receipt);

	public void updateReceipt(Receipt receipt);

	public void deleteReceiptById(Integer id);

	public List<ReceiptData> findAllReceipts();

	public void deleteAllReceipt();

}
