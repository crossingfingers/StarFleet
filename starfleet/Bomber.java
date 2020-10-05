package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter{
	private int numberOfTechnicians;
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
			this.numberOfTechnicians=numberOfTechnicians;
			double cost=this.annualMaintenanceCost;

			cost+=2500;

			double cReduction=0;

		for(Weapon a : weapons)
		{
			cReduction+=a.getAnnualMaintenanceCost();}
		cReduction=Math.round(cReduction*(numberOfTechnicians*0.1));
		cost=cost-cReduction;
		cost=cost-Math.round(maximalSpeed*1000);
		this.annualMaintenanceCost=(int)cost;


			}

			public String toString() {
				{return "Bomber\n"+super.myString()+"\n\tNumberOfTechnicians="+this.getNumberOfTechnicians();}
			}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
}