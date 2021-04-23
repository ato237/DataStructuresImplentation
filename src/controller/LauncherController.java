package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LauncherController{
    @FXML
    private JFXButton binarySearchTree;
    @FXML
    private JFXButton stack;
    @FXML
    private JFXButton queues;
    @FXML
    private JFXButton linkedList;
    @FXML
    private  JFXButton map;
    @FXML
    private  JFXButton sets;
    @FXML
    private  JFXButton priorityQueue;
    @FXML
    private JFXButton avlTree;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXTextField field;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private VBox verticalBox;


    public void binarySearchTreePage(ActionEvent event) throws IOException {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/containBst.fxml"));
            rootPane.getChildren().setAll(pane);
    }


    public void stack(ActionEvent event) throws IOException {
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/fxml/stackView.fxml"));
            rootPane.getChildren().setAll(pane1);
    }

    public void queuesPage(ActionEvent event){

    }

    public void linkedListPage(ActionEvent event){

    }

    public void mapPage(ActionEvent event){

    }

    public void setsPage(ActionEvent event)
    {

    }

    public void priorityQueuePage(ActionEvent event){

    }

    public void avlTreePage(ActionEvent event){

    }
}
