package com.demofirma.messages.services;

import com.demofirma.messages.domain.dto.MessageDTO;
import com.demofirma.messages.domain.entity.Message;
import com.demofirma.messages.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public MessageDTO addMessage(MessageDTO messageDTO) {
        Message message = Message.builder()
                .text(messageDTO.getText())
                .build();
        messageRepository.save(message);
        return MessageDTO.from(message);
    }

    public List<MessageDTO> getMessages() {
        List<Message> messages = messageRepository.findAll();
        return MessageDTO.from(messages);
    }

    public MessageDTO getMessage(Long messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        messageOptional.orElseThrow(() -> new RuntimeException("Message not found with id: " + messageId));
        return MessageDTO.from(messageOptional.get());
    }

    @Transactional
    public MessageDTO updateMessage(MessageDTO updateMessageDto) {
        Optional<Message> messageOptional = messageRepository.findById(updateMessageDto.getId());
        messageOptional.orElseThrow(() -> new RuntimeException("Message not found with id: " + updateMessageDto.getId()));
        Message message = messageOptional.get();
        message.setText(updateMessageDto.getText());
        messageRepository.save(message);
        return MessageDTO.from(message);
    }

    public void deleteMessage(Long messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        messageOptional.orElseThrow(() -> new RuntimeException("Message not found with id: " + messageId));
        messageRepository.delete(messageOptional.get());
    }
}















