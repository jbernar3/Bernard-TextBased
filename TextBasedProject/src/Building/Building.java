package Building;

import game.Person;
public abstract class Building {

	public static final int EMPTY = 0;
	public static final int DELI = 1;
	public static final int CLO = 2;
	public static final int HOME = 3;
	
    public boolean explored = false;
    private int x, y, index;
    private Person[] occupants;
    
    public abstract void print();

    public  Building(Person[] occupants) {
        this.explored = false;
        this.occupants=occupants;
    }
	
    public void print(boolean playerIn) 
	{
		if (playerIn)
			System.out.print("[ X ]");
		
		else if (explored)
			System.out.print("[ 0 ]");
		
		else
			print();
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
