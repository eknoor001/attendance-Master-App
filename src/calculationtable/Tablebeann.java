package calculationtable;

public class Tablebeann 
{

	String name;
	String urn;
	
	String result;
	String dor;
	
	public Tablebeann(String namee,String urnn,String resultt,String dorr) 
	{
		super();
	
	this.name=namee;
	this.urn=urnn;
	
	this.result=resultt;
	this.dor=dorr;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDor() {
		return dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}
	
	
	
	
}
