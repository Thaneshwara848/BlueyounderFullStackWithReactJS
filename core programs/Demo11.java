class A
{
	int a;
	A()
	{
	}
}
abstract class B 
{
	int a ;
	B(){}
} 
interface I
{
	int a=100;
	//I(){}	
	void xyz();
}
interface J
{
}
interface K extends J,I 
{
}
class Y
{
}
class X  extends Y implements K
{
	public void xyz(){}
}

interface S1
{
	void add();
}
interface S2
{
	void add();
}
class S3 implements S1,S2
{
	void add()
	{
		int a =100;
		int b =200;
		System.out.println(a+b);
	}	

}
class Demo11
{
	public static void main(String arg[])
	{
		S3 s3= new S3();
		s3.add();
	
	}
}















