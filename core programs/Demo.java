class A
{
	int a=10;
	A()
	{
		System.out.println("Hi COnstructor  "+a);
	}	
	void display()
	{
		System.out.println("Hi method");	
	}	
}
public class Demo
{
	public static void main(String args[])
	{
		A x = new A();
		x.display();	
	}
}
