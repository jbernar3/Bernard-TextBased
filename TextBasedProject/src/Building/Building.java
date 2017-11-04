package Building;

import game.Person;

public abstract class Building implements BuildingType{

	public static final int EMPTY = 0;
	public static final int DELI = 1;
	public static final int CLO = 2;
	public static final int HOME = 3;
	
	
    public boolean explored = false;
    private int x, y, index;
    private Person[] occupants;
    int buildingType = Building.EMPTY;
    Person player = null;
    
    public abstract void print();

    public  Building(Person[] occupants) 
    {
        this.explored = false;
        this.occupants=occupants;
    }
    
    public void setPlayer(Person player)
    {
    	this.player=player;
    }
    
	
    public void print(boolean occupied) 
    {
		if (occupied)
			System.out.print("[X]");
		else if (explored)
			System.out.print("[-]");
		else
			System.out.print("[ ]");;
	}
    

	public int getIndex() 
	{
		return index;
	}

	public void setIndex(int index) 
	{
		this.index = index;
	}
	
	public void setExplored(boolean explored) 
	{
		this.explored = explored;
	}
	
	public void setBuildingType(int buildingType)
	{
		this.buildingType = buildingType;
	}
	
	public int getBuildingType()
	{
		return buildingType;
	}
/*
	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}
*/

}
