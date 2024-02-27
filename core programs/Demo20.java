import java.util.*;
class A extends Thread 
{
	public void run() 
	{	
		try
		{
			for(int i=0;i<=3;i++)
			{		
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
class B extends Thread
{
	public void run() 
	{	
		try
		{
			for(int j=0;j<=8;j++)
			{		
				System.out.println("	J:"+j);
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
		B b = new B();
		a.start();
		b.start();
	}
}
