package snake;
/************************************************************************************************************
 * Name:        Shiva Shrestha  
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a template for a Snake object.  
 *********************************************************************************************************/
import javafx.scene.layout.Pane; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Snake {

	/*****************************************************************
	 * State: data fields
	 * ***************************************************************/
	private ArrayList<Point> snakeBody;
	private Direction direction ;
	private boolean isMoving;
	private boolean elongate;
	private Point head;
	private Color color  = Color.WHITE;
	public final int  SQUARE     = 6;
	public static final int  START_SIZE = 20;
	public static final int  START_X    = GUIWindow.WIDTH  / 2;
	public static final int  START_Y    = GUIWindow.HEIGHT / 2;

	/**********************************************************
	 * Constructor: Snake
	 * 				initializes data Fields
	 * ********************************************************/
	public Snake() {
		direction = Direction.RIGHT;
		elongate = false;
		isMoving = false;
		snakeBody  = make();
	}
	/********************************************************************************
	 * method: checkFoodCollision
	 *        if the elongate is true then it adds the tail  at the end of snakeBody 
	 *        
	 *********************************************************************************/
	public void checkFoodCollision()
	{
		
		if(elongate == true)
		{
			snakeBody.add(snakeBody.size()-1, getTail());
			System.out.println(elongate);
			System.out.println(snakeBody.size());
		}
		
	}
	/********************************************************************************
	 * method: checkSnakeCollision
	 *        initilizes the head
	 *        uses for loop to check the self collision of snake
	 *        - to check if snake as collided with itself, we get X and Y coordinate 
	 *        	of each index of snakeBody and then check if it equals to the snake's
	 *        	head's X and Y coordinate
	 *        	if both  X and Y equals then it returns true
	 *********************************************************************************/
	public boolean checkSelfCollision()
	{
		
		head = snakeBody.get(0);
		for(int i = 1; i< snakeBody.size(); i++)
		{
			if((snakeBody.get(i).getX() == head.getX())&&(snakeBody.get(i).getY() == head.getY()))
			{
				return true;
			}
			
			
		}
		
		return false;
	}
	/**********************************************************
	 * method: draw(Pane)
	 *         draws the current snakeBody
	 *         - to draw snake it gets the X and Y coordinate
	 *         	 from each index of snakeBody and makes square
	 *         	 then it adds to the pane
	 * ********************************************************/
	public void draw(Pane pane) {
		
		for (Point p : snakeBody) {
			Rectangle body = new Rectangle(p.getX(), p.getY(), SQUARE, SQUARE);
			body.setStroke(color);
			pane.getChildren().add(body);
		}
	}
	/********************************************************************************
	 * method: isMoving
	 *         returns true if snake is moving 
	 *********************************************************************************/
	public boolean isMoving()
	{
		if(isMoving = true)
		{
			return true;
		}
		return false;
	}
	
	
	
	/********************************************************************************
	 * accessor: Direction
	 *           returns direction
	 *********************************************************************************/
	public Direction getDirection()
	{
		return direction;
	}
	/********************************************************************************
	 * method: getHead
	 *         returns head of snake.(Both x and y coordinate as a Point) 
	 *********************************************************************************/
	public Point getHead()
	{
		return new Point(getX(), getY());
	}
	/********************************************************************************
	 * method: getTail
	 *         returns tail of snake.(Both x and y co-ordinate as a Point)  
	 *********************************************************************************/
	public Point getTail()
	{
		return new Point(snakeBody.get(snakeBody.size()-1));
	}
	/********************************************************************************
	 * method: getX
	 *         returns x- coordinate of head of the snake 
	 *********************************************************************************/
	public double getX()
	{
		return snakeBody.get(0).getX();
	}
	/********************************************************************************
	 * method: getY
	 *         returns y- coordinate of head of the snake 
	 *********************************************************************************/
	public double getY()
	{
		return snakeBody.get(0).getY();
	}
	
	
	/******************************************************************
	 * helper method: make
	 *                makes initial snake with an initial body length
	 *                - it creates new  ArrayList and adds initial X 
	 *                and Y on it
	 *                - uses for loop to add each element until the 
	 *                default size of snake i.e 20
	 * ****************************************************************/
	private ArrayList<Point> make() {
		
		ArrayList<Point> newSnake = new ArrayList<Point>();
		newSnake.add( new Point(START_X, START_Y) );
		
		for (int i = 1; i < START_SIZE; i++) {
			newSnake.add(new Point(START_X - i * SQUARE , START_Y) );
		}
		return newSnake;
	}
	/********************************************************************************
	 * method: moves
	 * 		   moves the snake
	 * 		   - to move snake make a new X and Y coordinate with increase X and Y
	 * 			 by SQUARE. Create new head with those updated X and Y
	 * 		   - use loop to shift every element on snake body by one index starting
	 *			 from end of snakeBody
	 *         - then set a new head at index 0
	 *********************************************************************************/
	public void moves()
	{
		if(isMoving == false)
		{
		 head = snakeBody.get(0);
		
		double newX = head.getX() + direction.getX() * SQUARE;
		double newY = head.getY() + direction.getY() * SQUARE;
		Point newHead = new Point(newX, newY);
		
		for(int i =snakeBody.size()-1; i>0; i--)
		{
			snakeBody.set(i, snakeBody.get(i-1));
		}
		
		snakeBody.set(0, newHead);
		}

	}
	
	
	/********************************************************************************
	 * method: setDirection
	 *        sets local value to global value of direction 
	 *********************************************************************************/
	public void setDirection(Direction direction)
	{
		 this.direction = direction;
	}
	/********************************************************************************
	 * method: selElongate
	 * 		   sets global elongate to local elongate
	 *********************************************************************************/
	public void setElongate(boolean elongate)
	{
		this.elongate = elongate;
	}
	/********************************************************************************
	 * method: isMoving
	 * 		   returns isMoving to true 
	 *********************************************************************************/
	public void setMoving(boolean isMoving)
	{
		this.isMoving = isMoving;
	}
	
	
	
}
