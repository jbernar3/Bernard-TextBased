package game;

import java.util.Scanner;
import Board.Board;
import Building.Building;
import Building.Deli;
import game.Person;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */


public class GameRunner {

	//main function creates and runs a game runner.
    public static void main (String[] args) throws InterruptedException {

    	GameRunner gr = new GameRunner();
    	gr.runGame();
    	
    	System.exit(0);
    }
	
    //Runs the game from beginning to end.
	private void runGame() throws InterruptedException 
	{
		//Introduction of the game for the user.
		int sleepTime = 750;
		System.out.println("Hello! Welcome to a simulation through a new world.");
		Thread.sleep(sleepTime);
		System.out.println("You will be playing a survival game placed in NYC.");
		Thread.sleep(sleepTime);
		System.out.println("You have snuck out of your house and you want to make as much money as possible by gambling with people you will find along the way.");
		Thread.sleep(sleepTime);
		System.out.println("But you can't go home hungry so you must stop at a deli.");
		Thread.sleep(sleepTime);
		System.out.println("The problem is though..... you don't know where anything is.");
		Thread.sleep(sleepTime);
		System.out.println("You will have $10 to start off with that you stole from your mom.");
		Thread.sleep(sleepTime);
		System.out.println("But if you don't end up with at least $10 then your mom will murder you!");
		Thread.sleep(sleepTime);
		//Getting preferred size from user.
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
    		boardSizeInt = Board.SMALL;
    	else
    		boardSizeInt = Board.LARGE;
    	
    	System.out.println("You've selected board: " + boardType + " (" + boardSizeInt+"x"+boardSizeInt+")");
   
    	// Generating buildings based on chose of size
        Board gameNeighborhood = new Board(boardSizeInt);
        gameNeighborhood.generateBuildings();
        
        // Getting info from user
        Person player = new Person();
        player.setPosition(0, 0, boardSizeInt);
        Building build = gameNeighborhood.getBuildings()[0][0];
        
        //Getting names of player and neighborhood.
        player.askForName(); 
        gameNeighborhood.askForName();
        
        gameNeighborhood.setPlayer(player);
        //System.out.println(player.getPosY());
        
        System.out.println("Welcome to your neighborhood, "+player.getName()+"\nIt looks like a beautiful night in "+gameNeighborhood.getName());
        
        
      
        
        boolean gameOn = true;
                
        while (gameOn) 
        {
        	//Prints the board.
            gameNeighborhood.printBoard();

            //Basic turn by turn info.
			System.out.println("You have $" + player.getMoney() + " left.");
			if (player.getHungry())
			{
				System.out.println("YOU ARE HUNGRY");
			}
			if (player.getThirsty())
			{
				System.out.println("YOU ARE THIRSTY");
			}
            
			//Player choosing his/her move.
            String move = player.chooseMove();
            gameNeighborhood.getBuildings()[0][0].setExplored(true);
            
            //Choice left.
            if (move.equalsIgnoreCase("a")) 
            {
    			if (player.getPosY()  > 0) 
    				player.setPosition(player.getPosX(), player.getPosY()-1, boardSizeInt);    		
    			
    		} 
            //Choice up.
            else if (move.equalsIgnoreCase("w")) 
            {
    			
    			if (player.getPosX() > 0) 
    				player.setPosition(player.getPosX()-1, player.getPosY(), boardSizeInt);
    			
    		} 
            //Choice right.
            else if (move.equalsIgnoreCase("d")) 
    		{		
    			
    			if (player.getPosY() < boardSizeInt-1) 
    				player.setPosition(player.getPosX(), player.getPosY()+1, boardSizeInt);    	
    			
    		} 
            //Choice down.
    		else if (move.equalsIgnoreCase("s")) 
    		{
    			
    			if (player.getPosX() < boardSizeInt-1) 
    				player.setPosition(player.getPosX()+1, player.getPosY(), boardSizeInt);
    				
    		}
            
            //The next building the player will be on based on previous move.
            Building nextBuild = gameNeighborhood.getBuildings()[player.getPosX()][player.getPosY()];
            nextBuild.setExplored(true);
           
            //If the next building is a deli.
            if (nextBuild.getBuildingType()== 1)
            {
            	System.out.println("This is a deli.");
            	nextBuild.setPlayer(player);
            	nextBuild.print();
            }
            //If the next building is a rock paper scissors game.
            if (nextBuild.getBuildingType()== 2)
            {
            	nextBuild.setPlayer(player);
            	nextBuild.print();
            }
            //If the next building is home.
            if (nextBuild.getBuildingType()==3)
            {
            	gameNeighborhood.printBoard();
            	nextBuild.setPlayer(player);
            	nextBuild.print();
            	gameOn = false;
            }
            //If the next building is a choice area.
            if (nextBuild.getBuildingType()==4)
            {
            	nextBuild.setPlayer(player);
            	nextBuild.print();
            }
            
            
        }
		
	}
	

}
