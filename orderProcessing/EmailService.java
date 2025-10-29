package orderProcessing;

public interface EmailService {
    void sendConfirmationEmail(String email, String subject, String body);
}

