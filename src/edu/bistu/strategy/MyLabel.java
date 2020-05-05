package edu.bistu.strategy;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;

public class MyLabel extends Label
{
    public MyLabel(Comparable val)
    {
        super(val.toString());
        setPrefSize(36, 30);
        setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        setAlignment(Pos.CENTER);
    }
}
