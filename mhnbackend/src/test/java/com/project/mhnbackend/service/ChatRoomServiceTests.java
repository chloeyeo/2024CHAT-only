package com.project.mhnbackend.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.mhnbackend.domain.ChatRoom;
import com.project.mhnbackend.repository.ChatRoomRepository;

@SpringBootTest
public class ChatRoomServiceTests {
	@Autowired
	private ChatRoomService chatRoomService;
	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	@Test
	public void testGetChatRoomByChatRoomId() {
		ChatRoom chatRoom = ChatRoom.builder()
        		.id(1L)
        		.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.build();
        chatRoomRepository.save(chatRoom);
        ChatRoom retrievedChatRoom = chatRoomService.getChatRoomByChatRoomId(chatRoom.getChatRoomId());
        System.out.println("id: " + retrievedChatRoom.getId());
        System.out.println("chatRoomId: " + retrievedChatRoom.getChatRoomId());
        System.out.println("senderId: " + retrievedChatRoom.getSenderId());
        System.out.println("recipientId: " + retrievedChatRoom.getRecipientId());
	}
	
	@Test
	public void testGetChatRoomId() {
		String chatRoomId = chatRoomService.getChatRoomId(3L, 2L);
		System.out.println("created chat room id: " + chatRoomId);
	}
	
}
