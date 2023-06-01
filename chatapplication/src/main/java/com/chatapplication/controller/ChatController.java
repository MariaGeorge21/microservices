package com.chatapplication.controller;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapplication.model.Message.ChatMessage;
import com.chatapplication.publisher.ChatMessagePublisher;

	@RestController
	@RequestMapping("/api/chat")
	public class ChatController {

	    private ChatMessagePublisher publisher;

	    @Autowired
	    public ChatController(ChatMessagePublisher publisher) {
	        this.publisher = publisher;
	    }

	    @PostMapping("/chat")
	    public void sendMessage1(@RequestBody ChatMessage chatMessage) {
	        publisher.publish(chatMessage);
	    }
	    @PostMapping("/send")
	    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
	        // Handle sending the chat message
	        // ...

	        return ResponseEntity.ok("Message sent successfully");
	    }

		/*
		 * @GetMapping("/history") public ResponseEntity<List<ChatMessage>>
		 * getChatHistory() { // Retrieve and return chat message history // ...
		 * 
		 * return ResponseEntity.ok(chatMessageHistory); }
		 */
	}
	



