package HelloMinesweeper;

import javafx.scene.layout.StackPane;

import java.util.Random;

/**
 * Created by Jason on 4/13/2016.
 */
public class Minefield {
	private Tile[][] minefield;
	private int rows, cols;
	private Random random = new Random();
	private int numMines;
	private int marked;
	private int totalMines;

    // Default constructor which will be used for easy mode with 8x8 field
    public Minefield(){
        rows = 7;
        cols = 7;
		numMines = 0;
		marked = 0;
		totalMines = 10;
//		this.difficulty = Difficulty;  unneeded if not changing mine percentage
        minefield = new Tile[rows][cols];

        for (int y = 0; y < rows; y++){
            for (int x = 0; x < cols; x++){
                Tile tile = new Tile(x,y);
                minefield[x][y] = tile;
            }
        }
		plantMines();
		computeTileStates();
    }

// Parameterized constructor which will be used to set medium and hard difficulty
	public Minefield(int Rows, int Columns){
		rows = Rows - 1;
		cols = Columns - 1;
		numMines = 0;
		marked = 0;
		if(Rows == 8){
			// set variables to easy settings
			totalMines = 10;
		}
		if(Rows == 16){
			// set variables to medium settings
			totalMines = 40;
		}
		if(Rows == 30){
			// set variables to hard settings
			totalMines = 99;
		}

		minefield = new Tile[rows][cols];

		for (int y = 0; y < rows; y++){
			for (int x = 0; x < cols; x++){
				Tile tile = new Tile(x,y);
				minefield[x][y] = tile;
			}
		}

		plantMines();
		computeTileStates();
	}


/*
* Iterates through an existing Minefield and randomly plants mines in tiles till totalMines value is reached
*/
	public void plantMines(){
		while(numMines <= totalMines){
    		int Row, Column;
			Row = random.nextInt(rows+1); //    nextInt upper end is exclusive
			Column = random.nextInt(cols+1); // so a +1 is needed here
			if(minefield[Row][Column].tileState != -1) {
				minefield[Row][Column].tileState = -1;
				numMines++;
			}
		}
	}


	/*
	* Computes the tileStates for the entire board and sets tileState for each tile which has mines around it
	* */
	public void computeTileStates(){
		for (int y = 0; y < rows; y++){
			for (int x = 0; x < cols; x++){
				int numMines = 0;
				if(minefield[x-1][y-1].tileState == -1) numMines++;
				if(minefield[x-1][y].tileState == -1) numMines++;
				if(minefield[x-1][y+1].tileState == -1) numMines++;
				if(minefield[x][y-1].tileState == -1) numMines++;
				if(minefield[x][y+1].tileState == -1) numMines++;
				if(minefield[x+1][y-1].tileState == -1) numMines++;
				if(minefield[x+1][y].tileState == -1) numMines++;
				if(minefield[x+1][y+1].tileState == -1) numMines++;
				if(minefield[x][y].tileState != -1) {
					minefield[x][y].tileState = numMines;
				}
			}
		}
	}


/*
* This method marks or unmarks a tile
* I don't understand why it should return a boolean. it seems like it could be a void return
* Talk with Proff Wallace about this one.
**/
	public void mark(int column, int row){ // REQUIRED METHOD (needs to be boolean?)
		if (minefield[column][row].marked == false) {
			minefield[column][row].marked = true; // set to true;
			marked++;
		}
		else if(minefield[column][row].marked == true) {
			minefield[column][row].marked = false;// set to false;
			marked--;
		}
	}


	public int expose(int column, int row){ // REQUIRED METHOD
//        - A call to expose() should return:
//        - 0 if a cell was safely exposed and no bombs are adjacent to it. In this case, the all adjacent cells with 0 adjacent bombs should also be exposed. These newly revealed neighbors s can be revealed by call(s) to isExposed
//                - 1-8 if a cell was safely exposed and 1 or more bombs is adjacent to it
//                - -1 If a bomb was exposed at the game is over.
//        - The model should ignore calls to expose a cell if the cell is already marked
        if(!minefield[column][row].exposed) {
	        return minefield[column][row].tileState;
        }
		else return -200;
    }


// Returns a boolean value for whether or not the
    public boolean isExposed(int column, int row){ // REQUIRED METHOD (needs to return int?)

		return minefield[column][row].exposed;
    }


	/*
	At any point in time a call to unexposedCount() should return how
	many cells can be exposed without setting off a bomb
	*/
    public int unexposedCount(){ // REQUIRED METHOD
		return (((rows+1) * (cols+1)) - numMines - marked);
    }


    private class Tile extends StackPane {
        private int x, y;
        private int tileState;  // 0=no mines, 1-8 = num mines, -1 = mine
        private boolean exposed;
        private boolean marked;

        private Tile(int x, int y){
            this.x = x;
            this.y = y;
            tileState = 0;
	        exposed = false;
	        marked = false;
        }
    }
}
