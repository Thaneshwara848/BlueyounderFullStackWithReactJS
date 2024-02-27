
import java.io.*;
import java.util.*;
class Demo3
{
	public static void main(String args[])
	{
		try
		{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

	
	File dir1= new File("abc");
	dir1.mkdir();

	File dir2= new File("xyz");
	dir2.mkdir();
	
	File f = new File(dir2,"atoz.txt");
	if(f.exists())
	{
		System.out.println("File existes  ");
		PrintWriter pw= new PrintWriter(new FileOutputStream(f,true));
		pw.print(br.readLine());
		pw.close();
	}
	else{
		f.createNewFile();
	}
	
		}
		catch(Exception e)
		{
	
		}
	}

	
}






