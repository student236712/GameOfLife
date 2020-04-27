package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Controller {
    int areaSize = 0;
    int startCellsAmount = 0;
    int generationsAmount = 0;
    Background backgroundBlack = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
    Background backgroundTeal = new Background(new BackgroundFill(Color.TEAL, CornerRadii.EMPTY, Insets.EMPTY));

    @FXML
    public void initialize() {
    }


    @FXML
    private TextField startCellsAmountTf;

    @FXML
    private TextField areaSizeTf;

    @FXML
    private TextField generationsAmountTf;

    @FXML
    private Button startBtn;

    @FXML
    private Button stopButton;

    @FXML
    private GridPane gridPane;

    @FXML
    void startGame(ActionEvent event) {

        //Check if every input is number
        try {
            areaSize = Integer.parseInt(areaSizeTf.getText());
            startCellsAmount = Integer.parseInt(startCellsAmountTf.getText());
            generationsAmount = Integer.parseInt(generationsAmountTf.getText());

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.show();
        }
        try {
            //Check if every number is positive
            if (areaSize <= 0 || startCellsAmount <= 0 || generationsAmount <= 0) {
                throw new ArithmeticException();
                //Check if area isn't smaller than provided cells amount
            } else if (areaSize * areaSize < startCellsAmount) {
                throw new CellsAmountException();
            } else {
                Game game = new Game(startCellsAmount, areaSize, generationsAmount);
                playGame(game);
            }


        } catch (CellsAmountException | ArithmeticException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Probably amount of cells is bigger than area");
            alert.show();
        }


    }

    @FXML
    void stopGame(ActionEvent event) {

    }

    @FXML
    void playGame(Game game) {
        Cell[][] cellArray = game.initializeCellArray(startCellsAmount, areaSize);
        for (int i = 0; i < generationsAmount; i++) {

            game.showCellArray(cellArray, gridPane, backgroundBlack, backgroundTeal);
            cellArray = game.createNextGeneration(cellArray);
            
        }


    }
}
