package Building;

import game.Person;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */

public class home extends Building{
	Person player = null;
	
	/*
	 * Constructor
	 * @param Array of Person objects named occupants.
	 * Uses super class function.
	 */
	public home(Person[] occupants) {
		super(occupants);
		// TODO Auto-generated constructor stub
	}
	
	/*
     * Set's the player received as the player.
     * @param Person that is the player being received to be set.
     */
	public void setPlayer(Person player)
	{
		this.player = player;
	}
	
	//print void function from Building.
	public void print()
	{
		int sleepTime = 500;
		System.out.println("You are home!");	
			String output = "";
			if (player.amountOfMoney<10)
				output = "Oh no your dead... you only have $" + player.amountOfMoney + "! Your mom is gonna kill you.";
			else if (player.amountOfMoney==10)
				output = "Whew! Your mom doesn't kill you because you have $10 but you didn't make a profit.";
			else if (player.amountOfMoney>10)
				output = "What a successful night! You made $" + (player.amountOfMoney-10) + "in profit and you're not gonna die!";
		
			String output1 = "";
			if (player.getHungry())
				output1 = "You went home hungry!! You starved in your bed.";
			else
				output1 = "You were able to eat so you don't die of starvation!";
			
			String output2 = "";
			if (player.getThirsty())
				output2 = "You didn't even get a soda?? You die of thirst";
			else 
				output2 = "Congratulations you didn't die because of your thirst!";
			
			System.out.println(output);
			System.out.println(output1);
			System.out.println(output2);
			if (player.amountOfMoney>=10 && !player.getHungry() && !player.getThirsty())
				System.out.println("Yayy you won!! Congrats");
			else
				System.out.println("You lost...");
				
	}
	

}
