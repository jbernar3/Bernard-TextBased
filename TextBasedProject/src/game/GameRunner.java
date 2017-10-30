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
    		System.out.println("Please select only S, M, L: ");
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
    	
    	System.out.println("You've selected board of size: " + citySize + " (" + citySizeInt+"x"+citySizeInt+")");
    		
    	
    	// Generating room based on the size selected
        city gameCity = new city(citySizeInt);
        gameCity.generateRooms();
        
        // Getting person info
        Person Person = new Person();
        Person.askForName(); 
        
        System.out.println("Welcome to the city, " + Person.askForName());
        
        
        
        
        boolean gameOn = true;
                
        while (gameOn) {
            
        	
            gameCity.printBoard();
		//while loop not finished;
            
          
            gameOn = false;
            
        }
		// in.close();
	}
	

}
