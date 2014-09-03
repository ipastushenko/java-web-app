package com.ipastushenko.core.service;

import com.ipastushenko.core.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * service for sends emails
 */
public class EmailService {
    private static final Logger log = Logger.getLogger(EmailService.class.getName());
    private MailSender mailSender;

    public void sendMail(String from, String to, String subject, String body) throws ServiceException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        try {
            mailSender.send(message);
        } catch (MailException e) {
            log.error("Email did send", e);
            throw new ServiceException("Email did send");
        }
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
