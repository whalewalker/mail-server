package com.example.mailservice.web.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MailDto {
    @NotEmpty(message = "Recipient address cannot be empty")
    private String recipientAddress;

    @NotEmpty(message = "Recipient address cannot be empty")
    private String subject;

    @NotEmpty(message = "Recipient address cannot be empty")
    private String content;

    private String file;
}
