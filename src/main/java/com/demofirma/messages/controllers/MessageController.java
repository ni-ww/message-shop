package com.demofirma.messages.controllers;

import com.demofirma.messages.domain.dto.MessageDTO;
import com.demofirma.messages.utils.ApiResponsesCustom;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(value = {@Tag(name = "Message")})
@RequestMapping("/api/messages")
public interface MessageController {

    @Operation(summary = "Create a new message",
            description = "This endpoint allows authenticated user to create a new message in the system.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created the message.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))})
    @ApiResponsesCustom
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MessageDTO addMessage(@Parameter(description = "Details of the message to be created", required = true)
                          @Valid @RequestBody MessageDTO messageDto);

    @Operation(summary = "Get a list of messages",
            description = "This endpoint allows authenticated user to get a list of messages in the system.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Request processed successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))})
    @ApiResponsesCustom
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<MessageDTO> getMessages();

    @Operation(summary = "Get a message by ID",
            description = "This endpoint allows authenticated user to get a message by its ID.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Request processed successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))})
    @ApiResponsesCustom
    @GetMapping("/{messageId}")
    @ResponseStatus(code = HttpStatus.OK)
    MessageDTO getMessage(@Parameter(description = "Message ID", required = true)
                          @Valid @PathVariable("messageId") Long messageId);

    @Operation(summary = "Update a message",
            description = "This endpoint allows authenticated user to update a message in the system.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Updated the message successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))})
    @ApiResponsesCustom
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    MessageDTO updateMessage(@Parameter(description = "Details of the message to be updated", required = true)
                             @Valid @RequestBody MessageDTO updateMessageDto);

    @Operation(summary = "Delete a message",
            description = "This endpoint allows authenticated user to delete a message in the system.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Deleted the message successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))})
    @ApiResponsesCustom
    @DeleteMapping("/{messageId}")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteMessage(@Parameter(description = "Message ID", required = true)
                       @Valid @PathVariable("messageId") Long messageId);
}









