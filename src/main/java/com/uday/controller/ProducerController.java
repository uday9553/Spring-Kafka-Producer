package com.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
	
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//	
//	private static final String Topic="uday";
//	
//
//	@GetMapping("/publish/{message}")
//	public String publishMessage(@PathVariable("message") String message) {
//		kafkaTemplate.send(Topic,message);
//		return "published seccessfully";
//	}
	
}
