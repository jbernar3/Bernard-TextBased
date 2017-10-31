package Building;
import java.util.Random;
//import utilities.Utility;
public class Deli extends Building{
	String[]menu = {"","","","",""};
	Random rand = new Random();
	int priceSandwich = rand.nextInt(5)+3;
	int priceDrink = rand.nextInt(4)+1;
	
	/*
	 * void generateMenu()
	 * Creates a random menu for a deli that has two different sandwiches and two different drinks.
	 */
	private void generateMenu()
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
		printMenu();
	}
}
