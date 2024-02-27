import java.util.*;
class A
{
	void display() throws InvalidAgeException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Age ");
		int age=sc.nextInt();
		
		if(age<=18)
		{
			throw new InvalidAgeException("Invalid age");
		}
		else{
			System.out.println(" Age  is "+age);
		}
			
	}
}
class Demo19
{
	public static void main(String args[])
	{
		try
		{
			A a = new A();
			a.display();
		}
		catch(InvalidAgeException iva)
		{
			System.out.println("Please enter the proper age :"+iva.getMessage());
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class InvalidAgeException extends Exception 
{
	InvalidAgeException(String arg)
	{
		super(arg);
	}
}