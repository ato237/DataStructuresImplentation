package controller;

import DataStructuresImp.Stack;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class StackController implements Initializable {

    @FXML
    JFXButton pop;

    @FXML
    JFXButton push;

    @FXML
    JFXTextField fieldText;

    Stack<Integer> stack;

    public void initialize(URL location, ResourceBundle resourceBundle){
        fieldText.getStyleClass().add("jfx-field");
    }

    public void popValue(){

    }
    public void pushValue(){

    }
}
