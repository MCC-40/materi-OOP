
package javaatmapp;

import java.util.ArrayList;

public class JavaAtmApp {
    static ArrayList<IBankAccount> accountList = new ArrayList<>();
    
    static IBankAccount findAccountList(String accountId){
        for (IBankAccount acc : accountList) {
            if (acc.getAccountId().equals(accountId))
            {
                return acc;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        accountList.add(new AtmCard("user1", "Suparno", 545123, "card1", 123456));
        accountList.add(new AtmCard("user2", "Siti", 5231090,  "card1", 123456));
        accountList.add(new AtmCard("user3", "Tarji", 40231900,  "card2", 123456));
        accountList.add(new AtmCard("user4", "Rendi", 185000,  "card2", 123456));
        
        AtmInterface atmInterface = new AtmInterface();
        atmInterface.insertCard();
    }
    
}
