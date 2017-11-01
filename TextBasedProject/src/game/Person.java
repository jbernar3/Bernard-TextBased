package game;

import java.util.Scanner;
import Building.Building;

public class Person {
	String name;
	private int amountOfMoney = 10;
	public boolean hungryThirsty = true;
	public int numOfMoves = 0;
	private int posX, posY; 
	private int posIndex;
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
			posY++;
		} 
		
		else if (input.equalsIgnoreCase("down")) 
		{
			posY--;
		}
		
		else if (input.equalsIgnoreCase("left")) 
		{
			posX--;
		} 
		else if (input.equalsIgnoreCase("right")) 
		{
			posX++;
		}

	}
	
	public void setPosition(int xCoord, int yCoord, int boardSize)
	{
		this.setPosX(xCoord);
		this.setPosY(yCoord);
		this.posIndex = xCoord + yCoord;
	}
	
	public int getIndex() 
	{
		return posIndex;
	}

	public void setPosIndex(int index) 
	{
		this.posIndex = index;
	}

	public int getPosY() 
	{
		return posY;
	}

	public void setPosY(int y) 
	{
		this.posY = y;
	}

	public int getPosX() 
	{
		return posX;
	}

	public void setPosX(int x) 
	{
		this.posX = x;
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
