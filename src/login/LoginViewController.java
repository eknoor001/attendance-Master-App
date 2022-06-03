package login;

/**
 * Sample Skeleton for 'LoginView.fxml' Controller Class
 */


//import registration.DatabaseConnector;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.management.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;



public class LoginViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtusername"
    private TextField txtusername; // Value injected by FXMLLoader

    @FXML // fx:id="txtpassword"
    private PasswordField txtpassword; // Value injected by FXMLLoader
    
    @FXML
    private Button btnlogin;

    @FXML
    private Hyperlink tecregis;

    @FXML
    private Hyperlink sturegis;

    PreparedStatement pst;
    
    @FXML
    void dologin(ActionEvent event)
    {
    	

			try {
				
				String query= "select * from registration where username= ? and password=?  ";
				con=DriverManager.getConnection("jdbc:mysql://localhost/attendance_module","root","");
				pst=con.prepareStatement(query);
				ResultSet rs= null;
				
				
				
				pst.setString(1, txtusername.getText());
				pst.setString(2, txtpassword.getText());
				
				rs=pst.executeQuery();
				
				
				
				if(rs.next())
					
				{
					
					
						try {
							
							Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("dashboard/DbView.fxml")); 
							Scene scene = new Scene(root);
							//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Stage stage=new Stage();
						    stage.setScene(scene);
						    stage.show();
					       }    
					       catch(Exception e) 
					       {
						     e.printStackTrace();
					        }
					
					
						
					
					
					}
				else
				{
					if(txtusername.getText()=="" && txtpassword.getText()=="")
					{
						showMsg1("Please fill both required fields only then you can enter");
					}
					else
					{
						showMsg("Wrong Information");
					}
					
				}
				
				Scene scene1=(Scene)btnlogin.getScene();
				   scene1.getWindow().hide();
				
				//showMsg("Wrong Information");

			}
			
			catch(Exception exp)
	    	{ 
	    		exp.printStackTrace();
	    	}
			
			
           
    	
    	
    	

    	
    	
    }
    
    void showMsg1(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("WARNING");
    	alert.setContentText(msg);
    	alert.show();
    }

    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    @FXML
    void doregister(ActionEvent event)
    {
    	
    	
    	try {
		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("passkey/PassKeyView.fxml")); 
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage=new Stage();
	    stage.setScene(scene);
	    stage.show();
       }    
       catch(Exception e) 
       {
	     e.printStackTrace();
        }
    	Scene scene1=(Scene)tecregis.getScene();
		   scene1.getWindow().hide();

    }
    
    @FXML
    void doRegisterStudents(ActionEvent event) 
    {
    	try{Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("studentregistration/StudentRegisView.fxml")); 
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage=new Stage();
	    stage.setScene(scene);
	    stage.show();
       }    
       catch(Exception e) 
       {
	     e.printStackTrace();
        }
    	 Scene scene1=(Scene)tecregis.getScene();
		   scene1.getWindow().hide();
    }
    
    private void Tooltip()
    {
    	javafx.scene.control.Tooltip usertip = new javafx.scene.control.Tooltip();
    	usertip.setText("Please enter your username");
    	txtusername.setTooltip(usertip);
    	
    	javafx.scene.control.Tooltip usertipp = new javafx.scene.control.Tooltip("Please enter your password");
    	txtpassword.setTooltip(usertipp);
    	
    	
    }

Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
        Tooltip();

    }
}
