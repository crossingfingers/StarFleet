package il.ac.tau.cs.sw1.ex8.starfleet;

public class CrewWoman extends myCrewMember {

	
	public CrewWoman (int age, int yearsInService, String name){
	this.name=name;
	this.age=age;
	this.yearsInService=yearsInService;
		
	}
	public String toString()
	{return "CrewWoman\n"+super.myString();}


}
