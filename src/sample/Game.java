package sample;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class Game {


    private static int startCellsAmount;
    private static int areaSize;
    private static int generationsAmount;

    public Game(int startCellsAmount, int areaSize, int generationsAmount) {
        this.startCellsAmount = startCellsAmount;
        this.areaSize = areaSize;
        this.generationsAmount = generationsAmount;
    }

    public void playGame(GridPane root, Background bc1, Background bc2) {

        Cell cellArray[][] = initializeCellArray(startCellsAmount, areaSize);
    }

    public Cell[][] initializeCellArray(int startCellsAmount, int arraySize) {
        Cell cellArray[][] = new Cell[arraySize][arraySize];
        Random random = new Random();
        int aliveCounter = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                int r = random.nextInt(2);
                cellArray[i][j] = new Cell();
                if (r == 1 && aliveCounter < startCellsAmount) {
                    cellArray[i][j].setAlive(1);
                    aliveCounter++;
                } else {
                    cellArray[i][j].setAlive(0);
                }
            }
        }
        return cellArray;
    }

    public static void showCellArray(Cell cellArray[][]) {
        for (Cell[] a : cellArray) {
            for (Cell i : a) {
                System.out.print(i.isAlive() + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void showCellArray(Cell[][] cellArray, GridPane root, Background bc1, Background bc2) {
        for (Cell[] a : cellArray) {
            for (Cell i : a) {

                TextField tf = new TextField();
                //tf.setPrefHeight(areaSize);
                //tf.setPrefWidth(areaSize);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);

                if (i.isAlive() == 1) {
                    tf.setBackground(bc1);
                } else {
                    tf.setBackground(bc2);
                }

                // Iterate the Index using the loops
                GridPane.setRowIndex(tf, i.getxPosition());
                GridPane.setColumnIndex(tf, i.getyPosition());
                root.getChildren().add(tf);

            }
        }
    }

    public void countCellsNeighbours(Cell cellArray[][]) {
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray.length; j++) {

                ArrayList<Integer> neighboursArray = new ArrayList<>();
                if (i == 0 && j == 0) {
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4
                    neighboursArray.add(cellArray[i + 1][j + 1].isAlive());//5
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                } else if (i == 0 && j == cellArray.length - 1) {
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                    neighboursArray.add(cellArray[i + 1][j - 1].isAlive());//7
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                } else if (i == cellArray.length - 1 && j == 0) {
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i - 1][j + 1].isAlive());//3
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4

                } else if (i == cellArray.length - 1 && j == cellArray.length - 1) {
                    neighboursArray.add(cellArray[i - 1][j - 1].isAlive());//1
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                } else if (i != 0 && i != cellArray.length - 1 && j == 0) {
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i - 1][j + 1].isAlive());//3
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4
                    neighboursArray.add(cellArray[i + 1][j + 1].isAlive());//5
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                } else if (i != 0 && i != cellArray.length - 1 && j == cellArray.length - 1) {
                    neighboursArray.add(cellArray[i - 1][j - 1].isAlive());//1
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                    neighboursArray.add(cellArray[i + 1][j - 1].isAlive());//7
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                } else if (j != 0 && j != cellArray.length - 1 && i == 0) {
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4
                    neighboursArray.add(cellArray[i + 1][j + 1].isAlive());//5
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                    neighboursArray.add(cellArray[i + 1][j - 1].isAlive());//7
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                } else if (j != 0 && j != cellArray.length - 1 && i == cellArray.length - 1) {
                    neighboursArray.add(cellArray[i - 1][j - 1].isAlive());//1
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i - 1][j + 1].isAlive());//3
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                } else {
                    neighboursArray.add(cellArray[i - 1][j - 1].isAlive());//1
                    neighboursArray.add(cellArray[i - 1][j].isAlive());//2
                    neighboursArray.add(cellArray[i - 1][j + 1].isAlive());//3
                    neighboursArray.add(cellArray[i][j + 1].isAlive());//4
                    neighboursArray.add(cellArray[i + 1][j + 1].isAlive());//5
                    neighboursArray.add(cellArray[i + 1][j].isAlive());//6
                    neighboursArray.add(cellArray[i + 1][j - 1].isAlive());//7
                    neighboursArray.add(cellArray[i][j - 1].isAlive());//8
                }
                int sum = neighboursArray.stream()
                        .mapToInt(a -> a)
                        .sum();
                cellArray[i][j].setNeighboursSum(sum);
                cellArray[i][j].setxPosition(i);
                cellArray[i][j].setyPosition(j);
            }
        }

    }

    public Cell[][] createNextGeneration(Cell cellArray[][]) {
        countCellsNeighbours(cellArray);

        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray.length; j++) {
                if (cellArray[i][j].isAliveInNextStep()) {
                    cellArray[i][j].setAlive(1);
                } else {
                    cellArray[i][j].setAlive(0);
                }
            }
        }
        return cellArray;
    }
}
