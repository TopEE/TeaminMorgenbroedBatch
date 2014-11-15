/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Mail metoder.
 *
 * @author Jens
 */
public class Mail {

    private static final String HOSTNAME = "localhost";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "jensgn";

    public static void sendMail(String from, String to, String subject, String text) throws MessagingException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOSTNAME);
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
    }
}
