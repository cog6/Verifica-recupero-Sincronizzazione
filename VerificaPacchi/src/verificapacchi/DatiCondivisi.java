/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificapacchi;

import java.util.concurrent.Semaphore;

/**
 *
 * @author cogliati_francesco
 */
public class DatiCondivisi {

    private Semaphore semTrasporto1, semTrasporto2;

    public DatiCondivisi() {
        semTrasporto1 = new Semaphore(0);
        semTrasporto2 = new Semaphore(0);
        
    }

    public Semaphore getSemTrasporto1() {
        return semTrasporto1;
    }

    public Semaphore getSemTrasporto2() {
        return semTrasporto2;
    }

    

}
