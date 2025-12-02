package com.demofirma.messages.domain.dto;

import com.demofirma.messages.domain.entity.Message;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    @Size(min = 1, max = 100, message = "Text must be between 1 and 100 characters")
    private String text;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public static MessageDTO from(Message message) {
        return MessageDTO.builder()
                .id(message.getId())
                .text(message.getText())
                .createDate(message.getCreateDate())
                .updateDate(message.getUpdateDate())
                .build();
    }

    public static List<MessageDTO> from(List<Message> messages) {
        return messages.stream().map(MessageDTO::from).toList();
    }
}





















