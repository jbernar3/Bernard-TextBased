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

public class RockPaperScissors extends Building{
	Person player = null;
	Random rand = new Random();
	int chanceRobbing = rand.nextInt(10);
	int howMuchBet = rand.nextInt(6)+1;
	int sleepTime = 500;
	
	/*
     * Set's the player received as the player.
     * @param Person that is the player being received to be set.
     */
	public void setPlayer(Person player)
	{
		this.player = player;
	}
	
	/*
	 * Constructor
	 * @param Array of Person objects named occupants.
	 * Uses super class function.
	 */
	public RockPaperScissors(Person[] occupants)
	{
		super(occupants);
	}
	
	//print void function from Building.
	public void print() throws InterruptedException
	{
		System.out.println("You've ran into a rock paper scissors game with a stranger in a hoodie.");
		System.out.println("He's only betting " + howMuchBet);
		if (howMuchBet>player.amountOfMoney)
		{
			System.out.println("Sorry.. you don't have enough money to play him.");
			System.out.println("---------------------------");
		}
		else
		{
			if(chooseIfWantPlay())
			{
				playGame();
			}
			else
			{
				notPlayGame();
			}
		}
	}

	//@returns boolean determining whether the player wants to play or not.
	public boolean chooseIfWantPlay()
	{
		
		System.out.println("Would you like to play with him?");
		Scanner scName = new Scanner(System.in);
		String playerWant = scName.nextLine();
		while((playerWant.isEmpty()) || (!playerWant.equalsIgnoreCase("yes") &&!playerWant.equalsIgnoreCase("no")))
		{
			System.out.println("Please just say yes or no.. he is getting impatient!");
			System.out.println("Would you like to play??");
			playerWant = scName.nextLine();		
		}
		if (playerWant.equalsIgnoreCase("no"))
			return false;
		else
			return true;

	}
	
	//If the player doesn't want to play the game.
	public void notPlayGame()
	{
		if (chanceRobbing==10)
		{
			System.out.println("Oh no!  He got really mad at you and took all your money!!!");
			System.out.println("---------------------------");
			player.amountOfMoney = 0;
		}
		else if (chanceRobbing>7)
		{
			System.out.println("Oh no! He got frustrated and took two dollars from you!");
			System.out.println("---------------------------");
			if (player.amountOfMoney<2)
				player.amountOfMoney = 0;
			else
				player.amountOfMoney+=-2;
		}
		else if (chanceRobbing>5)
		{
			System.out.println("Oops wrong answer... He got annoyed and took a dollar from you anyways.");
			System.out.println("---------------------------");
			if (!(player.amountOfMoney==0))
			{
				player.amountOfMoney+=-1;
			}
		}
		else 
		{
			System.out.println("He wasn't in a bad mood so he didn't mug you");
			System.out.println("---------------------------");
		}
	}
	
	//If the player decides to play the game.
	public void playGame() throws InterruptedException
	{
		
		int ROCK = 0;
		int SCISSOR = 1;
		int PAPER = 2;
		Random rand = new Random();
		int compSelection = rand.nextInt(3);
		
		System.out.println("The rules are pretty simple!! You say rock paper or scissor.  Rock beats paper etc etc etc...");
		System.out.println("Ready???");
		Thread.sleep(sleepTime);
		System.out.println("3");
		Thread.sleep(sleepTime);
		System.out.println("2");
		Thread.sleep(sleepTime);
		System.out.println("1");
		Thread.sleep(sleepTime);
		System.out.println("TYPE IN YOUR SELECTION OF WEAPONS!!!");
		Scanner scName = new Scanner(System.in);
		String playerSelect = scName.nextLine();
		
		while ((playerSelect.isEmpty()) || (!playerSelect.equalsIgnoreCase("rock") &&!playerSelect.equalsIgnoreCase("paper") &&!playerSelect.equalsIgnoreCase("scissors")))
		{
			System.out.println("Please say rock paper or scissors!!");
			System.out.println("Ok let's try this againn... TYPE IN YOUR SELECTION");
			playerSelect = scName.nextLine();
		}
		
		if (playerSelect.equalsIgnoreCase("rock"))
		{
			if (compSelection == ROCK)
			{
				System.out.println("DRAWW.. You guys both chose rock");
				System.out.println("Redo");
				playGame();
			}
			else if (compSelection == SCISSOR)
			{
				System.out.println("He chose Scissors");
				winGame();
			}
			else if (compSelection == PAPER)
			{
				System.out.println("He chose Paper");
				loseGame();
			}
		}
		else if (playerSelect.equalsIgnoreCase("scissors"))
		{
			if (compSelection == SCISSOR)
			{
				System.out.println("DRAWW.. You guys both chose scissors");
				System.out.println("Redo");
				playGame();
			}
			else if (compSelection == PAPER)
			{
				System.out.println("He chose Paper");
				winGame();
			}
			else if (compSelection == ROCK)
			{
				System.out.println("He chose Rock");
				loseGame();
			}
		}
		
		else if (playerSelect.equalsIgnoreCase("paper"))
		{
			if (compSelection == PAPER)
			{
				System.out.println("DRAWW.. You guys both chose paper");
				System.out.println("Redo");
				playGame();
			}
			else if (compSelection == SCISSOR)
			{
				System.out.println("He chose Scissors");
				loseGame();
			}
			else if (compSelection == ROCK)
			{
				System.out.println("He chose Rock");
				winGame();
			}
		}
		
	}
	
	//If the player wins.
	public void winGame() throws InterruptedException
	{
		System.out.println("YOU WINNNN");
		Thread.sleep(sleepTime);
		System.out.println("You have won $" + howMuchBet + "!!");
		System.out.println("---------------------------");
		Thread.sleep(sleepTime);
		player.amountOfMoney +=howMuchBet;
	}
	
	//If the player loses.
	public void loseGame() throws InterruptedException
	{
		System.out.println("Uh ohhhhh.... you lose");
		Thread.sleep(sleepTime);
		System.out.println("You lost $"+howMuchBet+"....");
		System.out.println("---------------------------");
		Thread.sleep(sleepTime);
		player.amountOfMoney-=howMuchBet;
	}

}
