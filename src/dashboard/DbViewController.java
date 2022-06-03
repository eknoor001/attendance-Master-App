
package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DbViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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
    void doCalculation(ActionEvent event) 
    {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("calculation/CalcView.fxml")); 
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
    void doInsert(ActionEvent event) 
    {
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
    void doRetreive(ActionEvent event)
    {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("calculationtable/Cview.fxml")); 
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
    void doStudent(ActionEvent event) 
    {
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
    void dodevelopers(ActionEvent event)
    {
try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("developer/DView.fxml")); 
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
