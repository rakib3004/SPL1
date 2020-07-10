package ResultPackage;

import AHPalgorithm.AHPcalculation;
import BookDataBaseFX.SevenValueCalculation;
import FilePackage.DateTimeWriter;
import InfoDisplay.UIDisplayFX;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import VisualRepresentation.LineChartFX;
import VisualRepresentation.ScatterChartFX;
import VisualRepresentation.StackedAreaFX;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MLR_LineChart extends Application {

    PriorityData[] priorityData;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    SevenValueCalculation sevenValueCalculation = new SevenValueCalculation();
    double []  year2017Books = new double[7];
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPcriteriaWeight ahPcriteriaWeight;

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
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.borrowStatistics(primaryStage);
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
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        LineChart LineChart  = new LineChart (categoryAxis,numberAxis);
        String below4,over4,over7,over10,over15,over20,over25,over30;

        below4 =  "0-3" ;
        over4 =  "4-6" ; over7 =  "7-9" ; over10 =  "10-14" ;
        over15=   "15-19" ;over20 =  "20-24" ; over25 =  "25-29" ;
        over30 =  "30+" ;
        double []   below4Count = new double[7] ;
        double [] over4Count = new double[7] ;
        double [] over7Count = new double[7] ;
        double [] over10Count = new double[7] ;
        double [] over15Count = new double[7] ;
        double []  over20Count = new double[7] ;
        double [] over25Count = new double[7] ;
        double [] over30Count = new double[7];
        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData =  multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        List<Double> list = new ArrayList<>();

        for(iterator=0;iterator<numberOfBooks;iterator++){
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=30.0){
                //over30Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over30Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=25.0){
                //over25Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over25Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=20.0){
                //over20Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over20Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=15.0){
                //over15Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over15Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=10.0){
                //over10Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over10Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=7.0){
                //over7Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over7Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=4.0){
                //over4Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over4Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>4.0){
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over4Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(below4);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over4);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(over7);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(over10);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(over15);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(over20);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(over25);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(over30);

        series1.getData().add(new XYChart.Data(below4,below4Count[0]));
        series1.getData().add(new XYChart.Data(below4,below4Count[1]));
        series1.getData().add(new XYChart.Data(below4,below4Count[2]));
        series1.getData().add(new XYChart.Data(below4,below4Count[3]));
        series1.getData().add(new XYChart.Data(below4,below4Count[4]));
        series1.getData().add(new XYChart.Data(below4,below4Count[5]));
        series1.getData().add(new XYChart.Data(below4,below4Count[6]));

        series2.getData().add(new XYChart.Data(over4,over4Count[0]));
        series2.getData().add(new XYChart.Data(over4,over4Count[1]));
        series2.getData().add(new XYChart.Data(over4,over4Count[2]));
        series2.getData().add(new XYChart.Data(over4,over4Count[3]));
        series2.getData().add(new XYChart.Data(over4,over4Count[4]));
        series2.getData().add(new XYChart.Data(over4,over4Count[5]));
        series2.getData().add(new XYChart.Data(over4,over4Count[6]));

        series3.getData().add(new XYChart.Data(over7,over7Count[0]));
        series3.getData().add(new XYChart.Data(over7,over7Count[1]));
        series3.getData().add(new XYChart.Data(over7,over7Count[2]));
        series3.getData().add(new XYChart.Data(over7,over7Count[3]));
        series3.getData().add(new XYChart.Data(over7,over7Count[4]));
        series3.getData().add(new XYChart.Data(over7,over7Count[5]));
        series3.getData().add(new XYChart.Data(over7,over7Count[6]));

        series4.getData().add(new XYChart.Data(over10,over10Count[0]));
        series4.getData().add(new XYChart.Data(over10,over10Count[1]));
        series4.getData().add(new XYChart.Data(over10,over10Count[2]));
        series4.getData().add(new XYChart.Data(over10,over10Count[3]));
        series4.getData().add(new XYChart.Data(over10,over10Count[4]));
        series4.getData().add(new XYChart.Data(over10,over10Count[5]));
        series4.getData().add(new XYChart.Data(over10,over10Count[6]));

        series5.getData().add(new XYChart.Data(over15,over15Count[0]));
        series5.getData().add(new XYChart.Data(over15,over15Count[1]));
        series5.getData().add(new XYChart.Data(over15,over15Count[2]));
        series5.getData().add(new XYChart.Data(over15,over15Count[3]));
        series5.getData().add(new XYChart.Data(over15,over15Count[4]));
        series5.getData().add(new XYChart.Data(over15,over15Count[5]));
        series5.getData().add(new XYChart.Data(over15,over15Count[6]));

        series6.getData().add(new XYChart.Data(over20,over20Count[0]));
        series6.getData().add(new XYChart.Data(over20,over20Count[1]));
        series6.getData().add(new XYChart.Data(over20,over20Count[2]));
        series6.getData().add(new XYChart.Data(over20,over20Count[3]));
        series6.getData().add(new XYChart.Data(over20,over20Count[4]));
        series6.getData().add(new XYChart.Data(over20,over20Count[5]));
        series6.getData().add(new XYChart.Data(over20,over20Count[6]));

        series7.getData().add(new XYChart.Data(over25,over25Count[0]));
        series7.getData().add(new XYChart.Data(over25,over25Count[1]));
        series7.getData().add(new XYChart.Data(over25,over25Count[2]));
        series7.getData().add(new XYChart.Data(over25,over25Count[3]));
        series7.getData().add(new XYChart.Data(over25,over25Count[4]));
        series7.getData().add(new XYChart.Data(over25,over25Count[5]));
        series7.getData().add(new XYChart.Data(over25,over25Count[6]));

        series8.getData().add(new XYChart.Data(over30,over30Count[0]));
        series8.getData().add(new XYChart.Data(over30,over30Count[1]));
        series8.getData().add(new XYChart.Data(over30,over30Count[2]));
        series8.getData().add(new XYChart.Data(over30,over30Count[3]));
        series8.getData().add(new XYChart.Data(over30,over30Count[4]));
        series8.getData().add(new XYChart.Data(over30,over30Count[5]));
        series8.getData().add(new XYChart.Data(over30,over30Count[6]));

        LineChart .getData().add(series1);
        LineChart .getData().add(series2);
        LineChart .getData().add(series3);
        LineChart .getData().add(series4);
        LineChart .getData().add(series5);
        LineChart .getData().add(series6);
        LineChart .getData().add(series7);
        LineChart .getData().add(series8);

        LineChart .setTranslateX(65);
        LineChart .setTranslateY(55);
        LineChart .setPrefSize(1000,700);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterChart = new MenuItem("Scatter Chart");
        MenuItem lineChart = new MenuItem("Line Chart");
        MenuItem stackedAreaChart = new MenuItem("Stacked Area Chart");
        lineChart.setOnAction((event) -> {
            LineChartFX lineChartFX = new LineChartFX();
            try {
                lineChartFX.startBorrowing(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stackedAreaChart.setOnAction((event) -> {
            try {
                StackedAreaFX stackedAreaFX = new StackedAreaFX();
                stackedAreaFX.startBorrowing(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        scatterChart.setOnAction((event) -> {
            try {
                ScatterChartFX stackedAreaFX = new ScatterChartFX();
                stackedAreaFX.startBorrowing(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        contextMenu.getItems().addAll(scatterChart,lineChart,stackedAreaChart);
        LineChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(LineChart, event.getScreenX(), event.getScreenY());
            }
        });
        HBox hBox1 = new HBox(LineChart ,exit,back);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(1400,750);
        Image background = new Image("Images"+ File.separator +"libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);
        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);
        Scene scene = new Scene(group ,1400, 770);
        primaryStage.setScene(scene);
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
