/**
 * Sample Skeleton for 'NewRegistration.fxml' Controller Class
 */

package registration;





import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class NewRegistrationController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtname"
    private TextField txtname; // Value injected by FXMLLoader

    @FXML // fx:id="txtdepartment"
    private TextField txtdepartment; // Value injected by FXMLLoader

    @FXML // fx:id="txtsemester"
    private TextField txtsemester; // Value injected by FXMLLoader

    @FXML // fx:id="txtsubject"
    private TextField txtsubject; // Value injected by FXMLLoader

    @FXML // fx:id="txtuser"
    private TextField txtuser; // Value injected by FXMLLoader

    @FXML // fx:id="txtpass"
    private PasswordField txtpass; // Value injected by FXMLLoader
    
    @FXML
    private Button btnSubmit;
    
    @FXML // fx:id="listab"
    private ListView<String> listab; // Value injected by FXMLLoader
    
    @FXML // fx:id="txthlo"
    private TextField txthlo; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtstatus"
    private TextField txtstatus; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnClose"
    private Button btnClose; // Value injected by FXMLLoader

    
    
    PreparedStatement pst;
    
    @FXML
    void doClose(ActionEvent event)
    {
    	Scene scene1=(Scene)btnClose.getScene();
		   scene1.getWindow().hide();
    }
    
    
    @FXML
    void doGreatJob(MouseEvent event) {

    }
    
    @FXML
    void doJob(ActionEvent event)
    {
    	
    }

    
    @FXML
    void dosave(ActionEvent event) 
    {
    	boolean a=true;
    	if(txtname.getText()=="" || txtdepartment.getText()=="" || txtsemester.getText()==""|| txtsubject.getText()==""
    			||txtuser.getText()==""||txtpass.getText()=="")
    	{
    		
    		showMsg2("Please fill both fields only then you can enter");
    		
    	}
    	else
    	{
    		ObservableList<String> amounts= listab.getItems();
    		 for (String pa : amounts) 
    		 { 
    			 txthlo.setText(pa);
    			 
    			 if(txtsubject.getText().matches(txthlo.getText()))
    	    		{
    				 a=false;
    				 txtstatus.setText("null");
    	try {
    		pst=con.prepareStatement("insert into registration value(?,?,?,?,?,?,?)");
    		pst.setString(1,txtname.getText());
    		pst.setString(2, txtdepartment.getText());
    		pst.setString(3, txtsemester.getText());
    		pst.setString(4, txtsubject.getText());
    		pst.setString(5, txtuser.getText());
    		pst.setString(6, txtpass.getText());
    		pst.setString(7, txtstatus.getText());
    		
    		
    		pst.executeUpdate();
    		
    	
    		
    		
    		 emailSending();
    		 
    		
    		//System.out.println("Done");
    		// Scene scene1=(Scene)btnSubmit.getScene();
  		 //  scene1.getWindow().hide();
    		
//    		try {
//    			
//    			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("login/LoginView.fxml")); 
//    			Scene scene = new Scene(root);
//    			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//    			Stage stage=new Stage();
//    		    stage.setScene(scene);
//    		    stage.show();
//    	       }   
//    		
//    	       catch(Exception e) 
//    	       {
//    		     e.printStackTrace();
//    	        }
    	       
    		
    	}
    	    		catch (SQLException e)
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	    		}
    	
    		 }
    		 if(a==false)
    		 {
    			 System.out.println("done");
    		 }
    		 else
    		 {
    			 showMsg("Your Email is Not Registered, Contact your Branch ");
    		 }
    		
     		
     		
     		
    		 }
    	
    	
    	//showMsg("Your Email id is not Present in College database Please contact with Your department ");
		
    	 
    	
    	
    }
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    void emailSending()
   	{
   		System.out.println("hello");
   		String message="hello "+txtuser.getText()+" Welcome I hope you are doing well, this is simple mail for confirmation Your USERNAME IS:-"+txtuser.getText()+" "+"YOUR PASSWORD IS:-"+txtpass.getText()+" please if you want that i will confirm your permission ! Please click on the CONFIRMED BUTTON other you can decline ";
   		String subject="GZSCCET : Confirmation";
   		String user=txtuser.getText();
   		String password=txtpass.getText();
   		String to=txtsubject.getText();
   		String from="eknoorgreat001@gmail.com";
   		
   		sendEmail(message,subject,user,password,to,from);
   		

   	}
    



