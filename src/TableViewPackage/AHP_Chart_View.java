package TableViewPackage;

import CrossValidationProcess.CombinedTrainingSet;
import CrossValidationProcess.CrossValidationVisualization;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AHP_Chart_View extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
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
            CrossValidationVisualization crossValidationVisualization = new CrossValidationVisualization();

            try {
                crossValidationVisualization.start(primaryStage);
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
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");


        LineChart lineChart = new LineChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();


        series1.setName("Book Weight Show");


        int positionIndicator = 0;

        //   series1.setName("Training Set 1 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));

        }


        lineChart.getData().add(series1);

        lineChart.setTranslateX(10);
        lineChart.setTranslateY(25);
        lineChart.setPrefSize(1350, 700);


        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterView = new MenuItem("Scatter View");
        MenuItem lineChartView = new MenuItem("LineChart View");
        MenuItem stackedAreaView = new MenuItem("StackedArea View");



        scatterView.setOnAction((event) -> {
            try {
                CombinedTrainingSet combinedTrainingSet = new CombinedTrainingSet();
                combinedTrainingSet.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        lineChartView.setOnAction((event) -> {
            CrossValidationVisualization crossValidationVisualization = new CrossValidationVisualization();
            try {
                crossValidationVisualization.startLineChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {
            CrossValidationVisualization crossValidationVisualization = new CrossValidationVisualization();
            try {
                crossValidationVisualization.startStackedArea(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


        contextMenu.getItems().addAll(scatterView, lineChartView, stackedAreaView);

        lineChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(lineChart, event.getScreenX(), event.getScreenY());
            }
        });


        //  Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, lineChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        // graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group, 1500, 950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
