package Board;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Building.*;

public class Board {


	public static final int SMALL = 6;
	public static final int LARGE = 10;
	String name;
	
    private Building[][] buildings;
    private int boardSize = 0;
    

    public Board(int boardSizeInt) 
    {

    	this.boardSize = boardSizeInt;
    	this.buildings = new Building[boardSize][boardSize];
       
    }

    public void printBoard() 
    {
    
        for(Building[] row : buildings) 
        {
        
            for (Building nb : row) 
            {
                nb.print();
            }
            System.out.println();
        }
    }
    
    public Building[][] getRooms() 
    {
        return buildings;
    }

    private int getXFromBuildingIndex(int index) 
    {
    	return (int) index/boardSize;
    }
    
    private int getYFromBuildingIndex(int index) 
    {
    	return index % boardSize;
    }
    
    /*
     * You can get money from the banks as you reach them.
     * You can buy food and drinks from deli.
     * Your goal is to get food from at least one deli before you reach home and as much money as you can get.
     * You don't know where home is and don't know where the delis are.
     * Also, there are hidden people and places that take your money or you have to fight.
     */
    int amountOfBanks;
    int amountOfDelis;
    int amountHouse = 1;
    
    
    
    public void generateBuildings() 
    {
    	
    	if (buildings == null)
    		return;
    	
		int index=0;
    	for (int x=0; x<buildings.length; x++) 
    	{
    		for (int y=0; y<buildings[x].length; y++) 
    		{
    			index++;
    			EmptyBuilding empty = new EmptyBuilding();
    			empty.setX(x);
    			empty.setY(y);
    			empty.setIndex(index);
    			
    			buildings[x][y] = empty;
    		}
    	}
    }
    
    public void askForName() 
	{

		System.out.println("What would you like to name your neighborhood?");
		
		Scanner scName = new Scanner(System.in);
		String neighborhoodName = scName.nextLine();
		
		while (neighborhoodName.isEmpty()) 
		{
			System.out.println("Please enter a name for your neighborhood.");
			neighborhoodName = scName.nextLine();
		}
    	
    	this.name = neighborhoodName;	
		
		
	}
	public String getName()
	{
		return name;
	}
}

