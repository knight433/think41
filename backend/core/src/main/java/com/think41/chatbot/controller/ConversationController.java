package com.think41.chatbot.controller;

import com.think41.chatbot.models.Conversation;
import com.think41.chatbot.repo.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
public class ConversationController {

    @Autowired
    private ConversationRepository conversationRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Conversation> getConversation(@PathVariable Integer id) {
        Optional<Conversation> conversation = conversationRepository.findById(id);
        return conversation.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conversation> updateConversation(@PathVariable Integer id, @RequestBody Conversation updatedConversation) {
        Optional<Conversation> existing = conversationRepository.findById(id);

        if (existing.isPresent()) {
            Conversation conversation = existing.get();
            conversation.setTitle(updatedConversation.getTitle());
            conversation.setUserId(updatedConversation.getUserId());
            conversation.setUpdatedAt(updatedConversation.getUpdatedAt() != null
                                      ? updatedConversation.getUpdatedAt()
                                      : java.time.LocalDateTime.now());

            conversationRepository.save(conversation);
            return ResponseEntity.ok(conversation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

