package com.example.mailservice.data.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Mail {
    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String recipientAddress;

    @Column(nullable = false, length = 25)
    private String senderAddress;

    @Column(nullable = false, length = 100)
    private String subject;

    @Column(nullable = false, length = 500)
    private String content;

    private String file;
}
