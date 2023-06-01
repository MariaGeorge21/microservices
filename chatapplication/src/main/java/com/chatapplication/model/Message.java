package com.chatapplication.model;

public class Message {
	public class ChatMessage {
	    private String content;
	    private String sender;

	    // Getters and setters
	    public ChatMessage() {
			// TODO Auto-generated constructor stub
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public ChatMessage(String content, String sender) {
			super();
			this.content = content;
			this.sender = sender;
		}
	    
	}


}
