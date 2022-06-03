/**
 * Sample Skeleton for 'CalcView.fxml' Controller Class
 */

package calculation;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import calculation.TableeBean;
import calculationtable.Tablebeann;

public class CalcViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="combodprt"
    private ComboBox<String> combodprt; // Value injected by FXMLLoader

    @FXML // fx:id="combosem"
    private ComboBox<String> combosem; // Value injected by FXMLLoader

    @FXML // fx:id="combosec"
    private ComboBox<String> combosec; // Value injected by FXMLLoader

    @FXML // fx:id="tblshow"
    private TableView<TableeBean> tblshow; // Value injected by FXMLLoader
    
    @FXML // fx:id="combosubs1"
    private ComboBox<String> combosubs1; // Value injected by FXMLLoader
    @FXML // fx:id="listkuch"
    private ListView<String> listkuch; // Value injected by FXMLLoader
    @FXML // fx:id="txthlo"
    private TextField txthlo; // Value injected by FXMLLoader
    @FXML // fx:id="txthi"
    private TextField txthi; // Value injected by FXMLLoader
    
    @FXML // fx:id="comboexperi"
    private Button comboexperi; // Value injected by FXMLLoader
    
    
    
    PreparedStatement pst;
    ObservableList<TableeBean> list;
    @FXML
    void doExcel(ActionEvent event) throws IOException 
    {
    	Writer writer = null;
        try {
        	File file = new File("Users.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="Name,Urn,Subject,Sum,Totallec,Percentage\n";
            writer.write(text);
            for (TableeBean p : list)
            {
				text = p.getName()+ "," + p.getUrn()+ "," + p.getSubject()+ "," + p.getSum()+","+ p.getTotallec()+","
				+p.getPercentage()+"\n";
                writer.write(text);
            }
            System.out.println("Exported Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        
}
    	
    }
    
    
    @FXML
    void dosub(ActionEvent event)
    {
    	
    }
    
    @FXML
    void doKuch(MouseEvent event) {

    }


    @FXML
    void doDprt(ActionEvent event) 
    {
    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combodprt.getSelectionModel().getSelectedItem();
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
			combosubs1.getItems().clear();
			combosubs1.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    }

    @FXML
    void doSem(ActionEvent event)
    {
    	ArrayList<String> specialsubject = new ArrayList<String>(Arrays.asList());
    	String departselect = combodprt.getSelectionModel().getSelectedItem();
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
			combosubs1.getItems().clear();
			combosubs1.getItems().addAll(specialsubject);	
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    }

    @FXML
    void doShow(ActionEvent event)
    {
    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
    	ArrayList<String> specialstudentt = new ArrayList<String>(Arrays.asList());
    	String departselect = combodprt.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    	String subjectselect = combosec.getSelectionModel().getSelectedItem();
    	String subjectselectt = combosubs1.getSelectionModel().getSelectedItem();
     		
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
			listkuch.getItems().clear();
			listkuch.getItems().addAll(specialstudent);
			
			
    	}
    	
    	
    	
    	catch (SQLException e) {
			e.printStackTrace();
			}
    	
    	
    	
    	
    	list=FXCollections.observableArrayList();
	    String department = combodprt.getSelectionModel().getSelectedItem();
	//    String semester = combosem.getSelectionModel().getSelectedItem();
	 //  String section = combosec.getSelectionModel().getSelectedItem();
	   String subject = combosubs1.getSelectionModel().getSelectedItem();
	// String ur="[19028008]";
	 ObservableList<String> amounts= listkuch.getItems();
	 for (String pa : amounts) 
	 { 
		 txthlo.setText(pa);
	 
    	try {
   		String query1="SELECT MAX(totallec) as totallec from attendancedata where branch like ? and urn like ? and subject like ?";
    		pst = con.prepareStatement(query1);
   		pst.setString(1, "%" + department + "%");
			pst.setString(2, "%" + txthlo.getText() + "%");
			 
			pst.setString(3, "%" + subject + "%");
			ResultSet tablee = pst.executeQuery();
			while(tablee.next())
	      	{
				String ho=tablee.getString("totallec");
				txthi.setText("");
				txthi.setText(ho);
	      	}
			
			String query="SELECT MAX(sum) as sum,max(totallec) as totallec,percentage,urn,name,subject from attendancedata where branch like ?"
					+ " and urn like ? and subject like ? and totallec like ? ";
			pst = con.prepareStatement(query);
			pst.setString(1, "%" + department + "%");
			//String str[];
			
			 
				  
				
			  
			pst.setString(2, "%" + txthlo.getText() + "%");
			 
			pst.setString(3, "%" + subject + "%");
//			pst.setString(1, "%"+subject+"%");
	//		pst.setString(2,  "%" + department + "%");
	//		pst.setString(3,"%" + semester + "%");
			pst.setString(4, "%" + txthi.getText() + "%");
			//pst.setString(1,department);
			//pst.setString(2, ur);
			System.out.println(department);
			//System.out.println(ur);
		//	System.out.println(combosubs1.getSelectionModel().getSelectedItem());
			
			ResultSet table = pst.executeQuery();
    	
			System.out.println("hello");
			while(table.next())
	      	{
				
				System.out.println("hell");
	      		
	      		String urnn=table.getString("urn");
	      		String namee=table.getString("name");
	      		//String branch=table.getString("branch");
	      		//String sem=table.getString("sem");
	      		//String sectionn=table.getString("section");
	      		String subjectt=table.getString("subject");
	      		//String dor=table.getString("dor");
	      		String summ=table.getString("sum");
	      		String tt=table.getString("totallec");
	      		String pp=table.getString("percentage");
	      		//String result=table.getString("result");
	      		
	      		System.out.println("heo");
	      	//	System.out.println(urnn+"   "+namee);
	      		//System.out.println(oid+"   "+contact+"   "+dress+"   "+workers+"   "+mrs+"   "+dos+"   "+amount+"  "+status);
	      		TableeBean obj=new TableeBean(summ,tt,pp,urnn,namee,subjectt);
	      		list.add(obj);
	      	}
	      	
			
			tblshow.setItems(list);
			//comboSD.getItems().clear();
			
    	}
    	catch (SQLException e) {
			e.printStackTrace();
			}
	 }
	 
    
    }

    @FXML
    void dosec(ActionEvent event) 
    {

    	
    }
    
   
   
    
    void addCols()
    {
    	TableColumn<TableeBean, String> urna=new TableColumn<TableeBean, String>("URN");
    	urna.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("urn"));
    	urna.setMinWidth(70);
    	
    	TableColumn<TableeBean, String> namea=new TableColumn<TableeBean, String>("NAME");
    	namea.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("name"));
    	namea.setMinWidth(100);
    	
    	TableColumn<TableeBean, String> suba=new TableColumn<TableeBean, String>("SUBJECT");
    	suba.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("subject"));
    	suba.setMinWidth(70);
    	
    	
    	
    	
    	TableColumn<TableeBean, String> suma=new TableColumn<TableeBean, String>("SUM");
    	suma.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("sum"));
    	suma.setMinWidth(10);
    	
    	TableColumn<TableeBean, String> leca=new TableColumn<TableeBean, String>("TOTAL lec");
    	leca.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("totallec"));
    	leca.setMinWidth(10);
    	
    	TableColumn<TableeBean, String> pera=new TableColumn<TableeBean, String>("PERCENTAGE");
    	pera.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("percentage"));
    	pera.setMinWidth(20);
    	
    	
    	
