package snake;
/************************************************************************************************************
 * Name:        Shiva Shrestha 

 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a template for a food object.
 *********************************************************************************************************/

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food {

	private double   n;
	private double   x;
	private double   y;
	private Color    foodColor;
	public  static final int SIZE  = 8;
	private int score;
	
	/**********************************************************
	 * Constructor: Food(Snake)
	 * 			    initializes data Fields
	 * ********************************************************/
	public Food(Snake s) {
		foodColor = Color.LAWNGREEN;
		n         = 1.5;
		// gets random location for food
		setLocation();
	}
	
	/**********************************************************
	 * method: draw(Pane)
	 *         draws the food on screen
	 *         makes a rectangle as a food and sets its color
	 * ********************************************************/
	public void draw(Pane pane) {
		Rectangle food = new Rectangle(x, y, SIZE, SIZE);
		food.setFill(foodColor);
		pane.getChildren().add(food);
	}
	
	/**********************************************************
	 * method: setLocation
	 * 		   changes the location of the food at random
	 *         on screen 
	 * ********************************************************/
	public void setLocation() {
		
		x     =  (Math.random() * ( GUIWindow.WIDTH  - n * SIZE ) );
		y     =  (Math.random() * ( (GUIWindow.HEIGHT-100) - n * SIZE ) );
		
	}
	
	/**********************************************************************************************************************
	 * method: checkSnakeCollision
	 *         if snake collides with food it will return true
	 *         - to check collision we get the X and Y coordinate of snake'head
	 *         	 if snake's X coordinate is more than food's X and snake's X coordinate is more than food's X  + SIZE
	 *         	 And if snake's Y coordinate is more than food's Y and snake's Y coordinate is more than food's Y  + SIZE
	 *         - it will set elongate to true and sets new location of food
	 *         - Also increases the count of score every time snake hits food.
	 *************************************************************************************************************************/
	public boolean checkSnakeCollision(Snake s)
	{	
		
		if(((s.getY() >= y) && (s.getY() <= y + SIZE)) 
			&& ((s.getX() >= x) && (s.getX() <= x + SIZE))  )
		{
			System.out.println("hi");
			  s.setElongate(true);
			setLocation();
			score++;
			
			return true;
			
		}
		s.setElongate(false);
		return false;
		
	}
	/********************************************************************************
	 * method: createFoodLocation
	 *         creates new food location with the new x and y coordinate 
	 *********************************************************************************/
	public void createFoodLocation(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	/********************************************************************************
	 * method: getFoodPoint
	 * 		   returns food's Point 
	 *********************************************************************************/
	public Point getFoodPoint()
	{
		return new Point(x, y);
	}
	/********************************************************************************
	 * method: getFoodPoint
	 *         returns foods point using the given x and y coordinate  
	 *********************************************************************************/
	public Point getFoodPoint(double x1, double y1)
	{
		x = x1;
		y = y1;
		
		return new Point(x, y);
	}
	/********************************************************************************
	 * method: getScore
	 * 		   returns score 
	 *********************************************************************************/
	public int getScore()
	{
		
		return score;
	}
}
