package com.example.emailService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailsDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
