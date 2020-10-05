package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.Comparator;


class myShipComparator implements Comparator<Spaceship>{

	public myShipComparator() {

	}
	
	@Override
	public int compare(Spaceship s1, Spaceship s2) {
		if(s1.getFirePower()<s2.getFirePower()){return 1;}
		if(s1.getFirePower()>s2.getFirePower()){return -1;}
		else {
			if(s1.getCommissionYear()<s2.getCommissionYear()){return 1;}
			if(s1.getCommissionYear()>s2.getCommissionYear()){return -1;}
		}
			if(s1.getName().compareTo(s2.getName())<0){return -1;}
			if(s1.getName().compareTo(s2.getName())>0){return 1;}
			else return 0;
			}
		} //replace this with the actual returned value




