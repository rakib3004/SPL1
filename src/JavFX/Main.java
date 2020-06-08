package JavFX;

import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationFX;
import RankingAlgorithmFx.StatisticsFX;
import VisualRepresentation.LineChartFX;
import javafx.application.Application;

import javafx.scene.Group;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button welcome = new Button("Welcome to RTML");
        welcome.setTranslateX(480);
        welcome.setTranslateY(300);
        setStyle(welcome);


        welcome.setPrefSize(400, 100);

        welcome.setOnAction(actionEvent -> {

          FxSecondWindow fxSecondWindow = new FxSecondWindow();
            try {
                fxSecondWindow.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        Button exit = new Button("Exit");

        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        setStyle(exit);

        exit.setPrefSize(200, 80);



        Image background = new Image("LibraryBackground17.jpg");
        Canvas canvas = new Canvas(1400, 770);



        Group root = new Group();
        root.getChildren().addAll(canvas, welcome,exit);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(background,0,0);




        Scene scene = new Scene(root,1400,780);
        stage.setScene(scene);
       stage.setFullScreen(true);
        stage.show();

    }

    public Button setStyle( Button button)
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

    

    public static void main(String[] args) {

        Application.launch(args);
    }


}