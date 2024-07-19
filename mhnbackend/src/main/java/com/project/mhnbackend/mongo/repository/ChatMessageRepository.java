package com.project.mhnbackend.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.mhnbackend.mongo.domain.ChatMessage;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {
}
