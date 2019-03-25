package demo.springboot.redis.pub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.redis.pub.model.Customer;
import demo.springboot.redis.pub.producer.CustomerInfoPublisher;

@RestController
public class CustomerInfoController {

	@Autowired
	private CustomerInfoPublisher redisPublisher;
	
	@PostMapping("/customer")
	public void publishCustomerInfo(@RequestBody Customer customer) {
		redisPublisher.publish(customer);
	}
}
