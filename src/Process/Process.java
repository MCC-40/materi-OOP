/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import View.View;
import Barang.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Yoshua
 */
public class Process {

    Scanner sc = new Scanner(System.in);

    public void processHome(Item item) {
        boolean appRunning = true;
        try {
            while (appRunning) {
                View.showHomeView();
                int choice = sc.nextInt(6);
                switch (choice) {
                    case 1:
                        processTransaction(item);
                        break;
                    case 2:
                        processEditItem(item);
                        break;
                    case 3:
                        appRunning = false;
                        break;
                    default:
                        View.optionNotFound();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void processTransaction(Item item) {
        boolean stillBuying = true;
        int choice;
        Map<String, Integer> basket = new HashMap<>();

        while (stillBuying) {
            View.showBuyView();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (basket.containsKey("Chitato")) {
                        basket.put("Chitato", basket.get("Chitato") + item.getChitato().buy());
                        break;
                    }
                    basket.put("Chitato", item.getChitato().buy());
                    break;
                case 2:
                    if (basket.containsKey("Ajinomoto")) {
                        basket.put("Ajinomoto", basket.get("Ajinomoto") + item.getAjinomoto().buy());
                        break;
                    }
                    basket.put("Ajinomoto", item.getAjinomoto().buy());
                    break;
                case 3:
                    if (basket.containsKey("Bayclin")) {
                        basket.put("Bayclin", basket.get("Bayclin") + item.getBayclin().buy());
                        break;
                    }
                    basket.put("Bayclin", item.getBayclin().buy());
                    break;
                case 4:
                    if (basket.isEmpty()) {
                        View.emptyBasket();
                        break;
                    }
                    stillBuying = processChange(View.showTransaction(basket), sc.nextInt());
                    System.out.println("\n");
                    break;
                case 5:
                    stillBuying = false;
                    break;
                default:
                    View.optionNotFound();
            }

        }
    }

    public boolean processChange(int totalPrice, int money) {
        if (money >= totalPrice) {
            System.out.println("Kembailan: " + (money - totalPrice));
            return false;
        } else {
            System.out.println("Uang tidak cukup");
            return true;
        }
    }

    public void processEditItem(Item item) {
        int choice;
        View.showEditView();
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                View.showPrice("Chitato", item.getChitato().getPrice());
                item.getChitato().setPrice(sc.nextInt());
                System.out.println("\nHarga Chitato Baru: " + item.getChitato().getPrice() + "\n");
                break;
            case 2:
                View.showPrice("Ajinomoto", item.getAjinomoto().getPrice());
                item.getChitato().setPrice(sc.nextInt());
                System.out.println("\nHarga Ajinomoto Baru: " + item.getAjinomoto().getPrice() + "\n");
                break;
            case 3:
                View.showPrice("Bayclin", item.getBayclin().getPrice());
                item.getChitato().setPrice(sc.nextInt());
                System.out.println("\nHarga Bayclin Baru: " + item.getBayclin().getPrice() + "\n");
                break;
            default:
                View.optionNotFound();
        }
    }
}
