package City;

import java.util.Arrays;
import java.util.Collections;

import neighborhood.*;

public class city {


	public static final int URBAN = 6;
	public static final int SUBURBAN = 8;
	
	
    private Neighborhood[][] neighborhoods;
    private int citySize = 0;
    

    public city(int citySizeInt) {

    	this.citySize = citySizeInt;
    	this.neighborhoods = new Neighborhood[citySize][citySize];
       
    }

    public void printBoard() {
    
        for(Neighborhood[] row : neighborhoods) {
        
            for (Neighborhood nb : row) {
            
                nb.print();
            }
            System.out.println();
        }
    }
    
    public Neighborhood[][] getRooms() {
        return neighborhoods;
    }

    
    private int getXfromNbIndex(int index) {
    	return (int) index/citySize;
    }
    
    private int getYfromNbIndex(int index) {
    	return index % citySize;
    }
    
    public void generateNeighborhoods() {
    	
    	if (neighborhoods == null)
    		return;
    	
    	
		int index=0;
    	for (int x=0; x<neighborhoods.length; x++) {
    		for (int y=0; y<neighborhoods[x].length; y++) {
    			index++;
    			
    			EmptyNeighborhood e = new EmptyRoom();
    			e.setX(x);
    			e.setY(y);
    			e.setIndex(index);
    			
    			neighborhoods[x][y] = e;
    		}
    	}
    	
		
    	
    	
    }
    

}
