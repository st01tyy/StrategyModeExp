package edu.bistu.strategy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    public static Integer[] prepare()
    {
        Integer[] arr = new Integer[16];
        for(int i = 0; i < arr.length; i++)
            arr[i] = new Random().nextInt(100);
        return arr;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("resources/ui.fxml").toURI().toURL());
        Parent parent = loader.load();
        Controller controller = loader.getController();
        controller.initialize();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("排序系统");
        primaryStage.show();
    }
}
