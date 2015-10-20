package com.fuelup.monitor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuelup.monitor.dao.TransactionDAO;
import com.fuelup.monitor.models.Transaction;

@Service
public class TransactionService {

	@Autowired
	TransactionDAO transactionDAO;
	
	public Transaction create(Transaction transaction) {

		if(transaction != null) {
			return transactionDAO.create(transaction);
		} else {
			return null;
		}
	}
	
	public Transaction modify(Long transactionID, Transaction transaction) {

		if(transaction != null && findByID(transactionID) != null) {
			return transactionDAO.modify(transactionID,transaction);
		}  else {
			return null;
		}
	}
	
	public Transaction remove(Long transactionID) {
		
		if(transactionID !=null && transactionID > 0) {
			Transaction deletedTransaction = findByID(transactionID);
			if(deletedTransaction != null) {
				return transactionDAO.remove(transactionID);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public Transaction findByID(Long transactionID) {
		
		if(transactionID !=null && transactionID > 0) {
			return transactionDAO.findByID(transactionID);
		} else {
			return null;
		}
	}
	
	public List<Transaction> findAll() {
		return transactionDAO.findAll();
	}
}
