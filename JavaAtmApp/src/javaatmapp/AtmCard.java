package javaatmapp;

public class AtmCard extends BankAccount{
    public String cardId;
    public int cardPin;

    public AtmCard(String accountId, String accountName, long balance, String cardId, int cardPin) {
        super(accountId, accountName, balance);
        this.cardId = cardId;
        this.cardPin = cardPin;
    }    
    
    public AtmCard(IBankAccount account, String cardId, int cardPin){
        super(account.getAccountId(), account.getAccountName(), account.getBalance());
        this.cardId = cardId;
        this.cardPin = cardPin;
    }
    
    public boolean matchAtmPin(int pin) {
        return cardPin == pin;
    }

}
