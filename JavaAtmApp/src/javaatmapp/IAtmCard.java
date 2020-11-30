package javaatmapp;


/**
 * ATM Card Interface
 * @author Mochamad Yusuf
 */
public interface IAtmCard extends IBankAccount {
    /**
    * Setup ATM card and bank account data
    * @param accountId User account id
    * @param accountName User account name
    * @param balance Initial balance
    * @param cardId card id
    * @param cardPin card pin
    * @return this ATM object
    */
     public IAtmCard setup(String accountId, String accountName, long balance, String cardId, int cardPin);
    /**
    * Setup ATM card and bank account data
    * @param account existing bank account
    * @param cardId card id
    * @param cardPin card pin
    * @return this ATM object
    */
     public IAtmCard setup(IBankAccount account, String cardId, int cardPin);
    /**
    * Checking ATM pin
    * @param pin inputed account
    * @return returns true if the pin is correct
    */
     public boolean matchAtmPin(int pin);
     
     public String getCardId();
     public void setCardId(String cardId);
}
