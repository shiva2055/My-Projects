package snake;
/************************************************************************************************************
 * Name:        Shiva Shrestha 
 * Course:      CSC 143
 * Quarter:     Fall 2018
 * Description: This class is a template for a GUIWindow. It gets Controller as pane makes a new application
 *********************************************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIWindow extends Application {
	
	public static final int  WIDTH  = 600;
	public static final int  HEIGHT = 500;
	
	
	/*****************************************************************
	 * override: start
	 *           overrides the start method in the Application class
	 * ***************************************************************/
	@Override
	public void start(Stage stage) {
		
		/************************************************************
		 * required:  Pane 
		 * 			  create a Pane to hold Snake and other graphics
		 * **********************************************************/
		Controller pane  = new Controller(stage);
		pane.setStyle("-fx-background-color: brown;");
		
		/**********************************************************
		 * required:  Scene
		 * 			  create a scene to hold the pane and place it 
		 *            in the stage for display
		 * ********************************************************/
		Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.BLACK);   
		stage.setTitle("Snake Game");			
		stage.setScene(scene);					
		stage.show();
		
	}
	
	/********************************************************************
	 * main method: launch application
	 *              needed to launch JavaFX program when running in IDE
	 * ******************************************************************/
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
