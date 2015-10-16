package com.fuelup.monitor.executables;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuelup.monitor.dao.TransactionDAO;

public class TransationApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);
		transactionDAO.fetchAllTransactions();
	}
}
