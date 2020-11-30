package javaatmapp;

/**
 * ITransactionConsole provide feedback and input for transactions.
 * Allowing ATM Interface and another form of console.
 * @author Mochamad Yusuf
 */
public interface ITransactionConsole {
    
    /**
    * Open new window (Strip lines)
    */
    public void newWindow();
    /**
    * Printing message to console
    * @param message message to print.
    */
    public void showMessage(String message);
    /**
    * Fetch number input from console
    * @param message label for input/message before input
    * @return number input
    */
    public int requestNumberInput(String message);
    /**
    * Fetch string input from console
    * @param message label for input/message before input
    * @return string input
    */
    public String requestStringInput(String message);
    
}
