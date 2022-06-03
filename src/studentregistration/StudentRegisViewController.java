/**
 * Sample Skeleton for 'StudentRegisView.fxml' Controller Class
 */

package studentregistration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class StudentRegisViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtname"
    private TextField txtname; // Value injected by FXMLLoader

    @FXML // fx:id="txtcrn"
    private TextField txtcrn; // Value injected by FXMLLoader

    @FXML // fx:id="combodprt"
    private ComboBox<String> combodprt; // Value injected by FXMLLoader

    @FXML // fx:id="combosemester"
    private ComboBox<String> combosemester; // Value injected by FXMLLoader

    @FXML // fx:id="txturn"
    private TextField txturn; // Value injected by FXMLLoader

    @FXML // fx:id="combobatch"
    private ComboBox<String> combobatch; // Value injected by FXMLLoader

    @FXML // fx:id="txtemail"
    private TextField txtemail; // Value injected by FXMLLoader

    @FXML // fx:id="combosection"
    private ComboBox<String> combosection; // Value injected by FXMLLoader

    PreparedStatement pst;
    @FXML
    void doDelete(ActionEvent event) 
    {
    	try {
    		pst=con.prepareStatement("delete from studentdata where urn=?");
    		pst.setString(1, txturn.getText());
    		int count=pst.executeUpdate();
    		if(count==0)
    		{
    			System.out.println("Wrong Id Please Check again");
    			showMsg1("Failed to delete");
    		}
    		else
    		{
    			System.out.println(count+" records deleted");
    			showMsg1("delete successfully");
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }

    @FXML
    void doSave(ActionEvent event) 
    {
    	if(txtname.getText()=="" || combodprt.getEditor().getText()=="" || txtcrn.getText()==""|| combosemester.getEditor().getText()==""
    			||txturn.getText()==""||combobatch.getEditor().getText()==""||txtemail.getText()=="")
    	{
    		
    		showMsg3("Please fill both required fields only then you can enter");
    		
    	}
    	else {
try
    	{
    		pst=con.prepareStatement("insert into studentdata value(?,?,?,?,?,?,?,?)");
    		pst.setString(1, txtname.getText());
    		pst.setString(2,combodprt.getSelectionModel().getSelectedItem());
    		pst.setString(3,combosemester.getSelectionModel().getSelectedItem());
    		pst.setString(4, txtcrn.getText());
    		pst.setString(5, txturn.getText());
    		pst.setString(6, combosection.getSelectionModel().getSelectedItem());
    		pst.setString(7, combobatch.getSelectionModel().getSelectedItem());
    		pst.setString(8, txtemail.getText());
    		
    		
    		pst.executeUpdate();
    		
    		System.out.println("Done");
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
showMsg3("Save successfully");


    }}

    void showMsg3(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    @FXML
    void doUpdate(ActionEvent event) 
    {
    	if(txtname.getText()=="" || combodprt.getEditor().getText()=="" || txtcrn.getText()==""|| combosemester.getEditor().getText()==""
    			||txturn.getText()==""||combobatch.getEditor().getText()==""||txtemail.getText()=="")
    	{
    		
    		showMsg3("Please fill both required fields only then you can enter");
    		
    	}
    	else {
    	try {
    		pst=con.prepareStatement("update studentdata set name=?,depart=?,semester=?,crn=?,section=?,batch=?,email=? where urn=?");
    		
    		pst.setString(1, txtname.getText());
    		pst.setString(2,combodprt.getEditor().getText());
    		pst.setString(3, combosemester.getEditor().getText());
    		pst.setString(4, txtcrn.getText());
    		pst.setString(5, combosection.getEditor().getText());
    		
    		
    		pst.setString(6,combobatch.getEditor().getText());
    		pst.setString(7, txtemail.getText());
    		pst.setString(8, txturn.getText());
    		
    		
		    int count=pst.executeUpdate();
    		if(count==0)
    		{
    			System.out.println("Invalid Id");
    			showMsg1("Sorry not updated");
    		}
    		else
    		{
    			System.out.println(count+" Records Updated");
    			showMsg1("Updated successfully");
    		}
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    		}}
    	
    
void showMsg1(String msg)
{
	Alert alert=new Alert(AlertType.INFORMATION);
	alert.setTitle("Its Result");
	alert.setContentText(msg);
	alert.show();
}
    
    @FXML
    void doSearch(ActionEvent event)
    {
    	try{
    		pst=con.prepareStatement("select * from studentdata where urn=?");
    		pst.setString(1, txturn.getText());
    	ResultSet table=pst.executeQuery();
    	while(table.next())
    	{
    		String name=table.getString("name");
    		String depart=table.getString("depart");
    		String semester=table.getString("semester");
    		String crn=table.getString("crn");
    		String email=table.getString("email");
    		 
    		String section=table.getString("section");
    		
    		
    		String batch=table.getString("batch");
    
    		
    		
    		System.out.println(name+"   "+depart+"   "+semester+"   "+crn+"   "+email+"   "+section+"   "+batch);
    		txtname.setText(name);
    		combodprt.getEditor().setText(depart);
    		combosemester.getEditor().setText(semester);
    		txtcrn.setText(crn);
    		txtemail.setText(email);
    		combosection.getEditor().setText(section);
    		combobatch.getEditor().setText(batch);
    		}
    	}
    	catch(Exception exp)
    	{ 
    		exp.printStackTrace();
    	}
    	
    	
    }
    
    @FXML
    void doRefresh(ActionEvent event) 
    {
    	txtname.setText(" ");
    	combodprt.getSelectionModel().clearSelection();
    	combobatch.getSelectionModel().clearSelection();
    	combosemester.getSelectionModel().clearSelection();
    	combosection.getSelectionModel().clearSelection();
        txturn.setText(" ");
        txtcrn.setText(" ");
        txtemail.setText(" ");
        combodprt.getEditor().setText("");
        combobatch.getEditor().setText("");
        combosection.getEditor().setText("");
        combosemester.getEditor().setText("");
        
    }
    private void Tooltip()
    {
    	javafx.scene.control.Tooltip usertip = new javafx.scene.control.Tooltip();
    	usertip.setText("Please enter your university roll no");
    	txturn.setTooltip(usertip);
    	
    	javafx.scene.control.Tooltip usertipp = new javafx.scene.control.Tooltip("Please enter your class roll no");
    	txtcrn.setTooltip(usertipp);
    	
    	javafx.scene.control.Tooltip usertippp = new javafx.scene.control.Tooltip("Please enter your email");
    	txtemail.setTooltip(usertippp);
    	
    	javafx.scene.control.Tooltip usertipppp = new javafx.scene.control.Tooltip("Please enter your name");
    	txtname.setTooltip(usertipppp);
    	
    	javafx.scene.control.Tooltip usertips = new javafx.scene.control.Tooltip("Please select you department");
    	combodprt.setTooltip(usertips);
    	
    	javafx.scene.control.Tooltip usertipps = new javafx.scene.control.Tooltip("Please select your batch");
    	combobatch.setTooltip(usertipps);
    	
    	javafx.scene.control.Tooltip usertippss = new javafx.scene.control.Tooltip("Please select  your semester");
    	combosemester.setTooltip(usertippss);
    	
    	javafx.scene.control.Tooltip usertippsss = new javafx.scene.control.Tooltip("Please select  your section");
    	combosection.setTooltip(usertippsss);
    	
    	
    	
    }
    
Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
       con= DatabaseConnector.getConnection();
       Tooltip();
       String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
   			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
   			,"University Business School"};
       combodprt.getItems().addAll(Arrays.asList(arr));
       
       String arr1[]= {"1","2","3","4","5","6","7","8"};
   	combosemester.getItems().addAll(Arrays.asList(arr1));
   	
   	String arr2[]= {"2018","2019","2020","2021","2022","2023"};
   	combobatch.getItems().addAll(Arrays.asList(arr2));
   	
   	String arr3[]= {"A","B","C"};
   	combosection.getItems().addAll(Arrays.asList(arr3));   	
   	
   	
    }
}
