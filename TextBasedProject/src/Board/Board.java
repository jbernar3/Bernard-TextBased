package Board;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import game.Person;
import Building.Building;
import Building.ChoiceBuilding;
import Building.Deli;
import Building.EmptyBuilding;
import Building.RockPaperScissors;
import Building.home;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */

public class Board {

	//Dimension sizes for types of boards.
	public static final int SMALL = 6;
	public static final int LARGE = 8;
	
	String name;
	private Person player;
    private Building[][] buildings;
    private int boardSize = 0;
    
    /*
     * Constructor.
     * Creates the Board.
     * @param the size of the board in integer form.
     */
    public Board(int boardSizeInt) 
    {

    	this.boardSize = boardSizeInt;
    	this.buildings = new Building[boardSize][boardSize];
       
    }

    //Prints the board based on where the user is.
    public void printBoard() 
    {
        
        for(Building[] row : buildings) {
        
            for (Building building : row) {
                building.print(isOccupied1(building));
            }
            System.out.println();
        }
    }
    //@return the player.
    public Person getPlayer()
    {
    	return player;
    }
    
    /*
     * Set's the player received as the player.
     * @param Person that is the player being received to be set.
     */
    public void setPlayer(Person player)
    {
    	this.player = player;
    }
    
    //@return 2d array of buildings for later use.
    public Building[][] getBuildings() 
    {
        return buildings;
    }
    
    //@return the integer value of the x coordinate of the building on the board.
    private int getXFromBuildingIndex(int index) 
    {
    	return (int) index/boardSize;
    }
    
    //@return the integer value of the y coordinate of the building on the board.
    private int getYFromBuildingIndex(int index) 
    {
    	return index % boardSize;
    }
    
    /*
     * Checks whether the player's index is the same as the building's index.
     * @return a boolean determining if the player is in this building.
     * @param the building it is checking.
     */
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
    
    /*
     * Creates a deli.
     * @param the assigned random room index.
     */
    private void createDeli(int randRoomIndex) 
    {
    	Person[] occupants = null;
		Deli del = new Deli(occupants);    			
		del.setIndex(randRoomIndex);	
		del.setPlayer(player);
		buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = del;
		del.setBuildingType(1);
    }
    
    /*
     * Creates a rock paper scissor game.
     * @param the assigned random room index.
     */
    private void createRPS(int randRoomIndex) 
    {
    	Person[] occupants = null;
		RockPaperScissors rps = new RockPaperScissors(occupants);    			
		rps.setIndex(randRoomIndex);	
		rps.setPlayer(player);
		buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = rps;
		rps.setBuildingType(2);
    }
    
    /*
     * Creates the home.
     * @param the assigned random room index.
     */
    private void createHome(int randRoomIndex)
    {
    	Person[] occupants = null;
    	home house = new home(occupants);
    	house.setIndex(randRoomIndex);
    	house.setPlayer(player);
    	buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = house;
    	house.setBuildingType(3);
    }
    
    /*
     * Creates choice building game.
     * @param assigned random room index.
     */
    private void createChoice(int randRoomIndex)
    {
    	Person[] occupants = null;
    	ChoiceBuilding choice = new ChoiceBuilding(occupants);
    	choice.setIndex(randRoomIndex);
    	choice.setPlayer(player);
    	buildings[getXFromBuildingIndex(randRoomIndex)][getYFromBuildingIndex(randRoomIndex)] = choice;
    	choice.setBuildingType(4);
    }
    
    /*
     * Generates all types of rooms randomly.
     */
    public void generateBuildings() 
    {
    	Person[] occupants = null;
    	
    	if (buildings == null)
    		return;
    	
    	//Makes the buildings all empty at first.
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
    	
    	//Decides and randomly assigns the different the types of buildings.
    	int amountOfDelis = 0;
    	int amountOfRPS = 0;
    	int amountOfHome = 1;
    	int amountOfChoice = 0;
    	if (boardSize == Board.SMALL)
    	{
    		amountOfDelis = 3;
    		amountOfRPS = 5;
    		amountOfChoice = 3;
    	}
    	
    	else if (boardSize == Board.LARGE)
    	{
    		amountOfDelis = 5;
    		amountOfRPS = 7;
    		amountOfChoice = 6;
    	}
    	
    	int lastBuildingIndex = boardSize*boardSize;
		
	    Integer[] randomBuildings = new Integer[lastBuildingIndex-3];
	    for (int i = 0; i < randomBuildings.length; i++) {
	    	randomBuildings[i] = i+1;
	    }
	    Collections.shuffle(Arrays.asList(randomBuildings));
	    
	    // Deli
	    for (int i=0; i<amountOfDelis; i++) 
	    {
	    	int randBuildingIndex = randomBuildings[i];
	    	while (randBuildingIndex == 0)
	    	{
	    		randBuildingIndex = randomBuildings[i];
	    	}
	    	createDeli(randBuildingIndex);
	    }
	    
    	
	    for (int i=0; i<amountOfRPS; i++) {
	    	int randBuildingIndex = randomBuildings[i+amountOfDelis];
	    	while (randBuildingIndex==0)
	    	{
	    		randBuildingIndex = randomBuildings[i+amountOfDelis];
	    	}
	    	createRPS(randBuildingIndex);
	    	
	    }
	    for (int i=0; i<amountOfChoice; i++)
	    {
	    	int randBuildingIndex = randomBuildings[i+amountOfDelis+amountOfRPS];
	    	while (randBuildingIndex==0)
	    	{
	    		randBuildingIndex = randomBuildings[i+amountOfDelis+amountOfRPS];
	    	}
	    	createChoice(randBuildingIndex);
	    }
	    
	    for (int i=0; i<amountOfHome; i++)
	    {
	    	int randBuildingIndex = randomBuildings[i+amountOfDelis+amountOfRPS];
	    	while (randBuildingIndex==0)
	    	{
	    		randBuildingIndex = randomBuildings[i+amountOfDelis+amountOfRPS+amountOfChoice];
	    	}
	    	createHome(randBuildingIndex);
	    }
	   
    	
    }
    
    //Asks the user the name of the neighborhood.
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
    
    //Returns the name of the board.
	public String getName()
	{
		return name;
	}
	
	
}

