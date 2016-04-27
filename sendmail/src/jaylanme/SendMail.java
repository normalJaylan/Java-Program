package jaylanme;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.*;

public class SendMail {
	public static void main(String args[]) throws Exception{
		new Send("xxx");
	}
	
}

class Send {
	private String host = "smtp.exmail.qq.com";
	private String from = "xxx";
	
	private String username = "xxx";
	private String password = "xxx";
	
	Properties properties = new Properties();
	
	public Send(String to) throws Exception{
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.ssl.enable", "true");
		
		Session session = Session.getDefaultInstance(properties);
		
		session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		message.setSubject("xxx");
		message.setText("xxx");
					
		message.saveChanges();
		Transport transport = session.getTransport("smtp");
		transport.connect(host, username, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}


