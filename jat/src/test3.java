

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class test3 {

	public static void main(String agr[])
	{
		List<String> wordList = new ArrayList();
		HashSet days = new HashSet();
		HashSet months=new HashSet();
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
		String sCurrentLine=" ";
		String tempstr=" ";
		String temp=" ";
		BufferedWriter bw=null;
		BufferedReader br=null;
		try
		{
			br = new BufferedReader(new FileReader("C:/Users/parma/Desktop/AZAD/project1/data/merged.txt"));
			// br = new BufferedReader(new FileReader("C:/input_e.txt"));
			FileWriter fw = new FileWriter("C:/output_merged.txt");
			bw = new BufferedWriter(fw);
			while ((sCurrentLine = br.readLine()) != null) {
				wordList.clear();
				//System.out.println(sCurrentLine);
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");

				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{

					tempstr=sCurrentLine;
					System.out.println(tempstr);
					//	continue;
					br.mark(1000);
					while ((sCurrentLine = br.readLine()) != null) {

						StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");

						if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
						{
							//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
							br.reset();
							break;
						}
						StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, ": ");
						while (tokn2.hasMoreTokens()) {
							temp=tokn2.nextToken();
							//System.out.println(temp);
							wordList.add(temp);
						}
						br.mark(1000);
					}
					bw.write(tempstr + " ");
				}
				ListIterator<String> itr=wordList.listIterator();
				//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				//tempi=itr.next();

				while(itr.hasNext())
				{
					bw.write(itr.next());
					bw.write(" ");
				}
				//bw.write('\n');
				bw.write('\r');
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 

		finally {
			try {
				br.close();
				bw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
