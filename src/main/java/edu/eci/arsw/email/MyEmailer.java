package edu.eci.arsw.email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MyEmailer {
   private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
   private static final String SMTP_AUTH_USER = "your_sendgrid_username";
   private static final String SMTP_AUTH_PWD = "your_sendgrid_password";

   public static void main(String[] args) throws Exception{
       new MyEmailer().SendMail();
   }

   public void SendMail() throws Exception{
      Properties properties = new Properties();
         properties.put("mail.transport.protocol", "smtp");
         properties.put("mail.smtp.host", SMTP_HOST_NAME);
         properties.put("mail.smtp.port", 587);
         properties.put("mail.smtp.auth", "true");
         
   }
}