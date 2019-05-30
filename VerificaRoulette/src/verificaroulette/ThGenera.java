/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaroulette;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int numZeri = 0;
        for(int i = 0; i < nDaGenerare; i++){            
            try {
                d.getSemGenera().acquire();
                
                
                nGenerato = rn.nextInt(37);
                d.setBuffer(nGenerato);
                
                
                
                if(nGenerato >= 1 && nGenerato <= 18)
                    d.incNum1_18Inseriti();
                else if(nGenerato >= 19 && nGenerato <= 36)
                    d.incNum19_36Inseriti();
                
                d.getSemConta1_18().release();
                d.getSemConta19_36().release();
                d.getSemVisualizza().release();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThGenera.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
        
        
    }
}
