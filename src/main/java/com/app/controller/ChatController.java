package com.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.app.model.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.login")
	@SendTo("/topic/all")
	public ChatMessage login(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", message.getSender());
		return message;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/all")
	public ChatMessage send(@Payload ChatMessage message) {
		return message;
	}

}
