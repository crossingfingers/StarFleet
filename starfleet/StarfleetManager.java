package il.ac.tau.cs.sw1.ex8.starfleet;


import javafx.collections.transformation.SortedList;

import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> sFleet=new ArrayList<Spaceship>();
		sFleet.addAll(fleet);
		sFleet.sort(new myShipComparator());
		List<String> ships = new ArrayList<String>();

		for( Spaceship s : sFleet)
		{ships.add(s.toString());
		}

		return ships;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {

		Map<String,Integer> map=new HashMap<>();
		for(Spaceship a : fleet)
		{
			if(!map.containsKey(a.getClass().getSimpleName()))
			{
				map.put(a.getClass().getSimpleName(),1);
			}
			else{map.put(a.getClass().getSimpleName(),map.get(a.getClass().getSimpleName())+1);}
		}
		return map;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost=0;
		for(Spaceship a : fleet)
		{totalCost+=a.getAnnualMaintenanceCost();}
		return totalCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		SortedSet<String> weaponList=new TreeSet<>();

		for (Spaceship a : fleet)
		{if(a.getClass()!=TransportShip.class)
			if(a.getClass()==StealthCruiser.class)
			weaponList.addAll(((StealthCruiser)a).getWeapons());
			else
				weaponList.addAll(((Fighter)a).getWeapons());
		}
	return weaponList;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalCrew=0;
		for(Spaceship a : fleet)
		{totalCrew+=a.getCrewMembers().size();}
		return totalCrew;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	private static ArrayList<Officer> myGetOfficers(Spaceship a)
	{
		ArrayList<Officer>  crew=new ArrayList<>();

		for(CrewMember b : a.getCrewMembers())
		{if(b.getClass()==Officer.class){crew.add((Officer)b);}
		}
		return crew;
	}
	private static ArrayList<CrewMember> myGetAllCrew(Collection<Spaceship> fleet)
	{ArrayList<CrewMember>  crew=new ArrayList<>();
		for(Spaceship a : fleet)
		{crew.addAll(myGetOfficers(a));

		}
		return crew;
	}

	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {

		float AVG=0;
		int counter=0;
		ArrayList<CrewMember>  crew=myGetAllCrew(fleet);
		for(CrewMember a : crew)
		{if(a.getClass()==Officer.class)
			counter++;
			AVG+=((Officer)a).getAge();}
		return (AVG/counter);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		ArrayList<Officer> shipCrew;
		Map<Officer,Spaceship> map = new HashMap<>();
		for(Spaceship a : fleet)
		{	shipCrew=myGetOfficers(a);
			shipCrew.sort(new myOfficerComparator());
			if(shipCrew.size()!=0)
			{map.put(shipCrew.get(shipCrew.size()-1),a);}
		}
	return map;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {

		Map<OfficerRank,Integer> map=new HashMap<>();
		ArrayList<Officer> oList=new ArrayList<>();
		for(Spaceship a : fleet)
		{
			oList=myGetOfficers(a);
			if(oList.size()!=0){
			for(Officer o: oList)
			{
				if(!map.containsKey(o.getRank())){map.put(o.getRank(),1);}
				else{map.put(o.getRank(),map.get(o.getRank())+1);}
			}
		}
		}
		ArrayList<Map.Entry<OfficerRank,Integer>> list=new ArrayList<>();
		for(Map.Entry<OfficerRank,Integer> o : map.entrySet())
		{list.add(o);}
		list.sort(new Comparator<Map.Entry<OfficerRank, Integer>>() {
			@Override
			public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
				int comp= o1.getValue().compareTo(o2.getValue());
				if(comp==0){return o1.getKey().compareTo(o2.getKey());} return comp;
			}
		});
		return list;
	}

}
