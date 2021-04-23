package DataStructuresImp;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StackView extends Pane {
    private Stack<Integer> stack = new Stack<>();
    private int length = 20;
    private int width = 10;


    public StackView(Stack<Integer> stack){
        this.stack = stack;
        setStatus("Stack is Empty");
    }

    public String setStatus(String msg){
        return msg;
    }

    public void displayStack(){
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        //getChildren().addAll(rectangle, new Text(5,6,stack.toString()));
    }



}
