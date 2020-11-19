package points;
/************************************************************************************************************
 * Name:        Shiva Shrestha
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a generic template for a BoundPoint object which extends to Numbers.
 *********************************************************************************************************/
public class BoundPoint<T extends Number > {
	// declaring data field of type T
	private  T  x;
	private  T  y;
	
	/********************************************************************************
	 * constructor:  two parameter
	 *              sets value of x and y to local value of x and y
	 *********************************************************************************/
	BoundPoint(T x, T y)
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
	 *          modifies the Boundpoint's x coordinate after construction
	 *********************************************************************************/
	public void setX(T x) {
		this.x = x;
	}
	/********************************************************************************
	 * mutator: T
	 *          modifies the Boundpoint's y coordinate after construction
	 *********************************************************************************/
	public void setY(T y) {		this.y = y;
	}
	/********************************************************************************
	 * mutator: T
	 *          modifies the Boundpoint's x and y coordinate after construction
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
	
	// could not use * operator because x and y are not primivitive type but wrapper type
	/********************************************************************************
	 * method: squareLength
	 *         prints the square length and return as real number
	 *********************************************************************************/
	public int squareLength()
	{
		return x.intValue() * x.intValue() + y.intValue() * y.intValue();
	}
}
