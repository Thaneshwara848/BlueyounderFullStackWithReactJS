public class arraydemo{
	public static void main(String args[]){
	Emp e[]= new Emp[5];
	String str[]={"abc","def","ghi","ijk","klm"};
		for(int i=0;i<e.length;i++)
		{
			 e[i]=new Emp();
			 e[i].name= str[i];
		}
		for(int i=0;i<e.length;i++)
		{
			System.out.println(e[i].name);
		}
		for(Emp e1:e)
		{
			System.out.println("name:"+e1.name);
		}
	}
}
class Emp
{
	String name;
}