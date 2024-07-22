package com.project.mhnbackend.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.mhnbackend.mongo.domain.ChatMessage;
import com.project.mhnbackend.mongo.repository.ChatMessageRepository;
import com.project.mhnbackend.mongo.service.ChatMessageService;

@SpringBootTest
public class ChatMessageServiceTests {
	@Autowired
	private ChatMessageService chatMessageService;
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	
	@Test
    public void testGetMessagesByChatRoomId() {
		List<ChatMessage> chatmessages = new ArrayList<>()
		ChatMessage chatMessage = ChatMessage.builder()
				.id(1L)
				.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.content("first message sent")
				.build();
		ChatMessage chatMessage2 = ChatMessage.builder()
				.id(1L)
				.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.content("second message sent")
				.build();
		ChatMessage chatMessage3 = ChatMessage.builder()
				.id(1L)
				.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.content("third message sent")
				.build();
		chatMessageRepository.save(chatMessage);
		chatMessageRepository.save(chatMessage2);
		chatMessageRepository.save(chatMessage3);
		List<ChatMessage> messages = chatMessageService.getMessagesByChatRoomId(chatMessage.getChatRoomId());
		for (ChatMessage message: messages) {
			System.out.println(message.getContent());
		}
	}
	
	@Test
	public void testSaveMessage() {
		ChatMessage chatMessage = ChatMessage.builder()
				.id(1L)
				.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.content("first message sent")
				.build();
		chatMessageRepository.save(chatMessage);
	}
}
