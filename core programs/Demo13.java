
final class Car
{
	final  int speed= 200;
	//final void gare()
	 void gare()
	{
		System.out.println("4 ");
	}
}
class BMW extends Car
{
	void gare()
	{
		System.out.println("5 gare "+" Speed is :"+speed);
		super.gare();
	}		
}
class Demo13
{
	public static void main(String args[])
	{
		Car c = new Car();
		System.out.println("CAR Speed :"+c.speed);
		//c.speed= 2000;
		System.out.println("CAR Speed :"+c.speed);

		BMW b = new BMW();
		b.gare();
		
		
		
	}
}