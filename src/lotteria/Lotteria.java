/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;


/**
 *
 * @author Alessandro Castellani
 */


public class Lotteria {


    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // Scelta del numero dei numeri da estrarre
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // classe di wrapping che trasforma stream di byte in caratteri
        System.out.println("Inserisci il numero da indovinare");
        int n =0;
        try {
        n = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(SEVERE, null, ex);
            System.err.println("Si è verificato un errore");
        }
        
        Estrazione e = new Estrazione(n);
        // Istanza ed avvio del thread Estrazione
        e.start();


        // Istanza di alcuni thread Giocatore;
        Giocatore g1 = new Giocatore(1, "Francesco",e);
        Giocatore g2 = new Giocatore(2, "Pippo", e);
        Giocatore g3 = new Giocatore(3, "Giorgio",e);
       
        // Avvio dei thread Giocatori IN MANIERA INDIPENDENTE AVVIANO TRE THREAD IN CONTEMPORANEA
        g1.start();
        g2.start();
        g3.start();
       
        // servono a far sì che un thread aspetti il completamento di un altro thread
        try {
            g1.join();                  // Questi metodi possono lanciare delle eccezioni controllate che devono essere gestite dal programmatore col try catch
            g2.join();
            g3.join();
        } catch (InterruptedException ex) {                                            
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore join");
        }
        // Comunicazione fine gioco
        System.out.println("FINE LOTTERIA");
    }
}
