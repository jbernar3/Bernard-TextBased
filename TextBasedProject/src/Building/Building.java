package Building;

import game.Person;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */

public abstract class Building implements BuildingType{

	//Constants integers for building types.
	public static final int EMPTY = 0;
	public static final int DELI = 1;
	public static final int RPS = 2;
	public static final int HOME = 3;
	public static final int CHOICE = 4;
	
	
    public boolean explored = false;
    private int x, y, index;
    private Person[] occupants;
    int buildingType = Building.EMPTY;
    Person player = null;
    
    //void function all Building objects will have.
    public abstract void print() throws InterruptedException;

    /*
     * Constructor
     * @param array of Person objects named occupants.
     */
    public  Building(Person[] occupants) 
    {
        this.explored = false;
        this.occupants=occupants;
    }
    
    /*
     * Set's the player received as the player.
     * @param Person that is the player being received to be set.
     */
    public void setPlayer(Person player)
    {
    	this.player=player;
    }
    
	//Prints the buildings in the board as either empties/unknowns, explored, or occupied.
    public void print(boolean occupied) 
    {
		if (occupied)
			System.out.print("[X]");
		else if (explored)
			System.out.print("[-]");
		else
			System.out.print("[ ]");;
	}
    
    //@return Index of the building.
	public int getIndex() 
	{
		return index;
	}
	
	//@param Index that is going to be set to this building's index.
	public void setIndex(int index) 
	{
		this.index = index;
	}
	
	//@param Boolean that says if the building has been "explored" before or not.
	public void setExplored(boolean explored) 
	{
		this.explored = explored;
	}
	
	//@param Building type in form of a integer that is set to this building's type.
	public void setBuildingType(int buildingType)
	{
		this.buildingType = buildingType;
	}
	
	//@return Building type in integer form.
	public int getBuildingType()
	{
		return buildingType;
	}


}
