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
 * @author Jens
 */
public class MailTest2 {

    private static String HOSTNAME = "localhost";
    private static String USERNAME = "admin";
    private static String PASSWORD = "jensgn";

    public static void main(String[] args) {
        try {
            String to = "jensgn@gmail.com";    //"hve@teamin.dk";
            String from = "jmn@teamin.dk";
            Properties properties = System.getProperties();

            properties.setProperty("mail.smtp.host", HOSTNAME);
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("My Subject!");
            message.setText("Here Goes My Message");
            Transport.send(message);
            System.out.println("Message Sending Completed");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
