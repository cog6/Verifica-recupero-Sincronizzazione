/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaroulette;

import java.util.concurrent.Semaphore;

/**
 *
 * @author cogliati_francesco
 */
public class DatiCondivisi {

    private int num1_18Inseriti;
    private int num1_18Letti;
    private int num19_36Inseriti;
    private int num19_36Letti;

    private int buffer;
    private int numDaGenerare;

    private Semaphore semGenera;
    private Semaphore semConta1_18;
    private Semaphore semConta19_36;
    private Semaphore semVisualizza;

    public DatiCondivisi(int numDaGenerare) {
        this.numDaGenerare = numDaGenerare;
        num1_18Inseriti = 0;
        num1_18Letti = 0;
        num19_36Inseriti = 0;
        num19_36Letti = 0;

        buffer = 0;
        this.numDaGenerare = numDaGenerare;

        semGenera = new Semaphore(1);
        semConta1_18 = new Semaphore(0);
        semConta19_36 = new Semaphore(0);
        semVisualizza = new Semaphore(0);
    }

    public int getNumDaGenerare() {
        return numDaGenerare;
    }

    public Semaphore getSemGenera() {
        return semGenera;
    }

    public Semaphore getSemConta1_18() {
        return semConta1_18;
    }

    public Semaphore getSemConta19_36() {
        return semConta19_36;
    }

    public Semaphore getSemVisualizza() {
        return semVisualizza;
    }

    public int getNum1_18Inseriti() {
        return num1_18Inseriti;
    }

    public int getNum1_18Letti() {
        return num1_18Letti;
    }

    public int getNum19_36Inseriti() {
        return num19_36Inseriti;
    }

    public int getNum19_36Letti() {
        return num19_36Letti;
    }
    
    

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }
        
    
    
    /*i prossimi metodi incrementano direttamente le varie variabili così da facilitare il programma*/
    public void incNum1_18Inseriti(){
        num1_18Inseriti++;
    }
    
    public void incNum1_18Letti(){
        num1_18Letti++;
    }
    
    public void incNum19_36Inseriti(){
        num19_36Inseriti++;
    }
    
    public void incNum19_36Letti(){
        num19_36Letti++;
    }
    

}
