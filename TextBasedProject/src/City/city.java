package City;

import java.util.Arrays;
import java.util.Collections;

import neighborhood.*;

public class city {


	public static final int URBAN = 6;
	public static final int SUBURBAN = 8;
	
	
    private Neighborhood[][] neighborhoods;
    private int citySize = 0;
    

    public city(int citySizeInt) 
    {

    	this.citySize = citySizeInt;
    	this.neighborhoods = new Neighborhood[citySize][citySize];
       
    }

    public void printBoard() 
    {
    
        for(Neighborhood[] row : neighborhoods) 
        {
        
            for (Neighborhood nb : row) 
            {
                nb.print();
            }
            System.out.println();
        }
    }
    
    public Neighborhood[][] getRooms() 
    {
        return neighborhoods;
    }

    private int getXfromNbIndex(int index) 
    {
    	return (int) index/citySize;
    }
    
    private int getYfromNbIndex(int index) 
    {
    	return index % citySize;
    }
    
    /*
     * You can get money from the banks as you reach them.
     * You can buy food and drinks from deli.
     * Your goal is to get food from at least one deli before you reach home and as much money as you can get.
     * You don't know where home is and don't know where the delis are.
     * Also, there are hidden people and places that take your money or you have to fight.
     */
    int amountOfBanks;
    int amountOfDelis;
    int amountHouse = 1;
    
    
    
    public void generateNeighborhoods() 
    {
    	
    	if (neighborhoods == null)
    		return;
    	
		int index=0;
    	for (int x=0; x<neighborhoods.length; x++) 
    	{
    		for (int y=0; y<neighborhoods[x].length; y++) 
    		{
    			index++;
    			EmptyNeighborhood empty = new EmptyNeighborhood();
    			empty.setX(x);
    			empty.setY(y);
    			empty.setIndex(index);
    			
    			neighborhoods[x][y] = empty;
    		}
    	}
    }
}

