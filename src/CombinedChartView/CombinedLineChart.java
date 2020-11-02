package CombinedChartView;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.ProcessAnalysis;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import PageRankAlgorithm.PageRankCalculation;
import PageRankAlgorithm.PageRankProcessData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class CombinedLineChart extends Application {
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

    public void start(Stage primaryStage,int index) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(55);
        back.setTranslateY(650);
        exit.setTranslateX(1120);
        exit.setTranslateY(650);

        back.setOnAction(actionEvent -> {
            ProcessAnalysis processAnalysis = new ProcessAnalysis();
            try {
                processAnalysis.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        back.setPrefSize(160, 50);
        exit.setPrefSize(160, 50);
        Font font3= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);
        back.setFont(font3);
        exit.setFont(font3);

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        LineChart lineChart = new LineChart(categoryAxis, numberAxis);
        Tooltip tooltip = new Tooltip("Multiple Linear Regression results shows in Line Chart.\nAll data are books weight");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Multi-variable Linear Regression ");

        int positionIndicator = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
        }

        lineChart.getData().add(series1);
        lineChart.setTranslateX(10);
        lineChart.setTranslateY(25);
        lineChart.setPrefSize(1250, 300);

        ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
        priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
        CategoryAxis categoryAxis1 = new CategoryAxis();
        categoryAxis1.setLabel("Book Class Category");

        NumberAxis numberAxis1 = new NumberAxis();
        numberAxis1.setLabel("Numbers of Book");
        LineChart lineChart1 = new LineChart(categoryAxis1, numberAxis1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Analytic Hierarchy Process");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            series2.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getAHPweight()));
        }

       lineChart1.getData().add(series2);
        lineChart1.setTranslateX(10);
        lineChart1.setTranslateY(350);
        lineChart1.setPrefSize(650, 300);
        PageRankProcessData pageRankProcessData = new PageRankProcessData();
        priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);
        CategoryAxis categoryAxis2 = new CategoryAxis();
        categoryAxis2.setLabel("Book Class Category");

        NumberAxis numberAxis2 = new NumberAxis();
        numberAxis2.setLabel("Numbers of Book");
        LineChart lineChart2 = new LineChart(categoryAxis2, numberAxis2);

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Page Rank Algorithm");

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            series3.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getPRAweight()));
        }
        lineChart2.getData().add(series3);

        lineChart2.setTranslateX(700);
        lineChart2.setTranslateY(350);
        lineChart2.setPrefSize(650, 300);
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
                    combinedLineChart.start(primaryStage,0);
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
        group.getChildren().addAll(canvas, lineChart,lineChart1,lineChart2,exit,back,selectOtherChart);

        Scene scene1 = new Scene(group, 1500, 950);
                primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        start(primaryStage,0);
    }
}
