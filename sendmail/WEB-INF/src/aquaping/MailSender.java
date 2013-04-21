package aquaping;

import aquaping.SourceReader;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;


import com.sun.mail.smtp.SMTPMessage;

import java.util.Properties;

public class MailSender extends HttpServlet {

    private SourceReader sr;
    private AquaReport rpt; 

    public static Message buildSimpleMessage(Session session, String msg)
	throws MessagingException {
	    SMTPMessage m = new SMTPMessage(session);
	    MimeMultipart content = new MimeMultipart();
	    MimeBodyPart mainPart = new MimeBodyPart();
	    mainPart.setText(msg);
	    content.addBodyPart(mainPart);
	    m.setContent(content);
	    m.setSubject("UID message");
	    return m;
    }

    public static Session buildGoogleSession() {
	Properties mailProps = new Properties();
	mailProps.put("mail.transport.protocol", "smtp");
	mailProps.put("mail.host", "smtp.gmail.com");
	mailProps.put("mail.from", "sisopefime@gmail.com");
	mailProps.put("mail.smtp.starttls.enable", "true");
	mailProps.put("mail.smtp.port", "587");
	mailProps.put("mail.smtp.auth", "true");
	
	final PasswordAuthentication usernamePassword = new PasswordAuthentication("jesus.antoniosv@gmail.com", "lyon4491");

	Authenticator auth = new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		    return usernamePassword;
		}
	    };

	Session session = Session.getInstance(mailProps, auth);
	session.setDebug(true);
	return session;
    }

    public static void addressAndSendMessage(Message message, String recipient) throws AddressException, MessagingException {
	message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
	Transport.send(message);
    }

    public static boolean sendMail(String message) throws MessagingException, IOException {
	Session session = buildGoogleSession();
	Message simpleMessage = buildSimpleMessage(session, message);
	addressAndSendMessage(simpleMessage, "jesus.antoniosv@gmail.com");
	return true;
   }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       doGet(request, response);
    }

   @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response)
       throws IOException, ServletException {
	// Set the response message's MIME type
       response.setContentType("text/html;charset=UTF-8");
       // Allocate a output writer to write the response message into the network socket
       PrintWriter out = response.getWriter();
 
       // Write the response message, in an HTML page
       boolean b = false;
       String debug = "nope";

       try {
	   String uid = request.getParameter("uid");
	   //out.println(uid);	   
	   if(uid != null) {	     
	       //out.println("LAS GALLETAAAS en email.");
	       // aqui se jala el json
	       sr = new SourceReader("http://data.mwater.co/apiv2/sources/", uid);
	       rpt = new AquaReport();
	       out.println("<p>Json sin parsear: </br>");
	       out.println(sr.readJson());
	       out.println("</p>");
	       rpt.parseValues(sr.readJson());
	       out.println("<p>Reporte: <br>");
	       out.println(rpt.printReport());
	       out.println("</p>");

	       try{
		   b = sendMail(rpt.getJson());
		   out.println("si se pudo mandar?!");
	       } catch(MessagingException e) {	   
		   debug = "something went wrong";
	       }    
	   }
       } finally {
	   out.close();
       }

   }
}
