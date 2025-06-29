package com.example.emailService.service;

import com.example.emailService.entity.EmailsDetails;
import org.springframework.boot.context.metrics.buffering.StartupTimeline;

public interface EmailService {
    String sendSimpleMail(EmailsDetails details);

}
