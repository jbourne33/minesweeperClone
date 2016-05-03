package HelloMinesweeper;

import javafx.scene.layout.StackPane;

import java.util.Random;

/**
 * Created by Jason on 4/13/2016.
 */
public class Minefield {

	private Tile[][] minefield;
	private int Rows, Cols;
	private Random random = new Random();
	private int numMines;
	private int marked;
	private int unexposed;
	private int totalMines;
	public static int MINE = -1;
	private static int EMPTY = 0;

    // Default constructor which will be used for easy mode with 8x8 field
    public Minefield(){
        Rows = 8;
        Cols = 8;
		numMines = 0;
		marked = 0;
		totalMines = 10;
//		this.difficulty = Difficulty;  unneeded if not changing mine percentage
        minefield = new Tile[Rows][Cols];

        for (int row = 0; row < Rows; row++){
            for (int col = 0; col < Cols; col++){
                Tile tile = new Tile(col,row);
                minefield[row][col] = tile;
            }
        }
		plantMines();
		computeTileStates();
    }

// Parameterized constructor which will be used to set medium and hard difficulty
	public Minefield(int rows, int columns){
		Rows = rows;
		Cols = columns;
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

		minefield = new Tile[Rows][Cols];

		for (int row = 0; row < Rows; row++){
			for (int col = 0; col < Cols; col++){
				Tile temp = new Tile(col,row);
				minefield[row][col] = temp;
			}
		}
		unexposed = Rows * Cols - totalMines;
		plantMines();
		computeTileStates();
	}


/*
* Iterates through an existing Minefield and randomly plants mines in tiles till totalMines value is reached
*/
	public void plantMines(){
		for(numMines = 0; numMines < totalMines;){

			int randRow = random.nextInt(Rows-1);
			int randColumn = random.nextInt(Cols-1);

			if(minefield[randRow][randColumn].tileState != MINE) {
				minefield[randRow][randColumn].tileState = MINE;
				numMines++;
			}
		}
	}


	/*
	* Computes the tileStates for the entire board and sets tileState for each tile which has mines around it
	* */
	public void computeTileStates(){
		for (int row = 0; row < Rows; row++){
			for (int col = 0; col < Cols; col++){
				if(minefield[row][col].tileState == MINE){
					incrementNeighbors(row,col);
				}
			}
		}
	}

/*
* This method is probably going over and causing a null pointer exception. need to put in an
* if statement or something. Also check the tile initialization
* */
	private void incrementNeighbors(int row, int col){
		for(int j = -1; j <= 1; j++){ // row iterator
			for(int k = -1; k <= 1; k++){ // column iterator
				int rr = row + j;
				int cc = col + k;
				if (j == 0 && k == 0) continue;
				if (rr >= 0 && rr < Rows && cc >= 0 && cc < Cols){
					if(minefield[rr][cc].tileState != MINE) {
						minefield[rr][cc].tileState++;
					}
				}
			}
		}
	}

/*
* This method marks or unmarks a tile
**/
	public boolean mark(int col, int row){ // REQUIRED METHOD (needs to be boolean?)
		if (!minefield[row][col].marked) {
			minefield[row][col].marked = true; // set to true;
			marked++;
			numMines--;
			return true;
		}
		else {
			minefield[row][col].marked = false;// set to false;
			marked--;
			numMines++;
			return false;
		}
	}


	public int expose(int col, int row){ // REQUIRED METHOD
	    if(!minefield[row][col].exposed) unexposed--;
		minefield[row][col].exposed = true;
		return minefield[row][col].tileState;
    }


// Returns a boolean value for whether or not the tile is exposed already
    public boolean isExposed(int column, int row){ // REQUIRED METHOD (needs to return int?)
		return minefield[column][row].exposed;
    }


	/*
	At any point in time a call to unexposedCount() should return how
	many cells can be exposed without setting off a bomb
	*/
    public int unexposedCount(){ // REQUIRED METHOD
	    return unexposed;
    } // getter for unexposed


	public int minesLeft() {return totalMines - numMines;}


	public boolean win(){
		return marked == numMines;
	}


	public int getTileValue(int row, int col){
		return minefield[row][col].tileState;
	}

    private class Tile extends StackPane {
        int col, row;
        int tileState;  // 0= EMPTY, 1-8 = num mines, -1 = MINE
        boolean exposed;
        boolean marked;

        private Tile(int col, int row){
            this.col = col; // x-axis
            this.row = row; // y-axis
            tileState = EMPTY;
	        exposed = false;
	        marked = false;
        }
    }
}
