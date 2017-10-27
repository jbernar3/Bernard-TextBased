package City;

import neighborhood.Neighborhood;
import utilities.Utility;

public class city {
	private Neighborhood[][] cityMap;
	public city(Neighborhood[][] cityMap)
	{
		this.cityMap = cityMap;
	}
	
	public void printMap()
	{
		for (Neighborhood[] row : cityMap)
		{
			System.out.print("Burrough name");
			for(Neighborhood neighborhood : row)
			{
				System.out.print("[ ]");
			}
			System.out.println();	
		}
	}
	
	public Neighborhood[][] getCityMap()
	{
		return cityMap;
	}
	
	public void setSchoolMap(Neighborhood[][] cityMap) 
	{
        this.cityMap = cityMap;
    }
}
