/**
 * Sample Skeleton for 'TeacherPerView.fxml' Controller Class
 */

package teacherpermission;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

public class TeacherPerViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtname"
    private TextField txtname; // Value injected by FXMLLoader

    @FXML // fx:id="txtsem"
    private TextField txtsem; // Value injected by FXMLLoader

    @FXML // fx:id="txtemail"
    private TextField txtemail; // Value injected by FXMLLoader

    @FXML // fx:id="txtdprt"
    private TextField txtdprt; // Value injected by FXMLLoader

    @FXML // fx:id="txtuser"
    private TextField txtuser; // Value injected by FXMLLoader

    @FXML // fx:id="txtpass"
    private TextField txtpass; // Value injected by FXMLLoader

    @FXML // fx:id="combostatus"
    private ComboBox<String> combostatus; // Value injected by FXMLLoader
    
    @FXML // fx:id="listemail"
    private ListView<String> listemail; // Value injected by FXMLLoader

    PreparedStatement pst;
    @FXML
    void dofetchee(ActionEvent event)
    {
    	ArrayList<String> specialemail = new ArrayList<String>(Arrays.asList());
    	try {
    		pst=con.prepareStatement("select email from registration where status =?");
    		
    		pst.setString(1, "null");
    		ResultSet rs = pst.executeQuery();
    		
    		
    		while(rs.next())
    		{
    			specialemail.add(rs.getString("email"));
    		}
    		
    		listemail.getItems().addAll(specialemail);
    		
    		

    	} 
    	catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    }

    
    @FXML
    void doFetchemail(MouseEvent event)
    {
//    	ArrayList<String> specialemail = new ArrayList<String>(Arrays.asList());
//try {
//	pst=con.prepareStatement("select email from registration where status =?");
//	
//	pst.setString(1, "false");
//	ResultSet rs = pst.executeQuery();
//	
//	
//	while(rs.next())
//	{
//		specialemail.add(rs.getString("email"));
//	}
//	
//	listemail.getItems().addAll(specialemail);
//	
//	
//
//} 
//catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} 
    }
    
    @FXML
    void doDone(ActionEvent event) 
    {
    	try {
    		pst=con.prepareStatement("update registration set status=? where email=?");
    		
    		
    		pst.setString(1,combostatus.getSelectionModel().getSelectedItem());
    		System.out.println(combostatus.getSelectionModel().getSelectedItem());
    		
    		pst.setString(2, txtemail.getText());
    		
    		
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
    }

    @FXML
    void doFetch(ActionEvent event) 
    {
    	try{
    		pst=con.prepareStatement("select * from registration where email=?");
    		pst.setString(1, txtemail.getText());
    	ResultSet table=pst.executeQuery();
    	while(table.next())
    	{
    		String name=table.getString("name");
    		String depart=table.getString("department");
    		String semester=table.getString("semester");
    		String user=table.getString("username");
    		String pass=table.getString("password");
    		 
    		
    		
    		
    		System.out.println(name+"   "+depart+"   "+semester+"   "+user+"   "+pass+"   ");
    		txtname.setText(name);
    		txtsem.setText(depart);
    		txtdprt.setText(depart);
    		txtuser.setText(user);
    		txtpass.setText(pass);
    		
    		}
    	}
    	catch(Exception exp)
    	{ 
    		exp.printStackTrace();
    	}
    }

    void showMsg1(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize()
    {
    	con=DatabaseConnector.getConnection();
        String arr[]={"true","false"};
        combostatus.getItems().addAll(Arrays.asList(arr));

    }
}

