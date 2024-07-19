package com.project.mhnbackend.repository;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.mhnbackend.domain.ChatRoom;

@SpringBootTest
public class ChatRoomRepositoryTests {
	@Autowired
    private ChatRoomRepository chatRoomRepository;
//
//	@Test
//    public void testFindAll() {
//        // Create and save a ChatRoom instance
//        ChatRoom chatRoom = ChatRoom.builder()
//        		.id(1L)
//        		.chatRoomId("chatroom1")
//        		.senderId(1L)
//        		.recipientId(2L)
//        		.build();
//        chatRoomRepository.save(chatRoom);
//
//        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
//    	for (ChatRoom room : chatRoomList) {
//    		if (room.getChatRoomId().equals(chatRoom.getChatRoomId())) {
//    			System.out.println("id: " + room.getId());
//    	        System.out.println("chatRoomId: " + room.getChatRoomId());
//    	        System.out.println("senderId: " + room.getSenderId());
//    	        System.out.println("recipientId: " + room.getRecipientId());
//    		}
//    	}
//    }
	
	@Test
	public void testFindBySenderIdAndRecipientId() {
		ChatRoom chatRoom = ChatRoom.builder()
        		.id(1L)
        		.chatRoomId("chatroom1")
        		.senderId(1L)
        		.recipientId(2L)
        		.build();
        chatRoomRepository.save(chatRoom);
        List<ChatRoom> retrieved = chatRoomRepository.findBySenderIdAndRecipientId(chatRoom.getSenderId(), chatRoom.getRecipientId());
        ChatRoom retrievedRoom = retrieved.get(0);
        System.out.println("length of chatroom list by senderId and recipientId: " + retrieved.size());
//        for (ChatRoom retrievedRoom: retrieved) {
        	System.out.println("id: " + retrievedRoom.getId());
        	System.out.println("chatRoomId: " + retrievedRoom.getChatRoomId());
        	System.out.println("senderId: " + retrievedRoom.getSenderId());
        	System.out.println("recipientId: " + retrievedRoom.getRecipientId());
//        }
		
	}
}
