package com.chatapplication.publisher;


	import org.springframework.amqp.rabbit.core.RabbitTemplate;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

import com.chatapplication.model.Message.ChatMessage;

	@Component
	public class ChatMessagePublisher {

	    private RabbitTemplate rabbitTemplate;

	    @Autowired
	    public ChatMessagePublisher(RabbitTemplate rabbitTemplate) {
	        this.rabbitTemplate = rabbitTemplate;
	    }

	    public void publish(ChatMessage chatMessage) {
	        rabbitTemplate.convertAndSend("chat.queue", chatMessage);
	    }
	}


