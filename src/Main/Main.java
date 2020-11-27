/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Process.Process;
import Barang.Item;
import java.util.Scanner;

/**
 *
 * @author Yoshua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Item item = new Item();
        Process process = new Process();
        process.processHome(item);
    }

}
