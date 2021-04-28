/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**

/**
 *
 * @author saida
 */
public class Mail {
 public static void senMail(String recepient, String objet , String text) throws Exception {
        System.out.println("preparing ");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.host", "smtp.gmail.com");

        properties.put("mail.smtp.port", "587");

         String myAccountEmail = "asma.saidani@esprit.tn";
        String myAccountPassword = "203JFT0907";  //yaaen jed assslek :)
       // String myAccountEmail = "ehealthcodeit@gmail.com";
       // String myAccountPassword = "EHealth2021";
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myAccountPassword);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient,   objet ,  text);

        Transport.send(message);
       

        System.out.println("message sent succefully");
    }

   private static Message prepareMessage(Session session, String myAccountEmail, String recepient,  String objet , String text) {
        try {
            Message message = new MimeMessage(session);
           
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(objet);
            message.setText(text+"\n cordialement ");
            System.out.println("mail envoyé avec succés");
            return message;

        } catch (Exception ex) {
               System.out.println(ex.getMessage());
        }
        return null;

    }

   public static void main(String[] args) throws Exception {
        senMail("asma.saidani@esprit.tn");

    } 

    private static void senMail(String asmasaidaniesprittn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

