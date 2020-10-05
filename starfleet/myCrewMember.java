package il.ac.tau.cs.sw1.ex8.starfleet;

public abstract class myCrewMember implements CrewMember {

    protected String name;
    protected int age;
    protected int yearsInService;



    public  String getName()
    {
        return this.name;
    }
    public int getAge()
    {return this.age;}
    public int getYearsInService()
    {return this.yearsInService;}

    protected String myString()
    {
        String s="\tName="+this.name+"\n\tAge="+this.age+"\n\tYearsInService="+this.yearsInService;
    return s;
    }

    @Override

    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof myCrewMember)) return false;
        else
            return (this.getName().equals(((myCrewMember)obj).getName()));
    }

    @Override
    public  abstract String toString();


}
