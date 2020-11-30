package javaatmapp;

/**
 * Bank Account Interface
 * @author Mochamad Yusuf
 */
public interface IBankAccount {
    public String getAccountId();
    public void setAccountId(String id);
    
    public String getAccountName();
    public void setAccountName(String name);
    
    public long getBalance();
    public void setBalance(long balance);
    
    /**
    * The addBalance method used for adding balance of account
    * @param amount is amount of money to be added to balance.
    */
    public void addBalance(long amount);
    
    /**
    * The transferMoney method used for transferring money from one account to another account
    * @param accountId is target account.
    * @param amount is amount of money to transfer
    * @param console is console to print transaction output
    * @return returns true if transfer is succeed
    */
    public boolean transferMoney(String accountId, int amount, ITransactionConsole console);
    /**
    * The withdraw method used for withdraw money from bank account
    * @param amount is amount of money to draw
    * @param console is console to print transaction output
    * @return returns true if transfer is succeed
    */
    public boolean withdraw(int amount, ITransactionConsole console);
     /**
    * The deposit method used for deposit money from ATM machine to bank account
    * @param amount is amount of money to deposit
    * @param console is console to print transaction output
    */
    public void deposit(int amount, ITransactionConsole console);

}
