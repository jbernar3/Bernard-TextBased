//Jefferson C. Bernard
package game;

import java.util.Scanner;
import Board.Board;
import Building.Building;


public class GameRunner {

	
    public static void main (String[] args) {

    	GameRunner gr = new GameRunner();
    	gr.runGame();
    	
    	System.exit(0);
    }
	
	private void runGame() {
		
		System.out.println("Hello! Welcome to a simulation through a new world. \nDo you want to play in a small or large neighborhood?");
    	
    	Scanner sc = new Scanner(System.in);
    	String boardType = sc.nextLine();
  	
    	while (!boardType.equalsIgnoreCase("small") && !boardType.equalsIgnoreCase("large")) 
    	{
    		System.out.println("Please select only small or large: ");
    		boardType = sc.nextLine();    		
    	}
    	
    	int boardSizeInt;
    	if (boardType.equalsIgnoreCase("small")) 
    	{
    		boardSizeInt = Board.SMALL;
    	}
    	else
    	{
    		boardSizeInt = Board.LARGE;
    	}
    	
    	System.out.println("You've selected board: " + boardType + " (" + boardSizeInt+"x"+boardSizeInt+")");
   
    	// Generating buildings based on chose of size
        Board gameNeighborhood = new Board(boardSizeInt);
        gameNeighborhood.generateBuildings();
        
        // Getting info from user
        Person player = new Person();
        player.askForName(); 
        gameNeighborhood.askForName();
        
        System.out.println("Welcome to your neighborhood, "+player.getName()+"\nIt looks like a beautiful night in "+gameNeighborhood.getName());
        
        
        
        
        boolean gameOn = true;
                
        while (gameOn) 
        {
            gameNeighborhood.printBoard();
		//while loop not finished;
            
          //temporary.  Need to implement player moves and other actions in everyday.
            gameOn = false;
            
        }
		// in.close();
	}
	

}
