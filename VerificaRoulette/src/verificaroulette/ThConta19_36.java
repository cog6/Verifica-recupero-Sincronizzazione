/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaroulette;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cogliati_francesco
 */
public class ThConta19_36 extends Thread{
    private int nDaGenerare;
    private DatiCondivisi d;

    public ThConta19_36(DatiCondivisi d) {
        this.d = d;
        nDaGenerare = d.getNumDaGenerare();
    }

    public void run() {
        int n = 0;

        for (int i = 0; i < nDaGenerare; i++) {

            try {

                d.getSemConta19_36().acquire();                      //aspetta che il ThGenera generi un numero

                n = d.getBuffer();
                if (n >= 19 && n <= 36)                              //controlla se è uno dei numeri di sua competenza
                {
                    d.incNum19_36Letti();
                }

                d.getSemVisualizza().release();                     //avvisa il thread visualizza che è avvenuto un cambiamento
                //d.getSemGenera().release();

            } catch (InterruptedException ex) {
                Logger.getLogger(ThConta1_18.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
