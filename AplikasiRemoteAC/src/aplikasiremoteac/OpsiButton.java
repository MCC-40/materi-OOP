/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiremoteac;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class OpsiButton {
    private int onOff;
    private int pilihan = 0;
    private int temperature = 24;
    private boolean swing = false;
    private boolean fan = false;
    private boolean dry = false;
    
    public void setOnOff(int onOff){
        this.onOff = onOff;
    }
    
    public int getOnOff(){
        return onOff;
    }
    
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    
    public int getTemperature(){
        return temperature;
    }
    
    public boolean isSwing() {
        return swing;
    }

    public void setSwing(boolean swing) {
        this.swing = swing;
    }

    public boolean isFan() {
        return fan;
    }

    public void setFan(boolean fan) {
        this.fan = fan;
    }

    public boolean isDry() {
        return dry;
    }

    public void setDry(boolean dry) {
        this.dry = dry;
    }
    
    void RunRemote(){
        boolean On = true;
        Scanner scanner = new Scanner(System.in);
        if (On == true){
            do{
                /*System.out.println("\nWELCOME TO APPLICATION REMOTE AC\n");
                System.out.println("=====================================");
                System.out.println("\nMENU\n");
                */
                System.out.println("\nAPPLICATION REMOTE AC");
                System.out.println("\n1. Up Temperature");
                System.out.println("2. Down Temperature");
                System.out.println("3. Swing");
                System.out.println("4. Sleep");
                System.out.println("5. Time On");
                System.out.println("6. Time Off");
                System.out.println("7. Fan");
                System.out.println("8. Dry");
                System.out.println("9. Off");
                System.out.print("\nYour Option : ");
                pilihan = scanner.nextInt();
                System.out.println();
                
                // jika fungsi tidak meminta kembalian
                if (pilihan == 1){
                    Aplikasi.upTemperature(this);
                }
                
                // jika fungsi memberikan kembalian
//                if (Pilihan == 1) {
//                    Temperature = aplikasi.UpTemperature(Temperature);
//                }
                else if (pilihan == 2){
                    Aplikasi.downTemperature(this);
                }
                else if (pilihan == 3){
                    Aplikasi.swingAc(this);
                }
                else if (pilihan == 4){
                    Aplikasi.sleepAc();
                }
                else if (pilihan == 5){
                    Aplikasi.timeOn();
                }
                else if (pilihan == 6){
                    Aplikasi.timeOff();
                }
                else if (pilihan == 7){
                    Aplikasi.fan(this);
                }
                else if (pilihan == 8){
                    Aplikasi.dry(this);
                }
                else if (pilihan == 9){
                    Aplikasi.off();
                }
            }
            while (pilihan != 9);
        }
    } 
}


