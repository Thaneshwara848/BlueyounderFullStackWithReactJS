class A
{
	A()
	{
		System.out.println("A class ");
	}	
	
	void m1()
	{
		System.out.println("A class m1 method ");
	}
}
class B  extends A
{
	B()
	{
		System.out.println("B class ");
	}
}
public class Demo6
{
	public static void main(String args[])
	{
		//A a = new A();
		B b = new B();
	}
}