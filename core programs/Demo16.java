import java.util.*;
class Demo16
{
	public static void main(String args[])
	{
		m1();
	}
	static void m1()
	{
		m2();
		System.out.println("M1 method.....!");
	}
	static void m2()
	{
		m3();
		System.out.println("M2 method.....!");
	}
	static void m3()
	{
		try
		{
			System.out.println("M3 method.....!");
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter A:");
			int a= sc.nextInt();
			System.out.print("Enter B:");
			int b= sc.nextInt();
	
			int c = a/b;
			System.out.println("Resuclt is :"+c);
		}
		catch(InputMismatchException im)
		{
			System.out.println("Hi Boss please enter the Number only");
		}
		catch(ArithmeticException ae)
		{
		System.out.println(" we cant devicde anytng by 0 ");
		}
		finally
		{
			System.out.println("Thank you......");
		}
	}
}





