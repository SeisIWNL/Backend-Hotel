package pe.com.hotel_api.hotel.service.interfaces;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmailForVerifiUser(String toUser, String token) throws MessagingException;
}