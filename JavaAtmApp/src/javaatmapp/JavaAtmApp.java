
package javaatmapp;

import java.util.ArrayList;
/**
 * Main class
 * @author Mochamad Yusuf
 */
public class JavaAtmApp {
    static ArrayList<IBankAccount> accountList = new ArrayList<>();
    
    static IBankAccount findBankAccount(String accountId){
        for (IBankAccount acc : accountList) {
            if (acc.getAccountId().equals(accountId))
            {
                return acc;
            }
        }
        return null;
    }
    
    static AtmCard findCard(String cardId){
        for (IBankAccount acc : accountList) {
            AtmCard card = (AtmCard) acc;
            if (card.getCardId().equals(cardId))
            {
                return card;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        accountList.add(new AtmCard().setup("user1", "Suparno", 545123,     "card1", 123456));
        accountList.add(new AtmCard().setup("user2", "Siti",    5231090,    "card2", 123456));
        accountList.add(new AtmCard().setup("user3", "Tarji",   40231900,   "card3", 123456));
        accountList.add(new AtmCard().setup("user4", "Rendi",   185000,     "card4", 123456));
        
        IAtmUI atmInterface = new AtmUI();
        atmInterface.insertCard();
    }    
}
