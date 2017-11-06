package Building;
import java.util.Random;
import java.util.Scanner;
import game.Person;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */

public class Deli extends Building
{
	String[]menu = {"","","","",""};
	Random rand = new Random();
	int priceSandwich = rand.nextInt(5)+3;
	int priceDrink = rand.nextInt(4)+1;
	int buildingLevel;
	Person player = null;
	int sleepTime = 500;
	/*
	 * Constructor
	 * @param Array of Person objects named occupants.
	 * Uses super class function.
	 */
	public Deli(Person[] occupants)
	{
		super(occupants);
	}
	
	/*
     * Set's the player received as the player.
     * @param Person that is the player being received to be set.
     */
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
	
	//Print void function from Building.
	public void print() throws InterruptedException 
	{
		System.out.println("You've ran into a deli!");
		System.out.println("-------------");
		generateMenu();
		printMenu();
		choosePurchase();
	}
	
	//Player chooses what to buy and has their money spent.
	public void choosePurchase() throws InterruptedException
	{
		System.out.println("Would you like to purchase something??");
		Scanner scName = new Scanner(System.in);
		String playerWant = scName.nextLine();
		while((playerWant.isEmpty()) || (!playerWant.equalsIgnoreCase("yes") &&!playerWant.equalsIgnoreCase("no")))
		{
			System.out.println("Please just say yes or no.. the deli has other impatient customers.");
			Thread.sleep(sleepTime);
			System.out.println("Would you like to purchase something??");
			playerWant = scName.nextLine();		
		}
		if (playerWant.equalsIgnoreCase("no"))
		{
			System.out.println("Okay goodbye have a nice night.");
			Thread.sleep(sleepTime);
		}
		else
		{
			System.out.println("Please put type in the number corresponding to the item you want.");
			Scanner scName1 = new Scanner(System.in);
			String playerChoice = scName1.nextLine();
		
			while (playerChoice.isEmpty() && !playerChoice.equals("1") && !playerChoice.equals("2") && !playerChoice.equals("3") && !playerChoice.equals("4")) {
				System.out.println("Please type in one of the menu items.");
				playerChoice = scName1.nextLine();
			}
		
			if (playerChoice.equals("1"))
			{
				if ((player.getMoney() - priceSandwich)<0)
				{
					System.out.println("Sorry you only have $" + player.getMoney() + ". Please try and order something again.");
					choosePurchase();
				}
			
				System.out.println("You have purchased " + menu[0] + ".  That will cost you " + priceSandwich);
				Thread.sleep(sleepTime);
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
				Thread.sleep(sleepTime);
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
				Thread.sleep(sleepTime);
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
				Thread.sleep(sleepTime);
				player.setMoney(player.getMoney()-priceDrink);
				player.setThirsty(false);
			}
		}
	}
	
	
}
