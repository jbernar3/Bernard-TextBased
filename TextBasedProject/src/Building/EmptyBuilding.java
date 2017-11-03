package Building;

import game.Person;

public class EmptyBuilding extends Building
{
	public EmptyBuilding(Person[] occupants) {
		super(occupants);
		// TODO Auto-generated constructor stub
	}

	public void print() 
	{
		System.out.print("[ ]");
	}

}

