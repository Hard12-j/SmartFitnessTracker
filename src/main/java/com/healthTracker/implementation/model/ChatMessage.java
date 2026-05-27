package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderId;
    private Long receiverId;

    /**
     * Deterministic room identifier: min(senderId, receiverId) + "_" + max(senderId, receiverId)
     * Same for both participants regardless of who sends first.
     */
    private String roomId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime sentAt = LocalDateTime.now();

    private boolean isRead = false;

    /** Computed utility */
    public static String buildRoomId(Long a, Long b) {
        return Math.min(a, b) + "_" + Math.max(a, b);
    }
}
