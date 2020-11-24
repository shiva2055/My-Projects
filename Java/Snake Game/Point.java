package snake;



/************************************************************************************************************
 * Name: Shiva Shrestha
 * Course: CSC 143
 * Quarter: Fall 2018
 * Description: This class is a template for a point Object. 
 *********************************************************************************************************/
//A point object represents a pair of (x,y) coordinates.
  public class Point {
	private  double x;
	private double y;
	
	/********************************************************************************
	 * constructor: no parameter
	 *              sets value of x and y to 1
	 *********************************************************************************/
	public Point() 
	{ 
		x=0;
		y=0;	
	} 
	public Point(Point p) {
		x=p.x;
		y=p.y;
	}
	public Point(double newX,double newY) {
		x= newX;
		y= newY;
	}
	/********************************************************************************
	 * method: distance
	 *         returns how far the point is from point p
	 *********************************************************************************/
	public double distance(Point p) 
	{    
		double dx = x - p.x;   
		double dy = y - p.y;   
		return Math.sqrt(dx * dx + dy * dy);
	}
	/********************************************************************************
	 * method: distancefromorigin
	 *         returns distance between current position from origin
	 *********************************************************************************/
	public double distanceFromOrigin()
	{    
		return Math.sqrt(x * x + y * y);
	}
	/********************************************************************************
	 * accessor: int
	 *           returns point's x coordinate
	 *********************************************************************************/
	public double getX() 
	{
		return x;
	}
	/********************************************************************************
	 * accessor: int
	 *           returns point's y coordinate
	 *********************************************************************************/
	public double getY() 
	{
		return y;
	}
	
	/********************************************************************************
	 * method: setlocation
	 *         sets the point's x and y to the given value
	 *********************************************************************************/
	public void setlocation(double newX, double newY)
	{
		x= newX;
		y= newY;
	}
	/********************************************************************************
	 * mutator: int
	 *          modifies the point's x coordinate after construction
	 *********************************************************************************/
	public void setX(double x) 
	{
		this.x = x;
	}
	/********************************************************************************
	 * mutator: int
	 *          modifies the point's y coordinate after construction
	 *********************************************************************************/
	public void setY(double y) 
	{
		this.y = y;
	}
	/********************************************************************************
	 * method: translate
	 *         adjusts the point's x and y by the given amount
	 *********************************************************************************/
	public void translate(double dx, double dy)
	{
		x= x+dx;
		y=y+dy;
	}
	
	

	
}
