class A extends Thread 
{
	public void run() 
	{	
		try
		{
			for(int i=0;i<=20;i++)
			{	
				if(Thread.currentThread().getName().equals("BMW"))
				{
					System.out.println("BMW :"+i);	
				
				}
				if(Thread.currentThread().getName().equals("BENZ"))
				{
					System.out.println("	BENZ :"+i);	
				
				}		
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class Demo22
{
	public static void main(String args[])
	{
		A a = new A();
		Thread t1= new Thread(a);
		Thread t2= new Thread(a);
		
		t1.start();
		t2.start();
		t1.setName("BMW");
		t2.setName("BENZ");

		try
		{
			for(int k=0;k<=30;k++)
			{
				System.out.println("			K :"+k);
				Thread.sleep(1000);
				if(k==10){
					t1.wait();
				}
				if(k==25){
					t1.notify();
				}
				if(k==15){
					t2.suspend();
				}
				if(k==18)
				{
					System.out.println(t2.isAlive());
				}
				if(k==10){
					t1.suspend();
				}
				if(k==20){
					t2.stop();
				}
				
			}
		}
		catch(Exception e)
		{}
	}
}