package br.com.camel.notifier.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

@Component
public class SendEMail {

    @Autowired
    private static JavaMailSender mailSender;

    public static void sendEMail(final String subject, final String message) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        mimeMessage.setFrom(new InternetAddress("no-reply@tempmonitor.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("manager@industry.com"));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);
        mailSender.send(mimeMessage);
    }
}
