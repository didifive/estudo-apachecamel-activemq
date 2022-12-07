package br.com.camel.notifier.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

@Service
public class EMailService {

    @Autowired
    private JavaMailSender mailSender;

    public EMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(final String subject, final String message) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        mimeMessage.setFrom(new InternetAddress("no-reply@tempmonitor.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("manager@industry.com"));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);
        mailSender.send(mimeMessage);
    }
}
