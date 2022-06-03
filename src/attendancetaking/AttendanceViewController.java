
package attendancetaking;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AttendanceViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="combosection"
    private ComboBox<String> combosection; // Value injected by FXMLLoader

    @FXML // fx:id="combobranch"
    private ComboBox<String> combobranch; // Value injected by FXMLLoader

    @FXML // fx:id="datepickera"
    private DatePicker datepickera; // Value injected by FXMLLoader

    @FXML // fx:id="combosem"
    private ComboBox<String> combosem; // Value injected by FXMLLoader

    @FXML // fx:id="comboSubject"
    private ComboBox<String> comboSubject; // Value injected by FXMLLoader

    @FXML // fx:id="listviewstudents"
    private ListView<String> listviewstudents; // Value injected by FXMLLoader

    @FXML // fx:id="txturn"
    private TextField txturn; // Value injected by FXMLLoader

    @FXML // fx:id="txtcrn"
    private TextField txtcrn; // Value injected by FXMLLoader

    @FXML // fx:id="radiopresent"
    private RadioButton radiopresent; // Value injected by FXMLLoader

    @FXML // fx:id="radioabsent"
    private RadioButton radioabsent; // Value injected by FXMLLoader
    
    @FXML // fx:id="comboname"
    private ComboBox<String> comboname; // Value injected by FXMLLoader
    
    @FXML // fx:id="txthidden"
    private TextField txthidden; // Value injected by FXMLLoader

    @FXML // fx:id="listnew"
    private ListView<String> listnew; // Value injected by FXMLLoader
    
    @FXML // fx:id="Gem"
    private ToggleGroup Gem; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtnamee"
    private TextField txtnamee; // Value injected by FXMLLoader
    
    @FXML // fx:id="listkyabaathai"
    private ListView<String> listkyabaathai; // Value injected by FXMLLoader

    @FXML // fx:id="hiidencal"
    private TextField hiidencal; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtcount"
    private TextField txtcount; // Value injected by FXMLLoader
    
//    @FXML // fx:id="listAllpresent"
//    private ListView<String> listAllpresent; // Value injected by FXMLLoader

//    @FXML // fx:id="txthk"
//    private TextField txthk; // Value injected by FXMLLoader

   
    
    PreparedStatement pst;
    