//    	TableColumn<TableeBean, String> cnameeCol=new TableColumn<TableeBean, String>("RESULT");
//       	cnameeCol.setCellValueFactory(new PropertyValueFactory<TableeBean,String>("result"));
//    	cnameeCol.setMinWidth(20);
//    	
  	
    	
    	
    	tblshow.getColumns().addAll(urna,namea,suba,suma,leca,pera);
    
    }

    @FXML
    void doDhmaka(ActionEvent event)
    {
    	String department = combodprt.getSelectionModel().getSelectedItem();
 	    String semester = combosem.getSelectionModel().getSelectedItem();
 	  
 	    String subject = combosubs1.getSelectionModel().getSelectedItem();
 	    
 	   try {
		pst = con.prepareStatement("select SUM(result) from attendancedata where  branch like ? and subject like ? and "
				+ "sem like ? and urn like ? ");
		pst.setString(1, "%" + department + "%");
		pst.setString(2, "%" + subject  + "%" );
		pst.setString(3, "%" + semester + "%" );
		pst.setString(4, "%" + "190280132" + "%" );
		
		 pst.executeQuery();
		
	} catch (SQLException e) 
 	   {
		
		e.printStackTrace();
	}
    }
    	
    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	con=DatabaseConnector.getConnection();
    	addCols();
    	String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
    			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
    			,"University Business School"};
    	combodprt.getItems().addAll(Arrays.asList(arr));
    	
    	String arr1[]= {"1","2","3","4","5","6","7","8"};
    	combosem.getItems().addAll(Arrays.asList(arr1));
    	
    	String arr3[]= {"A","B","C"};
       	combosec.getItems().addAll(Arrays.asList(arr3)); 
        assert combosubs1 != null : "fx:id=\"combosubs1\" was not injected: check your FXML file 'CalcView.fxml'.";
        
    }
    
    //int i=0;
//	//for(int i=listurn.setId(0);i<=listurn.getItems().size();i++)
//	while(listurn.getItems().next())
//	{
//		ObservableList<String> j=listurn.getSelectionModel().getSelectedItems();
//	pst = con.prepareStatement("SELECT SUM(result)  FROM attendancedata WHERE branch like ? and sem like ? and subject like ? and urn like ? ");
//	pst.setString(1, "%" + department + "%");
//	pst.setString(2, "%" + semester + "%");
//	pst.setString(3, "%" + subject + "%");
//	pst.setString(4, "%" + j + "%");
//	ResultSet tablee = pst.executeQuery();
//	
//	pst=con.prepareStatement("insert into calculation value(?,?,?,?");
//	pst.setString(1,combodprt.getSelectionModel().getSelectedItem() );
//	pst.setString(2,combodprt.getSelectionModel().getSelectedItem() );
//	pst.setString(3,combodprt.getSelectionModel().getSelectedItem() );
//	pst.setString(4,combodprt.getSelectionModel().getSelectedItem() );
//	
//	pst.executeUpdate();
//	}
}
