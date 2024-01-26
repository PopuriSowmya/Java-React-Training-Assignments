package com.hexaware.entity;

import java.util.List;

public class Bank {
	    private String name;
	    private List<BankAccount> accountList;

	    public Bank(String name, List<BankAccount> accountList) {
	        this.name = name;
	        this.accountList = accountList;
	    }

	    
	    public String getName() {
	        return name;
	    }

	    
	    public void setName(String name) {
	        this.name = name;
	    }

	    
	    public List<BankAccount> getAccountList() {
	        return accountList;
	    }

	    public void setAccountList(List<BankAccount> accountList) {
	        this.accountList = accountList;
	    }

	    
	    @Override
	    public String toString() {
	        String res = "Bank{" + "name= '" + name + '\'' +
	                ", accountList=" ;
	        for(BankAccount ba: accountList) {
	        	res += " " + ba.toString();
	        }
	        return res;
	    }
}
