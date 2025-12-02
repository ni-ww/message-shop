package com.demofirma.messages.controllers.impl;

import com.demofirma.messages.controllers.MessageController;
import com.demofirma.messages.domain.dto.MessageDTO;
import com.demofirma.messages.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageControllerImpl implements MessageController {

    private final MessageService messageService;

    @Override
    public MessageDTO addMessage(MessageDTO messageDto) {
        return messageService.addMessage(messageDto);
    }

    @Override
    public List<MessageDTO> getMessages() {
        return messageService.getMessages();
    }

    @Override
    public MessageDTO getMessage(Long messageId) {
        return messageService.getMessage(messageId);
    }

    @Override
    public MessageDTO updateMessage(MessageDTO updateMessageDto) {
        return messageService.updateMessage(updateMessageDto);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageService.deleteMessage(messageId);
    }
}
























