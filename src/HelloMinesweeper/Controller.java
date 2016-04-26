package HelloMinesweeper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Controller {

	@FXML private Button startButton;
	@FXML private ChoiceBox<String> difficultyMenu = new ChoiceBox<>();
	@FXML private Label bombsLeft;
	@FXML private Label messageBox;
	@FXML private GridPane gridpane;
	@FXML private Button[][] buttons;

	private Minefield minefield;
	private boolean finished = false;
	private boolean win = false;
	private int turn = 0;

	private int rows, cols;



	@FXML
	private void initialize() {
		messageBox.setText("");
		difficultyMenu.getItems().addAll("Easy", "Medium", "Hard");
		difficultyMenu.setValue("Easy");
		setRowsCols(difficultyMenu.getValue());
		startGame(rows, cols);

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setRowsCols(difficultyMenu.getValue());
				startGame(rows, cols);
			}
		});
	}

	@FXML
	private void startGame(int rows, int cols) { // tie to start button

		minefield = new Minefield(rows, cols);   // Minefield plants own mines and calculates states
		gridpane = new GridPane();
		for (int j = 0; j <= rows; j++) {
			for (int k = 0; k <= cols; k++) {
				final int finj = j;
				final int fink = k;
				buttons[j][k] = new Button();
				buttons[j][k].setPrefSize(40, 40);
				buttons[j][k].setText("");
				buttons[j][k].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent MouseEvent) { // left click events
						minefield.expose(fink,finj); // expose the tile
					}
				});
			}
		}
	}


	private void setRowsCols(String difficulty) {
		switch (difficulty) {
			case "Easy":
				rows = 8;
				cols = 8;
				break;
			case "Medium":
				rows = 16;
				cols = 16;
				break;
			case "Hard":
				rows = 30;
				cols = 16;
		}
		return;
	}
}


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



/*
* 	button.setOnAction(new EventHandler<ActionEvent>() {
* 		public void handle(ActionEvent event) {
	* 		System.out.println("Got an action!");
		*}
*	}
* */