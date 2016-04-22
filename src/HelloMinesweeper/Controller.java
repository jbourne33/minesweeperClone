package HelloMinesweeper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Controller {

	@FXML
	private Button startButton;
	@FXML
	private ChoiceBox difficultyMenu;
	@FXML
	private Label bombStatus;
	@FXML
	private Label messageBox;
	@FXML
	private GridPane gridpane;

	private Minefield field;
	private boolean finished = false;
	private boolean win = false;
	private int turn=0;

    @FXML
    private void initialize() { // tie to start button
	    Parent root = FXMLLoader.load(getClass().getResource("MineSweeperView.fxml"));
	    primaryStage.setTitle("Hello Minesweeper");
	    primaryStage.setScene(new Scene(root, 300, 275));
	    primaryStage.show();messageBox.setText("");
	    difficultyMenu.getValue.toString("Easy");
	    difficultyMenu.getValue.toString("Medium");
	    difficultyMenu.getValue.toString("Hard");
        Minefield field = new Minefield(); // maybe put this outside of initialize
    }

	private void updateField(Minefield field) {
		gridpane.
		return;
	}



    // Initialize
    // create minefield
    // event handler, left click
	// event handler, right click

//    - The Controller should create a new MineField Model in response to the programs initialization or in response to a press of the “start” button
//    - The Controller should call a mark method in the MineField object to toggle a cells marked status in response to a left mouse click
//    - The Controller should call a expose method in the MineField object to expose a cell in response to a right mouse click
//    - The Controller should update the View in response to mark/expose/start requests.

//	As cells are (right) clicked, they should reveal themselves with one of:
//			• a blank (or darker) exposed area if they are not adjacent to any bombs
//	• a number 1-8 indicating the number of bombs the cell is adjacent to
//	• a bomb indicating the user clicked on a bomb and the game is over
//	• right clicks on cells that are marked (see below) should be ignored

//	Left clicking should mark a cell as a bomb (X’s) in image below, or if the cell is
//	already marked with an X, it should remove the mark from the cell.

//	As cells are revealed, the unexposed cell counter should update itself, counting
//	down towards zero.
}
