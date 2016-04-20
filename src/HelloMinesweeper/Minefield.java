package HelloMinesweeper;

import javafx.scene.layout.StackPane;

import java.util.Random;

/**
 * Created by Jason on 4/13/2016.
 */
public class Minefield {
    private Tile[][] minefield;
    private int rows, columns;
    private string difficulty;
    Random random = new Random();
    boolean finish = false;
    boolean win = false;
    int turn = 0;

    public void Minefield(){

    }

	private void plantMines(){

	}

    public void Minefield(){
        rows = Rows;
        columns = Columns;
        this.difficulty = difficulty;

	    minefield = new Tile[rows][columns];

	    for (int y = 0; y < rows; y++){
		    for (int x = 0; x < columns; x++){
			    Tile tile = new Tile(x,y, Math.random() < getDifficulty());
			    minefield[x][y] = tile;
		    }
	    }
    }

    private class Tile extends StackPane {
        private int x, y;
		private int tileState;
	    private int bombsAround = 0;
	    private boolean exposed = false;

	    public Tile(int x, int y, boolean hasBomb){
		    this.x = x;
		    this.y = y;
		    this.hasBomb = hasBomb;
	    }
    }

    public boolean mark(int column, int row){ // REQUIRED METHOD

	    return false;
    }

    public int expose(int column, int row){ // REQUIRED METHOD
//        - A call to expose() should return:
//        - 0 if a cell was safely exposed and no bombs are adjacent to it. In this case, the all adjacent cells with 0 adjacent bombs should also be exposed. These newly revealed neighbors s can be revealed by call(s) to isExposed
//                - 1-8 if a cell was safely exposed and 1 or more bombs is adjacent to it
//                - -1 If a bomb was exposed at the game is over.
//        - The model should ignore calls to expose a cell if the cell is already marked
        return 0;
    }

    public int isExposed(int column, int row){ // REQUIRED METHOD

		return 0;

    }

	/*
	At any point in time a call to unexposedCount() should return how
	many cells can be exposed without setting off a bomb
	*/
    public int unexposedCount(){ // REQUIRED METHOD

	    return 0;
    }


}
