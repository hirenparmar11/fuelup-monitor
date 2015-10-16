package com.fuelup.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuelup.monitor.dao.TransactionDAO;
import com.fuelup.monitor.model.Transaction;

/**
 * {@link TransactionService} bridges between DAO and Controller layer
 * */

@Service
public class TransactionService {

	@Autowired
	TransactionDAO transactionDAO;
	
	public List<Transaction> fetchAllTransactions() {
		return transactionDAO.fetchAllTransactions();
	}
	
	@Transactional
	public Transaction createTransaction(Transaction transaction) {
		return transactionDAO.createTransaction(transaction);
	}
	
	@Transactional
	public Transaction deleteTransaction(Long transactionId) {
		return transactionDAO.deleteTransaction(transactionId);
	}
	
	@Transactional
	public Transaction modifyTransaction(Long transactionId, Transaction transaction) {
		return transactionDAO.modifyTransaction(transactionId, transaction);
	}

	public Transaction fetchTransaction(Long transactionId) {
		return transactionDAO.fetchTransaction(transactionId);
	}
}
