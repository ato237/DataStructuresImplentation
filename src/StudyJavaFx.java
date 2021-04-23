
import DataStructuresImp.Helpers;
import DataStructuresImp.Stack;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class StudyJavaFx extends Application {
    private VBox rectHolder = new VBox();
    private VBox holder = new VBox();
    Stack<String> stack = new Stack<>();
    private double vGap = 50;
    VBox vBox = new VBox();

    @Override
    public void start(Stage primaryStage){
        TextField textField = new TextField();
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");


        HBox hBox = new HBox();
        hBox.getChildren().addAll(insert,delete,textField);
        hBox.setAlignment(Pos.CENTER);



        holder.getChildren().add(rectHolder);
        holder.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(holder);
        borderPane.setBottom(hBox);
        borderPane.setTop(vBox);

        BorderPane.setAlignment(hBox,Pos.CENTER);

        Scene scene = new Scene(borderPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("value in rectangle");
        primaryStage.show();


        insert.setOnAction(e-> {
            String value = textField.getText();
            int x = 180;
            int y = 100;

                if (Helpers.isBlank(value)) {
                    vBox.getChildren().clear();
                    vBox.getChildren().add(new Text(20, 20, "Please Enter value!"));
                } else {
                    if (!stack.inside(value)) {
                        stack.push(value);
                        vBox.getChildren().clear();
                            displayStack(x, y, vGap);
                        System.out.println(stack);

                    } else {
                        vBox.getChildren().clear();
                        vBox.getChildren().add(new Text(20, 20, "Value is already present in stack!"));
                    }
                    if (stack.isEmpty())
                        return;
                }
        });

        delete.setOnAction(e->{
            stack.pop();
            System.out.println(stack);
            deleteStack();
           // rectHolder.getChildren().remove();
        });
    }


    public void displayStack( double x, double y, double vGap){
       Rectangle rectangle = new Rectangle(x ,y - vGap ,150,20);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectHolder.getChildren().addAll(rectangle, new Text(x,y,stack.peek()));
        rectHolder.setAlignment(Pos.CENTER);
    }

    public void deleteStack(){
        int n = rectHolder.getChildren().size();
        if (n == 0){
            vBox.getChildren().clear();
            vBox.getChildren().add(new Text(20,20,"Stack is Empty"));
            System.out.println("Stack is empty");
        }
        else {
            vBox.getChildren().clear();
            rectHolder.getChildren().remove(n-2,n);
            System.out.println(rectHolder.getChildren().size());
        }
       // rectHolder.getChildren().remove(1);
    }



}
