package com.handy.tax.exercise.taxexercise.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handy.tax.exercise.taxexercise.model.Receipt;
import com.handy.tax.exercise.taxexercise.model.ReceiptData;
import com.handy.tax.exercise.taxexercise.model.ReceiptNotFoundException;
import com.handy.tax.exercise.taxexercise.model.Tax;
import com.handy.tax.exercise.taxexercise.repository.ReceiptRepository;
import com.handy.tax.exercise.taxexercise.service.ReceiptService;

@Service("receiptService")
@Transactional
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	ReceiptRepository receiptRepository;

	@Override
	public ReceiptData findById(Integer id) {
		Receipt receipt = receiptRepository.findById(id)
				.orElseThrow(() -> new ReceiptNotFoundException("Receipt not found for this id :: " + id));
		return receiptDataTransformer(receipt);
	}

	private ReceiptData receiptDataTransformer(Receipt receipt) {
		ReceiptData receiptData = new ReceiptData();
		Tax tax = Tax.valueOf(Integer.valueOf(receipt.getTaxCode()));
		BigDecimal price = receipt.getPrice();
		BigDecimal taxValue = tax.calculateTax(tax, price);
		receiptData.setId(receipt.getId());
		receiptData.setName(receipt.getName());
		receiptData.setTaxCode(receipt.getTaxCode());
		receiptData.setTaxType(tax.getType());
		receiptData.setPrice(price);
		receiptData.setTax(taxValue);
		receiptData.setAmount(price.add(taxValue));
		receiptData.setRefundable(tax.isRefundable());
		return receiptData;
	}

	@Override
	public List<ReceiptData> findByName(String name) {
		List<ReceiptData> sameNameReceipts = new ArrayList<>();
		List<ReceiptData> receipts = findAllReceipts();
		receipts.forEach(receipt -> {
			if (receipt.getName().equalsIgnoreCase(name)) {
				sameNameReceipts.add(receipt);
			}
		});
		return sameNameReceipts;
	}

	@Override
	public void saveReceipt(Receipt receipt) {
		receiptRepository.save(receipt);
	}

	@Override
	public void updateReceipt(Receipt receipt) {
		receiptRepository.save(receipt);
	}

	@Override
	public void deleteReceiptById(Integer id) {
		ReceiptData receipt = findById(id);
		receiptRepository.deleteById(receipt.getId());
	}

	@Override
	public List<ReceiptData> findAllReceipts() {
		List<ReceiptData> receiptDatas = new ArrayList<>();
		receiptRepository.findAll().forEach(receipt -> {
			receiptDatas.add(receiptDataTransformer(receipt));
		});
		return receiptDatas;
	}

	@Override
	public void deleteAllReceipt() {
		receiptRepository.deleteAll();
	}

}
