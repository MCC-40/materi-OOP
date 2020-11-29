package javaatmapp;

public interface IBankAccount {
    public String getAccountId();
    public void setAccountId(String id);
    
    public String getAccountName();
    public void setAccountName(String name);
    
    public long getBalance();
    public void setBalance(long balance);
    public void addBalance(long amount);
    
    
    public boolean transferMoney(String accountId, int amount);
    public boolean withdraw(int amount);
    public void deposit(int amount);

}
