/**
 * Sample Skeleton for 'DAView.fxml' Controller Class
 */

package dashboardadmin;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class DAViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btngo"
    private Button btngo; // Value injected by FXMLLoader
    @FXML
    void doAttendance(ActionEvent event) 
    {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("attendancetaking/AttendanceView.fxml")); 
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

    @FXML
    void doCalcu2(ActionEvent event) {
    	try {
        	
    	    
        	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("calculationtable/Cview.fxml")); 
    		Scene scene = new Scene(root);
    		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage stage=new Stage();
    	    stage.setScene(scene);
    	    stage.show();
        } catch(Exception e) 
        {
    	     e.printStackTrace();
         }
    }

    @FXML
    void doCalu1(ActionEvent event) 
    {try {
    	
    
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("calculation/CalcView.fxml")); 
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage=new Stage();
	    stage.setScene(scene);
	    stage.show();
    } catch(Exception e) 
    {
	     e.printStackTrace();
     }
      
    }

    @FXML
    void doClose(ActionEvent event) 
    {
    	Scene scene1=(Scene)btngo.getScene();
		   scene1.getWindow().hide();
    }

    @FXML
    void doInsertion(ActionEvent event) {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("insertion/InsertionView.fxml")); 
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

    @FXML
    void doOpendatabase(ActionEvent event) 
    {
    	try {
			Desktop.getDesktop().open(new File("C:\\xampp\\xampp-control.exe"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doPermission(ActionEvent event) 
    {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("teacherpermission/TeacherPerView.fxml")); 
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

    @FXML
    void doStudentRegistration(ActionEvent event) {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("studentregistration/StudentRegisView.fxml")); 
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

    @FXML
    void doTeachersRegistration(ActionEvent event) 
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
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}

