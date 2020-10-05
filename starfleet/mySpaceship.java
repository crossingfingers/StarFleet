package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public abstract class mySpaceship implements Spaceship {
    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected Set<?extends  CrewMember> crewMembers;

    protected int firePower=10;//
    protected int annualMaintenanceCost;//



    public  String getName()
    {
        return this.name;
    }
    public int getCommissionYear(){return this.commissionYear;}
    public  float getMaximalSpeed(){return this.maximalSpeed;}
    public Set<? extends CrewMember> getCrewMembers(){return this.crewMembers;}


    protected String myString()
    {
        String s="\tName="+this.name+"\n\tCommissionYear="+this.commissionYear+"\n\tMaximalSpeed="+this.maximalSpeed;
        s= s+"\n\tFirePower="+this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()+"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost();

        return s;
    }

    public int getFirePower() {
        return this.firePower;
    }

    public int getAnnualMaintenanceCost() {
        return this.annualMaintenanceCost;
    }

    @Override
    public  abstract String toString();

    @Override

    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof mySpaceship)) return false;
        else
            return (this.getName().equals(((mySpaceship)obj).getName()));
    }
}
