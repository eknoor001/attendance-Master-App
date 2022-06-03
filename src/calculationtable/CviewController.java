package calculationtable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Sample Skeleton for 'Cview.fxml' Controller Class
 */



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import calculation.TableeBean;
//import calculation.TableeBean;
import calculationtable.Tablebeann;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CviewController {

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

    @FXML // fx:id="comboSubject"
    private ComboBox<String> comboSubject; // Value injected by FXMLLoader

    @FXML // fx:id="lista"
    private ListView<String> lista; // Value injected by FXMLLoader

    @FXML // fx:id="datapickera"
    private DatePicker datapickera; // Value injected by FXMLLoader

    @FXML // fx:id="tbldhmaka"
    private TableView<Tablebeann> tbldhmaka; // Value injected by FXMLLoader
    
    @FXML // fx:id="txthi"
    private TextField txthi; // Value injected by FXMLLoader
    
    PreparedStatement pst;
    ObservableList<Tablebeann> liste;
    @FXML
    void doFetchExcel(ActionEvent event) throws IOException
    {
    	Writer writer = null;
        try {
        	File file = new File("Users.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="Name,Urn,Result,Dor\n";
            writer.write(text);
            for (Tablebeann p : liste)
            {
				text = p.getName()+ "," + p.getUrn()+ "," + p.getResult()+ "," + p.getDor()+"\n";
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
    void doDate(ActionEvent event) 
    {

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
    }

    @FXML
    void doListKam(MouseEvent event) {

    }

    @FXML
    void doSec(ActionEvent event) 
    {
    	ArrayList<String> specialstudent = new ArrayList<String>(Arrays.asList());
  	  
    	String departselect = combodprt.getSelectionModel().getSelectedItem();
    	String semselect = combosem.getSelectionModel().getSelectedItem();
    	String subjectselect = combosec.getSelectionModel().getSelectedItem();
    	//String subjectselectt = comboSubject.getSelectionModel().getSelectedItem();
     		
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
			lista.getItems().clear();
			lista.getItems().addAll(specialstudent);
			
			
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
    }

    @FXML
    void doShow(ActionEvent event)
    { 
    	LocalDate date=datapickera.getValue();
    
    liste=FXCollections.observableArrayList();
    	
    	try {
			pst=con.prepareStatement("select urn,name,result,dor from attendancedata where urn like ? and subject like ? and dor like ?");
			pst.setString(1, "%" + lista.getSelectionModel().getSelectedItem() + "%");
			pst.setString(2, "%" + comboSubject.getSelectionModel().getSelectedItem() + "%");
			pst.setString(3, "%" + datapickera.getValue() + "%");
			ResultSet rs = pst.executeQuery();
			System.out.println(datapickera.getValue());
			System.out.println(lista.getSelectionModel().getSelectedItem());
			while(rs.next())
				{
					String name1=rs.getString("name");
					String urn1=rs.getString("urn");
					String result1=rs.getString("result");
					Date dos=rs.getDate("dor");
					Tablebeann obj1 =new Tablebeann(name1,urn1,result1,dos.toString());
		      		
					liste.add(obj1);
		      	
				}
			tbldhmaka.setItems(liste);
		
      	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     
    }

    @FXML
    void doShowAll(ActionEvent event)
    {
    	LocalDate date=datapickera.getValue();
        
        liste=FXCollections.observableArrayList();
        	
        ObservableList<String> amounts= lista.getItems();
   	 for (String pa : amounts) 
   	 { 
   		txthi.setText(pa);
   	 
        	try {
    			pst=con.prepareStatement("select urn,name,result,dor from attendancedata where urn like ? and subject like ? and dor like ?");
    			pst.setString(1, "%" + txthi.getText() + "%");
    			pst.setString(2, "%" + comboSubject.getSelectionModel().getSelectedItem() + "%");
    			pst.setString(3, "%" + datapickera.getValue() + "%");
    			ResultSet rs = pst.executeQuery();
    			System.out.println(datapickera.getValue());
    			System.out.println(lista.getSelectionModel().getSelectedItem());
    			while(rs.next())
    				{
    					String name1=rs.getString("name");
    					String urn1=rs.getString("urn");
    					String result1=rs.getString("result");
    					Date dos=rs.getDate("dor");
    					Tablebeann obj1 =new Tablebeann(name1,urn1,result1,dos.toString());
    		      		
    					liste.add(obj1);
    		      	
    				}
    			tbldhmaka.setItems(liste);
    		
          	
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
   	 }
    }

    @FXML
    void doSubject(ActionEvent event) 
    {

    }
    
    
    void adddCols()
    {
    	TableColumn<Tablebeann, String> namea=new TableColumn<Tablebeann, String>("NAME");
    	namea.setCellValueFactory(new PropertyValueFactory<Tablebeann,String>("name"));
    	namea.setMinWidth(70);
    	
    	TableColumn<Tablebeann, String> urna=new TableColumn<Tablebeann, String>("URN");
    	urna.setCellValueFactory(new PropertyValueFactory<Tablebeann,String>("urn"));
    	urna.setMinWidth(70);
    	
    	TableColumn<Tablebeann, String> resulta=new TableColumn<Tablebeann, String>("RESULT");
    	resulta.setCellValueFactory(new PropertyValueFactory<Tablebeann,String>("result"));
    	resulta.setMinWidth(70);
    	
    	TableColumn<Tablebeann, String> dora=new TableColumn<Tablebeann, String>("DOR");
    	dora.setCellValueFactory(new PropertyValueFactory<Tablebeann,String>("dor"));
    	dora.setMinWidth(70);
    	
    	
    	tbldhmaka.getColumns().addAll(namea,urna,resulta,dora);
    	//tbldhmaka.getItems().addAll(namea,urna,resulta,dora);
    
    
    }
    
    
     Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	con=DatabaseConnector.getConnection();
   	 adddCols();
   	 
   	 String arr[]= {"Civil","Computer Science","Electronics & comm.","Electrical","Mechanical","Textile","Chemistry",
    			"Mathematics","Physics","Computational Sciences","Food Science & Technology","Pharmaceutical Sciences & Technology"
    			,"University Business School"};
    	combodprt.getItems().addAll(Arrays.asList(arr));
    	
    	String arr1[]= {"1","2","3","4","5","6","7","8"};
    	combosem.getItems().addAll(Arrays.asList(arr1));
    	
    	String arr3[]= {"A","B","C"};
       	combosec.getItems().addAll(Arrays.asList(arr3));


    }
}
