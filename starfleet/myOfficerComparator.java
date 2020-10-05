package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.Comparator;


class myOfficerComparator implements Comparator<Officer> {

	public myOfficerComparator() {

	}
	
	@Override
	public int compare(Officer s1, Officer s2) {
		return	s1.getRank().compareTo(s2.getRank());
		}}




