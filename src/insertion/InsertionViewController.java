/**
 * Sample Skeleton for 'InsertionView.fxml' Controller Class
 */

package insertion;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import registration.DatabaseConnector;

public class InsertionViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboD"
    private ComboBox<String> comboD; // Value injected by FXMLLoader

    @FXML // fx:id="comboS"
    private ComboBox<String> comboS; // Value injected by FXMLLoader

    @FXML // fx:id="comboSu"
    private ComboBox<String> comboSu; // Value injected by FXMLLoader
    
    PreparedStatement pst;

    @FXML
    void doSave(ActionEvent event)
    {
    	
    	String str=comboD.getSelectionModel().getSelectedItem();
    	String str1=comboS.getSelectionModel().getSelectedItem();
    	String str2=comboSu.getSelectionModel().getSelectedItem();
if(str.equals("") && str1.equals("") && str2.equals(""))
{
	showMsg2("Please fill the required fields");
}
else
{
    	try {
    		pst=con.prepareStatement("insert into selection value(?,?,?)");
    		pst.setString(1,comboD.getSelectionModel().getSelectedItem());
    		pst.setString(2, comboS.getSelectionModel().getSelectedItem());
    		pst.setString(3,comboSu.getSelectionModel().getSelectedItem());
    		
    		pst.executeUpdate();
    		
    	//	System.out.println(comboD.getSelectionModel().getSelectedItem());
    		
    		System.out.println("Done");
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	showMsg2("saved successfully");
    }
    }
    
    void showMsg2(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    void open() throws IOException, URISyntaxException
    {
    	
		//	Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/"));
		   // Desktop.getDesktop().mail();
		
		
        
		//	Desktop.getDesktop().open(new File("C:\\Python27\\news.txt"));
		
			//Desktop.getDesktop().open(new File("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\XAMPP"));
			//Desktop.getDesktop().open(new File("C:\\xampp\\xampp-control.exe"));
    
    	
    
    }
    Connection con;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
    	con=DatabaseConnector.getConnection();
    
         

    	String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
    			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
    			,"University Business School"};
    	comboD.getItems().addAll(Arrays.asList(arr));
    	
    	String arr1[]= {"1","2","3","4","5","6","7","8"};
    	comboS.getItems().addAll(Arrays.asList(arr1));
    	
    	String arr2[]= {"Engineering Mathematics-I",
    			 "Engineering Physics",
    			 "Engineering Chemistry",
    			 "Systems in Mechanical Engineering",
    			 "Basic Electrical Engineering / Basic Electronics Engineering",
    			 "Programming and Problem Solving / Engineering Mechanics",
    			 "Workshop",
    			 "Engineering Mathematics-II",
    			" Engineering Physics/ Engineering Chemistry",
    			" Basic Electrical Engineering / Basic Electronics Engineering",
    			" Programming and Problem Solving / Engineering Mechanics",
    			" Engineering Graphics (Engineering Drawing)",
    			" Project-Based Learning",
    			 "Physical Education-Exercise and Field Activities",
    			" Building Technology and Architectural Planning",
    			" Mechanics of structure",
    			" Fluid Mechanics",
    			" Engineering Mathematics III",
    			 "Engineering Geology",
    			 "Awareness to civil Engineering Practices / Road Safety Management / Foreign Language",
    			" Geotechnical Engineering",
    			 "Survey",
    			 "Concrete Technology",
    			 "Structural Analysis",
    			 "Project management",
    			 "Project-Based Learning",
    			" Hydrology and water resource engineering.",
    			 "Infrastructure Engineering and Construction Techniques",
    			" Structural Design –I",
    			" Structural analysis – II",
    			 "Fluid Mechanics – II",
    			" Advanced Surveying",
    			 "Project Management and Engineering Economics",
    			" Foundation Engineering",
    			" Structural Design – II",
    			" Environmental Engineering – I",
    			"Environmental Engineering II",
    			"Transportation Engineering",
    			"Structural Design and Drawing III",
    			"Elective – I",
    			"Elective –II",
    			"Dams and Hydraulic Structures",
    			"Quantity Surveying, Contracts, and Tenders",
    			"Elective –III",
    			"Elective – IV",
    			
    			"echnical English",
    			"Engineering Mathematics – II",
    			"Engineering Mathematics– I	",
    		   "Environmental Science and Engineering",
    			"Engineering Physics",
    			"Data Structures & Algorithms",
    			"Engineering Chemistry",
    			"Object-Oriented Programming Using C ++",
    			"Computer-Aided Engineering Drawing",
    			"Personality Development and Soft skills",
    			"Computer Programming",
    			"Java Programming",
    	    	"Computer Programming Lab",
    			"Data Structures & Algorithms Lab",
    			"Engineering Practices Lab-I",
    			"Object Oriented Programming Lab",
    			"Communication Skills Lab-I	",
    			"Engineering Practices Lab-I",
    			"Physics lab",
    		   "Java Programming Lab",
    		   "Chemistry Lab	",
    			"Aptitude-I",
    			
    			
    			"Engineering Mathematics – III",
    			"Operating Systems",
    		    "Design and Analysis of Algorithms",
    			"Probability and Statistics",
    		   "Database Management Systems",
    			"Design Project-I",
    			"Digital Systems	",
    			"Principles of Programming Language",
    			"Computer Networks and Circuit Theory",
    			"Digital Electronics & Logic Design",
    	     	"Microprocessor & Computer Architecture"	,
    			"Operating System Lab",
    			"Algorithms Lab",
    		   "Computer Organisation",
    			"Database Management Systems Lab	",
    			"Computer Organisation Lab",
    		   "Networking Lab	",
    		   "Principles of Programming Language Lab",
    			"Aptitude-II",
    		   "Digital Electronics & Logic Design Lab",
    		    "Microprocessor and Microcontroller Lab",
    		   "Aptitude-III",
    			
    		   "Discrete Mathematics",
    			"Principles of Compiler",
    		   "Theory of Computation",
    			"Design Modern Software Engineering",
    			"Web Technology	",
    		   "Engineering Elective-I",
    		   "System Software Engineering	",
    		   "Engineering Elective-II",
    	     	"Open Elective-I ",
    		   "Open elective-II",
    		   "Elective-I",
    	    	"Engineering Elective-II",
    		   "Web Technology Lab	",
    			"Compiler Design Lab",
    			"System Software Lab",
    	    	"Software Engineering Lab",
    		   "Skill development in programming",
    		   "Comprehension and Communication Skills Lab",
    		"Design Project-II	",
    		   "Elective Lab-II",
    			"Placement Preparatory Program",
    		   "Personality Development Lab",
    		   "Elective Lab-I",
    		   "Elective Lab-III",
    			
    			"Data Warehousing and Data Mining",
    		   "Project / Internship",
    		   "Mobile Computing ",
    			"Viva-voce",
    			"Professional Elective-I",
    			"Seminar",
    			"Professional Elective-II ",
    			"Research Paper Publication",
    			"Professional Elective-III	",
    			"Open Elective-III	",
    			"Engineering Elective-V 	",
    		   "Software Design Project – III	",
    	     	"Data Mining Lab	",
    	     	"Viva-voce",};
    			
    	
    	
    	
    	
    	comboSu.getItems().addAll(Arrays.asList(arr2));
    			
    			 

    }
}


