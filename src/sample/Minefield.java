package sample;
import java.util.Random;

/**
 * Created by Jason on 4/13/2016.
 */
public class Minefield {
    private int[][] minefield;
    private int row, column;
    string difficulty;
    Random random = new Random();
    boolean finish = false;
    boolean win = false;
    int turn = 0;

    public void Minefield(){

    }

	private void plantMines(){

	}

    public void Minefield(int Row, int Column, string difficulty){
        row = Row;
        column = Column;
        this.difficulty = difficulty;
    }


    public boolean mark(int column, int row){

    }

    public int expose(int column, int row){
//        - A call to expose() should return:
//        - 0 if a cell was safely exposed and no bombs are adjacent to it. In this case, the all adjacent cells with 0 adjacent bombs should also be exposed. These newly revealed neighbors s can be revealed by call(s) to isExposed
//                - 1-8 if a cell was safely exposed and 1 or more bombs is adjacent to it
//                - -1 If a bomb was exposed at the game is over.
//        - The model should ignore calls to expose a cell if the cell is already marked


    }

    public int isExposed(int column, int row){





    }

    public int unexposedCount(){




    }
}
