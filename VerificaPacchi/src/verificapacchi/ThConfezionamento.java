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
public class ThConfezionamento extends Thread {

    private int nPacco;         //variabile usata per capire che pacco è
    private DatiCondivisi d;

    public ThConfezionamento(int nPacco, DatiCondivisi d) {
        this.nPacco = nPacco;
        this.d = d;
    }

    public void run() {

        int delay = 1000;
        Random rn = new Random();
        System.out.println("Inizio confezione pacco " + nPacco);

        delay += rn.nextInt(1000);
//        if(nPacco == 1)
//            delay = 10000;
        

        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThConfezionamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Fine confezione pacco " + nPacco);
        
        
        /*in base al pacco faccio partire il trasporto corrispondente*/
        if(nPacco == 1){
            d.getSemTrasporto1().release();          
        }else{
            d.getSemTrasporto2().release();
        }
    }
}
