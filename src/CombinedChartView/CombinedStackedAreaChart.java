package CombinedChartView;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.SystemAnalysis;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import PageRankAlgorithm.PageRankCalculation;
import PageRankAlgorithm.PageRankProcessData;
import RegressionFx.FourVariableRegression;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class CombinedStackedAreaChart extends Application {
    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    PageRankCalculation pageRankCalculation = new PageRankCalculation();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();


    @Override
    public void start(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            SystemAnalysis systemAnalysis = new SystemAnalysis();
            try {
                systemAnalysis.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setStyle(exit);
        setStyle(back);
        back.setPrefSize(160, 50);
        exit.setPrefSize(160, 50);
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        

        StackedAreaChart stackedAreaChart = new StackedAreaChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Multi-variable Linear Regression ");
        int positionIndicator = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
        }
        stackedAreaChart.getData().add(series1);
        stackedAreaChart.setTranslateX(10);
        stackedAreaChart.setTranslateY(25);
        stackedAreaChart.setPrefSize(1250, 300);
        ahPcriteriaWeight = ahPcalculation.AHPcalculationMethods(priorityData, numberOfBooks);
        priorityData = ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight, priorityData, numberOfBooks);
        CategoryAxis categoryAxis1 = new CategoryAxis();
        categoryAxis1.setLabel("Book Class Category");

        NumberAxis numberAxis1 = new NumberAxis();
        numberAxis1.setLabel("Numbers of Book");
        StackedAreaChart stackedAreaChart1 = new StackedAreaChart(categoryAxis1, numberAxis1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Analytic Hierarchy Process");


        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series2.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getAHPweight()));

        }
        stackedAreaChart1.getData().add(series2);

        stackedAreaChart1.setTranslateX(10);
        stackedAreaChart1.setTranslateY(350);
        stackedAreaChart1.setPrefSize(650, 300);
        PageRankProcessData pageRankProcessData = new PageRankProcessData();
        priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData, numberOfBooks);
        CategoryAxis categoryAxis2 = new CategoryAxis();
        categoryAxis2.setLabel("Book Class Category");

        NumberAxis numberAxis2 = new NumberAxis();
        numberAxis2.setLabel("Numbers of Book");


        StackedAreaChart stackedAreaChart2 = new StackedAreaChart(categoryAxis2, numberAxis2);

        XYChart.Series series3 = new XYChart.Series();


        series3.setName("Page Rank Algorithm");


        //   series1.setName("Training Set 1 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series3.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getPRAweight()));

        }


        stackedAreaChart2.getData().add(series3);

        stackedAreaChart2.setTranslateX(700);
        stackedAreaChart2.setTranslateY(350);
        stackedAreaChart2.setPrefSize(650, 300);
        MenuItem scatterChart3 = new MenuItem("Scatter Chart");
        scatterChart3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CombinedScatterChart combinedScatterChart = new CombinedScatterChart();
                try {
                    combinedScatterChart.start(primaryStage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } });
        MenuItem lineChart3 = new MenuItem("Line Chart");

        lineChart3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CombinedLineChart combinedLineChart = new CombinedLineChart();
                try {
                    combinedLineChart.start(primaryStage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        MenuItem stackedAreaChart3 = new MenuItem("StackedArea Chart");
        stackedAreaChart3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CombinedStackedAreaChart combinedStackedAreaChart = new CombinedStackedAreaChart();
                try {
                    combinedStackedAreaChart.start(primaryStage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        MenuButton selectOtherChart = new MenuButton("Select OtherChart");
        selectOtherChart.getItems().addAll( scatterChart3, lineChart3, stackedAreaChart3);


        selectOtherChart.setTranslateX(650);
        selectOtherChart.setTranslateY(320);
        selectOtherChart.setPrefSize(150, 35);


        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, stackedAreaChart, stackedAreaChart1, stackedAreaChart2, exit, back,selectOtherChart);

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public Button setStyle(Button button) {
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
        return button;
    }
}
