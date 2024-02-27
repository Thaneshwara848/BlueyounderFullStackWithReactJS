import java.util.Scanner;
class Address
{
	int pin=2345;
	String strrt="EC";
	
}
class Emp
{
	Scanner sc = new Scanner(System.in);	
	int id;
	String name;
	Emp()
	{	
		id= sc.nextInt();
		name= sc.next();
	}	
}
class Clerk  extends Emp
{
	Clerk()
	{	
	}
	void display()
	{
		Address a = new Address();
		System.out.println("ID :"+id);
		System.out.println("Name:"+name);
		System.out.println("PIN :"+a.pin);
		System.out.println("Street : "+a.strrt);		
	}
}
class Demo7
{
	public static void main(String args[])
	{
		Clerk c = new Clerk();
		c.display();
	}
}