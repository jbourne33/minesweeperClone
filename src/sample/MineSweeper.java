package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MineSweeper extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MineSweeperView.fxml"));
        primaryStage.setTitle("Hello Minesweeper");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


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
