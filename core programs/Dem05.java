class A
{	int a=10;
	int b=20;
	void m1()
	{
		System.out.println("M1 :"+(a+b));
	}
}
class B extends A
{
	int c=30;
	int d=40;	
		
	void m2()
	{
		System.out.println("M2  :"+(c+d));
	}
}
public class Dem05
{
	public static void main(String args[])
	{
		A a = new A();
		a.m1();
		B b = new B();
		b.m1();
		b.m2();
	}
}