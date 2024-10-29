/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 *
 * @author Alessandro Castellani
 */


// dichiarazione del thread giocatore
public class Giocatore extends Thread{
    //attributi
   
    private int idGiocatore;
    private String nomeGiocatore;


    // usa estrazione, essendo una relazione di aggregazione
    private Estrazione estrazione;
    private Random random = new Random();
   
    /**
    *
    * Metodo costruttore
    * @param idGiocatore codice del giocatore
    * @param estrazione riferimento dell'oggetto Estrazione
    * @param nomeGiocatore nome del giocatore
    */
   


    public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione){
        this.idGiocatore=idGiocatore;
        this.nomeGiocatore=nomeGiocatore;
        this.estrazione=estrazione;
    }


    /**
    *
    * Metodo per eseguire il thread
    */
   
    // metodo run della classe Giocatore
    @Override
    public void run() {
        // presentazione
        System.out.println("Il nome del giocatore è:" + nomeGiocatore + ", l'id del giocatore è: " + idGiocatore + "INIZIO");
       
       // scelta del numero da giocare
       Scanner scanner = new Scanner(System.in);
       int numeroScelto = scanner.nextInt();
       
       // conto alla rovescia
       for (int i=3; i>0; i--){
           System.out.println(i);
            try {
                // mette in waiting il thread per il tempo in millisecondi indicati
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
       // verifica del risultato attraverso il metodo verifica della classe estrazione
       estrazione.verifica(numeroScelto, idGiocatore);
       
       // stampa fine verifica
       System.out.println("Il giocatore: " + idGiocatore + ", ha finito di giocare.");
    }
}
