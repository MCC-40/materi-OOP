/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barang;

import java.util.Scanner;

/**
 *
 * @author Yoshua
 */
public class Bayclin implements Product {

    Scanner sc = new Scanner(System.in);
    private int price = 12000;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public int buy() {
        System.out.print("Masukan Jumlah yang akan dibeli: ");
        int total = sc.nextInt();
        return total * price;
    }
;
}
