package com.think41.chatbot.models;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages", schema = "con")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "conversation_id", nullable = false)
    private Integer conversationId;

    @Column(name = "sender",nullable = false)
    private String sender;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors
    public Message() {}

    public Message(Integer conversationId, String sender, String content) {
        this.conversationId = conversationId;
        this.sender = sender;
        this.content = content;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

