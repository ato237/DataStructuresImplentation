package controller;

import DataStructuresImp.BST;
import DataStructuresImp.BTView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class BSTController implements Initializable {

   @FXML
    private JFXButton delete;

    @FXML
    private JFXButton insert;

    @FXML
    private JFXTextField field;

    @FXML
    private AnchorPane bstPane;

    BST<Integer> tree = new BST<>();


    BTView view = new BTView(tree);


    public void initialize(URL location, ResourceBundle resources) {
        bstPane.getChildren().add(view);
        field.getStyleClass().add("jfx-field");
    }


    public void insertValue(javafx.event.ActionEvent event) {
        try {
            int key = Integer.parseInt(field.getText());
            if (tree.search(key)) {
                view.displayTree();
                view.setStatus(key + "is already in the tree");
            } else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + "is inserted in the tree");
            }
        }
        catch (NumberFormatException e){
            view.clear();
            view.displayTree();
            view.setStatus("Please enter an integer");
        }

    }

    public void deleteValue(javafx.event.ActionEvent event) {
        try {
        int key = Integer.parseInt(field.getText());

            if (!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + "is not in the tree");
            } else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + "is inserted in the tree");
            }
        }catch (NumberFormatException e){
            view.clear();
            view.displayTree();
            view.setStatus("Please enter an integer");
        }
    }

}
