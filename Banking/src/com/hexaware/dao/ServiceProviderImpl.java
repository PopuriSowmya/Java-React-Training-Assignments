package com.hexaware.dao;
import com.hexaware.entity.*;
import com.hexaware.exception.*;

public class ServiceProviderImpl implements IServiceProvider {
	private Bank myBank;

    public ServiceProviderImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ServiceProviderImpl(Bank myBank) {
        super();
        this.myBank = myBank;
    }

    @Override
    public BankAccount searchAccount(long accountNumber) throws AccountNumberInvalidException {
        BankAccount reqAccount = null;
        for (BankAccount account : myBank.getAccountList()) {
            if (account.getAccountNumber() == accountNumber) {
                reqAccount = account;
                break;
            }
            
        }
            
        
        if(reqAccount==null) {
        	throw new AccountNumberInvalidException("Account number is invalid");
        }
		return reqAccount;
    }

    public double checkBalance(long accountNumber) throws AccountNumberInvalidException {
        // TODO Auto-generated method stub
        double balanceAmount = -1;
        BankAccount reqAccount = searchAccount(accountNumber);
        if (reqAccount != null) {
            balanceAmount = reqAccount.getBalance();
        }
        else {
        	throw new AccountNumberInvalidException("Account number is invalid");
        }
        return balanceAmount;
    }

    @Override
    public boolean deposit(long accountNumber, double amount) throws AccountNumberInvalidException, NegativeAmountException {
        // TODO Auto-generated method stub
        BankAccount reqAccount = searchAccount(accountNumber);
        boolean depositStatus = false;
        if (amount > 0) {
            if (reqAccount == null) {
            	throw new AccountNumberInvalidException("Account number is invalid");
            } else {
                reqAccount.setBalance(reqAccount.getBalance() + amount);
                depositStatus = true;
            }
        }
        else {
        	throw new NegativeAmountException("Balance cannot be negative");
        }
        return depositStatus;
    }

    @Override
    public boolean withdraw(long accountNumber, double amount) throws AccountNumberInvalidException, NegativeAmountException, InsufficientFundsException {
        BankAccount reqAccount = searchAccount(accountNumber);
        boolean withdrawStatus = false;
        if (reqAccount == null) {
        	throw new AccountNumberInvalidException("Account number is invalid");
        } else {
            if (amount < 0) {
            	throw new NegativeAmountException("Balance cannot be negative");
            } else if (reqAccount.getBalance() < amount) {
            	throw new InsufficientFundsException("Funds are not sufficient");
            } else {
                reqAccount.setBalance(reqAccount.getBalance() - amount);
                withdrawStatus = true;
            }
        }
        return withdrawStatus;
    }

    @Override
    public boolean createAccount(BankAccount newAcc) {
        // TODO Auto-generated method stub
        BankAccount lastAccObj = myBank.getAccountList().get(myBank.getAccountList().size() - 1);
        boolean status = false;
        BankAccount newAccObj = new BankAccount(newAcc.getHolderName(),
                newAcc.getType(), newAcc.getBalance());
        myBank.getAccountList().add(newAccObj);
        status = true;
        return status;
    }

    @Override
    public boolean removeAccount(long accountNumber) throws AccountNumberInvalidException {
        // TODO Auto-generated method stub
        BankAccount reqAccount = searchAccount(accountNumber);
        boolean removeStatus = false;
        if (reqAccount != null) {
            myBank.getAccountList().remove(reqAccount);
            removeStatus = true;
        }
        else {
        	throw new AccountNumberInvalidException("Account number is invalid");
        }
        return removeStatus;
    }

	
}