//    @FXML
//    void doAllPr(MouseEvent event) 
//    {
//
//    }

    @FXML
    void doComboBranch(ActionEvent event) 
    {

    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combobranch.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    		
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
			comboSubject.getItems().clear();
			comboSubject.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	listviewstudents.getItems().clear();      
        listnew.getItems().clear();
        txtcount.setText("");
        hiidencal.setText("");
        if(radiopresent.isSelected())
		{
    	   radiopresent.setSelected(false);
		}
		else
			if(radioabsent.isSelected())
			{
				radioabsent.setSelected(false);
			}
    }

    @FXML
    void doComboSection(ActionEvent event) 
    {

    	listviewstudents.getItems().clear();      
        listnew.getItems().clear();
        txtcount.setText("");
        hiidencal.setText("");
        if(radiopresent.isSelected())
		{
    	   radiopresent.setSelected(false);
		}
		else
			if(radioabsent.isSelected())
			{
				radioabsent.setSelected(false);
			}
			
			
   
    }

    @FXML
    void doComboSemester(ActionEvent event) 
    {

    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combobranch.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    		
    	try {
			pst = con.prepareStatement("select subject from selection where department like ? and sem like ? ");
			pst.setString(1, "%" + departselect + "%");
			pst.setString(2, "%" + semselect + "%" );
			ResultSet rs = pst.executeQuery();
		
			
			while(rs.next())
			{
				specialsubject.add(rs.getString("subject"));
			}
			comboSubject.getItems().clear();
			comboSubject.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    	listviewstudents.getItems().clear();      
        listnew.getItems().clear();
        txtcount.setText("");
        hiidencal.setText("");
        if(radiopresent.isSelected())
		{
    	   radiopresent.setSelected(false);
		}
		else
			if(radioabsent.isSelected())
			{
				radioabsent.setSelected(false);
			}
    }
    
    @FXML
    void doHide(ActionEvent event) 
    {
    	
    	System.out.println(txthidden.getText());
    	
if(txthidden.getText()!="")
{
	ArrayList<String> special = new ArrayList<String>(Arrays.asList());
	ObservableList<String> all=	listviewstudents.getSelectionModel().getSelectedItems();
		
	try {
		pst = con.prepareStatement("select name,crn from studentdata where urn like ? ");
		pst.setString(1, "%" + all + "%");
		//pst.setString(2, "%" + semselect + "%" );
		ResultSet rs = pst.executeQuery();
	
		
		while(rs.next())
		{
			special.add(rs.getString("name"));
			special.add(rs.getString("crn"));
			
			System.out.println(special);
		}
		//comboSubject.getItems().clear();
		//listviewstudents.getItems().addAll(special);	
		//txturn.setText();
	}
	catch (SQLException e) {
		e.printStackTrace();
		}
}
    	
    	
    	
    }

    @FXML
    void doComboSubject(ActionEvent event) 
    {
    	listviewstudents.getItems().clear();      
        listnew.getItems().clear();
        txtcount.setText("");
        hiidencal.setText("");
        if(radiopresent.isSelected())
		{
    	   radiopresent.setSelected(false);
		}
		else
			if(radioabsent.isSelected())
			{
				radioabsent.setSelected(false);
			}
    	
    }
    

    @FXML
    void doListWork(MouseEvent event)
    {
    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
    	ArrayList<String> specialstudent3 = new ArrayList<String>(Arrays.asList());
    	String branchselect = combobranch.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    	String secselect = combosection.getSelectionModel().getSelectedItem();
       	String subselect = comboSubject.getSelectionModel().getSelectedItem();
    	String urn1=listviewstudents.getSelectionModel().getSelectedItem();
    	ArrayList<String> special = new ArrayList<String>(Arrays.asList());
    	ArrayList<String> special1 = new ArrayList<String>(Arrays.asList())	;
    	//specialstudent3=listviewstudents.getSelectionModel().getSelectedItem();

       //  if(listviewstudents.getSelectionModel().getSelectedItem()!="")
       //  {
       // 	 specialstudent3.add(listviewstudents.getSelectionModel().getSelectedItem());
        //	 listAllpresent.getItems().addAll(specialstudent3);
        // }
     	//String urn1=listUrn.getSelectionModel().getSelectedItem();
    	txthidden.setText(urn1);
    	//ArrayList<String> specialstudent1 = new ArrayList<String>(Arrays.asList());
    	String urn2=txthidden.getText();
    	try {
			pst = con.prepareStatement("select crn,name from studentdata where urn like ?");
			//pst = con.prepareStatement("select name from studentdata where urn like ?");
			
			pst.setString(1, "%" + txthidden.getText() + "%");
			
			ResultSet rs = pst.executeQuery();
	
			
			while(rs.next())
			{
				special1.add(rs.getString("name"));
				special.add(rs.getString("name"));
    			special.add(rs.getString("crn"));
   			
   			System.out.println(special);
   		//	System.out.println(special1);
 			listnew.getItems().clear();
 			listnew.getItems().addAll(special); 
    			String allItemss="";
    	    	for (String str : special1)
    	    	{
    					allItemss+=str+",";
    			}
    	    	txtnamee.setText("");
    	    	txtnamee.setText(allItemss.substring(0, allItemss.length()-1));
   			
   			   			}
    		
    	    
				
    
			pst = con.prepareStatement("select result from attendancedata where  subject = ? and sem like ? and section like ? and urn like ? and branch like ?");
			pst.setString(1, subselect );
			pst.setString(2, "%" + semselect + "%" );
			pst.setString(3, "%" + secselect + "%");
			pst.setString(4, "%" + urn1 + "%");
			pst.setString(5, "%" + branchselect + "%");
			
			
			ResultSet rss = pst.executeQuery();
	
			
			while(rss.next())
			{
				specialstudent.add(rss.getString("result"));
			}
			listkyabaathai.getItems().clear();
			listkyabaathai.getItems().addAll(specialstudent);	
			
			 int sum=0;
			 ObservableList<String> amounts= listkyabaathai.getItems();
			 
			int count=0;
			 for (String result : amounts) 
			 { 
				 sum+=Integer.parseInt(result); 
				 count++;
			 } 
			 System.out.println("total classes:"+count);
			 System.out.println("total attendance:"+sum);
			 hiidencal.setText(Integer.toString(sum));
			 txtcount.setText(Integer.toString(count));
			
    
    	}
    	catch (SQLException e) {
			e.printStackTrace();
    	}
    	
//    	ObservableList<String> all=	listviewstudents.getSelectionModel().getSelectedItems();
//    	ObservableList<String> alll=	listviewstudents.getSelectionModel().getSelectedItems();
//    	
//    	String allItems="";
//    	for (String str : all)
//    	{
//				allItems+=str+",";
//		}
//    	
//    	
//    	txthidden.setText(allItems.substring(0, allItems.length()-1));
//    	System.out.println(txthidden.getText());
//    	
//    	ArrayList<String> special = new ArrayList<String>(Arrays.asList());
//    	ArrayList<String> special1 = new ArrayList<String>(Arrays.asList());
//    	
//    		
//    	try {
//    		pst = con.prepareStatement("select name,crn from studentdata where urn like ? ");
//    		pst.setString(1, "%" + txthidden.getText() + "%");
//    		//pst.setString(2, "%" + semselect + "%" );
//    		ResultSet rs = pst.executeQuery();
//
//    		
//    		while(rs.next())
//    		{
//    			special1.add(rs.getString("name"));
//    			special.add(rs.getString("name"));
//    			special.add(rs.getString("crn"));
//    			
//    			System.out.println(special);
//    			System.out.println(special1);
//    			listnew.getItems().clear();
//    			listnew.getItems().addAll(special); 
//    			String allItemss="";
//    	    	for (String str : special1)
//    	    	{
//    					allItemss+=str+",";
//    			}
//    	    	txtnamee.setText("");
//    			txtnamee.setText(allItemss.substring(0, allItemss.length()-1));
//    			
//    			
//    			}
//    		
//    	    	
//    	}
//    	catch (SQLException e) {
//    		e.printStackTrace();
//    		}
//    	    	
//    	    }
		   
    	if(radiopresent.isSelected()||radioabsent.isSelected())
		{
    	   radiopresent.setSelected(false);
    	   radiopresent.setText("PRESENT");
	      
			
				radioabsent.setSelected(false);
				radioabsent.setText("ABSENT");
		}
    
    }
    
    
    @FXML
    void listkya(MouseEvent event) 
   {
    	
    	//int i=listkyabaathai.Items.Count;
    	
    	
//    	ArrayList<String> specialstudentt = new ArrayList<String>(Arrays.asList());
//    	String departselect = combobranch.getSelectionModel().getSelectedItem();
//    	String semselect = combosem.getSelectionModel().getSelectedItem();
//   
//    	String subjectselectt = comboSubject.getSelectionModel().getSelectedItem();
//    	
//    	try {
//			pst = con.prepareStatement("select result from attendancedata where branch like ? and sem like ? and subject like ? and urn like ? ");
//			pst.setString(1, "%" + departselect + "%");
//			pst.setString(2, "%" + semselect + "%" );
//			pst.setString(3, "%" + subjectselectt + "%" );
//			pst.setString(4, "%" + txthidden.getText() + "%" );
//			ResultSet rs = pst.executeQuery();
//		
//			
//			while(rs.next())
//			{
//				specialstudentt.add(rs.getString("result"));
//			}
//			
//			listkyabaathai.getItems().addAll(specialstudentt);
//			
//			
//    	}
//    	catch (SQLException e) {
//			e.printStackTrace();
//			}
    	
    }

    
    
   
    
    

    @FXML
    void doSave(ActionEvent event) 
    {
    	
boolean flag =  true;
    	
    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
    	String branchselect = combobranch.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    	String secselect = combosection.getSelectionModel().getSelectedItem();
       	String subselect = comboSubject.getSelectionModel().getSelectedItem();
    	String urn1=listviewstudents.getSelectionModel().getSelectedItem();
    
    
    	try {
    		if(flag == true)
    		{
			pst=con.prepareStatement("insert into attendancedata value(?,?,?,?,?,CURRENT_DATE,?,?,?,?,?)");
			pst.setString(1,combobranch.getSelectionModel().getSelectedItem());
			pst.setString(2, listviewstudents.getSelectionModel().getSelectedItems().toString());
			pst.setString(3,txtnamee.getText());
			pst.setString(4, comboSubject.getSelectionModel().getSelectedItem());
			pst.setString(5, combosection.getSelectionModel().getSelectedItem());
    
    	
    			if(radiopresent.isSelected())
    		{
    			String text= "1";
    			radiopresent.setText(text);
    		pst.setString(6, radiopresent.getText());
    		}
    		else
    			if(radioabsent.isSelected())
    			{String text= "0";
    	radioabsent.setText(text);
    				pst.setString(6,radioabsent.getText());	
    				
    			}
    			pst.setString(7, combosem.getSelectionModel().getSelectedItem());
    		String c1=txtcount.getText();
    		int c2=Integer.parseInt(c1);
            int c3=c2+1;
            if(radiopresent.isSelected())
            {
           String h1= 	hiidencal.getText();
          int h2= Integer.parseInt(h1);
          int h3=h2+1;
          pst.setString(8, Integer.toString(h3));
            }
            else
            {
            	//String h4=hiidencal.getText();
            	pst.setString(8, hiidencal.getText());
            }

    		//	pst.setString(8, hiidencal.getText());
    			pst.setString(9, Integer.toString(c3));
    			
    			String c4=txtcount.getText();
        		int c5=Integer.parseInt(c4);
                int c6=c5+1;
                if(radiopresent.isSelected())
                {
               String h4= 	hiidencal.getText();
              int h5= Integer.parseInt(h4);
              int h6=h5+1;
              float h7=h6;
              float percentage=((h7)*100)/(c6);
              pst.setString(10, Float.toString(percentage));
  			
                }
                else
                {
                	float percentage=((Float.parseFloat(hiidencal.getText()))*100)/(c6);
                    pst.setString(10, Float.toString(percentage));
                }

        		//	pst.setString(8, hiidencal.getText());
        			pst.setString(9, Integer.toString(c6));
    			
    			
    			pst.executeUpdate();
    	
    			flag = false;
    		}
    		if(flag == false)
    		{
    	
    		
 
    			pst = con.prepareStatement("select result from attendancedata where  subject = ? and sem like ? and section like ? and urn like ? and branch like ?");
    			pst.setString(1, subselect );
    			pst.setString(2, "%" + semselect + "%" );
    			pst.setString(3, "%" + secselect + "%");
    			pst.setString(4, "%" + urn1 + "%");
    			pst.setString(5, "%" + branchselect + "%");
    			
    			
    			ResultSet rs = pst.executeQuery();
    	
    			
    			while(rs.next())
    			{
    				specialstudent.add(rs.getString("result"));
    			}
    			listkyabaathai.getItems().clear();
    			listkyabaathai.getItems().addAll(specialstudent);	
    			
    			 int sum=0;
    			 int count=0;
    			 ObservableList<String> amounts= listkyabaathai.getItems();
    			 for (String pa : amounts) 
    			 { 
    				 sum+=Integer.parseInt(pa); 
    				 count++;
    			 } 
    			 System.out.println("total attendance:"+sum);
    			 hiidencal.setText(Integer.toString(sum));
    			 txtcount.setText(Integer.toString(count));
    			 

    			}
    		
    		
    	}
        
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
//    	try {
//    		pst=con.prepareStatement("insert into attendancedata value(?,?,?,?,?,current_date(),?,?)");
//    		pst.setString(1,combobranch.getSelectionModel().getSelectedItem());
//    		pst.setString(2, listviewstudents.getSelectionModel().getSelectedItems().toString());
//    		pst.setString(3, txtnamee.getText());
//    		pst.setString(4, comboSubject.getSelectionModel().getSelectedItem());
//    		pst.setString(5, combosection.getSelectionModel().getSelectedItem());
//    		//pst.setString(4, combosem.getSelectionModel().getSelectedItem());
//    		
//    		
//    		
//    		if(radiopresent.isSelected())
//    		{
//    			String text= "1";
//    			radiopresent.setText(text);
//    		pst.setString(6, radiopresent.getText());
//    		}
//    		else
//    			if(radioabsent.isSelected())
//    			{String text= "0";
//    			radioabsent.setText(text);
//    				pst.setString(6, radioabsent.getText());	
//    			}
//    		pst.setString(7, combosem.getSelectionModel().getSelectedItem());
//    		pst.executeUpdate();
//    		
//    		System.out.println("Done");
//    		
//    		
//    		
//    	} catch (SQLException e)
//    	{
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    	}
//    	
    	
    	
    }
    
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Its Result");
    	alert.setContentText(msg);
    	alert.show();
    }
    
