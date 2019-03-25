package demo.springboot.redis.pub.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import demo.springboot.redis.pub.model.Customer;

public class RedisCustomerInfoPublisher implements CustomerInfoPublisher {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private ChannelTopic topic;

	public RedisCustomerInfoPublisher() {
	}

	public RedisCustomerInfoPublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.topic = topic;
	}

	@Override
	public void publish(Customer customer) {

		redisTemplate.convertAndSend(topic.getTopic(), customer.toString());
		System.out.println("Published Customer: " + customer.toString());
	}

}
