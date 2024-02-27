import java.util.*;
import java.io.*;
import java.sql.*;
class A
{
	void abc() throws FileNotFoundException , SQLException,ArithmeticException
	{
		for(int age=0;age<=20;age++)
		{
			if(age==18) throw new ArithmeticException();
			if(age==15) throw new InputMismatchException();
			if(age==10) throw new FileNotFoundException();
			if(age==8) throw new SQLException();
			System.out.println("I :"+age);
		}
	}
}
class Demo18
{
	public static void main(String args[]) 
	{
		try
		{
			A a = new A();
			a.abc();
			try
			{
			}
			catch(Exception e)
			{
			}
		}
		catch(ArithmeticException ae)
		{
			System.out.println("ArithmeticException came ");
			try
			{
			}
			catch(Exception e)
			{
			}
		}
		catch(InputMismatchException im)
		{
			System.out.println("InputMismatchException");
		}		
		catch(SQLException sql)
		{
			System.out.println("SQLException came ");
		}
		
		catch(FileNotFoundException fnf)
		{
			System.out.println("FileNotFoundException came ");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Thank you  ");
			try
			{
			}
			catch(Exception e)
			{
			}
		}
	}
}