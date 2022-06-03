/**
 * Sample Skeleton for 'SelectionModule.fxml' Controller Class
 */

package selection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

//import customermeasure.DataBaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class SelectionModuleController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="combodepart"
    private ComboBox<String> combodepart; // Value injected by FXMLLoader


    @FXML // fx:id="combosemester"
    private ComboBox<String> combosemester; // Value injected by FXMLLoader

    @FXML // fx:id="combosubject"
    private ComboBox<String> combosubject; // Value injected by FXMLLoader

    PreparedStatement pst;
    @FXML
    void dogo(ActionEvent event) 
    {

    }
    
    
    @FXML
    void doDepart(ActionEvent event) 
    
    {

    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combodepart.getSelectionModel().getSelectedItem();
    	String semselect = combosemester.getSelectionModel().getSelectedItem();
    		
    	try {
			pst = con.prepareStatement("select subject from selection where department like ? and sem like ? ");
			pst.setString(1, "%" + departselect + "%");
			pst.setString(2, "%" + semselect + "%" );
			ResultSet rs = pst.executeQuery();
		//doSemester();
			//helo();
			
			while(rs.next())
			{
				specialsubject.add(rs.getString("subject"));
			}
			combosubject.getItems().clear();
			combosubject.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    }

    @FXML
    void doSemester(ActionEvent event) 
    
    {
    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combodepart.getSelectionModel().getSelectedItem();
    	String semselect = combosemester.getSelectionModel().getSelectedItem();
    		
    	try {
			pst = con.prepareStatement("select subject from selection where department like ? and sem like ? ");
			pst.setString(1, "%" + departselect + "%");
			pst.setString(2, "%" + semselect + "%" );
			ResultSet rs = pst.executeQuery();
		//doSemester();
			//helo();
			
			while(rs.next())
			{
				specialsubject.add(rs.getString("subject"));
			}
			combosubject.getItems().clear();
			combosubject.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}

//    	ArrayList<String> specialsubjectt = new ArrayList<String>(Arrays.asList());
//    	String departselect = combodepart.getSelectionModel().getSelectedItem();
//    	String semselect = combosemester.getSelectionModel().getSelectedItem();
//    		
//    	try {
//			pst = con.prepareStatement("select subject from selection where sem like ?");
//			//pst.setString(1, "%" + departselect + "%");
//			pst.setString(1, "%" + semselect + "%" );
//			ResultSet rs = pst.executeQuery();
//			
//			while(rs.next())
//			{
//				specialsubjectt.add(rs.getString("subject"));
//			}
//			combosubject.getItems().clear();
//			combosubject.getItems().addAll(specialsubjectt);	
//    	}
//    	catch (SQLException e) {
//			e.printStackTrace();
//			}
    	
    }
    
    void helo()
    {
    	ArrayList<String> specialsubjectt = new ArrayList<String>(Arrays.asList());
        //	String departselect = combodepart.getSelectionModel().getSelectedItem();
        	String semselect = combosemester.getSelectionModel().getSelectedItem();
        		
        	try {
    			pst = con.prepareStatement("select subject from selection where sem like ?");
    			//pst.setString(1, "%" + departselect + "%");
    			pst.setString(1, "%" + semselect + "%" );
    			ResultSet rs = pst.executeQuery();
    			
    			while(rs.next())
    			{
    				specialsubjectt.add(rs.getString("subject"));
    			}
    			combosubject.getItems().clear();
    			combosubject.getItems().addAll(specialsubjectt);	
        	}
        	catch (SQLException e) {
    			e.printStackTrace();
    			}
    }
    
    @FXML
    void doSmartWork(ActionEvent event) 
    {
    	
    	
    	
    	
    }
    Connection con;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	con=DatabaseConnector.getConnection();
    	
    	String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
    			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
    			,"University Business School"};
    	combodepart.getItems().addAll(Arrays.asList(arr));
    	
    	String arr1[]= {"1","2","3","4","5","6","7","8"};
    	combosemester.getItems().addAll(Arrays.asList(arr1));
    	
    }

    
}

