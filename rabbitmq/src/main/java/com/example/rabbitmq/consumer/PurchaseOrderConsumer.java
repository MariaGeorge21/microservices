package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	@Value("${ust.rabbitmq.queue}")
	String ust_queue;
	@RabbitListener(queues="ust_queue")
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("message recieved from queue:"+ orderStatus);
	}

}
