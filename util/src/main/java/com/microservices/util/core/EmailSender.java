package com.microservices.util.core;

public interface EmailSender {
    boolean sendEmail(String to,String subject,String email);
}
