package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		int cost=this.annualMaintenanceCost;

		cost+=1500;
		cost+= (500*crewMembers.size());
		cost=cost-Math.round(500*maximalSpeed);

		this.annualMaintenanceCost=cost;
	}




public String toString() {
		{return "ColonialViper\n"+super.myString();}
		}
}