/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiremoteac;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class Aplikasi{
        static void upTemperature(OpsiButton opsiButton) {
            //int Temperature = 24;
            opsiButton.setTemperature(opsiButton.getTemperature()+1);
            System.out.println("Temperature : "+opsiButton.getTemperature());
        }
        
//       static int UpTemperature(int Temperatur) {
//            System.out.println("Temperature : "+Temperatur);
//            return Temperatur++;
//        } 

        static void downTemperature(OpsiButton opsiButton) {
            //int Temperature = 24;
            opsiButton.setTemperature(opsiButton.getTemperature()-1);
            System.out.println("Temperature : "+opsiButton.getTemperature());
        }

        static void swingAc(OpsiButton opsiButton) {
            if(opsiButton.isSwing()){
                opsiButton.setSwing(false);
            }
            else {
                opsiButton.setSwing(true);
            }
            System.out.println("AC in : " + (opsiButton.isSwing() ? "Mode Swing" : "Mode Default").toString());
        }

        static void sleepAc() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input timer : ");
            int time = scanner.nextInt();
            System.out.println("AC has been set to Sleep in "+time+" second");
        }

        static void timeOn() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input timer : ");
            int time = scanner.nextInt();
            System.out.println("AC has been set to Off in "+time+" second");
        }

        static void timeOff() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input timer : ");
            int time = scanner.nextInt();
            System.out.println("AC has been set to On in "+time+" second");
        }

        static void fan(OpsiButton opsiButton){
            if(opsiButton.isFan()){
                opsiButton.setFan(false);
            }
            else {
                opsiButton.setFan(true);
            }
            System.out.println("AC in : " + (opsiButton.isFan() ? "Mode Fan" : "Mode Default").toString());
        }
        
        static void dry(OpsiButton opsiButton) {
            if(opsiButton.isDry()){
                opsiButton.setDry(false);
            }
            else {
                opsiButton.setDry(true);
            }
            System.out.println("AC in : " + (opsiButton.isDry() ? "Mode Dry" : "Mode Default").toString());
        }

        static void off() {
            System.exit(0);
        }
}
