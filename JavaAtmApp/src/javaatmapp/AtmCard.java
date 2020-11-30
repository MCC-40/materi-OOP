package javaatmapp;

/**
 * ATM Card Class
 * @author Mochamad Yusuf
 */
public class AtmCard extends BankAccount implements IAtmCard {

    private String cardId;
    private int cardPin;
    
    public AtmCard() {};

    public AtmCard(String accountId, String accountName, long balance) {
        super(accountId, accountName, balance);
    }

    @Override
    public IAtmCard setup(String accountId, String accountName, long balance, String cardId, int cardPin) {
        setAccountId(accountId);
        setAccountName(accountName);
        setBalance(balance);
        this.cardId = cardId;
        this.cardPin = cardPin;
        return this;
    }

    @Override
    public IAtmCard setup(IBankAccount account, String cardId, int cardPin) {
        setAccountId(account.getAccountId());
        setAccountName(account.getAccountName());
        setBalance(account.getBalance());
        this.cardId = cardId;
        this.cardPin = cardPin;
        return this;
    }

    @Override
    public boolean matchAtmPin(int pin) {
        return cardPin == pin;
    }

    @Override
    public String getCardId() {
        return this.cardId;
    }

    @Override
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

}
