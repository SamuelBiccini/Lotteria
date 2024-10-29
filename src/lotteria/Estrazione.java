/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package lotteria;


import java.util.Random;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alessandro Castellani
 */


// dichiarazione del Thread Estrazione
public class Estrazione extends Thread {
    // dichiarazione matrice
    private int[][] numeri=new int[10][10];
    // dichiarazione array dei vincitori
    int[] vincitori=new int[3];
    //dichiarazione
    private List<Integer> numeroVincitori=new ArrayList<Integer>();
    private Random random=new Random();
   
    /**
     * Metodo costruttore
     * @param n
     */  
    
    
   
    // popolazione matrice
    public Estrazione(int n) {
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                numeri[i][j]=random.nextInt(100);
            }
        }
    }

    Estrazione(int n) {
        for(int i=n; i<n; i++){
            for(int j=n; j<n; j++){
                numeri[i][j]=random.nextInt(100);
            }
        }
    }


    /**
    *
    * Metodo per visualizzare la matrice dei numeri estratti
    */
   
    // stampa a schermo dei numeri contenuti nella matrice
    public void stampaMatrice() {
       for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.println(numeri[i][j]);
            }
        }
    }
   
    /**
    *
    * Metodo per visualizzare i vincitori dell'estrazione
    */
   
    public void stampaVincitori() {
       
        }


    /**
    *
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
     * @param numero
     * @param idGiocatore
    */
   
    // verifica che i numeri dei giocatori siano contenuti nella matrice
    public void verifica(int numeroScelto, int idGiocatore) {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++){
                if(numeroScelto==numeri[i][j]){
                    numeroVincitori.add(idGiocatore);
                    System.out.println("Giocatore " + idGiocatore + " hai scelto il numero " + numero + "e hai vinto");
                    return;
                }
            }
        }
       
    System.out.println("Giocatore " + idGiocatore + " hai perso!");
    }    


    /**
    *
    * Metodo per eseguire il thread
    *
    */
   
    // metodo run della classe Estrazione che printa dove questa inizia e finisce
    @Override
    public void run() {
        // stampa iniziale
        System.out.println("INIZIO ESTRAZIONE");
        // estrazione dei numeri
        // stampa matrice
        // stampa finale
        System.out.println("FINE ESTRAZIONE");
    }
}
