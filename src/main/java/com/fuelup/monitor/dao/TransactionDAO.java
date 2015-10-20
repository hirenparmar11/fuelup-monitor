package com.fuelup.monitor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fuelup.monitor.models.Transaction;

@Repository
public class TransactionDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Transaction create(Transaction transaction) {

		if(transaction != null) {
			entityManager.persist(transaction);
			return findByID(transaction.getTransactionID());
		} else {
			return null;
		}
	}
	
	@Transactional
	public Transaction modify(Long transactionID, Transaction transaction) {

		Transaction staleTransaction = entityManager.find(Transaction.class, transactionID);
		if(transaction != null && staleTransaction != null) {
			staleTransaction.setTransactionDate(transaction.getTransactionDate());
			staleTransaction.setCostPerGallon(transaction.getCostPerGallon());
			staleTransaction.setGallons(transaction.getGallons());
			staleTransaction.setMileage(transaction.getMileage());
			staleTransaction.setNotes(transaction.getNotes());
			staleTransaction.setTotalCost(transaction.getTotalCost());
			staleTransaction.setCcUsed(transaction.getCcUsed());
			return staleTransaction;
		}  else {
			return null;
		}
	}
	
	@Transactional
	public Transaction remove(Long transactionID) {
		
		if(transactionID !=null && transactionID > 0) {
			Transaction deletedTransaction = findByID(transactionID);
			if(deletedTransaction != null && entityManager.contains(deletedTransaction)) {
				entityManager.remove(entityManager.merge(deletedTransaction));
				if(findByID(transactionID) == null) {
					return deletedTransaction;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}

	}
	
	public Transaction findByID(Long transactionID) {
		
		if(transactionID !=null && transactionID > 0) {
			return entityManager.find(Transaction.class, transactionID);
		} else {
			return null;
		}
	}
	
	public List<Transaction> findAll() {
		return entityManager.createNamedQuery("findAll", Transaction.class).getResultList();
	}
}
