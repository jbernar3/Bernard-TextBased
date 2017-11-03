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
		String output = "";
		for (String item : menu)
		{
			output += item + "\n";
		}
		System.out.println(output);
		System.out.println("Drinks cost "+priceDrink);
		System.out.println("Sandwiches cost "+priceSandwich);
	}
	public void print() 
	{
		System.out.print("You've ran into a deli!");
		System.out.println("----------");
		printMenu();
	}
	
	public void choosePurchase()
	{
		System.out.println("What would you like to purchase?");
		Scanner scName = new Scanner(System.in);
		String playerChoice = scName.nextLine();
		
		while (playerChoice.isEmpty()|| findKeyword(playerChoice, menu[0],0)==-1 || findKeyword(playerChoice, menu[1],0)==-1 || findKeyword(playerChoice, menu[2],0)==-1 || findKeyword(playerChoice, menu[3],0)==-1) {
			System.out.println("Please type in one or more of the menu items.");
			playerChoice = scName.nextLine();
		}
		
		if (findKeyword(playerChoice, menu[0],0)!=-1)
		{
			if (player.getMoney() - priceSandwich<0)
			{
				System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
				choosePurchase();
			}
			
			System.out.println("You have purchased " + menu[0] + ".  That will cost you " + priceSandwich);
		}
	}
	
	public int findKeyword(String statement, String goal,int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in

		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a

		// word
		while (psn >= 0)
		{

			// Find the string of length 1 before and after

			// the word

			String before = " ", after = " ";

			if (psn > 0)

			{

				before = phrase.substring(psn - 1, psn);

			}

			if (psn + goal.length() < phrase.length())

			{

				after = phrase.substring(

						psn + goal.length(),

						psn + goal.length() + 1);

			}



			// If before and after aren't letters, we've

			// found the word

			if (((before.compareTo("a") < 0) || (before

					.compareTo("z") > 0)) // before is not a

											// letter

					&& ((after.compareTo("a") < 0) || (after

							.compareTo("z") > 0)))

			{

				return psn;

			}



			// The last position didn't work, so let's find

			// the next, if there is one.

			psn = phrase.indexOf(goal, psn + 1);



		}



		return -1;

	}
}
