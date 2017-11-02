package Building;

import game.Person;

public class EmptyBuilding extends Building
{
	public EmptyBuilding() {
		//super([]);
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Prints out the physical array of the empty room
	 */
	@Override
	public void print() 
	{
		System.out.print("[ ]");
	}

}

