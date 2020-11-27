/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Map;

/**
 *
 * @author Yoshua
 */
public class View {

    public static void showHomeView() {
        System.out.println("Aplikasi Kasir");
        System.out.println("===================================");
        System.out.println("1. Beli Barang");
        System.out.println("2. Edit Barang");
        System.out.println("3. Keluar");
        System.out.print("Masukan pilihan anda: ");
    }

    public static void showBuyView() {
        System.out.println("\nList Barang");
        System.out.println("==================================");
        System.out.println("1. Chitato");
        System.out.println("2. Ajinomoto");
        System.out.println("3. Bayclin");
        System.out.println("4. Cetak Transaksi");
        System.out.println("5. Kembali ke halaman awal");
        System.out.print("Masukan Barang yang akan dibeli: ");
    }

    public static void showEditView() {
        System.out.println("\nList Barang");
        System.out.println("==================================");
        System.out.println("1. Chitato");
        System.out.println("2. Ajinomoto");
        System.out.println("3. Bayclin");
        System.out.println("4. Kembali ke halaman awal");
        System.out.print("Masukan Barang yang akan diubah: ");
    }

    public static void optionNotFound() {
        System.out.println("\n--------------Pilihan Tidak Ditemukan--------------\n");
    }
    
    public static void emptyBasket() {
        System.out.println("\n--------------Keranjang Kosong--------------\n");
    }
    
    public static void showPrice(String itemToShow, int price) {
        System.out.println("Harga " + itemToShow + ": " + price);
        System.out.print("Masukan harga baru: ");
    }

    public static void showTransaction(Map<String, Integer> basket) {
        int totalPrice = 0;
        System.out.println("\n");
        for (Map.Entry element : basket.entrySet()) {
            System.out.println(element.getKey() + ":\t" + element.getValue());
            totalPrice += (int) element.getValue();
        }
        System.out.println("--------------------------------");
        System.out.println("Total: \t\t" + totalPrice + "\n\n");
    }
}
