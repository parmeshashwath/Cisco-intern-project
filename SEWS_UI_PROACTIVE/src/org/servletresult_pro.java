package org;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.google.gson.Gson;

/**
 * Servlet implementation class servletresult_pro
 */
@WebServlet("/servletresult_pro")
public class servletresult_pro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletresult_pro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String temp1;
				String temp2=" ";
				int flag =0;
				BufferedReader br=null;
				response.setContentType("text/html");
				String temp_path=request.getParameter("filename");
				PrintWriter writer=response.getWriter();
				writer.println(temp_path);
			//	System.out.println(temp_path);
					System.out.println(String.valueOf(flag));
					try
					{
						String filenames=request.getParameter("filenames");
						System.out.println("$$$$$$$$$$$$$$$$$$$"+filenames);
						StringTokenizer tokn=new StringTokenizer(filenames,"&");
					int arg_count=tokn.countTokens();
						int i=0;
						String cmd_arg="";
						while(tokn.hasMoreTokens())
						{
							cmd_arg+=" "+"C:\\Users\\parma\\Desktop\\"+tokn.nextToken();
							
						}
						cmd_arg=cmd_arg.trim();
						System.out.println(cmd_arg);
						
						if(flag==0)
						{
							
							Process obj=Runtime.getRuntime().exec("java -jar C:\\Users\\parma\\Desktop\\proactive2.jar "+arg_count+" "+cmd_arg);
									obj.waitFor();
				            // Process obj=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -rmr hdfs://localhost:54310/usr/local/hadoop/output_jat_fin");
					//obj.waitFor();
				//	File f = new File(temp_path);
		  		 // String name_file=(f.getName());
					

							//Process obj1=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/rr.jar " + "/usr/local/hadoop/inputlog_temp/" + name_file + " /usr/local/hadoop/output_jat_fin");
							//obj1.waitFor();
							//writer.println("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/rr.jar " + "/usr/local/hadoop/inputlog_temp/" + name_file + " /usr/local/hadoop/output_jat_fin");
						//	Process obj3=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs  -copyToLocal hdfs://localhost:54310/usr/local/hadoop/output_jat_fin/part-00000 /home/pah/Desktop");
							//obj3.waitFor();
		HttpSession session = request.getSession();
		String[] jsonstrarr=new String[10];
		final Gson gson = new Gson();
		int jsonite=0;
		 br=new BufferedReader(new FileReader("C:/o6.txt"));
		 while((temp1=br.readLine())!=null)
		 {
		 	//temp2=temp2+temp1;
		 System.out.println(temp1);
		 StringTokenizer tok=new StringTokenizer(temp1,"*");
		 Symptom_2_pro s =new Symptom_2_pro();
		 int token_iterator=0;
		 while(tok.hasMoreTokens())
		 {
			 switch(token_iterator)
			 {
			 case 0:
				 s.setError(tok.nextToken());
				 System.out.println("ERROR"+s.getError());
				 break;
			 case 1:
				 String rawstr=tok.nextToken().toString();
				
				 
				
				 StringTokenizer itt=new StringTokenizer(rawstr,",");
				 int k=0;
				 while(itt.hasMoreTokens())
				 {
					 /*ts[k]=itt.nextToken();
					 System.out.println(ts[k]);
					 k++;*/
					 System.out.println("hello");
					 s.setSymptoms(itt.nextToken());
				 }
			//	 System.out.println("Timestamps:"+s.getTimestamps());
				 break;
				 
					
			 case 2:
				 s.setTimestamp(tok.nextToken().toString());
				 System.out.println("Time Stamp"+s.getTimestamp());
				 break;
			 
			 case 3:
				 String rt=tok.nextToken();
				// String rt2=rt.replace(" ","");
				
				 s.setprob(rt);
				 System.out.println("Count"+s.getProb());
				 break;
			
			 case 4:
				 s.setSeverity(tok.nextToken().toString());
				 System.out.println("Severity"+s.getSeverity());
				 break;
			 case 5:
				 s.setLinks(tok.nextToken().toString());
				 System.out.println("Links"+s.getLinks());
				 break;
			default:
				System.out.println("In default bloack");
				System.out.println(tok.nextToken());
				break;
			
			 }
			 
		 token_iterator++;
		 
		 }
		 String jsonstr = gson.toJson(s);
		 System.out.println("Json String^^^^^^^^^^^^^^^^^^^^ "+jsonite+":"+jsonstr);
		 jsonstrarr[jsonite]=jsonstr;
		 jsonite++;

		 }
		 jsonstrarr[jsonite]="@";
		 System.out.println("JSON STRINGS");
		 for(int pk=-0;pk<jsonstrarr.length;pk++)
		 {
			 if(jsonstrarr[pk].equals("@"))
					 {
				 		break;
					 }
			 session.setAttribute("jsonstr"+pk, jsonstrarr[pk]);
			 System.out.println("Json String "+pk+":"+jsonstrarr[pk]);
			 
		 }

		 

		flag++;

		writer.println("finshed");



		String nextJSP = "/Home_pro.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		System.out.println(dispatcher.toString());
		dispatcher.forward(request,response);
						}
							else
						{
							flag++;
			//				System.out.println(flag);
						}
					
					}
					catch(Exception ex)
					{
					ex.printStackTrace();	
					}
					finally {
						try {
						if (br != null)
						{
							
						br.close();
						
						}
						} catch (IOException ex) {
						ex.printStackTrace();
						}
						}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
