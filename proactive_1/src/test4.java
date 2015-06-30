import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.*;

// This is the entry point for the second thread.
class NewThread3 implements Runnable {
int swap;
	Thread t;
var obvar;
String name;
List<String>wordList;
HashSet<String>days;
HashSet<String>months;
HashSet<String>dic;
NewThread3(String str,var ob,List<String>wordListp,HashSet<String>daysp,HashSet<String>monthsp,HashSet<String>dicp) {
// Create a new, second thread
	name=str;
	swap=0;
t = new Thread(this, "Demo Thread-"+str);
//System.out.println("Child thread: " + t);
obvar=ob;
wordList=wordListp;
days=daysp;
months=monthsp;
dic=dicp;
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
try {
	//
	int flag2=0;
    String timestamp1=obvar.timestamp1;
    String timestamp2=obvar.timestamp2;
	BufferedReader br=obvar.br;
	
    String sCurrentLine=" ";
    flag2=0;
	br.mark(100000);
	String qw1,qw2,qw3,qw4,qw5,qw6,qw7,qw8,qw9,temp;
	String qw11,qw21,qw31,qw41,qw51;
	StringTokenizer toknm = new StringTokenizer(timestamp2, ": ");
	int wq1=0,wq2=0,wq3=0,flag=0;
	if (timestamp2!="0")
	{
	
	toknm.nextToken();
	toknm.nextToken();
	qw1=toknm.nextToken();
	qw2=toknm.nextToken();
	qw3=toknm.nextToken();
	qw4=toknm.nextToken();
	qw5=qw1+qw2+qw3+qw4;
	
	wq1=Integer.parseInt(qw5);
	}
	else
	{
		flag=1;
		wq1=0;
	}
//	System.out.println("wq1:"+ wq1);
StringTokenizer toknm1 = new StringTokenizer(timestamp1, ": ");
	
	int wq11=0,wq21=0,wq31=0,flag1=0;
	toknm1.nextToken();
	toknm1.nextToken();
	qw11=toknm1.nextToken();
	qw21=toknm1.nextToken();
	qw31=toknm1.nextToken();
	qw41=toknm1.nextToken();
	qw51=qw11+qw21+qw31+qw41;
	wq11=Integer.parseInt(qw51);
	
	try
	{
		flag2=0;
		br.mark(10000);
		if((sCurrentLine=br.readLine())!=null)
		{
			//System.out.println("!@!@!@!@!@!@!@");
		//System.out.println(name+"  "+sCurrentLine);
		br.reset();
		StringTokenizer toknn = new StringTokenizer(sCurrentLine, ": ");
		if(toknn.countTokens()>2 && days.contains(toknn.nextToken()) && months.contains(toknn.nextToken()))
		{
		qw1=toknn.nextToken();
		qw2=toknn.nextToken();
		qw3=toknn.nextToken();
		qw4=toknn.nextToken();
		qw5=qw1+qw2+qw3+qw4;
		wq2=Integer.parseInt(qw5);
		//System.out.println("QQQQQQQQQQQQQQQQQQQ"+wq2+" "+wq11);
		}
		//System.out.println(name+"wq11:::"+wq11);
		//System.out.println(name+"wq2:::"+wq2);
		if(wq2<wq11+10 && wq2>wq11-10)
		{	
			if (flag==0)
			br.mark(10000);
	while((sCurrentLine=br.readLine())!=null)
	{
//System.out.println(name+"   " +"aaaaaa##########3   "+sCurrentLine);	
		//flag=0;
		
		StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
		if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
		{
		qw1=tokn.nextToken();
		qw2=tokn.nextToken();
		qw3=tokn.nextToken();
		qw4=tokn.nextToken();
		qw5=qw1+qw2+qw3+qw4;
		wq2=Integer.parseInt(qw5);
		//System.out.println("wq2:"+ wq2);
		if(wq2>wq1-10)
		{
			flag=1;
	//		System.out.println(wq2+"   "+wq1+"    "+name+"aqaqaqaqaqaqaqa");
			
		}
if (flag==0)
	br.mark(100000);
		while ((sCurrentLine = br.readLine()) != null) {
			
			StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");
		//	System.out.println("aaaaaa::"+sCurrentLine);
			if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
			{
				
				qw1=tokn1.nextToken();
				qw2=tokn1.nextToken();
				qw3=tokn1.nextToken();
				qw4=tokn1.nextToken();
				qw5=qw1+qw2+qw3+qw4;
				wq3=Integer.parseInt(qw5);
			//	System.out.println("wq1::"+wq1);
				//System.out.println("wq11::"+wq11);
				//System.out.println("wq3::"+wq3);
				
				if(wq3>wq1-10)
				{
					flag=1;
					//
					
				}
				if(wq3>wq11+10 )
				{
					flag2=1;
					//System.out.println(timestamp1);
					
					break;
				}
				
				
				
				
				
			}
			StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
	while (tokn2.hasMoreTokens()) {
		temp=tokn2.nextToken();
	//	System.out.println("in fun"+temp);
		if(dic.contains(temp)&& !wordList.contains(temp))
		wordList.add(temp);
		}
	if (flag==0)
		br.mark(100000);
		}
		
		}
		if(flag2==1)
		{
			//System.out.println("azazazaz  "+br.readLine());
			if(wq1!=0)
			br.reset() ;
			break;
		}
	}
		}
		
		
		}
	//System.out.println("q1q1q1qq"+ wq1+")))"+wq3);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
} catch (Exception e) {
System.out.println("Child interrupted.");
}
//System.out.println("Exiting child thread.");
}
}


class outdet
{
	public
		int cnt;
String symptoms;
}
class outkey{
	String outcome;
	int grp;
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof outkey) {
            return outcome.equals(((outkey)obj).outcome) && grp==((outkey)obj).grp;
        }
        return false;
    }

    @Override
    public int hashCode() {
    	return Integer.valueOf(grp).hashCode()+(outcome).hashCode();
    }
}
class var {
	BufferedReader br;
	String timestamp1;
	String timestamp2;
}
class out_sev_link
{
	String sev;
	String link;
}
class test4 {
	static int TS(BufferedReader br,HashSet<String>days,HashSet<String>months)
	{
		int l=Integer.MAX_VALUE;
		try
		{
		String sCurrentLine=" ",tempstr;
		String qw1,qw2,qw3,qw4,qw5;;
		
		br.mark(100000);
		while ((sCurrentLine = br.readLine()) != null) {
			StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
			
			if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
			{
				
				tempstr=sCurrentLine;
			//	System.out.println("tempstr=  "+ tempstr);
				
				
				qw1=tokn.nextToken();
				qw2=tokn.nextToken();
				qw3=tokn.nextToken();
				qw4=tokn.nextToken();
				qw5=qw1+qw2+qw3+qw4;
				l=Integer.parseInt(qw5);
				br.reset();
				return l;
				
		}
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}
public static void main(String args[]) {
	String query1 = "SELECT * FROM OUT_SYM WHERE SYM=";
	String query2 = "SELECT * FROM OUT_SYM WHERE OUT=";
	String sCurrentLine,tempstr="0",tempstr2="0",temp;
	/*BufferedReader br =null;
	BufferedReader br3=null;
	BufferedReader br2=null;*/
	int number=Integer.parseInt(args[0]);
	BufferedReader []br=new BufferedReader[number];
	int lo;
	BufferedWriter bw=null;
	int flagb=0;
	HashSet days = new HashSet();
	HashSet months=new HashSet();
	HashMap<outkey,outdet> symhash=new HashMap<outkey,outdet>();
	HashMap<String,String> sym_des=new HashMap<String,String>();
	HashMap<String,out_sev_link> out_des=new HashMap<String,out_sev_link>();
	HashSet dic=new HashSet();
	days.add("Sun");
	days.add("Mon");
	days.add("Tue");
	days.add("Wed");
	days.add("Thu");
	days.add("Fri");
	months.add("Jan");
	months.add("Feb");
	months.add("Mar");
	months.add("Apr");
	months.add("May");
	months.add("Jun");
	months.add("Jul");
	months.add("Aug");
	months.add("Sep");
	months.add("Oct");
	months.add("Nov");
	months.add("Dec");
	try
	{
		for(lo=0;lo<number;lo++)
		br[lo] = new BufferedReader(new FileReader(args[lo+1]));
		 FileWriter fw = new FileWriter("C:/o6.txt");
			bw = new BufferedWriter(fw);
		 Connection c = null;
		 List<String> wordList=new ArrayList<String>();
		 	String tempg,tempg2=null,tempg3=null;
			int final_break=0;
			int wq1=0,wq2=0,wq3=0;
			String qw1,qw2,qw3,qw4,qw5,qw6,qw7,qw8,qw9;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","azadAZAD1");
				}
				catch(ClassNotFoundException error) {
				System.err.println("Unable to load the JDBC/ODBC bridge" + error.getMessage( ));
				System.exit(1);
				}
				catch(SQLException error) {
				System.err.println("Unable to connect to database---" + error.getMessage( ));
				System.exit(2);
				}
				catch(Exception e) { 
					e.printStackTrace();
				}
			while(true)
			{
				for(lo=0;lo<number;lo++)
				br[lo].mark(100000);
		//		br[1].mark(100000);
			//	br[2].mark(100000);
				/*tempg=br[0].readLine();
				br[0].reset();
				tempg2=br[1].readLine();
				br[1].reset();
				tempg3=br[2].readLine();
				br[2].reset();*/
				int flagend=0;
					for(lo=0;lo<number;lo++)
					{
						tempg=br[lo].readLine();
						br[lo].reset();
						if(tempg!=null)
						{
							flagend=1;
						}
					}
					
					if(flagend==0)
					{
						final_break=1;
						break;
						
					}
					
			int l1=Integer.MAX_VALUE,l2=Integer.MAX_VALUE,l3=Integer.MAX_VALUE;
			/*br.mark(100000);
			while ((sCurrentLine = br.readLine()) != null) {
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{
					
					tempstr=sCurrentLine;
				//	System.out.println("tempstr=  "+ tempstr);
					
					
					qw1=tokn.nextToken();
					qw2=tokn.nextToken();
					qw3=tokn.nextToken();
					qw4=tokn.nextToken();
					qw5=qw1+qw2+qw3+qw4;
					l1=Integer.parseInt(qw5);
					br.reset();
					break;
			}
				
			}
			br2.mark(100000);
			while ((sCurrentLine = br2.readLine()) != null) {
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{
					
					tempstr=sCurrentLine;
					//System.out.println("tempstr=  "+ tempstr);
					
					
					qw1=tokn.nextToken();
					qw2=tokn.nextToken();
					qw3=tokn.nextToken();
					qw4=tokn.nextToken();
					qw5=qw1+qw2+qw3+qw4;
					l2=Integer.parseInt(qw5);
					br2.reset();
					break;
			}
				
			}
			br3.mark(100000);
			while ((sCurrentLine = br3.readLine()) != null) {
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{
					
				tempstr=sCurrentLine;
					//System.out.println("tempstr=  "+ tempstr);
					
					
					qw1=tokn.nextToken();
					qw2=tokn.nextToken();
					qw3=tokn.nextToken();
					qw4=tokn.nextToken();
					qw5=qw1+qw2+qw3+qw4;
					l3=Integer.parseInt(qw5);
					br3.reset();
					
					break;
			}
				
			}*/
			Integer[] l=new Integer[number];
			for(lo=0;lo<number;lo++)
			l[lo]=TS(br[lo],days,months);
		/*System.out.println("l1="+l1);
		System.out.println("l2="+l2);
		System.out.println("l3="+l3);*/
			
			int small = l[0];
			int index = 0;
			for (int i = 0; i < l.length; i++)
			    if (l[i] < small)
			    {
			        small = l[i];
			        index = i;
			    }
			BufferedReader tempbr=br[index];
			br[index]=br[0];
			br[0]=tempbr;
			/*if(l2<=l1 && l2<=l3)
			{
				BufferedReader tempbr=br[1];
				br[1]=br[0];
				br[0]=tempbr;
			}
			else if(l3<=l1 && l3<=l2)
			{
				BufferedReader tempbr=br[2];
				br[2]=br[0];
				br[0]=tempbr;
			}
			else if (l1<=l2 && l1<=l3)
			{
				//br=br;
			}
			/*else if (l1==0 && l2==0 && l3!=0)
			{
				BufferedReader tempbr=br3;
				br3=br;
				br=tempbr;
			}
			else if(l1==0 && l3==0 && l2!=0)
			{
				BufferedReader tempbr=br2;
				br2=br;
				br=tempbr;
			}
			else if (l2==0 && l3==0 && l1!=0)
			{
				//br=br;
			}
			else if (l2==0 && l3<l1)
			{
				BufferedReader tempbr=br3;
				br3=br;
				br=tempbr;
			}
			else if (l2==0 && l3>l1)
			{
				//br=br;
			}
			else if (l3==0 && l2<l1)
			{
				BufferedReader tempbr=br2;
				br2=br;
				br=tempbr;
			}
			else if (l2==0 && l2>l1)
			{
				//br=br;
			}
			else if (l1==0 && l3<l2)
			{
				BufferedReader tempbr=br3;
				br3=br;
				br=tempbr;
			}
			else if (l1==0 && l3>l2)
			{
				BufferedReader tempbr=br2;
				br2=br;
				br2=tempbr;
			}*/
		/*	
			else
			{
				break;
			}
			*/
			
				
				
				
			
			
			
			while ((sCurrentLine = br[0].readLine()) != null) {
				
				wordList.clear();
				tempstr="0";
				tempstr2="0";
				try
				{
					Statement st = c.createStatement();
				ResultSet r = st.executeQuery("SELECT * FROM OUT_SYM");
				while(r.next())
				{
					outdet obv=new outdet();
					outkey obk=new outkey();
					obv.cnt=0;
					obv.symptoms=" ";
					obk.grp=r.getInt(3);
					obk.outcome=r.getString(1);
					dic.add(r.getString(2));
					//System.out.println("qqqqq"+r.getString(2));
					symhash.put(obk, obv);
				}
				r = st.executeQuery("SELECT * FROM SYM_DES_2");
				while(r.next())
				{
					String str4=r.getString(1);
					String str5=r.getString(2);
				//	System.out.println("###################################");
					//System.out.println(str4);
					//System.out.println(str5);
				//	System.out.println("###################################");
					
					sym_des.put(str4, str5);
					
				}
				r = st.executeQuery("SELECT * FROM OUT_DES_2");
				while(r.next())
				{
					String str4=r.getString(1);
					System.out.println("###############"+str4);
					out_sev_link ob=new out_sev_link();
					ob.link=r.getString(3);
					ob.sev=r.getString(2);
					out_des.put(str4, ob);
				}
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{
					
					tempstr=sCurrentLine;
					//System.out.println("tempstr=  "+ tempstr);
					
					qw1=tokn.nextToken();
					qw2=tokn.nextToken();
					qw3=tokn.nextToken();
					qw4=tokn.nextToken();
					qw5=qw1+qw2+qw3+qw4;
					wq1=Integer.parseInt(qw5);
					
					//System.out.println(tempstr);
				//	continue;
					br[0].mark(1000);
					while ((sCurrentLine = br[0].readLine()) != null) {
						
						StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");
						
						if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
						{
							//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
							/*qw1=tokn1.nextToken();
							qw2=tokn1.nextToken();
							qw3=tokn1.nextToken();
							qw4=tokn1.nextToken();
							qw5=qw1+qw2+qw3+qw4;
							wq2=Integer.parseInt(qw5);*/
							tempstr2=sCurrentLine;
						//	System.out.println("wq1::"+wq1);
							//System.out.println("wq2::"+wq2);
							//if(wq2<wq1+30)
							
						//		System.out.println("!!!!!!!!!!!!!!!!!!!");
							br[0].reset();
							flagb=1;
							break;
							
						}
						StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
				while (tokn2.hasMoreTokens()) {
					temp=tokn2.nextToken();
					//System.out.println(temp);
					if(dic.contains(temp)&& !wordList.contains(temp))
					wordList.add(temp);
					}
				br[0].mark(1000);
					}
				}
			if(flagb==1)
				break;
			}
			//System.out.println("~~~"+tempstr);
			//System.out.println("~~~"+tempstr2);
			var []obvar1=new var[number-1];
			NewThread3 [] ob=new NewThread3[number-1];
			for(int h=0;h<obvar1.length;h++)
			{
				obvar1[h]=new var();
				obvar1[h].timestamp1=tempstr;
				obvar1[h].timestamp2=tempstr2;
				obvar1[h].br=br[1];
				ob[h] = new NewThread3("logt2",obvar1[h],wordList,days,months,dic);
			}
			/*obvar1.timestamp1=tempstr;
			obvar1.timestamp2=tempstr2;
			obvar1.br=br[1];
			var obvar2=new var();
			obvar2.timestamp1=tempstr;
			obvar2.timestamp2=tempstr2;
			obvar2.br=br[2];*/
			//System.out.println("test1");
			//NewThread3 ob1 = new NewThread3("logt2",obvar1,wordList,days,months,dic); // create a new thread
		//	NewThread3 ob2 = new NewThread3("logt3",obvar2,wordList,days,months,dic);
			for(int hh=0;hh<ob.length;hh++)
			while(true)
			{
				if(!ob[hh].t.isAlive())
				{
					//System.out.println("test2");
					break;
				}
			}
			/*while(true)
			{
				if(!ob2.t.isAlive())
				{
				//	System.out.println("test2");
					break;
				}
			}*/
			StringTokenizer toknn=new StringTokenizer(tempstr2,": ");
			if(tempstr2!="0")
			{
			toknn.nextToken();
			toknn.nextToken();
			qw1=toknn.nextToken();
			qw2=toknn.nextToken();
			qw3=toknn.nextToken();
			qw4=toknn.nextToken();
			qw5=qw1+qw2+qw3+qw4;
			wq2=Integer.parseInt(qw5);
			}
			else 
				wq2=100000;
			//System.out.println(wq1+" "+wq2);
			if(wq2<wq1+10)
			{
				br[0].mark(1000);
				while ((sCurrentLine = br[0].readLine()) != null && wq2<(wq1+10)) {
					//System.out.println("kkkkkkkkkkkkkkk" + sCurrentLine);
					StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");
					
					if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
					{
						//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						qw1=tokn1.nextToken();
						qw2=tokn1.nextToken();
						qw3=tokn1.nextToken();
						qw4=tokn1.nextToken();
						qw5=qw1+qw2+qw3+qw4;
						wq2=Integer.parseInt(qw5);
						tempstr2=sCurrentLine;
					//	System.out.println("wq1::"+wq1);
						//System.out.println("wq2::"+wq2);
						
						
					}
					StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
			while (tokn2.hasMoreTokens()) {
				temp=tokn2.nextToken();
				//System.out.println("test1"+temp);
				
				if(dic.contains(temp)&& !wordList.contains(temp))
				wordList.add(temp);
				}
			if(wq2>wq1+10)
			{
				//System.out.println("!!!!!!!!!!!!!!!!!!!"+wq2+"  "+wq1);
				br[0].reset();
			
			break;
			}
			
				}
				}
		//	System.out.println("@@@@@@@@@@@@@");
			ListIterator<String> itr=wordList.listIterator();

			while(itr.hasNext())
			{
				outdet obnv=null;
				outkey obnk=new outkey();
				temp=itr.next();
			//System.out.println("jj"+temp);
				try
				{
					Statement st = c.createStatement();
				ResultSet r = st.executeQuery(query1+ "'"+temp+"'");
				while(r.next())
				{
					String str2=r.getString(1);
					
					int id=r.getInt(3);
					
					obnk.grp=id;
					obnk.outcome=str2;
					
				obnv=symhash.get(obnk);
				//System.out.println("##############################");
				//System.out.println(obnv.symptoms+obnv.cnt);
					obnv.cnt++;
					
					obnv.symptoms=obnv.symptoms+temp+", ";
					symhash.put(obnk, obnv);
				
				// System.out.println("aaaaaaaaa"+sym);
				}
			
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			try
			{
				Set set = symhash.entrySet();
				Iterator i = set.iterator();
			      // Display elements
				
				
			      while(i.hasNext()) {
			    	  int v=0;
			         Map.Entry me = (Map.Entry)i.next();
			         
			         outdet u=(outdet)me.getValue();
			         outkey yy=(outkey)me.getKey();
			         
				Statement st = c.createStatement();
				//System.out.println("SELECT * FROM OUT_SYM WHERE OUT="+ "'"+y.outcome+"'"+ "AND"+"ID= "+y.grp);
			ResultSet r = st.executeQuery("SELECT * FROM OUT_SYM WHERE OUT="+ "'"+yy.outcome+"'"+ " AND "+"ID= "+yy.grp);
			while(r.next())
			{
				v++;
				
			// System.out.println("aaaaaaaaa"+sym);
			}
			if(v!=0 && tempstr!="0" && u.cnt!=0)
			{
			System.out.print(yy.outcome+"*");
			bw.write(yy.outcome+"*");
			StringTokenizer strtok=new StringTokenizer(u.symptoms,",");
			while(strtok.hasMoreTokens())
			{
				String strtemp=strtok.nextToken();
				strtemp=strtemp.trim();
				if(!strtemp.equals(""))
				{
			System.out.print(strtemp+"@"+sym_des.get(strtemp)+",");
				bw.write(strtemp+"@"+sym_des.get(strtemp)+",");
				}
			}
		
			System.out.print("*"+tempstr+"*");
			bw.write("*"+tempstr+"*");
			
			System.out.print((float)u.cnt/v+"*");
			bw.write((float)u.cnt/v+"*");
			out_sev_link obsl =(out_sev_link)out_des.get((String)yy.outcome);
			System.out.print(obsl.sev+"*");
			bw.write(obsl.sev+"*");
			System.out.println(obsl.link);
			bw.write(obsl.link);
			bw.write('\n');
			}
			
			}
			    //  System.out.println(pp);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//br.mark(1000);
				
			
			
			}
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		try {
		if (br != null)
		{
			
		bw.close();
		for(int ik=0;ik<number;ik++)
		br[ik].close();
		//br[1].close();
		//br[2].close();

		}
		} catch (IOException ex) {
		ex.printStackTrace();
		}
		}
}
}