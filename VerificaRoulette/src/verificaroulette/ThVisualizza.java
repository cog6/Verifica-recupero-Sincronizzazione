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
public class ThVisualizza extends Thread {

    private DatiCondivisi d;

    public ThVisualizza(DatiCondivisi d) {
        this.d = d;
    }

    public void run() {

        try {

            for (int i = 0; i < d.getNumDaGenerare(); i++) {
                d.getSemVisualizza().acquire();

                String visualizzare = "numeri da 1 a 18 scritti: " + d.getNum1_18Inseriti() + "\n"
                        + "numeri da 19 a 36 scritti: " + d.getNum19_36Inseriti() + "\n"
                        + "numeri da 1 a 18 letti: " + d.getNum1_18Letti() + "\n"
                        + "numeri da 19 a 36 letti: " + d.getNum19_36Letti() + "\n";
                System.out.println(visualizzare);
                d.getSemGenera().release();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
