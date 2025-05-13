package com.joshualeepenn.healthtracker.dto;

import lombok.Data;

@Data
public class MessageDto {

    private enum Status {
        SUCCESS,
        FAILURE
    }
    private String message;
    private String status;

    public static MessageDto success(String message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(message);
        messageDto.setStatus(Status.SUCCESS.toString().toLowerCase());
        return messageDto;
    }

    public static MessageDto failure(String message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(message);
        messageDto.setStatus(Status.FAILURE.toString().toLowerCase());
        return messageDto;
    }
}
