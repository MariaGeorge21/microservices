package com.chatapplication.consumer;


	import org.springframework.amqp.rabbit.annotation.RabbitListener;
	import org.springframework.stereotype.Component;

import com.chatapplication.model.Message.ChatMessage;

	@Component
	public class ChatMessageConsumer {

	    @RabbitListener(queues = "chat.queue")
	    public void handleMessage(ChatMessage chatMessage) {
	        // Handle received chat message
	        System.out.println("Received Message: " + chatMessage.getContent() + " from " + chatMessage.getSender());
	    }
	}



