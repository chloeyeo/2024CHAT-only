package com.project.mhnbackend.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.mhnbackend.mongo.domain.ChatMessage;
import com.project.mhnbackend.mongo.repository.ChatMessageRepository;
import com.project.mhnbackend.service.ChatRoomService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    @Transactional
    public ChatMessage saveMessage(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId());
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> getMessagesByChatRoomId(String chatRoomId) {
    	List<ChatMessage> roomMessages = new ArrayList<>();
    	List<ChatMessage> messages = chatMessageRepository.findAll();
    	for (ChatMessage message: messages) {
    		if (message.getChatRoomId().equals(chatRoomId)) roomMessages.add(message);
    	}
        return roomMessages;
    }
}
