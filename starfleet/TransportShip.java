package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Collection;
import java.util.Set;

public class TransportShip extends mySpaceship {
	private int cargoCapacity;
	private int passengerCapacity;
	private final int BaseFare=3000;


	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity) {
		this.name=name;
		this.commissionYear=commissionYear;
		this.maximalSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;
		this.annualMaintenanceCost=this.BaseFare+(this.cargoCapacity*5)+(this.passengerCapacity*3);
	}

	public String toString() {
		{return "TransportShip\n"+super.myString()+"\n\tCargoCapacity="+this.cargoCapacity+"\n\tPassengerCapacity="+this.passengerCapacity;}
	}


}