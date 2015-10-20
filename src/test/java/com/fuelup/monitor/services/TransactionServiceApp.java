package com.fuelup.monitor.services;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuelup.monitor.models.Transaction;
import com.fuelup.monitor.services.TransactionService;

public class TransactionServiceApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		TransactionService transactionService = context.getBean(TransactionService.class);
		
		Transaction transaction = new Transaction();
		//transaction.setTransactionID(1L);
		transaction.setTransactionDate(new Date());
		transaction.setNotes("test note");
		transaction.setGallons(9.00d);
		transaction.setCostPerGallon(2.50);
		transaction.setMileage(13100l);
		transaction.setTotalCost(22.50d);
		transaction.setCcUsed("BofA DC");
		transaction.setLastUpdatedTime(new Date());
		
		transactionService.create(transaction);
	}
}
