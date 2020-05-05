package edu.bistu.strategy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller
{
    @FXML
    private GridPane resultDisplay;

    @FXML
    private GridPane sourceDisplay;

    private SortSystem sortSystem;

    private Comparable[] src;
    private Comparable[] res;

    public void initialize()
    {
        sortSystem = new SortSystem();
    }

    @FXML
    void generateSource(ActionEvent event)
    {
        clearDisplay(sourceDisplay);
        clearDisplay(resultDisplay);
        src = Main.prepare();
        displayArray(src, sourceDisplay);
    }

    @FXML
    void bubbleSort(ActionEvent event)
    {
        clearDisplay(resultDisplay);
        sortSystem.setStrategy(BubbleSortStrategy.getInstance());
        res = sortSystem.sort(src);
        displayArray(res, resultDisplay);
    }

    @FXML
    void quickSort(ActionEvent event)
    {
        clearDisplay(resultDisplay);
        sortSystem.setStrategy(QuickSortStrategy.getInstance());
        res = sortSystem.sort(src);
        displayArray(res, resultDisplay);
    }

    @FXML
    void mergeSort(ActionEvent event)
    {
        clearDisplay(resultDisplay);
        sortSystem.setStrategy(MergeSortStrategy.getInstance());
        res = sortSystem.sort(src);
        displayArray(res, resultDisplay);
    }

    @FXML
    void heapSort(ActionEvent event)
    {
        clearDisplay(resultDisplay);
        sortSystem.setStrategy(HeapSortStrategy.getInstance());
        res = sortSystem.sort(src);
        displayArray(res, resultDisplay);
    }

    private void displayArray(Comparable[] arr, GridPane display)
    {
        clearDisplay(display);
        for(int i = 0; i < arr.length; i++)
        {
            display.add(new MyLabel(arr[i]), i, 0);
        }
    }

    private void clearDisplay(GridPane display)
    {
        display.getChildren().clear();
    }

}
