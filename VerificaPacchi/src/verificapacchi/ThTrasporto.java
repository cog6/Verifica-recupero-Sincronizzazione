/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificapacchi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cogliati_francesco
 */
public class ThTrasporto extends Thread{
    private int nPacco;             //variabile usata per capire che pacco è
    private DatiCondivisi d;

    public ThTrasporto(int nPacco, DatiCondivisi d) {
        this.nPacco = nPacco;
        this.d = d;
    }
    
    @Override
     public void run() {
         
         
        if (nPacco == 1) {
            try {
                d.getSemTrasporto1().acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThTrasporto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                d.getSemTrasporto2().acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThTrasporto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("INIZIO TRASPORTO pacco " + nPacco);

        /*creo il random per generare un numero da 0 a 1000 per poi sommarlo a 1000
            per far in modo da avere un numero tra 1 e 2*/
        
        Random rn = new Random();
        int tempo = rn.nextInt(1000) + 1000;
        try {
            Thread.sleep((long)tempo);          //fermo il thread
        } catch (InterruptedException ex) {
            Logger.getLogger(ThTrasporto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("FINE TRASPORTO pacco " + nPacco);
        
        
    }
}
