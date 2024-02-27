class A
{
	private int id;
	private String name;
	void setName(String name){
		this.name= name ; 
	}
	void setId(int id){
		this.id=id;
	}
	String getName(){
		return name;
	}
	int getId(){
		return id;
	}	
}
class Demo14
{
	public static void main(String args[])
	{
		A a = new A();
		a.setId(100);	
		a.setName("Thanesh");
		System.out.println(a.getId());	
		System.out.println(a.getName());			
	}
}
lunch break