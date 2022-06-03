/**
 * Sample Skeleton for 'LoginnewView.fxml' Controller Class
 */

package loginnew;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import registration.DatabaseConnector;

public class LoginnewViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtuser"
    private TextField txtuser; // Value injected by FXMLLoader

    @FXML // fx:id="txtpass"
    private PasswordField txtpass; // Value injected by FXMLLoader

    @FXML // fx:id="txtusername"
    private TextField txtusername; // Value injected by FXMLLoader

    @FXML // fx:id="txtpassword"
    private PasswordField txtpassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnlogin"
    private Button btnlogin; // Value injected by FXMLLoader

    @FXML // fx:id="tecregis"
    private Hyperlink tecregis; // Value injected by FXMLLoader

    @FXML // fx:id="sturegis"
    private Hyperlink sturegis; // Value injected by FXMLLoader
    
    PreparedStatement pst;

    @FXML
    void doRegister(ActionEvent event) 
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

    @FXML
    void dologin(ActionEvent event) 
    {
    	try {
			
			String query= "select * from registration where username= ? and password=? and status=? ";
			con=DriverManager.getConnection("jdbc:mysql://localhost/attendance_module","root","");
			pst=con.prepareStatement(query);
			ResultSet rs= null;
			
			
			
			pst.setString(1, txtusername.getText());
			pst.setString(2, txtpassword.getText());
			pst.setString(3, "true");
			//pst.setString
			
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
				if(txtusername.getText()=="" || txtpassword.getText()=="")
				{
					showMsg1("Please fill both required fields only then you can enter");
				}
				
				else
				{
					showMsg("wrong information");
				}
				
			}
			
			//Scene scene1=(Scene)btnlogin.getScene();
			 //  scene1.getWindow().hide();
			
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
    void dologinn(ActionEvent event)
    {
    	String str=txtuser.getText();
		String str1=txtpass.getText();
		System.out.println(str+ "  "+str1);
	
	if(str.matches("admin") && str1.matches("gzsccet"))
	{
	try { 
		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("dashboardadmin/DAView.fxml")); 
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
	}else {
		
		showMsg("Wrong Information");
	}
        }

    
    
    

    @FXML
    void doregister(ActionEvent event)
    {
    	try {
    		
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("registration/NewRegistration.fxml")); 
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
        //	Scene scene1=(Scene)tecregis.getScene();
    		//   scene1.getWindow().hide();
    }
    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	con=DatabaseConnector.getConnection();

    }
}


