package Building;
import java.util.Random;
import java.util.Scanner;
import utilities.Utility;
import game.Person;
public class Deli extends Building
{
	String[]menu = {"","","","",""};
	Random rand = new Random();
	int priceSandwich = rand.nextInt(5)+3;
	int priceDrink = rand.nextInt(4)+1;
	int buildingLevel;
	Person player = null;
	
	public Deli(Person[] occupants)
	{
		super(occupants);
	}
	public void setPlayer(Person player)
	{
		this.player = player;
	}
	
	/*
	 * void generateMenu()
	 * Creates a random menu for a deli that has two different sandwiches and two different drinks.
	 */
	public String[] generateMenu()
	{
		//Arrays of possible food and drink the deli could possibly have.
		String[] hotSandwich = {"Bacon Egg and Cheese","BLT with Chipotle Mayo","Toasted Bagel with Butter","Heart Attack","Prince Tech"};
		String[] drinks = {"Coffee","Water","Arizona","Coke","Grape soda"};
		
		//Add two sandwiches to the menu;
		Random rand = new Random();
		int n = rand.nextInt(hotSandwich.length);
		int m = rand.nextInt(hotSandwich.length);
		while (n==m)
		{
			m = rand.nextInt(hotSandwich.length);
		}
		menu[0] = hotSandwich[n];
		menu[1] = hotSandwich[m];
		
		//Add two drinks to the menu;
		int j = rand.nextInt(drinks.length);
		int k = rand.nextInt(drinks.length);
		while (j==k)
		{
			k = rand.nextInt(drinks.length);
		}
		menu[2] = drinks[j];
		menu[3] = drinks[k];
		
		return menu;
	}
	//Prints out the menu of the deli with the prices of drinks and sandwiches at the particular deli.
	public void printMenu()
	{
		System.out.println("MENU");
		String output = "";
		for (int i=0; i<4;i++)
		{
			output +=(i+1)+")"+ menu[i] + "\n";
		}
		System.out.println(output);
		System.out.println("Drinks cost "+priceDrink);
		System.out.println("Sandwiches cost "+priceSandwich);
	}
	public void print() 
	{
		System.out.println("You've ran into a deli!");
		System.out.println("-------------");
		generateMenu();
		printMenu();
		choosePurchase();
	}
	
	public void choosePurchase()
	{
		System.out.println("What would you like to purchase?\nType in the number corresponding to what you want to buy.");
		Scanner scName = new Scanner(System.in);
		String playerChoice = scName.nextLine();
		
		while (playerChoice.isEmpty() && !playerChoice.equals("1") && !playerChoice.equals("2") && !playerChoice.equals("3") && !playerChoice.equals("4")) {
			System.out.println("Please type in one or more of the menu items.");
			playerChoice = scName.nextLine();
		}
		
		if (playerChoice.equals("1"))
		{
			if ((player.getMoney() - priceSandwich)<0)
			{
				System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
				choosePurchase();
			}
			
			System.out.println("You have purchased " + menu[0] + ".  That will cost you " + priceSandwich);
			player.setMoney(player.getMoney()-priceSandwich);
			player.setHungry(false);
		}
		else if (playerChoice.equals("2"))
		{
			if ((player.getMoney() - priceSandwich)<0)
			{
				System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
				choosePurchase();
			}
			
			System.out.println("You have purchased " + menu[1] + ".  That will cost you " + priceSandwich);
			player.setMoney(player.getMoney()-priceSandwich);
			player.setHungry(false);
		}
		else if (playerChoice.equals("3"))
		{
			if ((player.getMoney() - priceDrink)<0)
			{
				System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
				choosePurchase();
			}
			
			System.out.println("You have purchased " + menu[2] + ".  That will cost you " + priceDrink);
			player.setMoney(player.getMoney()-priceDrink);
			player.setThirsty(false);
		}
		else if (playerChoice.equals("4"))
		{
			if ((player.getMoney() - priceDrink)<0)
			{
				System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
				choosePurchase();
			}
			
			System.out.println("You have purchased " + menu[3] + ".  That will cost you " + priceDrink);
			player.setMoney(player.getMoney()-priceDrink);
			player.setThirsty(false);
		}
	}
	
	
}
