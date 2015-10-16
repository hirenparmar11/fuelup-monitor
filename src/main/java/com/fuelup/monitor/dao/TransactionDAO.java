package com.fuelup.monitor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fuelup.monitor.model.Transaction;

@Repository
public class TransactionDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	public List<Transaction> fetchAllTransactions() {
		List<Transaction> transactions = entityManager.createNamedQuery("fetchAllTrx", Transaction.class).getResultList();
		return transactions;
	}
	
	public Transaction fetchTransaction(Long transactionId) {
		return entityManager.find(Transaction.class, transactionId);
	}
	
	public Transaction createTransaction(Transaction transaction) {
		entityManager.persist(transaction);
		return fetchTransaction(transaction.getTransactionID());
	}

	public Transaction deleteTransaction(Long transactionId) {
		Transaction transaction = fetchTransaction(transactionId);
		entityManager.remove(transaction);
		
		if(fetchTransaction(transactionId) == null) {
			return transaction;
		} else {
			return null;
		}

	}

	public Transaction modifyTransaction(Long transactionId, Transaction transaction) {
		entityManager.refresh(transaction);
		
		if(fetchTransaction(transactionId) == null) {
			return null;
		} else if(fetchTransaction(transactionId).equals(transaction)) {
			return transaction;
		} else {
			return null;
		}
	}
}
