import DataStructuresImp.Helpers;
import DataStructuresImp.Queue;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StudyQueue extends Application {
        Queue<String> queue = new Queue<>();
        private VBox holder = new VBox();
        private VBox rectHolder = new VBox();
        private VBox vBox = new VBox();

        private double vGap = 50;

    @Override
    public void start(Stage primaryStage){
        TextField textField = new TextField();
        Button enqueue = new Button("enqueue");
        Button dequeue = new Button("dequeue");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(enqueue,dequeue,textField);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(rectHolder);
        borderPane.setTop(vBox);

        Scene scene = new Scene(borderPane,500,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Linked List");
        primaryStage.show();

        enqueue.setOnAction(e->{
            String value = textField.getText();
            int x = 180;
            int y = 100;

            if (Helpers.isBlank(value)) {
                vBox.getChildren().clear();
                vBox.getChildren().add(new Text(20,20,"Please Enter value"));
            }
            else{
                if(!queue.inside(value)){
                    queue.enqueue(value);
                    vBox.getChildren().clear();
                    displayQueue(x,y,vGap);
                    System.out.println(queue);
                }else{
                    vBox.getChildren().clear();
                    vBox.getChildren().add(new Text(20,20,"Value is already present in queue"));
                }
                if (queue.isEmpty())
                    return;
            }
        });

        dequeue.setOnAction(e->{
            queue.dequeue();
            System.out.println(queue);
            deleteQueue();
        });
    }


    public void displayQueue(double x, double y, double vGap){
        Rectangle rectangle = new Rectangle(x, y-vGap,150,20);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectHolder.getChildren().addAll(rectangle, new Text(x,y,queue.last()));
        System.out.println(queue.last());
        rectHolder.setAlignment(Pos.CENTER);
    }

    public void deleteQueue(){

        if (rectHolder.getChildren().size()==0){
            vBox.getChildren().clear();
            vBox.getChildren().add(new Text(20,20,"Queue is Empty"));
            System.out.println("Queue is Empty");
        }
        else{
            vBox.getChildren().clear();
            rectHolder.getChildren().remove(0,2);
            System.out.println(rectHolder.getChildren().size());
        }
    }

}
