package com.project.mhnbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.project.mhnbackend.domain.ChatRoom;
//import com.project.mhnbackend.mongo.repository.ChatMessageRepository;
import com.project.mhnbackend.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
//    private final ChatMessageRepository chatMessageRepository;

    public String getChatRoomId(Long senderId, Long recipientId) { // creates chatroom and returns the chatroom id if it doesn't exist
        List<ChatRoom> chatRooms = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        ChatRoom chatRoom = null;
        if (!chatRooms.isEmpty()) {
        	chatRoom = chatRooms.get(0);
        	if (chatRooms.size() > 1) {
        		chatRooms.clear();
            	chatRooms.add(chatRoom);
        	}
        }
        if (chatRoom!=null) {
        	return chatRoom.getChatRoomId();
        } else {
        	 String chatRoomId = String.format("%s_%s_%s", senderId+"", recipientId+"", UUID.randomUUID().toString());
             ChatRoom senderRecipient = ChatRoom.builder()
                     .chatRoomId(chatRoomId) // chatId is the chatroom id
                     .senderId(senderId)
                     .recipientId(recipientId)
                     .build();
             ChatRoom recipientSender = ChatRoom.builder()
                     .chatRoomId(chatRoomId)
                     .senderId(senderId)
                     .recipientId(recipientId)
                     .build();
             chatRoomRepository.save(senderRecipient);
             chatRoomRepository.save(recipientSender);
             return chatRoomId;
        }
    }

    public ChatRoom getChatRoomByChatRoomId(String chatRoomId) {
    	List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
    	for (ChatRoom chatRoom : chatRoomList) {
    		if (chatRoom.getChatRoomId().equals(chatRoomId)) return chatRoom;
    	}
        return null;
    }
}
