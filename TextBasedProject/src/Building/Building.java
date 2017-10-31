package Building;


public abstract class Building {

    public boolean explored;
    private int x, y, index;

    public  Building() {
        this.explored = false;
    }

    public abstract void print();
    

	public int getIndex() 
	{
		return index;
	}

	public void setIndex(int index) 
	{
		this.index = index;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}


}
