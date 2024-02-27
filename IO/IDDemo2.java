
import java.io.*;
import java.util.*;
class IDDemo2
{
	public static void main(String args[])
	{
		try
		{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the File ");
	String fname=br.readLine();

	File f= new File(fname);
	if(f.exists())
	{
		BufferedReader fr= new BufferedReader(new FileReader(fname));
		String line;
		while((line=fr.readLine())!=null)
		{	
			System.out.println(line);
		}
	}
	else{
		System.out.println("Sorry File not exixtes ");
	}
	
		}
		catch(Exception e)
		{
	
		}
	}
}






