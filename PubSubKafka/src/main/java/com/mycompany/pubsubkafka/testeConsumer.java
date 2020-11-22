/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pubsubkafka;

import java.time.Duration;
import java.util.Collections;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

/**
 *
 * @author Thiago
 */
public class testeConsumer {
    public static void main(String[] args) {
        var consumer = new Consumer().getConsumer();
        consumer.subscribe(Collections.singletonList("EXEMPLO_TOPICO"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> registro : records) {
                System.out.println("------------------------------------------");
                System.out.println("Recebendo nova temperatura");
                System.out.println(registro.key());
                System.out.println(registro.value());

                final String valor = registro.value().replaceAll("º", "");
                final Integer temperatura = Integer.valueOf(valor);
                if (temperatura > 30) {
                    System.out.println("Está calor");
                } else if (temperatura < 20) {
                    System.out.println("Está frio");
                }

                System.out.println("Temperatura processada.");
            }
        }
    }
}
