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

	@FXML private Button startButton;
	@FXML private ChoiceBox<String> difficultyMenu = new ChoiceBox<>();
	@FXML private Label bombsLeft;
	@FXML private Label messageBox;
	@FXML private GridPane gridpane;
	@FXML private Button[][] minefield;


	private Minefield mf;
	private boolean finished = false;
	private boolean win = false;
	private int turn = 0;

	private int rows, cols;
	private void setRowsCols(String difficulty){
		switch(difficulty){
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

    @FXML
    private void initialize() { // tie to start button
//	    primaryStage.setTitle("Hello Minesweeper");
	    messageBox.setText("");
	    difficultyMenu.getItems().addAll("Easy", "Medium", "Hard");
	    difficultyMenu.setValue("Easy");
		bombsLeft.setText(Integer.toString(mf.unexposedCount()));
		// startGame()
    }

//	@FXML
//	private void startGame(){
	//	do{
	////	mf = new Minefield();   // Minefield plants own mines and calculates states
	//		turn++;
	//
	//		System.out.println("Turn "+turn);
	//		Minefield.show();
	//		finished = Minefield.setPosition();
	//
	//		if(!finished){
	//			mf.openNeighbors();
	//			finished = mf.win();
	//		}
	//
	//	}while(!finished);
	//
	//	if(mf.win()){
	//		System.out.println("Congratulations, you let the 10 fields with the mines in "+turn+" turns");
	//		mf.showMines();
	//	} else {
	//		System.out.println("Mine! You lost!");
	//		mf.showMines();
	//	}
	//
	//	private void updateField(Minefield field) {
	//		gridpane.
	//		return;
	//	}
	//
	//	button.setOnAction
	//
	//	button.setOnMouseClicked(new EventHandler<MouseEvent>() {
	//		@Override
	//		public void handle(MouseEvent mouseEvent) {
	//			if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
	//				System.out.println("Set flag on the button");
	//			}
	//		}
	//	});



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


/*
* 	button.setOnAction(new EventHandler<ActionEvent>() {
* 		public void handle(ActionEvent event) {
	* 		System.out.println("Got an action!");
		*}
*	}
* */