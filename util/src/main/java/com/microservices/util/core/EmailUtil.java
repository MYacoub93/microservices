package com.microservices.util.core;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailUtil implements EmailSender {


    @Autowired
    private final JavaMailSender mailSender;

    @Override
    @Async
    public boolean sendEmail(String to,String subject,String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setTo(to);
            helper.setText(email);
            helper.setSubject(subject);
            helper.setFrom("Hello@microservices.com");
            mailSender.send(mimeMessage);

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
            return true;
    }
}
