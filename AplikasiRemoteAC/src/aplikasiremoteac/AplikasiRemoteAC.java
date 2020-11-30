package aplikasiremoteac;

import java.io.IOException;
import java.util.Scanner;

public class AplikasiRemoteAC {
    
    public static void main(String[] args) 
    throws IOException{
        Scanner scanner = new Scanner(System.in);
        OpsiButton button = new OpsiButton();
        button.RunRemote();
    }
    
}
