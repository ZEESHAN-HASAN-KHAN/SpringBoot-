package com.example.emailService.controller;

import com.example.emailService.entity.EmailsDetails;
import com.example.emailService.service.EmailService;
import com.example.emailService.service.EmailServiceImpl;
import com.example.emailService.service.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailsDetails details)
    {
        System.out.println("Sending Emails");
        String status=emailService.sendSimpleMail(details);
        return status;
    }

}
