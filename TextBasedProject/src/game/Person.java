package game;

import java.util.Scanner;

public class Person {
	String name;
	private int amountOfMoney = 10;
	public boolean hungryThirsty = true;
	public int numOfMoves = 0;
	private int positionX, positionY; 
	public void askForName() 
	{

		System.out.println("What's your name?");
		
		Scanner scName = new Scanner(System.in);
		String playerName = scName.nextLine();
		
		while (playerName.isEmpty()) 
		{
			System.out.println("Sorry? What's your name?");
			playerName = scName.nextLine();
		}
    	
    	this.name = playerName;	
		
		
	}
	public void chooseMove()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to move up, left, right or down?");
		while (!sc.hasNext("[upleftrightdown]")) 
		{
		    System.out.println("That's not correct, please try again. Use only up, left, right, or down.");
		    sc.next();
		}
		
		String input = sc.next();
		System.out.println("Moving " + input + "!");

		if (input.equalsIgnoreCase("up")) 
		{	
			positionY++;
		} 
		
		else if (input.equalsIgnoreCase("down")) 
		{
			positionY--;
		}
		
		else if (input.equalsIgnoreCase("left")) 
		{
			positionX--;
		} 
		else if (input.equalsIgnoreCase("right")) 
		{
			positionX++;
		}

	}
	
	
	
	
	
	public String getName()
	{
		return name;
	}
	public int getMoney()
	{
		return amountOfMoney;
		
	}
}
