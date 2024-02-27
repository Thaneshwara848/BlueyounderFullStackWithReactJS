import java.io.*;
import java.util.*;
class Demo1
{
	public static void main(String args[])
	{
		try
		{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	//Scanner sc= new Scanner(System.in);
		System.out.println("Enter ID : ");
		//int id= sc.nextInt();
		int id= Integer.parseInt(br.readLine());

		System.out.println("Enter Name : ");
		String name= br.readLine();
		//String name= sc.nextLine();

		System.out.println("Enter Desig : ");
		String desig= br.readLine();
		//String desig= sc.nextLine();


		System.out.println("ID  : "+id );
		System.out.println("Name  : "+name );
		System.out.println("Desig  : "+desig );

		}
		catch(Exception e)
		{
	
		}
	}
}