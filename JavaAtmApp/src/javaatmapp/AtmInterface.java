package javaatmapp;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AtmInterface {

    AtmCard activeCard;
    final int moneyUnit = 50000;
    public static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getInstance(new Locale("id", "ID"));

    public void insertCard() {
        newWindow();

        String accountId = requestStringInput("Card id: ");
        try {
            activeCard = (AtmCard) JavaAtmApp.findAccountList(accountId);
        } catch (ClassCastException  cce) {
            activeCard = null;
            showMessage("The bank account may not have an ATM card");
        }
        if (activeCard == null) {
            showMessage("Invalid card id");
            insertCard();
            return;
        }
        int pin = requestNumberInput("enter pin: ");
        int faultCount = 0;
        while (!activeCard.matchAtmPin(pin) && faultCount < 2) {
            faultCount++;
            showMessage("Pin Incorrect");
            pin = requestNumberInput("enter pin: ");
        }
        if (faultCount == 2) {
            showMessage("Your ATM card is blocked");
        } else {
            showMessage("Pin Correct");
            showAtmMenu();
        }
    }

    public void reinsertCard() {
        newWindow();
        showMessage("New transaction?");
        showMessage("1. Yes");
        showMessage("2. No/Quit program");
        int input = requestNumberInput("Input: ");
        switch (input) {
            case 1:
                insertCard();
                break;
            case 2:
                newWindow();
                showMessage("card ejected");
                break;
            default:
                newWindow();
                showMessage("Invalid input");
                reinsertCard();
                break;
        }
    }

    public void showAtmMenu() {
        newWindow();
        showMessage("1. Balance info");
        showMessage("2. Withdraw");
        showMessage("3. Transfer");
        showMessage("4. Deposit");
        showMessage("10. Cancel");
        int input = requestNumberInput("Input: ");
        switch (input) {
            case 1:
                showBalanceMenu();
                break;
            case 2:
                showWithdrawMenu();
                break;
            case 3:
                showTransferMenu();
                break;
            case 4:
                showDepositMenu();
                break;
            case 10:
                ejectCard();
                break;
            default:
                showMessage("Invalid option");
                showAtmMenu();
                break;
        }
    }

    public void ejectCard() {
        showMessage("Card ejected");
        reinsertCard();
    }

    public void showBalanceMenu() {
        newWindow();
        showMessage("Your balance: Rp " + CURRENCY_FORMATTER.format(activeCard.getBalance()) + ",-");
        reinsertCard();
    }

    public void showWithdrawMenu() {
        newWindow();
        showMessage("Withdraw amount must be in multiples of Rp"
                + CURRENCY_FORMATTER.format(moneyUnit) + ",-");
        int amount = requestNumberInput("Withdraw: ");
        newWindow();
        if (amount % moneyUnit != 0) {
            showMessage("Amount must be in multiples of Rp"
                    + CURRENCY_FORMATTER.format(moneyUnit) + ",-");
            showMessage("Withdraw failed");
            reinsertCard();
        }
        if (activeCard.withdraw(amount)) {
            showMessage("Withdraw succeed");
            showMessage("Rp " + CURRENCY_FORMATTER.format(amount) + ",- withdrawed");
            showMessage("Your balance: Rp " + CURRENCY_FORMATTER.format(activeCard.getBalance()) + ",-");
        } else {
            showMessage("Withdraw failed");
        }
        reinsertCard();
    }

    public void showTransferMenu() {
        newWindow();
        String accountId = requestStringInput("Account ID: ");
        int amount = requestNumberInput("Money to Transfer: ");

        newWindow();
        IBankAccount targetAccount = JavaAtmApp.findAccountList(accountId);
        if (targetAccount == null) {
            showMessage("Cannot find account");
        } else {
            showMessage("Account ID\t:" + targetAccount.getAccountId());
            showMessage("Name\t\t:" + targetAccount.getAccountName());
            showMessage("Amount\t\t: Rp " + CURRENCY_FORMATTER.format(amount) + ",-");
            showMessage("\n\nProceed transfer?");
            showMessage("1. Yes");
            showMessage("2. No");

            int input = requestNumberInput("Input: ");
            switch (input) {
                case 1:
                    newWindow();
                    if (activeCard.transferMoney(accountId, amount)) {
                        showMessage("Transaction Succeed");
                        newWindow();
                        
                        showMessage("\t[RECEIPT]\n");
                        showMessage("From:");
                        showMessage("Account ID\t:" + activeCard.getAccountId());
                        showMessage("Name\t\t:" + activeCard.getAccountName());
                        showMessage("Amount\t\t: Rp " + CURRENCY_FORMATTER.format(amount) + ",-");
                        
                        showMessage("\nTo:");
                        showMessage("Account ID\t:" + targetAccount.getAccountId());
                        showMessage("Name\t\t:" + targetAccount.getAccountName());
                    } else {
                        showMessage("Transaction Failed");
                    }
                    break;
                case 2:
                    ejectCard();
                    return;
                default:
                    showMessage("Invalid input");
                    break;
            }
        }
        reinsertCard();
    }

    public void showDepositMenu() {
        int amount = requestNumberInput("Money in machine: ");
        if (amount % 1000 != 0) {
            showMessage("Deposit failed");
            showMessage("Amount must be in multiples of Rp 1.000,-");
        } else {
            activeCard.deposit(amount);
            showMessage("Deposit succeed");
            showMessage("Rp " + CURRENCY_FORMATTER.format(amount) + ",- deposited");
            showMessage("Your balance: Rp " + CURRENCY_FORMATTER.format(activeCard.getBalance()) + ",-");
        }
        reinsertCard();
    }

    public static void showErrorMessage(String message) {
        System.out.println(message);
    }

    public static void newWindow() {
        System.out.println("\n-------------------\n");
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static int requestNumberInput(String message) {
        System.out.print(message);
        Scanner myObj = new Scanner(System.in);
        int input = myObj.nextInt();
        return input;
    }

    public static String requestStringInput(String message) {
        System.out.print(message);
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        return input;
    }
}
