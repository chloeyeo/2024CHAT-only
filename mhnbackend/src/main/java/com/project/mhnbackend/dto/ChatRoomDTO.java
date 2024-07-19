package com.project.mhnbackend.dto;

import java.util.List;

import com.project.mhnbackend.domain.ChatRoom;
import com.project.mhnbackend.mongo.domain.ChatMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDTO {
    private ChatRoom chatRoom;
    private List<ChatMessage> messages;
}
