package com.teamin.batch.batchlet;

import java.util.Properties;
import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Henrik
 */
@Named
public class InfoMailBatchlet extends AbstractBatchlet {
    
    private static String HOSTNAME = "localhost";
    private static String USERNAME = "admin";
    private static String PASSWORD = "henrik1969";

    @Override
    public String process() {
        System.out.println("Running inside a batchlet : InfoMailBatchlet");
        
        try {
            String to1 = "hve@teamin.dk";    
            String to2 = "jmn@teamin.dk";    
            String to3 = "jhl@teamin.dk";    
            String from = "hve@teamin.dk";
            Properties properties = System.getProperties();

            properties.setProperty("mail.smtp.host", HOSTNAME);
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to2));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to3));
            message.setSubject("Infomail");
            message.setText("Du skylder os penge...");
            Transport.send(message);
            System.out.println("Mail er sendt");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return "COMPLETED";
    }
    
}
