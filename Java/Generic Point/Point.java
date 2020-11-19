package points;
/************************************************************************************************************
 * Name:        Shiva Shrestha
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a generic template for a Point object.
 *********************************************************************************************************/
public class Point <T>{
	// Declaring data fields of type T
	private  T  x;
	private  T  y;
	
	/********************************************************************************
	 * constructor:  two parameter
	 *              sets value of x and y to local value of x and y
	 *********************************************************************************/
	Point(T x, T y)
	{
		this.x = x;
		this.y = y;
	}
	
	/********************************************************************************
	 * accessor: T
	 *          returns value of x
	 *********************************************************************************/
	public T getX() {
		return x;
	}
	/********************************************************************************
	 * accessor: T
	 *          returns value of y
	 *********************************************************************************/
	public T getY() {
		return y;
	}
	/********************************************************************************
	 * mutator: T
	 *          modifies the point's x coordinate after construction
	 *********************************************************************************/
	public void setX(T x) {
		this.x = x;
	}
	/********************************************************************************
	 * mutator: T
	 *          modifies the point's y coordinate after construction
	 *********************************************************************************/
	public void setY(T y) {
		this.y = y;
	}
	/********************************************************************************
	 * mutator: T
	 *          modifies the point's both x and y coordinate after construction
	 *********************************************************************************/
	public void set(T x, T y)
	{
		this.x= x;
		this.y=y;
	}
	/********************************************************************************
	 * method: toString
	 *         returns value of x and y in certain format 
	 *********************************************************************************/
	public String toString()
	{
		return"(" + "x_" + x + ", " + "y_" + y + ")";
	}
	/********************************************************************************
	 * method: Print
	 *         displays the current generic Point<T> 
	 *********************************************************************************/
	public Point<T> Print()
	{
		return new Point<T>(x,y);
	}
	
	
	
	
}
