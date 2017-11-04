package Building;

import game.Person;

public class home extends Building{
	public home(Person[] occupants) {
		super(occupants);
		// TODO Auto-generated constructor stub
	}

	public void print()
	{
		System.out.println("You are home!");
	}
	public void setPlayer(Person player)
	{
		this.player = player;
	}

}
