/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaatmapp;

/**
 * Bank Account Class
 * @author Mochamad Yusuf
 */
public class BankAccount implements IBankAccount {
    public final int minimalBalance = 50000;
    private String accountId;
    private String accountName;
    private long balance;
    
    public BankAccount() { };

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
    public boolean transferMoney(String accountId, int amount, ITransactionConsole console) {
        IBankAccount targetAccount = JavaAtmApp.findBankAccount(accountId);
        if (amount + minimalBalance > balance)
        {
            console.showMessage("Transaction Failed: Insufficient Balance");
            console.showMessage("Minimal balance is Rp " + AtmUI.CURRENCY_FORMATTER.format(minimalBalance) + ",-");
            return false;
        }
        
        if (targetAccount == null){
            console.showMessage("Transaction Failed: Account not exist");
            return false;
        }
        
        if (targetAccount == this){
            console.showMessage("Transaction Failed: Cannot transfer to yourself");
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
    public boolean withdraw(int amount, ITransactionConsole console) {
        if (amount + minimalBalance < balance){
            balance -= amount;
            return true;
        }
        else{
            console.showMessage("Insufficient balance");
            return false;
        }
    }

    @Override
    public void deposit(int amount, ITransactionConsole console) {
        balance += amount;
    }

}
