package com.fuelup.monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuelup.monitor.models.Transaction;
import com.fuelup.monitor.services.TransactionService;

@Controller
@RequestMapping(value="/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Transaction>> fetchAllTransactions() {
		List<Transaction> transactions = transactionService.findAll();
		if(transactions != null && transactions.size() >0) {
			return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/fetch/{transactionId}", method=RequestMethod.GET)
	public ResponseEntity<Transaction> fetchTransaction(@PathVariable Long transactionId) {
		Transaction transaction = transactionService.findByID(transactionId);
		if(transaction != null ) {
			return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
		} else {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		Transaction createdTransaction = transactionService.create(transaction);
		if(createdTransaction != null) {
			return new ResponseEntity<Transaction>(createdTransaction, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@RequestMapping(value="/delete/{transactionId}", method=RequestMethod.DELETE)
	public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long transactionId) {
		Transaction deletedTransaction = transactionService.remove(transactionId);
		if(deletedTransaction != null) {
			return new ResponseEntity<Transaction>(deletedTransaction, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_MODIFIED);
		}		
	}
	
	@RequestMapping(value="/modify/{transactionId}", method=RequestMethod.PUT)
	public ResponseEntity<Transaction> modifyTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) {
		Transaction modifiedTransaction = transactionService.modify(transactionId, transaction);
		if(modifiedTransaction != null) {
			return new ResponseEntity<Transaction>(modifiedTransaction, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_MODIFIED);
		}
	}
}
