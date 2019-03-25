package demo.springboot.redis.pub.producer;

import demo.springboot.redis.pub.model.Customer;

public interface CustomerInfoPublisher {
	
	void publish(Customer customer);
}
