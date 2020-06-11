package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
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

public class TestingSet extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

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
            CrossValidationFX crossValidationFX = new CrossValidationFX();

            try {
                crossValidationFX.start(primaryStage);
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








        Button testingSetResults = new Button("TestingSet Results");
        Button trainingTestingCompersion = new Button("TrainingTesting Compersion");
        Button codeValidationSet = new Button("CodeValidation Set");


        testingSetResults.setTranslateX(500);
        testingSetResults.setTranslateY(250);
        trainingTestingCompersion.setTranslateX(500);
        codeValidationSet.setTranslateX(500);
        codeValidationSet.setTranslateY(350);
        trainingTestingCompersion.setTranslateY(450);



        testingSetResults.setOnAction(actionEvent -> {
            CombinedTrainingSet combinedTrainingSet = new CombinedTrainingSet();
            try {
                combinedTrainingSet.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        trainingTestingCompersion.setOnAction(actionEvent -> {

            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
             try {
                trainingTestingComparison.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        codeValidationSet.setOnAction(actionEvent -> {
            CrossValidationVisualization crossValidationVisualization =  new CrossValidationVisualization();
            try {
                crossValidationVisualization.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        setStyle(testingSetResults);
        setStyle(trainingTestingCompersion);
        setStyle(codeValidationSet);


        testingSetResults.setPrefSize(350, 80);
        trainingTestingCompersion.setPrefSize(380, 80);
        codeValidationSet.setPrefSize(350, 80);


        Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,testingSetResults,
                trainingTestingCompersion,codeValidationSet);

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
