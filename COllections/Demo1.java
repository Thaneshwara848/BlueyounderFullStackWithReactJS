import java.util.*;
class Emp
{

}
class Demo1
{
	public static void main(String args[])
	{
		ArrayList al = new ArrayList(100);
		al.add(100);
		al.add(200);
		al.add(300);
		al.add(400);
		al.add("Thanesh");
		al.add(new Date());
		al.add(true);
		al.add('A');
		al.add(new Thread());
		al.add(new Emp());		
			
		System.out.println(al);
		
		
	}
}