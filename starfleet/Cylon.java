package il.ac.tau.cs.sw1.ex8.starfleet;

public class Cylon extends myCrewMember {
		private int modelNumber;
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
		this.modelNumber = modelNumber;
	}
	public String toString(){
		return "Cylon\n"+super.myString()+"\n\tModelNumber="+this.modelNumber;
		}

}
