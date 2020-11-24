package snake;
/************************************************************************************************************
 * Name:        Shiva Shrestha 
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a template for a Controller object.  It takes both Snake and food as object 
 * 				and draws them, different layout for the display of game is constructed here. Animation and
 * 				other events like button event are checked for the game.
 *********************************************************************************************************/
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font ;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button ;

public class Controller extends BorderPane{
	
	/*****************************************************************
	 * State: data fields
	 *        variables needed for graphics, animation and game over
	 * ***************************************************************/
	private Food        food;
	private Snake 	    snake;
	private Timeline animation;
	public static final int  WIDTH  = GUIWindow.WIDTH ;
	public static final int  HEIGHT = GUIWindow.HEIGHT;
	private Pane gameBoard;
	private Text score;
	private HBox scoreBoard;
	private VBox optionsBoard;
	private Boolean gameOver, paused;
	Button button,button2;
	private static final String instruction = "About Snake:\n-To play game, use arrow key to control \n  the snake"
			+ 		"and eat the green food.\n-Game ends if the snake \n  collides with the wall "
			+ 		" or itself";
	private Stage stage;
	
	
	/**********************************************************
	 * Constructor: SnakePane
	 * 				sets animation and key controller
	 * ********************************************************/
	public Controller( Stage stage) {
		//setting global stage to local so I can call the global stage in my newCreateGame() method
		this.stage = stage;
		
		//setting initial gameOver to be false
		gameOver =false;
		paused = false;
		
		snake      = new Snake();			  
		food       = new Food(snake);
		// making a new playing Area
		gameBoard = new Pane();
	
		// button to start a new game
		 button = new Button ("New Game");
		
		 //button to view settings
		 button2 = new Button ("Setting");
		
		 //setting the size of buttons 
		button.setPrefSize(120.0, 100.0);
		button2.setPrefSize(120.0, 100.0);
		
		// Displaying the instruction text in the window
		Text about = new Text(25,25, instruction );
		about.setFill(Color.YELLOW);
		about.setFont(Font.font("Palantino", FontWeight.MEDIUM, 
				FontPosture.ITALIC, 14) );
		
		// Displaying score in the window
		score = new Text(25,25, "/nScore:  " + food.getScore() );
		score.setFill(Color.DARKVIOLET);
		score.setFont(Font.font("Palantino", FontWeight.BOLD, 
				FontPosture.REGULAR, 20) );
		
		// getting score on HBox
		scoreBoard= new HBox(score);
		
		//getting buttons on VBox 
		optionsBoard = new VBox(button, button2);
	
		// setting style and size of my playing area
		gameBoard.setPrefSize(GUIWindow.WIDTH, GUIWindow.HEIGHT-100);
		gameBoard.setStyle("-fx-background-color: black;");
		
		// setting style and size of my optionBoard and scoreBoard
		optionsBoard.setStyle("-fx-background-color: white;");
		scoreBoard.setStyle("-fx-background-color: black;");
		optionsBoard.setPrefSize(100, 100);
		scoreBoard.setPrefSize(50, 50);
		
		//placing the panes and box in the window 
		setTop(gameBoard);
		setRight(optionsBoard);
		setLeft(scoreBoard);
		setCenter(about);
		
		// setting margins for all panes and box in the boarder pane
		BorderPane.setMargin(gameBoard, new Insets(2, 5, 5, 3));
		BorderPane.setMargin(scoreBoard, new Insets(20));
		BorderPane.setMargin(optionsBoard, new Insets(10));
		
		
		
		
		

		  
		
		// use of keyframe to get animation of our snake
		KeyFrame frame = new KeyFrame(Duration.millis(60),(e->update())) ;
		
		// getting input and action when key pressed
		gameBoard.setOnKeyPressed(e -> control(e));
		
		// requesting focus of my input on the playing area to move the snake
		gameBoard.requestFocus();
		gameBoard.setFocusTraversable(true);
		
		animation = new Timeline(frame);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		//using event handler to handle action on the button
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                createNewGame(); 
            } 
        }; 
  
        // when button is pressed 
        button.setOnAction(event);
		
	}
	/********************************************************************************
	 * method: animate
	 *         uses keyframe and Animation to animate the snake 
	 *********************************************************************************/
		public void animate()
		{
			// if game is not over it moves snake and checks if snake has collided with food
			if(!gameOver)
			{
				snake.moves();
				food.checkSnakeCollision(snake);
			}
			//if game is over it gets score, stops animation and displays score on the window 
			else
			{
				int playerScore = food.getScore();
				Text gameOverText = new Text(200,200, " GAME OVER \n Score:  " + playerScore);
				
				// setting style and color of text
				gameOverText.setFill(Color.RED);
				gameOverText.setFont(Font.font("Palantino", FontWeight.BOLD, 
						FontPosture.REGULAR, 35) );
				
				// adding text on pane 
				 getChildren().add(gameOverText);
				
				
					animation.stop();
			}
			
		
		}
		/********************************************************************************
		 * method: checkCollision()
		 * 		   It sets game over if snake touches the gameBoard boundary
		 * 		   It also sets game over if snake touches it self as well
		 * 		   when game is set to game over, it stops animation 
		 * 		   - for checking boundaries it gets X and Y coordinate of snake's head
		 * 		    and if the X and Y co orinate equals to the boundaries of gameBoard it 
		 * 			sets game over to be true
		 *        
		 *********************************************************************************/
		public void checkCollisions()
		{
			if( snake.getY() + snake.SQUARE  >= HEIGHT-100)
			{
				gameOver = true;
				
				
				
			}
			if(snake.getY() <= 0)
			{
				gameOver = true;
		
			}
			if(snake.getX()  <=0)
			{
				gameOver = true;
		
			}
			if(snake.getX() + snake.SQUARE > WIDTH)
			{
				gameOver = true;
			
			}
			if(snake.checkSelfCollision() == true)
			{
				gameOver = true;
	
			}
			if(gameOver)
			{
				animation.stop();
				
			}
		}
	/********************************************************************************
	 * method: control(KeyEvent)
	 *         helps to move snake 
	 *         it first gets the input from the keyboard, if the inputs are UP, DOWN, 
	 *         LEFT, RIGHT and SPACE it does certain action
	 *         
	 *         To move snake it checks which key is pressed and if snake's direction 
	 *         is not equal to its opposite direction it sets the direction of snake 
	 *         to the key input direction  
	 *         
	 *         Moreover if SPACE is pressed it pauses and plays the animation
	 *********************************************************************************/
		
	
		public void control(KeyEvent e) {
		
		if (e.getCode() == KeyCode.UP) {
			if(snake.getDirection() != Direction.DOWN){
			snake.setDirection(Direction.UP);
			}
	
		}
		if (e.getCode() == KeyCode.DOWN) {
			
			if(snake.getDirection() != Direction.UP) {
			snake.setDirection(Direction.DOWN);
			
			}
		}
		if (e.getCode() == KeyCode.LEFT) {
			if(snake.getDirection() != Direction.RIGHT) {
			snake.setDirection(Direction.LEFT);
			}
		}
		if (e.getCode() == KeyCode.RIGHT) {
			if(snake.getDirection() != Direction.LEFT) {
			snake.setDirection(Direction.RIGHT);
			}}
		
		if (e.getCode() == KeyCode.SPACE) {
			 
			
			 paused = !paused;
			 if(paused)
			 {
				 animation.pause();
			 }
			 else
			 {
				 animation.play();
			 }
			 
		}
		
		
		}
	
	/********************************************************************************
	 * method: createNewGame()
	 *         it creates a new window with different scene
	 *         -first it closes the previous stage, then creates a new scene with 
	 *          same graphics as the previous one
	 *         -sets different style of of pane and displays on stage 
	 *********************************************************************************/

	
		public void createNewGame()
		{
			
			stage.close();
			Controller pane = new Controller(stage);
			Scene scene = new Scene(pane,WIDTH, HEIGHT);
			pane.setStyle("-fx-background-color: brown;");
			scene.setFill(Color.ANTIQUEWHITE);
			
			stage.setTitle("Snake Game");
			stage.setScene(scene);
			stage.show();
		}
		
		/*************************************************************
		 * method: draw
		 * 		   draws snake and food on gameBoard
		 * ***********************************************************/
		public void draw() {
			snake.draw(gameBoard);
			food.draw(gameBoard);
		}
		
		/*************************************************************
		 * method: update
		 * 		   updates graphics, scores on screen
		 * 		   it also checks collision and animates our snake
		 * ***********************************************************/
		public void update() {
			// it clears the previous graphics when snake is moved
			gameBoard.getChildren().clear();
			
			// displaying score on screen
			score.setText("Score:" + food.getScore());
			
			//draws snake and food on gameBoard
			draw();
			
			// checks boundary collision and self collision. It sets gameOver if collision is true
			checkCollisions();
			
			//moves snake, checks food collision and if game is over it displays game over and score on pane 
			animate();
			
			
		}
		
		
		
}
