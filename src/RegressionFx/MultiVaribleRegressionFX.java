package RegressionFx;

import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import RankingAlgorithmFx.StatisticsFX;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class MultiVaribleRegressionFX extends Application {


    @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button twoVariableRegression = new Button("Two Variable Regression");
        Button threeVariableRegression = new Button("Three Variable Regression");
        Button fourVariableRegression = new Button("Four Variable Regression");
        twoVariableRegression.setTranslateX(50);
        twoVariableRegression.setTranslateY(20);
        threeVariableRegression.setTranslateX(50);
        threeVariableRegression.setTranslateY(380);
        fourVariableRegression.setTranslateX(50);
        fourVariableRegression.setTranslateY(740);

double temp;
       temp= twoVariableRegression.getTranslateX();
        twoVariableRegression.setTranslateX(twoVariableRegression.getTranslateY());
        twoVariableRegression.setTranslateY(temp);

        temp=      threeVariableRegression.getTranslateX();
        threeVariableRegression.setTranslateX(threeVariableRegression.getTranslateY());
        threeVariableRegression.setTranslateY(temp);

        temp=     fourVariableRegression.getTranslateX();
        fourVariableRegression.setTranslateX(fourVariableRegression.getTranslateY());
        fourVariableRegression.setTranslateY(temp);

        twoVariableRegression.setOnAction(actionEvent -> {

            TwoVariableRegression twoVariableRegression1 = new TwoVariableRegression();

            try {

                twoVariableRegression1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        threeVariableRegression.setOnAction(actionEvent -> {
ThreeVariableRegression threeVariableRegression1 = new ThreeVariableRegression();
        try {
                threeVariableRegression1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        fourVariableRegression.setOnAction(actionEvent -> {
FourVariableRegression fourVariableRegression1 = new FourVariableRegression();
        try {
                fourVariableRegression1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }


        });


        setStyle(twoVariableRegression);
        setStyle(threeVariableRegression);
        setStyle(fourVariableRegression);


        twoVariableRegression.setPrefSize(350, 80);
        threeVariableRegression.setPrefSize(350, 80);
        fourVariableRegression.setPrefSize(350, 80);



        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            StatisticsFX statisticsFX = new StatisticsFX();

            try {
                statisticsFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);

        });

        setStyle(exit);
        setStyle(back);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground5.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,twoVariableRegression,fourVariableRegression,
                threeVariableRegression,exit,back);



        Button administrationMood = new Button("Administration Mood");
        Button readersMood = new Button("Readers Mood");
        Button about = new Button("About");

        readersMood.setTranslateX(20);
        readersMood.setTranslateY(260);
        administrationMood.setTranslateX(20);
        administrationMood.setTranslateY(320);
        about.setTranslateX(20);
        about.setTranslateY(380);


        administrationMood.setPrefSize(160, 30);
        readersMood.setPrefSize(160, 30);
        about.setPrefSize(160,30);

        administrationMood.setOnAction(actionEvent -> {

            FXThirdWindow fxThirdWindow = new FXThirdWindow();
            try {
                fxThirdWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        readersMood.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        about.setOnAction(actionEvent -> {
            About about1 = new About();
            try {
                about1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        group.getChildren().addAll(readersMood,administrationMood,about);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

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
}
