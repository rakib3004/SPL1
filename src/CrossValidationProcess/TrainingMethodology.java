package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class TrainingMethodology extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    @Override
    public void start(Stage primaryStage){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);



        back.setOnAction(actionEvent -> {
            TrainingObserVation trainingObserVation = new TrainingObserVation();
            try {
                trainingObserVation.start(primaryStage);
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

        Button trainingSet1 = new Button("Training Set 1");
        Button trainingSet2 = new Button("Training Set 2");

        Button trainingSet3 = new Button("Training Set 3");
        Button trainingSet4 = new Button("Training Set 4");
        Button trainingSetAll = new Button("Training Set All");


        trainingSet1.setTranslateX(500);
        trainingSet1.setTranslateY(200);
        trainingSet2.setTranslateX(500);
        trainingSet2.setTranslateY(300);

        trainingSet3.setTranslateX(500);
        trainingSet3.setTranslateY(400);
        trainingSet4.setTranslateX(500);
        trainingSet4.setTranslateY(500);
        trainingSetAll.setTranslateX(500);
        trainingSetAll.setTranslateY(600);


        trainingSet1.setOnAction(actionEvent -> {

TrainingSet1 trainingSet11 = new TrainingSet1();
            try {
                trainingSet11.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        trainingSet2.setOnAction(actionEvent -> {
            TrainingSet2 trainingSet21 = new TrainingSet2();
            try {
                trainingSet21.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
trainingSet3.setOnAction(actionEvent -> {
           TrainingSet3 trainingSet31 = new TrainingSet3();
            try {
                trainingSet31.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        trainingSet4.setOnAction(actionEvent -> {
            TrainingSet4 trainingSet41 = new TrainingSet4();
            try {
                trainingSet41.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
trainingSetAll.setOnAction(actionEvent -> {
            CombinedTrainingSet combinedTrainingSet = new CombinedTrainingSet();
            try {
                combinedTrainingSet.startCombined(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        setStyle(trainingSet1);
        setStyle(trainingSet2);
        setStyle(trainingSet3);
        setStyle(trainingSet4);
        setStyle(trainingSetAll);


        trainingSet1.setPrefSize(350,80);
        trainingSet2.setPrefSize(350,80);
        trainingSet3.setPrefSize(350,80);
        trainingSet4.setPrefSize(350,80);
        trainingSetAll.setPrefSize(350,80);


        Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,trainingSet1,trainingSet2,trainingSet3,trainingSet4,trainingSetAll);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

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
