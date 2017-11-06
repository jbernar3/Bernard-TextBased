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

public class ChoiceBuilding extends Building
{
	Person player = null;
	String[] choicePoss = {"You hear a kitten crying from under a car...\nDo you want to help it?","You hear a loud bang coming from a small alley next to you...\nDo you want to check it out?","Some man in a tuxedo asks you if you want to be a billionaire....  \nWhat is your response?"};
	Random rand = new Random();
	int story = rand.nextInt(choicePoss.length);
	int sleepTime = 500;
	
	/*
	 * Constructor
	 * @param Array of Person objects named occupants.
	 * Uses super class function.
	 */
	public ChoiceBuilding(Person[] occupants)
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
	
	//print void function from Building.
	public void print() throws InterruptedException 
	{
		System.out.println(choicePoss[story]);
		Scanner scName = new Scanner(System.in);
		String playerWant = scName.nextLine();
		while((playerWant.isEmpty()) || (!playerWant.equalsIgnoreCase("yes") &&!playerWant.equalsIgnoreCase("no")))
		{
			System.out.println("Please just say yes or no...");
			Thread.sleep(sleepTime);
			System.out.println("What do you want to do?");
			playerWant = scName.nextLine();		
		}
		if (playerWant.equalsIgnoreCase("no"))
		{
			System.out.println("Ok... Your choice I guess..");
			System.out.println("---------------------------");
			Thread.sleep(sleepTime);
		}
		else 
		{
			if (story==0)
			{
				Random rand = new Random();
				int cost = rand.nextInt(4)+1;
				Thread.sleep(sleepTime);
				System.out.println("You realize that the 'kitten' is a full grown cat and it attacks you..\nYou have to spend $"+cost+" on bandages");
				System.out.println("---------------------------");
				player.amountOfMoney-=cost;
			}
			else if (story==1)
			{
				Random rand = new Random();
				int cost = rand.nextInt(8)+3;
				Thread.sleep(sleepTime);
				System.out.println("The bang is a raccoon with rabies that is jumping off a garbage can...\nYou see $"+cost+" on the floor.. you pick it up and run.");
				System.out.println("---------------------------");
				player.amountOfMoney+=cost;
			}
			else if (story==2)
			{
				Random rand = new Random();
				int cost = rand.nextInt(30)+10;
				Thread.sleep(sleepTime);
				System.out.println("He says you can win $"+cost+" by guessing the number in his head out of 10!!!!\nThat money can pay for your college!");
				Thread.sleep(sleepTime);
				System.out.println("You only have to pay a dollar!");
				int num = rand.nextInt(10);
				String[] nums = {"1","2","3","4","5","6","7","8","9","10"};
				System.out.println("Choose a number between 1-10!");
				Scanner scName1 = new Scanner(System.in);
				String playerChoice = scName1.nextLine();
				Thread.sleep(sleepTime);
				if (nums[num].equals(playerChoice))
				{
					System.out.println("Holy guacamole you won!!!!");
					System.out.println("You just got $"+cost+" closer to being a billionaire!");
					System.out.println("---------------------------");
					Thread.sleep(sleepTime);
					player.amountOfMoney+=cost;
				}
				else
				{
					System.out.println("He chose "+nums[num]+ "... Sorryy");
					System.out.println("---------------------------");
					Thread.sleep(sleepTime);
					player.amountOfMoney-=1;
				}
			}
		}
		
	}
}
