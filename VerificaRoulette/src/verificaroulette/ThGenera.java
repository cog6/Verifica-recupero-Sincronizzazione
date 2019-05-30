/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaroulette;

import java.util.Random;

/**
 *
 * @author cogliati_francesco
 */
public class ThGenera extends Thread{
    private DatiCondivisi d;
    private int nDaGenerare;

    public ThGenera(DatiCondivisi d) {
        this.d = d;        
        this.nDaGenerare = d.getNumDaGenerare();
    }
       
    public void run(){
        Random rn = new Random();
        int nGenerato = 0;
        for(int i = 0; i < nDaGenerare; i++){            
                d.getSemGenera().acquireUninterruptibly();
            
            
            nGenerato = rn.nextInt(37);
            d.setBuffer(nGenerato);
            
            d.getSemConta1_18().release();
            d.getSemConta19_36().release();
            
            if(nGenerato >= 1 && nGenerato <= 18)
                d.incNum1_18Inseriti();
            else if(nGenerato >= 19 && nGenerato <= 36)
                d.incNum19_36Inseriti();
            
            
            d.getSemVisualizza().release();
        }
    }
}
