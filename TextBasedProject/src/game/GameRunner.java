//Jefferson C. Bernard
package game;

import java.util.Scanner;
import Board.Board;
import Building.Building;
import game.Person;



public class GameRunner {

	
    public static void main (String[] args) throws InterruptedException {

    	GameRunner gr = new GameRunner();
    	gr.runGame();
    	
    	System.exit(0);
    }
	
	private void runGame() throws InterruptedException {
		
		System.out.println("Hello! Welcome to a simulation through a new world.");
		Thread.sleep(1500);
		System.out.println("You will be playing a survival game placed in NYC.");
		Thread.sleep(1500);
		System.out.println("You have snuck out of your house and you want to make as much money as possible by gambling with people you will find along the way.");
		Thread.sleep(1500);
		System.out.println("But you can't go home hungry so you must stop at a deli.");
		Thread.sleep(1500);
		System.out.println("The problem is though..... you don't know where anything is.");
		Thread.sleep(1500);
		System.out.println("Do you want to play in a small or large neighborhood?");
    	
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
        player.setPosition(0, 0, boardSizeInt);
        Building build = gameNeighborhood.getBuildings()[0][0];
        
        
        player.askForName(); 
        gameNeighborhood.askForName();
        
        gameNeighborhood.setPlayer(player);
        //System.out.println(player.getPosY());
        
        System.out.println("Welcome to your neighborhood, "+player.getName()+"\nIt looks like a beautiful night in "+gameNeighborhood.getName());
        
        
      
        
        boolean gameOn = true;
                
        while (gameOn) 
        {
            gameNeighborhood.printBoard();
            
            System.out.println("You have $" + player.getMoney() + " left.");
            
            String move = player.chooseMove();
            
            if (move.equalsIgnoreCase("u")) 
            {
    			if (player.getPosY()  > 0) 
    				player.setPosition(player.getPosX(), player.getPosY()-1, boardSizeInt);    		
    			
    		} 
            else if (move.equalsIgnoreCase("l")) 
            {
    			
    			if (player.getPosX() > 0) 
    				player.setPosition(player.getPosX()-1, player.getPosY(), boardSizeInt);
    			
    		} 
            else if (move.equalsIgnoreCase("r")) 
    		{		
    			
    			if (player.getPosY() < boardSizeInt-1) 
    				player.setPosition(player.getPosX(), player.getPosY()+1, boardSizeInt);    	
    			
    		} 
    		else if (move.equalsIgnoreCase("d")) 
    		{
    			
    			if (player.getPosX() < boardSizeInt-1) 
    				player.setPosition(player.getPosX()+1, player.getPosY(), boardSizeInt);
    				
    		}
            
            
        }
		// in.close();
	}
	

}
