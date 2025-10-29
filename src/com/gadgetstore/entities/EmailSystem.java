package com.gadgetstore.entities;

import com.gadgetstore.services.EmailService;
/** Email System class to store items temporarily */

public class EmailSystem implements EmailService {
    @Override
    public void sendConfirmationEmail(String email, String subject, String body) {}
}

