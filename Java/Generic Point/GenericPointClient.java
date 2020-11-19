package points;
/************************************************************************************************************
 * Name:        Shiva Shrestha
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a generic template for a Generic Point test class.
 * 				it tests the result from point and BoundPoint class.
 *********************************************************************************************************/
public class GenericPointClient {

	public static void main(String[] args) {
		//initilizing point class with different types
		Point<Integer> p1 = new Point<>(3, 4);
		Point<Double> p2 = new Point<>(5.0, 8.0);
		Point<Number> p3 = new Point<>(4, 9);
		
		//printing to string for point class
		System.out.println("Points_toString");
		System.out.println("p1: " + p1.toString());
		System.out.println("p2: " + p2.toString());
		System.out.println("p3: " + p3.toString());
		//printing print method for point class
		System.out.println("\nPoints_Print");
		System.out.println("p1: " + p1.Print());
		System.out.println("p2: " + p2.Print());
		System.out.println("p3: " + p3.Print());
		
		//initilizing bound point class with different types
		BoundPoint<Integer> bp1 = new BoundPoint<>(3, 4);
		BoundPoint<Double> bp2 = new BoundPoint<>(5.0, 8.0);
		BoundPoint<Number> bp3 = new BoundPoint<>(4, 9);
		
		//printing to string for bound point class
		System.out.println("\nBoundPoints");
		System.out.println("bp1:   "   + bp1.toString());
		System.out.println("bp2:   "   + bp2.toString());
		System.out.println("bp3:   "   + bp3.toString());
		//printing square length method for bound class
		System.out.println("\nSquare Length");
		System.out.println("bp1:   "   + bp1.squareLength());
		System.out.println("bp2:   "   + bp2.squareLength());
		System.out.println("bp3:   "   + bp3.squareLength());
		
	}

}
