package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DataStructureUi.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("/style/menuStyle.css");
        primaryStage.setTitle("Data structure implementation");
        primaryStage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
}
