package com.handy.tax.exercise.taxexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handy.tax.exercise.taxexercise.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}
