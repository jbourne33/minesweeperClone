package HelloMinesweeper;


public class MineSweeper {

    private Minefield mf;
    private boolean finished = false;
    private boolean win = false;
    private int turn=0;

    public MineSweeper(int Row, int Column, string difficulty){
        mf = new Minefield(Row, Column, difficulty);
        Play(mf);
    }

    public void Play(Minefield mf){
        do{
            turn++;
            System.out.println("Turn "+turn);
            Minefield.show();
            finished = Minefield.setPosition();

            if(!finished){
                mf.openNeighbors();
                finished = mf.win();
            }

        }while(!finished);

        if(mf.win()){
            System.out.println("Congratulations, you let the 10 fields with the mines in "+turn+" turns");
            mf.showMines();
        } else {
            System.out.println("Mine! You lost!");
            mf.showMines();
        }
    }
}
