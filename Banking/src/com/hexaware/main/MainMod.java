package com.hexaware.main;
import java.util.ArrayList;
import com.hexaware.dao.ServiceProviderImpl;
import com.hexaware.entity.*;
import com.hexaware.exception.*;
import java.util.logging.*;
import java.util.logging.Logger;

public class MainMod {
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) throws InsufficientFundsException, AccountNumberInvalidException,
            NegativeAmountException {

        // TODO Auto-generated method stub
    	LOGGER.log(Level.INFO, "Starting the Banking Application");
        BankAccount obj1 = new BankAccount("Sachin", "Current", 80000.50);
        BankAccount obj2 = new BankAccount("Nisha", "Savings", 20000.50);
        BankAccount obj3 = new BankAccount("Roshid", "Current", 35000.50);
        
        ArrayList<BankAccount> myList = new ArrayList<>();
        myList.add(obj1);
        myList.add(obj2);
        myList.add(obj3);

        Bank myBank = new Bank("ICICI", myList);
        System.out.println(myBank.toString());

        ServiceProviderImpl myServiceObj = new ServiceProviderImpl(myBank);
        
        try{
        	LOGGER.log(Level.INFO, "Checking balance...");
        	System.out.println("Balance for account 1112: "+myServiceObj.checkBalance(1112));
        } catch(AccountNumberInvalidException e) {
        	LOGGER.log(Level.WARNING, "Invalid Account Number");
        	System.out.println(e.getMessage());
        }
        
        try {
        	LOGGER.log(Level.INFO, "Depositing amount...");
        	System.out.println("Status of deposit: "+myServiceObj.deposit(1112, -3000.00));
        } catch(NegativeAmountException e) {
        	LOGGER.log(Level.WARNING, "Amount cannot be negative");
        	System.out.println(e.getMessage());
        }
        
        try {
        	LOGGER.log(Level.INFO, "Withdrawing amount...");
        	System.out.println("Status of withdraw: "+myServiceObj.withdraw(1112, 5000.00));
        } catch(InsufficientFundsException e) {
        	LOGGER.log(Level.WARNING, "Amount not sufficient");
        	System.out.println(e.getMessage());
        }
        
    }
}
