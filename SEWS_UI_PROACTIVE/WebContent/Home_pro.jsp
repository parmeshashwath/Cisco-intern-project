<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <style>
 
 .form-control {
 
 width: 100%;
 }
 .error
 {
 
 }
 .heading{
  background-color:#505050;
  position:relative;
  top:0%;
  width:1700px;
  height:80px;
  
  
  }
  .container
  {
  
  position:relative;
  top:10%;
  left:1%;
  }
  .footer
  {
  position:relative;
  top:297px;
  left:90%;
  }
  .danger_1{
  background_color:red;
  color:white;
  
  }
   .warning_1{
  background_color:yellow;
  color:white;
  
  }
   .info_1{
  background_color:#006600;
  color:white;
  
  }
  #body {
height: 100%;
width: 100%;
}
  </style>
</head>
<body>
<div id="body">
 <%@page language="java"%>
 <%@page import="java.lang.*" import="java.sql.*" import="java.io.*" import="java.text.*" import="java.util.*"  import="com.google.gson.*" import="org.*"%>
<div class ="heading">
<p align="center">
<font size="20" color="#FFFFFF">Symptom Based Early Warning System</font> </p>
</div>    

    <div class="container">
  <h2>Proactive Monitoring</h2>
        
  <table class="table table-bordered table-hover">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>EVENTS</th>
        
        <th>TIME STAMP</th>
        
        <th>PROBABIITY</th>
        <th>SEVERITY</th>
        <th>LINKS</th>
      </tr>
    </thead>
    <tbody>
    
     <%
     LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("C:/o6.txt")));
     lnr.skip(Long.MAX_VALUE);
    //Add 1 because line index starts at 0
     // Finally, the LineNumberReader object should be closed to prevent resource leak
     lnr.close();
     int cons=lnr.getLineNumber();
     System.out.println("!!!!!!!!!!!!!!!!!!"+cons); 
     final Gson gson = new Gson(); 
     for (int i=0;i<cons;i++)
     {
     String jsonstr=session.getAttribute("jsonstr"+i).toString();
     Symptom_2_pro s =gson.fromJson(jsonstr,Symptom_2_pro.class);
    
    String sevtype="";
    String butontype="";
if(s.getSeverity().equals("H"))
{
	System.out.println("The severity is high");
	SendEmail obj=new SendEmail(); 
	String temp_arg="";
	temp_arg=s.getError()+"*"+"  has occured "+" due to following symptoms - ";
	HashMap<String,String> hm=s.getSymptoms();
	
    
	 obj.mail(temp_arg,hm);
	 sevtype="#FF3300";
	 butontype="btn btn-danger";
}
else if(s.getSeverity().equals("M"))
{
	System.out.println("The severity is Medium");
	 sevtype="#CCCC00";
	 butontype="btn btn-warning";
}
else if (s.getSeverity().equals("L"))
{
	System.out.println("The severity is Low");
	 sevtype="#66CC00";
	 butontype="btn btn-info";
}
	  
    %>
    
      <tr style="color:white; background-color:<%=sevtype%>">
        <!--  <td><%=s.getError()%></td>-->
       
        
       
        <td data-toggle="modal" data-target="#myModal_1<%=i%>"><p class="text-primary" style="color:#000000"><b><font size="5" ><%=s.getError() %></font></b></p></td>
      
     
       <td><b><font size="3" ><%=s.getTimestamp() %></font></b></td>
        <td><b><font size="3" > <%=s.getProb() %></font></b></td>
       
       <td><b><font size="3" ><%=s.getSeverity() %></font></b></td>
       <!--  <td data-toggle="modal" data-target="#myModal_2<%=i%>"><p class="text-primary">help</p></td> -->
         <td> <a href=<%=s.getLinks() %>><p class="text-primary" style="color:#000000;"><b><font size="3" >help</font></b></p></a></td> 
       
       
      </tr>
        
     <% 
  	
     }
    
     %>
      </tbody>
  </table>
</div>
<div class="footer">
<h6>Cisco confidential 2014-2015</h6>

</div>

<%
for(int k=0;k<cons;k++)
{
	 String jsonstr=session.getAttribute("jsonstr"+k).toString();
     Symptom_2_pro s =gson.fromJson(jsonstr,Symptom_2_pro.class);
%>
<div id="myModal_1<%=k%>" class="modal fade" role="dialog" tabindex="-1" aria-labelledby="myModalLabel<%=k%>" aria-hidden="true">
  <div class="modal-dialog" id="<%=k%>">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
        <h2 class="modal-title" id="myModalLabel<%=k%>">SYMPTOMS for <%=s.getError()%></h2>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>SYMPTOMS</th>
        <th>DESCRIPTION</th>
        
      </tr>
    </thead>
     <tbody>       
        <%
        HashMap<String,String> t=s.getSymptoms();
        try
		{
			Set set = s.sym_des.entrySet();
			Iterator i = set.iterator();
		      // Display elements
			
			
		      while(i.hasNext()) {
		    	  
		    	  Map.Entry me = (Map.Entry)i.next();
		    	  String temp=(String)me.getKey();
		    	  String temp2=(String)me.getValue();
		    	  
		    	  %>
		    	  <tr>
		             <td> <%=temp%></td>
		             <td> <%=temp2%></td>
		            
		              </tr>
		              <%         
		      }
		}
        catch(Exception e)
        {
        	
        }
       
        %>
        	      
           
        </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
<%
}
%> 


<%
for(int k=0;k<cons;k++)
{
	 String jsonstr=session.getAttribute("jsonstr"+k).toString();
     Symptom_2_pro s =gson.fromJson(jsonstr,Symptom_2_pro.class);
     String link=s.links;
	   StringTokenizer token=new StringTokenizer(link,",");
	   String [] link_arr=new String[token.countTokens()];
	   int i=0;
	   while(token.hasMoreTokens())
	   {
		   link_arr[i]=token.nextToken();
		   i++;
	   }
%>
<div id="myModal_2<%=k%>" class="modal fade" role="dialog" tabindex="-1" aria-labelledby="myModalLabel<%=k%>" aria-hidden="true">
  <div class="modal-dialog" id="<%=k%>">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
        <h2 class="modal-title" id="myModalLabel<%=k%>">Reasons for <%=s.getError()%></h2>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>Links</th>
      
      </tr>
    </thead>
    <tbody>       
        <%
        for (int lo=0;lo<link_arr.length;lo++)
        {     	
        %>
        
        	<tr>
        	
            <td> <a href=<%=link_arr[lo] %>>click</a></td> 
             
              </tr>       
           <%  
        }   
        %>
        
        
         
        </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
<%
}
%>     
</div>
<br><br><br>
</div>
</body>

</html>