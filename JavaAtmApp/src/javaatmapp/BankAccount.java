/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaatmapp;

/**
 *
 * @author Mochamad Yusuf
 */
public class BankAccount implements IBankAccount {
    public final int minimalBalance = 50000;
    private String accountId;
    private String accountName;
    private long balance;

    public BankAccount(String accountId, String accountName, long balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }
    @Override
    public String getAccountId() {
        return this.accountId;
    }

    @Override
    public void setAccountId(String id) {
        this.accountId = id;
    }

    @Override
    public String getAccountName() {
        return this.accountName;
    }

    @Override
    public void setAccountName(String name) {
        this.accountName = name;
    }

    @Override
    public long getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(long balance) {
        this.balance = balance;
    }
    
    @Override
    public void addBalance(long amount) {
        this.balance += amount;
    }


    @Override
    public boolean transferMoney(String accountId, int amount) {
        IBankAccount targetAccount = JavaAtmApp.findAccountList(accountId);
        if (amount + minimalBalance > balance)
        {
            AtmInterface.showMessage("Transaction Failed: Insufficient Balance");
            AtmInterface.showMessage("Minimal balance is Rp " + AtmInterface.CURRENCY_FORMATTER.format(minimalBalance) + ",-");
            return false;
        }
        
        if (targetAccount == null){
            AtmInterface.showMessage("Transaction Failed: Account not exist");
            return false;
        }
        
        if (targetAccount == this){
            AtmInterface.showMessage("Transaction Failed: Cannot transfer to yourself");
            return false;
        }
        
        if (targetAccount.getAccountId().equals(accountId))
        {
            balance -= amount;
            targetAccount.addBalance(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount + minimalBalance < balance){
            balance -= amount;
            return true;
        }
        else{
            AtmInterface.showMessage("Insufficient balance");
            return false;
        }
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

}
