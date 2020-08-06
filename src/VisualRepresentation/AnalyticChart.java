package VisualRepresentation;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnalyticChart extends Application {

    @Override
    public void start(Stage primaryStage) {
    }

    public void startTypeBook(Stage primaryStage){

    }public void startDemandBook(Stage primaryStage){

    }public void startGenericBook(Stage primaryStage){

    }public void startCLassBook(Stage primaryStage){

    }public void startBorrowCount(Stage primaryStage){

    }

    public Button setStyle(Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }
}
