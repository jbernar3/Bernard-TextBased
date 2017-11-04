package Board;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import game.Person;
import Building.Building;
import Building.Deli;
import Building.EmptyBuilding;
import Building.home;

public class Board {


	public static final int SMALL = 6;
	public static final int LARGE = 8;
	
	String name;
	private Person player;
    private Building[][] buildings;
    private int boardSize = 0;
    

    public Board(int boardSizeInt) 
    {

    	this.boardSize = boardSizeInt;
    	this.buildings = new Building[boardSize][boardSize];
       
    }

    public void printBoard() 
    {
        
        for(Building[] row : buildings) {
        
            for (Building building : row) {
                building.print(isOccupied1(building));
            }
            System.out.println();
        }
    }
    
    public Person getPlayer()
    {
    	return player;
    }
    
    public void setPlayer(Person player)
    {
    	this.player = player;
    }
    
    public Building[][] getBuildings() 
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
    
    //int amountOfBanks;
    //int amountOfDelis;
    //int amountHouse = 1;
    
    private boolean isOccupied1(Building building) 
    {
    	
    	if (this.getPlayer() == null)
    		return false;
    	
    	if (building.getIndex() == this.getPlayer().getIndex()) 
    	{
    		//System.out.println(building.getIndex());
    		return true;
    	}
    		
    	else 
    		return false;
    
    }
    
    private void createDeli(int randRoomIndex) 
    {
    	Person[] occupants = null;
		Deli del = new Deli(occupants);    			
		del.setIndex(randRoomIndex);	
		del.setPlayer(player);
		buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = del;
		del.setBuildingType(1);
    }
    
    private void createHome(int randRoomIndex)
    {
    	Person[] occupants = null;
    	home house = new home(occupants);
    	house.setIndex(randRoomIndex);
    	//house.setPlayer(randRoomIndex);
    	buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = house;
    	house.setBuildingType(3);
    }
    
    
    public void generateBuildings() 
    {
    	Person[] occupants = null;
    	
    	if (buildings == null)
    		return;
    	
		int index=0;
    	for (int x=0; x<buildings.length; x++) 
    	{
    		for (int y=0; y<buildings[x].length; y++) 
    		{
    			EmptyBuilding empty = new EmptyBuilding(occupants);
    			
    			empty.setIndex(index);
    			buildings[x][y] = empty;
    			
    			index++;
   			}
    	}
    	
    	int amountOfDelis = 0;
    	int amountOfCLO = 0;
    	int amountOfHome = 1;
    	if (boardSize == Board.SMALL)
    	{
    		amountOfDelis = 6;
    		amountOfCLO = 3;
    	}
    	
    	else if (boardSize == Board.LARGE)
    	{
    		amountOfDelis = 12;
    		amountOfCLO = 9;
    	}
    	
    	int lastBuildingIndex = boardSize*boardSize;
		
	    Integer[] randomBuildings = new Integer[lastBuildingIndex-3];
	    for (int i = 0; i < randomBuildings.length; i++) {
	    	randomBuildings[i] = i+1;
	    }
	    Collections.shuffle(Arrays.asList(randomBuildings));
	    
	    // Deli
	    for (int x=0; x<amountOfDelis; x++) 
	    {
	    	int randBuildingIndex = randomBuildings[x];
	    	while (randBuildingIndex == 0)
	    	{
	    		randBuildingIndex = randomBuildings[x];
	    	}
	    	createDeli(randBuildingIndex);
	    }
    	
	    for (int x=0; x<amountOfCLO; x++) {
	    	int randBuildingIndex = randomBuildings[x+amountOfDelis];
	    	
	    }
	    for (int x=0; x<amountOfHome;x++)
	    {
	    	int randBuildingIndex = randomBuildings[x+amountOfDelis+amountOfCLO];
	    	while (randBuildingIndex==0)
	    	{
	    		randBuildingIndex = randomBuildings[x+amountOfDelis+amountOfCLO];
	    	}
	    	createHome(randBuildingIndex);
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

