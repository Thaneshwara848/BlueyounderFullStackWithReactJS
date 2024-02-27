import java.util.*;
class A extends Thread 
{
	public void run() 
	{	
		try
		{
			for(int i=0;i<=500;i++)
			{		
				ss 
				mm
				hr 
				System.out.println("I :"+i);
				
				Thread.sleep(1000);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class Demo20
{
	public static void main(String args[])
	{
		A a = new A();			
		a.start();
	}
}
