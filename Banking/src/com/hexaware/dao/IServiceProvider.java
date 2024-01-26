package com.hexaware.dao;

import com.hexaware.entity.BankAccount;
import com.hexaware.exception.*;

public interface IServiceProvider {
		public BankAccount  searchAccount(long accountNumber) throws AccountNumberInvalidException;
		public double checkBalance(long accountNumber) throws AccountNumberInvalidException;
		public boolean deposit(long accountNumber,double amount) throws AccountNumberInvalidException, NegativeAmountException;
		public boolean withdraw(long accountNumber,double amount) throws AccountNumberInvalidException, InsufficientFundsException, NegativeAmountException;
		public boolean removeAccount(long accountNumber) throws AccountNumberInvalidException;
		public boolean createAccount(BankAccount newAcc);
}