class Bank
{
	public int  roi()
	{		
		return 7;
	}
}
class SBI extends Bank
{
}
class Axix extends Bank
{
	public int roi()
	{		
		return 9;
	}
}

class Demo9
{
	public static void main(String args[])
	{
		SBI s = new SBI();
		System.out.println(s.roi());
		Axix a = new Axix();
		System.out.println(a.roi());	
	}
}