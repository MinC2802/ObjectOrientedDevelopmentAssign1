package com.gadgetstore.services;

public interface EmailService {
    void sendConfirmationEmail(String email, String subject, String body);
}

