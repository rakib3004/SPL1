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
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainingSet3 extends Application {
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
    public void start(Stage primaryStage) throws IOException {

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
            TrainingSet trainingSet = new TrainingSet();
            try {
                trainingSet.start(primaryStage);
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

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        ScatterChart ScatterChart  = new ScatterChart (categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Training Set 1 ");
        for (iterator=0;iterator<numberOfBooks;iterator++){
            if (priorityData[iterator].bookData.bookId.substring(13,14).contains("3")||
                    priorityData[iterator].bookData.bookId.substring(13,14).contains("8")) {
                series1.getData().add(new XYChart.Data(priorityData[iterator].bookData.bookName,priorityData[iterator].getMLRweight()));
            }
        }

        ScatterChart .getData().add(series1);

        ScatterChart .setTranslateX(65);
        ScatterChart .setTranslateY(55);
        ScatterChart .setPrefSize(1000,700);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem trainingSet1 = new MenuItem("Training Set 1");
        MenuItem trainingSet2 = new MenuItem("Training Set 2");
        MenuItem trainingSet3 = new MenuItem("Training Set 3");
        MenuItem trainingSet4 = new MenuItem("Training Set 4");
        MenuItem fullTrainingSet = new MenuItem("Full TrainingSet");

        trainingSet1.setOnAction((event) -> {
            try {
                TrainingSet1 trainingSet11 = new TrainingSet1();
                trainingSet11.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        trainingSet2.setOnAction((event) -> {
            TrainingSet2 trainingSet21 = new TrainingSet2();
            try {
                trainingSet21.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        trainingSet3.setOnAction((event) -> {
            try {
                TrainingSet3 trainingSet31 = new TrainingSet3();
                trainingSet31.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        trainingSet4.setOnAction((event) -> {
            try {
                TrainingSet4 trainingSet41 = new TrainingSet4();
                trainingSet41.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fullTrainingSet.setOnAction((event) -> {
            CombinedTrainingSet combinedTrainingSet = new CombinedTrainingSet();
            try {
                combinedTrainingSet.startCombined(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(trainingSet1,trainingSet2,trainingSet3,trainingSet4,fullTrainingSet);

        ScatterChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(ScatterChart, event.getScreenX(), event.getScreenY());
            }
        });

       Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,ScatterChart,exit,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

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
