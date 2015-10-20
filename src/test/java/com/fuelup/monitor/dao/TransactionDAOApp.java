package com.fuelup.monitor.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuelup.monitor.models.Transaction;

public class TransactionDAOApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);
		
		Transaction transaction = new Transaction();
		//transaction.setTransactionID(1L);
		transaction.setTransactionDate(new Date());
		transaction.setNotes("test note");
		transaction.setGallons(10.00d);
		transaction.setCostPerGallon(2.50);
		transaction.setMileage(13000l);
		transaction.setTotalCost(25.00d);
		transaction.setCcUsed("BofA DC");
		transaction.setLastUpdatedTime(new Date());
		
		transactionDAO.create(transaction);
	}
}
