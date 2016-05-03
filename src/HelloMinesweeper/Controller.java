package HelloMinesweeper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Controller {

	@FXML private Button startButton;
	@FXML private ChoiceBox<String> difficultyMenu = new ChoiceBox<>();
	@FXML private Label tilesLeft;
	@FXML private Label messageBox;
	@FXML private GridPane grid;
	@FXML private Button[][] btns;

	private Minefield minefield;
	private int turn = 0;

	private int Rows, Cols;
	public static int MINE = -1;
	public static int EMPTY = 0;



	@FXML
	private void initialize() {
		messageBox.setText("Game on!");
		tilesLeft.setText("");
		difficultyMenu.getItems().addAll("Easy", "Medium", "Hard");
		difficultyMenu.setValue("Easy");
		startGame();

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startGame();
			}
		});
	}

	@FXML
	private void startGame() {
		setRowsCols(difficultyMenu.getValue());
		btns = new Button[Rows][Cols];
		minefield = new Minefield(Rows, Cols);   // Minefield plants own mines and calculates states
		grid.getChildren().clear(); // clear gridpane before adding buttons
		tilesLeft.setText(Integer.toString(minefield.unexposedCount()));

		for (int j = 0; j < Rows; j++) {
			for (int k = 0; k < Cols; k++) {
				final int finJ = j;	// Row
				final int finK = k; // Column
				btns[j][k] = new Button();
				btns[j][k].setMaxSize(40,40);
				btns[j][k].setMinSize(40,40);
				btns[j][k].setText("");
				btns[j][k].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) { // left click events
						if(mouseEvent.getButton() == MouseButton.PRIMARY) {
							int btnValue = minefield.expose(finK, finJ); // expose the tile in the model
							btns[finJ][finK].setText(Integer.toString(btnValue));  // change the text of the button to show the value
							if (btnValue == MINE){
								btns[finJ][finK].setText("B");
								btns[finJ][finK].setTextFill(Color.RED);
								explode();
							}
							if(btnValue == EMPTY) {
								btns[finJ][finK].setStyle("-fx-background-color: lightgrey");
								btns[finJ][finK].setText("");
								floodFill(finJ,finK);
							}
							tilesLeft.setText(Integer.toString(minefield.unexposedCount()));
							turn++;

						}
						if(mouseEvent.getButton() == MouseButton.SECONDARY) {
							boolean marked = minefield.mark(finK,finJ); // mark the tile in minefield, get col and row from gridpane
							if (marked) {
								btns[finJ][finK].setTextFill(Color.RED);
								btns[finJ][finK].setText("X"); // change the text of the button to show a RED flag or 'F'
								turn++;
							}
							if(!marked) {
								btns[finJ][finK].setText(""); // change the text of the button to show a RED flag or 'F'
								turn++;
							}
							tilesLeft.setText(Integer.toString(minefield.unexposedCount()));// change value of tilesLeft
							if (minefield.win()) won(); // if there are no bombs left, won()
						}
					}
				});
				grid.add(btns[j][k], finK, finJ);
			}
		}
	}

	private void explode(){
		exposeAllTiles();
		messageBox.setTextFill(Color.RED);
		messageBox.setText("YOU BLEW UP!!!");
	}


	private void won(){
		exposeAllTiles();
		messageBox.setTextFill(Color.BLUE);
		messageBox.setText("YOU WON!!! Congratulations, to play again click Start");
	}


	private void exposeAllTiles(){
		for(int i = 0; i < Rows; i++){
			for(int j = 0; j < Cols; j++){
				int btnValue = minefield.expose(j,i);
				btns[i][j].setText(Integer.toString(btnValue));
				if (btnValue == MINE) {
					btns[i][j].setTextFill(Color.RED);
					btns[i][j].setText("B");
				}
				btns[i][j].setDisable(true);   //button.disable
			}
		}
	}


	private void floodFill(int row, int col){
		for(int j = -1; j <= 1; j++){ // row iterator
			for(int k = -1; k <= 1; k++){ // column iterator
				int rr = row + j;
				int cc = col + k;
				if (j == 0 && k == 0) continue;
				if (rr >= 0 && rr < Rows && cc >= 0 && cc < Cols){
					int btnValue = minefield.getTileValue(rr, cc);
					if(btnValue == EMPTY) {
						minefield.expose(cc, rr);
						btns[rr][cc].setStyle("-fx-background-color: lightgrey");
						btns[rr][cc].setText("");
						floodFill(rr,cc);
					}
					else{
						if(!minefield.isExposed(cc, rr)){
							minefield.expose(cc, rr);
							btns[rr][cc].setText(Integer.toString(btnValue));
						}
					}
				}
			}
		}
		return;
	}


	private void setRowsCols(String difficulty) {
		switch (difficulty) {
			case "Easy":
				Rows = 8;
				Cols = 8;
				break;
			case "Medium":
				Rows = 16;
				Cols = 16;
				break;
			case "Hard":
				Rows = 30;
				Cols = 16;
		}
		return;
	}
}
//	As cells are revealed, the unexposed cell counter should update itself, counting
//	down towards zero.
