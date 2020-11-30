
package javaatmapp;

/**
 * ATM User Interface Interface
 * @author Mochamad Yusuf
 */
public interface IAtmUI {
    
    /**
    * The insertCard method used for card login
    */
    public void insertCard();
    /**
    * The reinsertCard method allows user to re-login the card
    */
    public void reinsertCard();
    /**
    * The ejectCard method ejects the user card
    */
    public void ejectCard();
    
    /**
    * Show ATM main menu 
    */
    public void showMainMenu();
    /**
    * Show account balance info
    */
    public void showBalanceMenu();
    /**
    * Show withdraw menu
    */
    public void showWithdrawMenu();
    /**
    * Show transfer menu
    */
    public void showTransferMenu();
    /**
    * Show deposit menu
    */
    public void showDepositMenu();    
}
