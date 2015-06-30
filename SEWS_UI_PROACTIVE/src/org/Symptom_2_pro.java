package org;


import java.util.HashMap;
import java.util.StringTokenizer;

public class Symptom_2_pro {

	/**
	 * @param args
	 */
	
	String error;
	
	public String links;

	
	
	String severity;
	String prob;
	public String  timestamp;
	public HashMap<String,String> sym_des=new HashMap<String,String>();
	

	
	
	public String getError()
	{
		return this.error;
	}
	
	public String getLinks()
	{
		
		return this.links;
		
	}
	
	
	
	public String getSeverity()
	{
		return this.severity;
	}
	public String getTimestamp()
	{
		return this.timestamp;
	}
	public String getProb()
	{
		return this.prob;
	}
	public HashMap<String,String> getSymptoms()
	{
		
		return sym_des;
	}
	public void setError(String error)
	{
		this.error=error;
	}
	public void setTimestamp(String error)
	{
		this.timestamp=error;
	}
	public void setLinks(String link)
	{
		this.links=link;
		
	}
	
	public void setSeverity(String sev)
	{
		this.severity=sev;
	}
	public void setprob(String prob)
	{
		this.prob=prob;
	}
	public void setSymptoms(String timestamps)
	{
		
		StringTokenizer itok=new StringTokenizer(timestamps,"@");
		String symptom_key=itok.nextToken();
		
		String des_val=itok.nextToken();
		
		sym_des.put(symptom_key, des_val);
		System.out.println("k");
	}
	
			
			  @Override
			  public String toString() {
			return "Symptom [error=" + error +", Severity=" + severity + ", probalitity=" + prob +", Timestamps=" + timestamp +"]";
			  }


}
