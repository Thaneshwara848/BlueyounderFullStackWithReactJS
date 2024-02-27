class A
{
	static int x =100;
	static void abc(String name)
	{
		System.out.println("Name "+name);
	}
}
class Demo12
{
	public static void main(String args[])
	{
		//A a = new A();
		//a.abc();
		System.out.println(A.x);
		A.abc("Thanesh");
		
	}
}