package calculation;

public class TableeBean 
{
	
	String sum;
	String totallec;
	String percentage;
	String urn;
	String name;
	String subject;
	


	

	public TableeBean(String summ,String totallec,String percentage,String urn,String name,String subject ) 
	{
		super();
		
		this.sum=summ;
		this.totallec=totallec;
		this.percentage=percentage;
		this.urn=urn;
		this.name=name;
		this.subject=subject;
		//this.result=result;
		

	
	}




	public String getUrn() {
		return urn;
	}




	public void setUrn(String urn) {
		this.urn = urn;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	public String getSum() {
		return sum;
	}




	public void setSum(String sum) {
		this.sum = sum;
	}




	public String getTotallec() {
		return totallec;
	}




	public void setTotallec(String totallec) {
		this.totallec = totallec;
	}




	public String getPercentage() {
		return percentage;
	}




	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}




	


	




	



	
}
