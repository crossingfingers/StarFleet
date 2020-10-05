package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fighter extends mySpaceship {
	private List<Weapon> weaponList;
	private final int BaseFare=2500;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<?extends CrewMember> crewMembers, List<Weapon> weapons){
		this.name=name;
		this.commissionYear=commissionYear;
		this.maximalSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
		this.weaponList=weapons;

		int wPower=this.firePower;
		int wCost=0;

		for(Weapon a : weapons)
		{wPower+=a.getFirePower();
		wCost+=a.getAnnualMaintenanceCost();}
		this.firePower=wPower;
		this.annualMaintenanceCost=BaseFare+wCost+Math.round(1000*maximalSpeed);
	}


	public String myString()
	{return super.myString()+"\n\tWeaponArray="+this.weaponList.toString();}
	public String toString() 	{return "Fighter\n"+this.myString();}

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




	
	

