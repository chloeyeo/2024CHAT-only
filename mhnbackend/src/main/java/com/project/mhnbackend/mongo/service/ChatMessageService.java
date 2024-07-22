package com.project.mhnbackend.mongo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.mhnbackend.mongo.dto.ChatMessageDTO;
import org.springframework.stereotype.Service;

import com.project.mhnbackend.mongo.domain.ChatMessage;
import com.project.mhnbackend.mongo.repository.ChatMessageRepository;
import com.project.mhnbackend.service.ChatRoomService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    @Transactional
    public ChatMessage saveMessage(ChatMessage chatMessage) {
    	log.info("inside chat service");
    	log.info("Saving message: {}", chatMessage);
        String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId());
        chatMessage.setChatRoomId(chatId);
        // Find the ChatMessageDTO for the given chatRoomId or create a new one if not found
        Optional<ChatMessageDTO> optionalChatMessageDTO = chatMessageRepository.findById(chatId);
        ChatMessageDTO chatMessageDTO;

        if (optionalChatMessageDTO.isPresent()) {
            chatMessageDTO = optionalChatMessageDTO.get();
        } else {
            chatMessageDTO = new ChatMessageDTO();
            chatMessageDTO.setChatRoomId(chatId);
        }

        chatMessageDTO.getMessages().add(chatMessage);
        chatMessageRepository.save(chatMessageDTO);

        log.info("Saved message: {}", chatMessage);
        log.info("Exiting chat service");
        return chatMessage;
    }

    public List<ChatMessage> getMessagesByChatRoomId(String chatRoomId) {
        Optional<ChatMessageDTO> optionalChatMessageDTO = chatMessageRepository.findById(chatRoomId);
        if (optionalChatMessageDTO.isPresent()) {
            return optionalChatMessageDTO.get().getMessages();
        }
        return List.of(); // Return an empty list if no messages are found
    }
}