private static void sendEmail(String message, String subject,String user, String password, String to, String from) 
{
	//String fromm=from;
		String host="smtp.gmail.com";
		
		Properties properties= System.getProperties();
		System.out.println(properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.starttls.enable","true");
		//properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.ssl.protocols","TLSv1.2");
		
		
		Session session=Session.getInstance(properties, new Authenticator()
				{

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("eknoorgreat001@gmail.com","password");
					}
			
				});
		session.setDebug(true);
		
		
		try {
			MimeMessage m=new MimeMessage(session);	
		m.setFrom(new InternetAddress(from));
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		m.setSubject(subject);
		m.setText(message);
	//	m.setText("Username "+user);
		//m.setText("Password "+password);
		//Transport tr =session.getTransport("smtp");
		//String smtp_server=properties.getProperty("mail.smtp.host");
		
		Transport.send(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

void showMsg2(String msg)
{
	Alert alert=new Alert(AlertType.INFORMATION);
	alert.setTitle("Its Result");
	alert.setContentText(msg);
	alert.show();
}

//void reciveEm()
//{
//	String host="pop.gmail.com";
//	String mailStoreType="pop3";
//	String username="eknoorgreat001@gmail.com";
//	String password="9877614193";
//	recieveEmail(host,mailStoreType,username,password);
//	
//}
//
//public static void recieveEmail(String host,String storeType ,String username,String password)
//{
//	
//	try
//	{
//		Properties prop=new Properties();
//		
//		prop.put("mail.pop3.host", host);
//		prop.put("mail.pop3.port", "995");
//		prop.put("mail.pop3.starttls.enable", "true");
//		Session emailSession = Session.getDefaultInstance(prop);
//		
//		
//		Store store = emailSession.getStore("pop3s");
//		
//		store.connect(host,username,password);
//		
//		Folder emailFolder =store.getFolder("INBOX");
//		emailFolder.open(Folder.READ_ONLY);
//		
//		Message messages[]=emailFolder.getMessages();
//		
// 		for(int i=messages.length-3;i<messages.length;i++)
// 		{
// 			Message message=messages[i];
// 			System.out.println("Email Number:  "+i+1);
// 			System.out.println("Subject:  "+message.getSubject());
// 			System.out.println("From:  "+message.getFrom()[0]);
//			System.out.println("Sent date:  "+message.getSentDate());
// 		}
// 		
// 		emailFolder.close(false);
// 		store.close();
//		
//	}
//	catch(Exception e)
// 	{
// 		e.printStackTrace();
// 	}
	
//}
		  void fetchEmail()
		  {
			  try {
					pst = con.prepareStatement("select emailid from teachersdata ");
					ArrayList<String> specialteacher = new ArrayList<String>(Arrays.asList());
					ResultSet rs = pst.executeQuery();
				
					
					while(rs.next())
					{
						specialteacher.add(rs.getString("emailid"));
					}
					
					listab.getItems().addAll(specialteacher);
					
					
		    	}
		    	
		    	
		    	
		    	catch (SQLException e) {
					e.printStackTrace();
					}
		  }
    
    Connection con;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	con=DatabaseConnector.getConnection();
    	//reciveEm();
        fetchEmail();
    	
    	//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("comboboxx/combobox.fxml")); 
		//Scene scene = new Scene(root);
		//Stage stage=new Stage();
		//stage.setScene(scene);
		//stage.show();
		
		
		//to hide the opened window
		 
		 //  Scene scene1=(Scene)btnSubmit.getScene();
		 //  scene1.getWindow().hide();
         
// 		Properties properties=new Properties();
// 		//properties.setProperty("mail.imaps.host","imaps.gmail.com");
// 	//	properties.setProperty("mail.imaps.port","993");
// 		properties.setProperty("mail.imap.ssl.enable", "true");
// 		//properties.setProperty("mail.imaps.auth","true");
// 		
// 		properties.setProperty("mail.store.protocol","imaps");
// 		properties.put("mail.imaps.ssl.checkserveridentity", "false");
// 		properties.put("mail.imaps.ssl.trust", "*");
// 		MailSSLSocketFactory sf= new MailSSLSocketFactory();
// 		sf.setTrustAllHosts(true);
// 		properties.put("mail.imaps.ssl.socketFactory",sf );
// 		Session session =Session.getDefaultInstance(properties);
// 		Store emailStore=session.getStore("imaps");
// 		
// 		
// 		emailStore.connect("imaps.gmail.com",username,password);
// 		
// 		Folder emailFolder=emailStore.getFolder("INBOX");
// 		
// 		emailFolder.open(Folder.READ_ONLY);
// 		Message messages[]=emailFolder.getMessages();
// 		
// 		for(int i=messages.length-3;i<messages.length;i++)
// 		{
// 			Message message=messages[i];
// 			System.out.println("Email Number:  "+i+1);
// 			System.out.println("Subject:  "+message.getSubject());
// 			System.out.println("From:  "+message.getFrom()[0]);
// 			System.out.println("Sent date:  "+message.getSentDate());
// 		}
// 		emailFolder.close(false);
// 		emailStore.close();
// 	}
 //	
// 	catch(Exception e)
// 	{
// 		e.printStackTrace();
// 	}
		 

    }
}
