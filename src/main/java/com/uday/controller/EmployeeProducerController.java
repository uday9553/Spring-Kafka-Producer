package com.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.model.Employee;


@RestController
@RequestMapping("/kafka")
public class EmployeeProducerController {
	
	//by default kafka uses string serialization
	//but now in this we need to tell kafka that we are publishing JSON
	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;
	
	private static final String Topic="uday";
	
//	@GetMapping("/publish/{message}")
//	public String publishMessageForEmployee(@PathVariable("message") String message) {
//		kafkaTemplate.send(Topic,message);
//		return "published seccessfully";
//	}
	
	@GetMapping("/publishemployee/{name}")
	public void publishMessage(@PathVariable("name") String name) {
		
		ListenableFuture<SendResult<String, Employee>> future=kafkaTemplate.send(Topic,new Employee(1,name,"developer"));
		future.addCallback(new ListenableFutureCallback<SendResult<String, Employee>>() {
			
	        @Override
	        public void onSuccess(SendResult<String, Employee> result) {
	            System.out.println("Sent message=[" + name + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	           	           
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            System.out.println("Unable to send message=[" 
	              + name + "] due to : " + ex.getMessage());	            
	        }
	        
	    });
		
	}
	

}
