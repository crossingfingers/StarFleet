package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends mySpaceship {
	 protected static int stealthCounter;
	private List<Weapon> weaponList;
	private final int BaseFare=2500;
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		this.name=name;
		this.commissionYear=commissionYear;
		this.maximalSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
		this.weaponList=weapons;
		int wPower=this.firePower;
		for(Weapon a : weapons)
		{wPower+=a.getFirePower();}
		this.firePower=wPower;
		stealthCounter++;
		this.annualMaintenanceCost=this.calcCost();


	}



	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		List<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon ("Laser Cannons",10,100));
		this.name=name;
		this.commissionYear=commissionYear;
		this.maximalSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
		this.weaponList=weapons;
		int wPower=this.firePower;
		for(Weapon a : weapons)
		{wPower+=a.getFirePower();}
		this.firePower=wPower;
		stealthCounter++;
		this.annualMaintenanceCost=this.calcCost();

	}

	private int calcCost()
	{


		int wCost=0;

		for(Weapon a : this.weaponList)
		{
			wCost+=a.getAnnualMaintenanceCost();}
		return BaseFare+wCost+Math.round(1000*maximalSpeed)+(50*stealthCounter);
	}

	@Override
	public String toString() {
		return "StealthCruiser\n"+super.myString()+"\n\tWeaponArray="+this.weaponList.toString();
	}

	public int getAnnualMaintenanceCost() {
		this.annualMaintenanceCost=this.calcCost();
		return this.annualMaintenanceCost;
	}

	protected  List<String> getWeapons()
	{
		ArrayList<String> weapons=new ArrayList<>();
		for(Weapon a : this.weaponList)
		{
			weapons.add(a.getName().toString());

		}
		return weapons;
	}
}
