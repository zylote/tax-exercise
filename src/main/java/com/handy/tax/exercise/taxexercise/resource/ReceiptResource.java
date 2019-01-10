package com.handy.tax.exercise.taxexercise.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handy.tax.exercise.taxexercise.model.Receipt;
import com.handy.tax.exercise.taxexercise.model.ReceiptData;
import com.handy.tax.exercise.taxexercise.service.ReceiptService;

@RestController
@RequestMapping(value = "/rest/receipts")
public class ReceiptResource {
	@Autowired
	ReceiptService receiptService;

	@GetMapping("/all")
	public List<ReceiptData> getAll() {
		return receiptService.findAllReceipts();
	}

	@GetMapping("/receipt/{id}")
	public ReceiptData getReceipt(@PathVariable Integer id) {
		return receiptService.findById(id);
	}

	@PostMapping("/load")
	public List<ReceiptData> saveOrUpdate(@RequestBody final Receipt receipt) {
		receiptService.saveReceipt(receipt);
		return receiptService.findAllReceipts();
	}

	@DeleteMapping("/deleteAll")
	public List<ReceiptData> deleteAll() {
		receiptService.deleteAllReceipt();
		return receiptService.findAllReceipts();
	}

	@DeleteMapping("/delete/{id}")
	public List<ReceiptData> deleteById(@RequestParam Integer id) {
		receiptService.deleteReceiptById(id);
		return receiptService.findAllReceipts();
	}

}
