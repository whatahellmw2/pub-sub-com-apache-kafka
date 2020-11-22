/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pubsubkafka;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class TesteProducer {
    public static void main(String args[]){
        Menssagem menssagem = new Menssagem();
        try {
            menssagem.setMenssage("30");
        } catch (ExecutionException ex) {
            Logger.getLogger(TesteProducer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
