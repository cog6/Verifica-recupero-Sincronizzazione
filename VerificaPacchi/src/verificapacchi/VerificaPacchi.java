/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificapacchi;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author cogliati_francesco
 */
public class VerificaPacchi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String start = "";

        System.out.println("INIZIO PROGRAMMA");
        
        do {
            System.out.println("Premimi 'S' per far partire i due confezionatori");
            start = sc.nextLine();
        } while (!start.equals("S"));
        
        DatiCondivisi d = new DatiCondivisi();
        
        
        ThConfezionamento thConfPacco1= new ThConfezionamento(1,d);
        ThTrasporto thTrasportoPacco1 = new ThTrasporto(1,d);
        
        ThConfezionamento thConfPacco2 = new ThConfezionamento(2,d);
        ThTrasporto thTrasportoPacco2 = new ThTrasporto(2,d);
        
        /*partono i thread*/
        thConfPacco1.start();
        thTrasportoPacco1.start();
        thConfPacco2.start();
        thTrasportoPacco2.start();
        
        /*aspetto che ogni thread finisca*/
        thConfPacco1.join();
        thTrasportoPacco1.join();
        thConfPacco2.join();
        thTrasportoPacco2.join();
        
        
                
        System.out.println("FINE PROGRAMMA");
    }

}
