/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pubsubkafka;

import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author Thiago
 */
public class Menssagem {
    public void setMenssage(String temperatura) throws ExecutionException, InterruptedException {
    var producer = new Producer().getProducer();
    var key = "TEMPERATURA";
    var value = "34º";
    var record = new ProducerRecord<String, String>("EXEMPLO_TOPICO", key, value);
    Callback callback = (data, ex) -> {
        if (ex != null) {
            ex.printStackTrace();
            return;
        }
        System.out.println("Mensagem enviada com sucesso para: " + data.topic() + " | partition " + data.partition() + "| offset " + data.offset() + "| tempo " + data.timestamp());
    };
    producer.send(record, callback).get();
    
   
}
}
