package com.project.mhnbackend.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.mhnbackend.mongo.domain.ChatMessage;
import com.project.mhnbackend.mongo.repository.ChatMessageRepository;

@SpringBootTest
public class ChatMessageRepositoryTests {
	@Autowired
	private ChatMessageRepository chatMessageRepository;

//	@Test
//    public void testFindAll() {
//		ChatMessage chatMessage = ChatMessage.builder()
//				.id(1L)
//				.chatRoomId("chatroom1")
//        		.senderId(1L)
//        		.recipientId(2L)
//        		.content("first message sent")
//				.build();
//		chatMessageRepository.save(chatMessage);
//
//        List<ChatMessage> chatMessageList = chatMessageRepository.findAll();
//    	for (ChatMessage message : chatMessageList) {
//    		if (message.getChatRoomId().equals(chatMessage.getChatRoomId())) {
//    			System.out.println("content: " + message.getContent());
//    		}
//    	}
//    }
}
