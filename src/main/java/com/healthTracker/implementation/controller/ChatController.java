package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.ChatMessage;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.ChatMessageRepository;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Renders the chat page between the current logged-in user and another user (trainer or client)
     */
    @GetMapping("/chat/{otherUserId}")
    public String showChatPage(@PathVariable Long otherUserId, Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        User currentUser = userService.getUserByUsername(principal.getName());
        User otherUser = userService.getUserById(otherUserId);

        if (currentUser == null || otherUser == null) {
            return "redirect:/welcome";
        }

        // Calculate deterministic room ID
        String roomId = ChatMessage.buildRoomId(currentUser.getId(), otherUser.getId());

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("otherUser", otherUser);
        model.addAttribute("roomId", roomId);

        return "chat";
    }

    /**
     * REST endpoint to retrieve chat history for a specific roomId
     */
    @GetMapping("/chat/history/{roomId}")
    @ResponseBody
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable String roomId, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        User currentUser = userService.getUserByUsername(principal.getName());
        if (currentUser == null) {
            return ResponseEntity.status(401).build();
        }
        
        String[] ids = roomId.split("_");
        if (ids.length != 2) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Long id1 = Long.parseLong(ids[0]);
            Long id2 = Long.parseLong(ids[1]);
            if (!currentUser.getId().equals(id1) && !currentUser.getId().equals(id2)) {
                return ResponseEntity.status(403).build(); // Forbidden to view other rooms
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        List<ChatMessage> history = chatMessageRepository.findByRoomIdOrderBySentAtAsc(roomId);
        return ResponseEntity.ok(history);
    }

    /**
     * STOMP WebSocket message handler mapping.
     * When client sends to /app/chat.send, this handles it.
     */
    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessage message) {
        String calculatedRoomId = ChatMessage.buildRoomId(message.getSenderId(), message.getReceiverId());
        message.setRoomId(calculatedRoomId);
        message.setSentAt(LocalDateTime.now());
        message.setRead(false);

        // Persist to database
        chatMessageRepository.save(message);

        // Broadcast to both participants subscribed to /topic/chat/{roomId}
        messagingTemplate.convertAndSend("/topic/chat/" + calculatedRoomId, message);
    }
}