//    @FXML
//    void doAllPRESENT(ActionEvent event)
//    {
//boolean flag =  true;
//    	
//    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
//    	ArrayList<String> special1 = new ArrayList<String>(Arrays.asList());
//    	ArrayList<String> special = new ArrayList<String>(Arrays.asList());
//String branchselect = combobranch.getSelectionModel().getSelectedItem();
//    	String semselect = combosem.getSelectionModel().getSelectedItem();
//    	String secselect = combosection.getSelectionModel().getSelectedItem();
//       	String subselect = comboSubject.getSelectionModel().getSelectedItem();
//    	//String urn1=listviewstudents.getSelectionModel().getSelectedItem();
//    	 ObservableList<String> amountss= listAllpresent.getItems();
//    	 for (String paa : amountss) 
//    	 { 
//    		 txthk.setText(paa);
//    		 
//    		 try {
//    				pst = con.prepareStatement("select crn,name from studentdata where urn like ?");
//    				//pst = con.prepareStatement("select name from studentdata where urn like ?");
//    				
//    				pst.setString(1, "%" + txthk.getText() + "%");
//    				
//    				ResultSet rs = pst.executeQuery();
//    		
//    				
//    				while(rs.next())
//    				{
//    					special1.add(rs.getString("name"));
//    					special.add(rs.getString("name"));
//    	    			special.add(rs.getString("crn"));
//    	   			
//    	   			System.out.println(special);
//    	   		//	System.out.println(special1);
//    	 			listnew.getItems().clear();
//    	 			listnew.getItems().addAll(special); 
//    	    			String allItemss="";
//    	    	    	for (String str : special1)
//    	    	    	{
//    	    					allItemss+=str+",";
//    	    			}
//    	    	    	txtnamee.setText("");
//    	    	    	txtnamee.setText(allItemss.substring(0, allItemss.length()-1));
//    	   			
//    				}   			}
//    		 catch (SQLException e) {
//    				// TODO Auto-generated catch block
//    				e.printStackTrace();
//    		}
//    	 
//    
//    	try {
//    		if(flag == true)
//    		{
//			pst=con.prepareStatement("insert into attendancedata value(?,?,?,?,?,CURRENT_DATE,?,?,?,?,?)");
//			pst.setString(1,combobranch.getSelectionModel().getSelectedItem());
//			pst.setString(2, txthk.getText());
//			pst.setString(3,txtnamee.getText());
//			pst.setString(4, comboSubject.getSelectionModel().getSelectedItem());
//			pst.setString(5, combosection.getSelectionModel().getSelectedItem());
//    
//			
//    			if(radiopresent.isSelected())
//    		{
//    			String text= "1";
//    			radiopresent.setText(text);
//    		pst.setString(6, radiopresent.getText());
//    		}
//    		else
//    			if(radioabsent.isSelected())
//    			{String text= "0";
//    	radioabsent.setText(text);
//    				pst.setString(6,radioabsent.getText());	
//    				
//    			}
//    			pst.setString(7, combosem.getSelectionModel().getSelectedItem());
//    		String c1=txtcount.getText();
//    		int c2=Integer.parseInt(c1);
//            int c3=c2+1;
//            if(radiopresent.isSelected())
//            {
//           String h1= 	hiidencal.getText();
//          int h2= Integer.parseInt(h1);
//          int h3=h2+1;
//          pst.setString(8, Integer.toString(h3));
//            }
//            else
//            {
//            	//String h4=hiidencal.getText();
//            	pst.setString(8, hiidencal.getText());
//            }
//
//    		//	pst.setString(8, hiidencal.getText());
//    			pst.setString(9, Integer.toString(c3));
//    			
//    			String c4=txtcount.getText();
//        		int c5=Integer.parseInt(c4);
//                int c6=c5+1;
//                if(radiopresent.isSelected())
//                {
//               String h4= 	hiidencal.getText();
//              int h5= Integer.parseInt(h4);
//              int h6=h5+1;
//              float h7=h6;
//              float percentage=((h7)*100)/(c6);
//              pst.setString(10, Float.toString(percentage));
//  			
//                }
//                else
//                {
//                	float percentage=((Float.parseFloat(hiidencal.getText()))*100)/(c6);
//                    pst.setString(10, Float.toString(percentage));
//                }
//
//        		//	pst.setString(8, hiidencal.getText());
//        			pst.setString(9, Integer.toString(c6));
//    			
//    			
//    			pst.executeUpdate();
//    			txtnamee.setText("");
//    	
//    			flag = false;
//    		}
//    		if(flag == false)
//    		{
//    	
//    		
// 
//    			pst = con.prepareStatement("select result from attendancedata where  subject = ? and sem like ? and section like ? and urn like ? and branch like ?");
//    			pst.setString(1, subselect );
//    			pst.setString(2, "%" + semselect + "%" );
//    			pst.setString(3, "%" + secselect + "%");
//    			pst.setString(4, "%" + txthk.getText() + "%");
//    			pst.setString(5, "%" + branchselect + "%");
//    			
//    			
//    			ResultSet rsa = pst.executeQuery();
//    	
//    			
//    			while(rsa.next())
//    			{
//    				specialstudent.add(rsa.getString("result"));
//    			}
//    			listkyabaathai.getItems().clear();
//    			listkyabaathai.getItems().addAll(specialstudent);	
//    			
//    			 int sum=0;
//    			 int count=0;
//    			 ObservableList<String> amounts= listkyabaathai.getItems();
//    			 for (String pa : amounts) 
//    			 { 
//    				 sum+=Integer.parseInt(pa); 
//    				 count++;
//    			 } 
//    			 System.out.println("total attendance:"+sum);
//    			 hiidencal.setText(Integer.toString(sum));
//    			 txtcount.setText(Integer.toString(count));
//    			 
//                  flag=true;
//    			}
//    		
//    		
//    	}
//        
//		 catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
//    	 }
//    	
//    }
    
    @FXML
    void doGo(ActionEvent event)
    {
    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
    	ArrayList<String> specialstudentt = new ArrayList<String>(Arrays.asList());
    	String departselect = combobranch.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    	String subjectselect = combosection.getSelectionModel().getSelectedItem();
    	String subjectselectt = comboSubject.getSelectionModel().getSelectedItem();
     		
    	try {
			pst = con.prepareStatement("select urn from studentdata where depart like ? and semester like ? and section like ? ORDER BY urn ASC ");
			pst.setString(1, "%" + departselect + "%");
			pst.setString(2, "%" + semselect + "%" );
			pst.setString(3, "%" + subjectselect + "%" );
			ResultSet rs = pst.executeQuery();
		
			
			while(rs.next())
			{
				specialstudent.add(rs.getString("urn"));
			}
			
			listviewstudents.getItems().addAll(specialstudent);
			
			
    	}
    	
    	
    	
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    	
    	
    }
    
    @FXML
    void dosomwthing(ActionEvent event) 
    {
//    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
//    	String branchselect = combobranch.getSelectionModel().getSelectedItem();
//    	String semselect = combosem.getSelectionModel().getSelectedItem();
//    	String secselect = combosection.getSelectionModel().getSelectedItem();
//       	String subselect = comboSubject.getSelectionModel().getSelectedItem();
//    	String urn1=listviewstudents.getSelectionModel().getSelectedItem();
//    	ArrayList<String> special = new ArrayList<String>(Arrays.asList());
//    	ArrayList<String> special1 = new ArrayList<String>(Arrays.asList())	;
//    	
//    	try
//    	{
//    	pst = con.prepareStatement("select result from attendancedata where  subject = ? and sem like ? and section like ? and urn like ? and branch like ?");
//		pst.setString(1, subselect );
//		pst.setString(2, "%" + semselect + "%" );
//		pst.setString(3, "%" + secselect + "%");
//		pst.setString(4, "%" + urn1 + "%");
//		pst.setString(5, "%" + branchselect + "%");
//		
//		
//		ResultSet rss = pst.executeQuery();
//
//		
//		//while(rss.next())
//		//{
//		//	specialstudent.add(rss.getString("result"));
//		//}
//		//listkyabaathai.getItems().clear();
//		//listkyabaathai.getItems().addAll(specialstudent);	
//		
//		 int sum=0;
//		 ObservableList<String> amounts= listkyabaathai.getItems();
//		 for (String result : amounts) 
//		 { 
//			 sum+=Integer.parseInt(result); 
//			 
//		 } 
//		 System.out.println("total attendance:"+sum);
//		 hiidencal.setText(Integer.toString(sum));
//		
//    	}
//    	catch (SQLException e) {
//			e.printStackTrace();
//	}
//    }
    }
    
    @FXML
    void doREFRESH(ActionEvent event)
    {

    	
       
        combobranch.getEditor().setText("");
        combobranch.getSelectionModel().clearSelection();
        combosection.getSelectionModel().clearSelection();
        comboSubject.getSelectionModel().clearSelection();
        combosem.getSelectionModel().clearSelection();
        combosection.getEditor().setText("");
        combosem.getEditor().setText("");
        comboSubject.getEditor().setText("");
        listviewstudents.getItems().clear();      
       listnew.getItems().clear();
        if(radiopresent.isSelected())
		{
    	   radiopresent.setSelected(false);
    	   radiopresent.setText("PRESENT");
		}
		else
			if(radioabsent.isSelected())
			{
				radioabsent.setSelected(false);
				radioabsent.setText("ABSENT");
			}
        
    }


    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
        con=DatabaseConnector.getConnection();
        String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
    			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
    			,"University Business School"};
    	combobranch.getItems().addAll(Arrays.asList(arr));
    	
    	String arr1[]= {"1","2","3","4","5","6","7","8"};
    	combosem.getItems().addAll(Arrays.asList(arr1));
    	
    	String arr3[]= {"A","B","C"};
       	combosection.getItems().addAll(Arrays.asList(arr3));  
       	//listviewstudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       	
       	listviewstudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       	
       	
}
}

