package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import DataComparing.CodeValidationShowing;
import FilePackage.DateTimeWriter;
import JavFX.AuthorSystem;
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

public class CrossValidationFX extends Application {

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
            AuthorSystem authorSystem = new AuthorSystem();


            try {
                authorSystem.start(primaryStage);
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

        Button dataComparing = new Button("Data Comparing");
        Button dataPlotting = new Button("Data Plotting");



        dataComparing.setTranslateX(500);
        dataComparing.setTranslateY(250);
        dataPlotting.setTranslateX(500);
        dataPlotting.setTranslateY(350);


        dataComparing.setOnAction(actionEvent -> {

            // new process which we processed today......................................................................
            CodeValidationShowing codeValidationShowing = new CodeValidationShowing();
            try {
                codeValidationShowing.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }



        });

        dataPlotting.setOnAction(actionEvent -> {
                finish(primaryStage);

        });


        setStyle(dataComparing);
        setStyle(dataPlotting);

        dataComparing.setPrefSize(350, 80);
        dataPlotting.setPrefSize(350, 80);



        Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,dataComparing,dataPlotting);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

public void finish(Stage primaryStage){

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
           start(primaryStage);


        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);

        });



        setStyle(exit);
        setStyle(back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Button trainingSet = new Button("Training Set");
        Button testingSet = new Button("Testing Set");



        trainingSet.setTranslateX(500);
        trainingSet.setTranslateY(250);
        testingSet.setTranslateX(500);
        testingSet.setTranslateY(350);


        trainingSet.setOnAction(actionEvent -> {
        TrainingObserVation trainingObserVation = new TrainingObserVation();
            try {
                trainingObserVation.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        testingSet.setOnAction(actionEvent -> {

            TestingSet testingSet1 = new TestingSet();
            try {
                testingSet1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        setStyle(trainingSet);
        setStyle(testingSet);

        trainingSet.setPrefSize(350, 80);
        testingSet.setPrefSize(350, 80);



        Image image = new Image("libraryBackground22.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,trainingSet,testingSet);

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
