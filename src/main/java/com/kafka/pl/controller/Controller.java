package com.kafka.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.pl.domain.POJOclass;

@RestController
@RequestMapping(value = "/kafka/api")
@EnableKafka
public class Controller {
	
	@Autowired
	KafkaTemplate<String, POJOclass> kafkaTemplate;
	
	@Value("${topic.name}")
	String topic;

	@PostMapping
	public void post(@RequestBody POJOclass pojo) {
		kafkaTemplate.send(topic, pojo);
	}
	
    @KafkaListener(topics = "${topic.name}")
    public void getFromKafka(POJOclass pojo){
        System.out.println(pojo.toString());        
    }

}
