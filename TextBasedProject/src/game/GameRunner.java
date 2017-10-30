//Jefferson C. Bernard
package game;

import java.util.Scanner;
import City.city;
import neighborhood.Neighborhood;


public class GameRunner {

	
    public static void main (String[] args) {

    	GameRunner gr = new GameRunner();
    	gr.runGame();
    	
    	System.exit(0);
    }
	
	
	
	private void runGame() {
		
		System.out.println("Hello! Welcome to a simulation through a new world. \nDo you want to play in a Urban place or a Suburban place?");
    	
    	Scanner sc = new Scanner(System.in);
    	String citySize = sc.nextLine();
  	
    	while (!citySize.equalsIgnoreCase("Urban") && !citySize.equalsIgnoreCase("Suburban")) 
    	{
    		System.out.println("Please select only Urban or Suburban: ");
    		citySize = sc.nextLine();    		
    	}
    	
    	
    	int citySizeInt;
    	if (citySize.equalsIgnoreCase("Urban")) 
    	{
    		citySizeInt = city.URBAN;
    	}
    	else
    	{
    		citySizeInt = city.SUBURBAN;
    	}
    	
    	System.out.println("You've selected board: " + citySize + " (" + citySizeInt+"x"+citySizeInt+")");
    		
    	
    	// Generating room based on the type of place
        city gameCity = new city(citySizeInt);
        gameCity.generateNeighborhoods();
        
        // Getting person info
        Person player = new Person();
        player.askForName(); 
        
        System.out.println("Welcome to the city, "+player.getName()+"\nYou are the X on the board! Find your location.");
        
        
        
        
        boolean gameOn = true;
                
        while (gameOn) {
            
        	
            gameCity.printBoard();
		//while loop not finished;
            
          //temporary.  Need to implement player moves and other actions in everyday.
            gameOn = false;
            
        }
		// in.close();
	}
	

}
