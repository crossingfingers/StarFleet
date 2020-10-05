package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		int cost=this.annualMaintenanceCost;

		cost+=1000;
		cost+= (500*crewMembers.size());
		cost+=Math.round(maximalSpeed*200);

		this.annualMaintenanceCost=cost;

	}


	public String toString() {
		{return "CylonRaider\n"+super.myString();}
	}
}
