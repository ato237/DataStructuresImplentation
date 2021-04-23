import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleAnimation extends Application {

    private VBox left;
    private VBox right;
    private Timeline timeline;
    private Button pausePlay;

    @Override
    public void start(Stage primaryStage){
        left = new VBox(10);
        left.setMinWidth(200);
        right = new VBox(10);
        right.setMinWidth(200);

        HBox hBox = new HBox(10,left,right);
        pausePlay = new Button();

        Button reset = new Button("Reset");
        reset.setOnAction(e-> reset());

        reset();

        BorderPane root = new BorderPane(hBox);
        HBox buttons = new HBox(5,pausePlay,reset);
        buttons.setAlignment(Pos.CENTER);

        root.setBottom(buttons);

        Scene scene = new Scene(root,600,600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void reset(){
        if (timeline != null)
        {
            timeline.stop();
        }

        left.getChildren().clear();
        right.getChildren().clear();

        for (int i =0; i< 5; i++){
            left.getChildren().add(new Rectangle(100,100, Color.CORNFLOWERBLUE));
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->{
            if (moreStepsToDo()){
                doNextStep();
            }else{
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        pausePlay.disableProperty().bind(Bindings.createBooleanBinding(()->{
            if (left.getChildren().isEmpty()) {
                return true;
            }
            return false;
        }, left.getChildren()));

        pausePlay.textProperty().bind(Bindings.createStringBinding(()->{
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                return "Pause";
            }
            return "Play";
        }, timeline.statusProperty()));

        pausePlay.setOnAction(e->{
            if (timeline.getStatus() == Animation.Status.RUNNING){
                timeline.pause();
            }else{
                timeline.play();
            }
        });
    }
    private boolean moreStepsToDo(){
        return !left.getChildren().isEmpty();
    }

    private void doNextStep(){
        int n = left.getChildren().size();
        Node node = left.getChildren().remove(n-1);
        right.getChildren().add(node);
    }

    public static void main(String[]args){
        launch(args);
    }
}
