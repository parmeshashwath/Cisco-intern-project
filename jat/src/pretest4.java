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

public class pretest4 {

	public static void main(String agr[])
	{
		BufferedReader br=null;
	String scl;
		try
		{
			br = new BufferedReader(new FileReader("C:/output_jathin.txt"));
			while((scl=br.readLine())!=null)
			{
				System.out.println(scl.substring(0, 10));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 

		finally {
			try {
				br.close();
				

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		}
	}