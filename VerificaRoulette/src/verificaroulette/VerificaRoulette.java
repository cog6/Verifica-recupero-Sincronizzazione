/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaroulette;

import java.util.Scanner;

/**
 *
 * @author cogliati_francesco
 */
public class VerificaRoulette {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numCaratteri = 0;

        Scanner sc = new Scanner(System.in);
        
        do{
        System.out.println("Inserire il numero di caratteri da generare:");
        numCaratteri = sc.nextInt();
        }while(numCaratteri < 0 || numCaratteri > 100);

        DatiCondivisi d = new DatiCondivisi(numCaratteri);

        ThGenera thGenera = new ThGenera(d);
        ThConta19_36 thConta19_36 = new ThConta19_36(d);
        ThConta1_18 thConta1_18 = new ThConta1_18(d);
        ThVisualizza thVisualizza = new ThVisualizza(d);

        thGenera.start();
        thConta19_36.start();
        thConta1_18.start();
        thVisualizza.start();
    }
    
}
