package Building;

import game.Person;

/*
 * Text Based Adventure Project
 * @author Jefferson C. Bernard
 * Period 6-7
 * 11/5/17 final
 */

public class EmptyBuilding extends Building
{
	/*
	 * Constructor
	 * @param Array of Person objects named occupants.
	 * Uses super class function.
	 */
	public EmptyBuilding(Person[] occupants) {
		super(occupants);
		// TODO Auto-generated constructor stub
	}

	//print void function from Building.
	public void print() 
	{
		System.out.print("[ ]");
	}

}

