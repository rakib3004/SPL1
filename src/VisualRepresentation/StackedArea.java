package VisualRepresentation;
import BookDataBaseFX.*;
import FilePackage.DateTimeWriter;
import InfoDisplay.SevenNumberImplementation;
import InfoDisplay.SevenValueStatistics;
import JavFX.Main;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StackedArea extends Application {

    PriorityData[] priorityData;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    SevenValueCalculation sevenValueCalculation = new SevenValueCalculation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    String sevenValueArray0 =  "findMinimumValue";
    String sevenValueArray6 ="findMaximumValue";
    String sevenValueArray3= "findMedianValue";
    String sevenValueArray2= "findFirstQuartileValue";
    String sevenValueArray4=  "findThirdQuartileValue";
    String sevenValueArray1=  "findLowerAdjacentValue";
    String sevenValueArray5=  "findUpperAdjacentValue";

    ScatterChart scatterChart = new ScatterChart();
    LineChart lineChart = new LineChart();
    StackedArea stackedArea = new StackedArea();
    @Override
    public void start(Stage primaryStage) {
    }
    public void startTyping(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410,230);
        line_chart.setPrefSize(410,230);
        stacked_area_chart.setPrefSize(410,230);

        scatter_chart.setFont(font2);
        line_chart.setFont(font2);
        stacked_area_chart.setFont(font2);
        scatter_chart.setTranslateX(30);
        scatter_chart.setTranslateY(35);
        line_chart.setTranslateX(30);
        line_chart.setTranslateY(270);
        stacked_area_chart.setTranslateX(30);
        stacked_area_chart.setTranslateY(505);

        scatter_chart.setContentDisplay(ContentDisplay.TOP);
        line_chart.setContentDisplay(ContentDisplay.TOP);
        stacked_area_chart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));

        scatter_chart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTyping(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTyping(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        line_chart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTyping(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Type based Seven Value Analysis");
        text.setTranslateX(520);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenNumberImplementation sevenNumberImplementation = new SevenNumberImplementation();
            try {
                sevenNumberImplementation.typeStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart,exit,home,text,back);

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData =    multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);

        String uponnashType,kobitaType,rochonaBoliType,
                religionType,bigganType,sciFicType,shisuSahittoType,kisoreUponnashType,onubadType,othersType;

        double [] uponnashTypeNO= new double[7] ;
        double []kobitaTypeNO= new double[7] ;
        double []rochonaBoliTypeNO= new double[7] ;
        double []  religionTypeNO= new double[7] ;
        double []bigganTypeNO= new double[7] ;
        double []sciFicTypeNO= new double[7] ;
        double []shisuSahittoTypeNO= new double[7] ;
        double []  kisoreUponnashTypeNO= new double[7] ;
        double []onubadTypeNO= new double[7] ;
        double []othersTypeNO = new double[7];
        uponnashType="Uponnash";
        kobitaType = "Kobita";
        rochonaBoliType = "Rochhona Boli";
        religionType= "Religion";
        bigganType = "Biggan";
        sciFicType = "Science Fiction";
        shisuSahittoType = "SHishu Sahitto";
        kisoreUponnashType = "Kisore";
        onubadType = "Onubad";
        othersType= "Others";
        List<Double> list = new ArrayList<>();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("01")) {
                //   uponnashTypeNO++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                uponnashTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("05")) {
                //    rochonaBoliTypeNO++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                rochonaBoliTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("02")) {
            //    kobitaTypeNO++;
            list.add(priorityData[iterator].getMLRweight());
        }
            int sizeB = list.size();
            if(sizeB>7){
                kobitaTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("13")) {
            //  bigganTypeNO++;
            list.add(priorityData[iterator].getMLRweight());
        }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("14")) {
            //   bigganTypeNO++;

            list.add(priorityData[iterator].getMLRweight());
        }
            int sizeB = list.size();
            if(sizeB>7){
                bigganTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("06")) {
            //   sciFicTypeNO++;
           list.add(priorityData[iterator].getMLRweight());
        }
           int sizeB = list.size();
            if(sizeB>7){
                sciFicTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("10")) {
            //  kisoreUponnashTypeNO++;

        }  } for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("11")) {
            //  shisuSahittoTypeNO++;
            list.add(priorityData[iterator].getMLRweight());
        }
            int sizeB = list.size();
            if(sizeB>7){
                shisuSahittoTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("08")) {
            // onubadTypeNO++;
            list.add(priorityData[iterator].getMLRweight());
        }
            int sizeB = list.size();
            if(sizeB>7){
                onubadTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();for (iterator = 0; iterator < numberOfBooks; iterator++) { if (priorityData[iterator].bookData.bookId.substring(0,2).equals("12")) {
            //  onubadTypeNO++;
            list.add(priorityData[iterator].getMLRweight());
        }
            int sizeB = list.size();
            if(sizeB>7){
                onubadTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("04")) {
                //     religionTypeNO++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                religionTypeNO =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }for (iterator = 0; iterator < numberOfBooks; iterator++) { {
            //   othersTypeNO++;
        }
        }
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Types");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(uponnashType);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(kobitaType);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(rochonaBoliType);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(religionType);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(bigganType);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(sciFicType);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(shisuSahittoType);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(kisoreUponnashType);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(onubadType);
        XYChart.Series series10 = new XYChart.Series();
        series10.setName(othersType);

        series1.getData().add(new XYChart.Data(sevenValueArray0,uponnashTypeNO[0]));
        series1.getData().add(new XYChart.Data(sevenValueArray1,uponnashTypeNO[1]));
        series1.getData().add(new XYChart.Data(sevenValueArray2,uponnashTypeNO[2]));
        series1.getData().add(new XYChart.Data(sevenValueArray3,uponnashTypeNO[3]));
        series1.getData().add(new XYChart.Data(sevenValueArray4,uponnashTypeNO[4]));
        series1.getData().add(new XYChart.Data(sevenValueArray5,uponnashTypeNO[5]));
        series1.getData().add(new XYChart.Data(sevenValueArray6,uponnashTypeNO[6]));

        series2.getData().add(new XYChart.Data(sevenValueArray0,kobitaTypeNO[0]));
        series2.getData().add(new XYChart.Data(sevenValueArray1,kobitaTypeNO[1]));
        series2.getData().add(new XYChart.Data(sevenValueArray2,kobitaTypeNO[2]));
        series2.getData().add(new XYChart.Data(sevenValueArray3,kobitaTypeNO[3]));
        series2.getData().add(new XYChart.Data(sevenValueArray4,kobitaTypeNO[4]));
        series2.getData().add(new XYChart.Data(sevenValueArray5,kobitaTypeNO[5]));
        series2.getData().add(new XYChart.Data(sevenValueArray6,kobitaTypeNO[6]));

        series3.getData().add(new XYChart.Data(sevenValueArray0,rochonaBoliTypeNO[0]));
        series3.getData().add(new XYChart.Data(sevenValueArray1,rochonaBoliTypeNO[1]));
        series3.getData().add(new XYChart.Data(sevenValueArray2,rochonaBoliTypeNO[2]));
        series3.getData().add(new XYChart.Data(sevenValueArray3,rochonaBoliTypeNO[3]));
        series3.getData().add(new XYChart.Data(sevenValueArray4,rochonaBoliTypeNO[4]));
        series3.getData().add(new XYChart.Data(sevenValueArray5,rochonaBoliTypeNO[5]));
        series3.getData().add(new XYChart.Data(sevenValueArray6,rochonaBoliTypeNO[6]));

        series4.getData().add(new XYChart.Data(sevenValueArray0,religionTypeNO[0]));
        series4.getData().add(new XYChart.Data(sevenValueArray1,religionTypeNO[1]));
        series4.getData().add(new XYChart.Data(sevenValueArray2,religionTypeNO[2]));
        series4.getData().add(new XYChart.Data(sevenValueArray3,religionTypeNO[3]));
        series4.getData().add(new XYChart.Data(sevenValueArray4,religionTypeNO[4]));
        series4.getData().add(new XYChart.Data(sevenValueArray5,religionTypeNO[5]));
        series4.getData().add(new XYChart.Data(sevenValueArray6,religionTypeNO[6]));

        series5.getData().add(new XYChart.Data(sevenValueArray0,bigganTypeNO[0]));
        series5.getData().add(new XYChart.Data(sevenValueArray1,bigganTypeNO[1]));
        series5.getData().add(new XYChart.Data(sevenValueArray2,bigganTypeNO[2]));
        series5.getData().add(new XYChart.Data(sevenValueArray3,bigganTypeNO[3]));
        series5.getData().add(new XYChart.Data(sevenValueArray4,bigganTypeNO[4]));
        series5.getData().add(new XYChart.Data(sevenValueArray5,bigganTypeNO[5]));
        series5.getData().add(new XYChart.Data(sevenValueArray6,bigganTypeNO[6]));

        series6.getData().add(new XYChart.Data(sevenValueArray0,sciFicTypeNO[0]));
        series6.getData().add(new XYChart.Data(sevenValueArray1,sciFicTypeNO[1]));
        series6.getData().add(new XYChart.Data(sevenValueArray2,sciFicTypeNO[2]));
        series6.getData().add(new XYChart.Data(sevenValueArray3,sciFicTypeNO[3]));
        series6.getData().add(new XYChart.Data(sevenValueArray4,sciFicTypeNO[4]));
        series6.getData().add(new XYChart.Data(sevenValueArray5,sciFicTypeNO[5]));
        series6.getData().add(new XYChart.Data(sevenValueArray6,sciFicTypeNO[6]));

        series7.getData().add(new XYChart.Data(sevenValueArray0,shisuSahittoTypeNO[0]));
        series7.getData().add(new XYChart.Data(sevenValueArray1,shisuSahittoTypeNO[1]));
        series7.getData().add(new XYChart.Data(sevenValueArray2,shisuSahittoTypeNO[2]));
        series7.getData().add(new XYChart.Data(sevenValueArray3,shisuSahittoTypeNO[3]));
        series7.getData().add(new XYChart.Data(sevenValueArray4,shisuSahittoTypeNO[4]));
        series7.getData().add(new XYChart.Data(sevenValueArray5,shisuSahittoTypeNO[5]));
        series7.getData().add(new XYChart.Data(sevenValueArray6,shisuSahittoTypeNO[6]));

        series8.getData().add(new XYChart.Data(sevenValueArray0,kisoreUponnashTypeNO[0]));
        series8.getData().add(new XYChart.Data(sevenValueArray1,kisoreUponnashTypeNO[1]));
        series8.getData().add(new XYChart.Data(sevenValueArray2,kisoreUponnashTypeNO[2]));
        series8.getData().add(new XYChart.Data(sevenValueArray3,kisoreUponnashTypeNO[3]));
        series8.getData().add(new XYChart.Data(sevenValueArray4,kisoreUponnashTypeNO[4]));
        series8.getData().add(new XYChart.Data(sevenValueArray5,kisoreUponnashTypeNO[5]));
        series8.getData().add(new XYChart.Data(sevenValueArray6,kisoreUponnashTypeNO[6]));

        series9.getData().add(new XYChart.Data(sevenValueArray0,onubadTypeNO[0]));
        series9.getData().add(new XYChart.Data(sevenValueArray1,onubadTypeNO[1]));
        series9.getData().add(new XYChart.Data(sevenValueArray2,onubadTypeNO[2]));
        series9.getData().add(new XYChart.Data(sevenValueArray3,onubadTypeNO[3]));
        series9.getData().add(new XYChart.Data(sevenValueArray4,onubadTypeNO[4]));
        series9.getData().add(new XYChart.Data(sevenValueArray5,onubadTypeNO[5]));
        series9.getData().add(new XYChart.Data(sevenValueArray6,onubadTypeNO[6]));

        series10.getData().add(new XYChart.Data(sevenValueArray0,othersTypeNO[0]));
        series10.getData().add(new XYChart.Data(sevenValueArray1,othersTypeNO[1]));
        series10.getData().add(new XYChart.Data(sevenValueArray2,othersTypeNO[2]));
        series10.getData().add(new XYChart.Data(sevenValueArray3,othersTypeNO[3]));
        series10.getData().add(new XYChart.Data(sevenValueArray4,othersTypeNO[4]));
        series10.getData().add(new XYChart.Data(sevenValueArray5,othersTypeNO[5]));
        series10.getData().add(new XYChart.Data(sevenValueArray6,othersTypeNO[6]));

        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart .getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);
        StackedAreaChart .getData().add(series10);

        StackedAreaChart.setTranslateX(470);
        StackedAreaChart.setTranslateY(35);
        StackedAreaChart.setPrefSize(850,425);
        group.getChildren().add(StackedAreaChart);
        Scene scene = new Scene(group ,1400, 770);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public void startTiming(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410,230);
        line_chart.setPrefSize(410,230);
        stacked_area_chart.setPrefSize(410,230);

        scatter_chart.setFont(font2);
        line_chart.setFont(font2);
        stacked_area_chart.setFont(font2);
        scatter_chart.setTranslateX(30);
        scatter_chart.setTranslateY(35);
        line_chart.setTranslateX(30);
        line_chart.setTranslateY(270);
        stacked_area_chart.setTranslateX(30);
        stacked_area_chart.setTranslateY(505);

        scatter_chart.setContentDisplay(ContentDisplay.TOP);
        line_chart.setContentDisplay(ContentDisplay.TOP);
        stacked_area_chart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));
        scatter_chart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTiming(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTiming(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        line_chart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTiming(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Time based Seven Value Analysis");
        text.setTranslateX(520);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenNumberImplementation sevenNumberImplementation = new SevenNumberImplementation();
            try {
                sevenNumberImplementation.timeStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart,exit,home,text,back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Generics of Book Bar Chart");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Generics of Book");

        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);
        double []  year2008Books= new double [7] ; double []year2009Books= new double [7] ; double []year2010Books= new double [7] ; double []year2011Books= new double [7] ; double []year2012Books= new double [7] ; double []
                year2013Books= new double [7] ; double []year2014Books= new double [7] ; double []year2015Books= new double [7] ; double []year2016Books= new double [7] ; double []year2017Books = new double[7];
        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData =  multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        List<Double> list = new ArrayList<>();

        for(iterator=0;iterator<numberOfBooks;iterator++){
            if(priorityData[iterator].bookData.bookId.contains("17")){
                //year2017Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2017Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("16")){
                //year2016Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2016Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("15")){
                //year2015Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2015Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("14")){
                //year2014Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2014Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("13")){
                //year2013Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2013Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0812")){
                //year2012Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2012Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0212")){
                //year2012Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2012Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("1211")){
                //year2011Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2011Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0311")){
                //year2011Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2011Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("1210")){
                //year2010Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2010Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0810")){
                //year2010Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2010Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0410")){
                //year2010Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2010Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("1009")){
                //year2009Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2009Books =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0409")){
                //year2009Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2009Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("1208")){
                //year2008Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2008Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear(); for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(priorityData[iterator].bookData.bookId.contains("0608")){
                //year2008Books++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                year2008Books  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;

        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(year2008);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(year2009);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(year2010);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(year2011);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(year2012);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(year2013);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(year2014);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(year2015);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(year2016);
        XYChart.Series series10 = new XYChart.Series();
        series9.setName(year2017);

        series1.getData().add(new XYChart.Data(sevenValueArray0,year2008Books[0]));
        series1.getData().add(new XYChart.Data(sevenValueArray1,year2008Books[1]));
        series1.getData().add(new XYChart.Data(sevenValueArray2,year2008Books[2]));
        series1.getData().add(new XYChart.Data(sevenValueArray3,year2008Books[3]));
        series1.getData().add(new XYChart.Data(sevenValueArray4,year2008Books[4]));
        series1.getData().add(new XYChart.Data(sevenValueArray5,year2008Books[5]));
        series1.getData().add(new XYChart.Data(sevenValueArray6,year2008Books[6]));

        series2.getData().add(new XYChart.Data(sevenValueArray0,year2009Books[0]));
        series2.getData().add(new XYChart.Data(sevenValueArray1,year2009Books[1]));
        series2.getData().add(new XYChart.Data(sevenValueArray2,year2009Books[2]));
        series2.getData().add(new XYChart.Data(sevenValueArray3,year2009Books[3]));
        series2.getData().add(new XYChart.Data(sevenValueArray4,year2009Books[4]));
        series2.getData().add(new XYChart.Data(sevenValueArray5,year2009Books[5]));
        series2.getData().add(new XYChart.Data(sevenValueArray6,year2009Books[6]));

        series3.getData().add(new XYChart.Data(sevenValueArray0,year2010Books[0]));
        series3.getData().add(new XYChart.Data(sevenValueArray1,year2010Books[1]));
        series3.getData().add(new XYChart.Data(sevenValueArray2,year2010Books[2]));
        series3.getData().add(new XYChart.Data(sevenValueArray3,year2010Books[3]));
        series3.getData().add(new XYChart.Data(sevenValueArray4,year2010Books[4]));
        series3.getData().add(new XYChart.Data(sevenValueArray5,year2010Books[5]));
        series3.getData().add(new XYChart.Data(sevenValueArray6,year2010Books[6]));

        series4.getData().add(new XYChart.Data(sevenValueArray0,year2011Books[0]));
        series4.getData().add(new XYChart.Data(sevenValueArray1,year2011Books[1]));
        series4.getData().add(new XYChart.Data(sevenValueArray2,year2011Books[2]));
        series4.getData().add(new XYChart.Data(sevenValueArray3,year2011Books[3]));
        series4.getData().add(new XYChart.Data(sevenValueArray4,year2011Books[4]));
        series4.getData().add(new XYChart.Data(sevenValueArray5,year2011Books[5]));
        series4.getData().add(new XYChart.Data(sevenValueArray6,year2011Books[6]));

        series5.getData().add(new XYChart.Data(sevenValueArray0,year2012Books[0]));
        series5.getData().add(new XYChart.Data(sevenValueArray1,year2012Books[1]));
        series5.getData().add(new XYChart.Data(sevenValueArray2,year2012Books[2]));
        series5.getData().add(new XYChart.Data(sevenValueArray3,year2012Books[3]));
        series5.getData().add(new XYChart.Data(sevenValueArray4,year2012Books[4]));
        series5.getData().add(new XYChart.Data(sevenValueArray5,year2012Books[5]));
        series5.getData().add(new XYChart.Data(sevenValueArray6,year2012Books[6]));

        series6.getData().add(new XYChart.Data(sevenValueArray0,year2013Books[0]));
        series6.getData().add(new XYChart.Data(sevenValueArray1,year2013Books[1]));
        series6.getData().add(new XYChart.Data(sevenValueArray2,year2013Books[2]));
        series6.getData().add(new XYChart.Data(sevenValueArray3,year2013Books[3]));
        series6.getData().add(new XYChart.Data(sevenValueArray4,year2013Books[4]));
        series6.getData().add(new XYChart.Data(sevenValueArray5,year2013Books[5]));
        series6.getData().add(new XYChart.Data(sevenValueArray6,year2013Books[6]));

        series7.getData().add(new XYChart.Data(sevenValueArray0,year2014Books[0]));
        series7.getData().add(new XYChart.Data(sevenValueArray1,year2014Books[1]));
        series7.getData().add(new XYChart.Data(sevenValueArray2,year2014Books[2]));
        series7.getData().add(new XYChart.Data(sevenValueArray3,year2014Books[3]));
        series7.getData().add(new XYChart.Data(sevenValueArray4,year2014Books[4]));
        series7.getData().add(new XYChart.Data(sevenValueArray5,year2014Books[5]));
        series7.getData().add(new XYChart.Data(sevenValueArray6,year2014Books[6]));

        series8.getData().add(new XYChart.Data(sevenValueArray0,year2015Books[0]));
        series8.getData().add(new XYChart.Data(sevenValueArray1,year2015Books[1]));
        series8.getData().add(new XYChart.Data(sevenValueArray2,year2015Books[2]));
        series8.getData().add(new XYChart.Data(sevenValueArray3,year2015Books[3]));
        series8.getData().add(new XYChart.Data(sevenValueArray4,year2015Books[4]));
        series8.getData().add(new XYChart.Data(sevenValueArray5,year2015Books[5]));
        series8.getData().add(new XYChart.Data(sevenValueArray6,year2015Books[6]));

        series9.getData().add(new XYChart.Data(sevenValueArray0,year2016Books[0]));
        series9.getData().add(new XYChart.Data(sevenValueArray1,year2016Books[1]));
        series9.getData().add(new XYChart.Data(sevenValueArray2,year2016Books[2]));
        series9.getData().add(new XYChart.Data(sevenValueArray3,year2016Books[3]));
        series9.getData().add(new XYChart.Data(sevenValueArray4,year2016Books[4]));
        series9.getData().add(new XYChart.Data(sevenValueArray5,year2016Books[5]));
        series9.getData().add(new XYChart.Data(sevenValueArray6,year2016Books[6]));

        series10.getData().add(new XYChart.Data(sevenValueArray0,year2017Books[0]));
        series10.getData().add(new XYChart.Data(sevenValueArray1,year2017Books[1]));
        series10.getData().add(new XYChart.Data(sevenValueArray2,year2017Books[2]));
        series10.getData().add(new XYChart.Data(sevenValueArray3,year2017Books[3]));
        series10.getData().add(new XYChart.Data(sevenValueArray4,year2017Books[4]));
        series10.getData().add(new XYChart.Data(sevenValueArray5,year2017Books[5]));
        series10.getData().add(new XYChart.Data(sevenValueArray6,year2017Books[6]));

        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);
        StackedAreaChart.getData().add(series10);

        StackedAreaChart.setTranslateX(470);
        StackedAreaChart.setTranslateY(35);
        StackedAreaChart.setPrefSize(850,425);


        group.getChildren().add(StackedAreaChart);
        Scene scene = new Scene(group ,1400, 770);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public void startBorrowing(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410,230);
        line_chart.setPrefSize(410,230);
        stacked_area_chart.setPrefSize(410,230);

        scatter_chart.setFont(font2);
        line_chart.setFont(font2);
        stacked_area_chart.setFont(font2);
        scatter_chart.setTranslateX(30);
        scatter_chart.setTranslateY(35);
        line_chart.setTranslateX(30);
        line_chart.setTranslateY(270);
        stacked_area_chart.setTranslateX(30);
        stacked_area_chart.setTranslateY(505);

        scatter_chart.setContentDisplay(ContentDisplay.TOP);
        line_chart.setContentDisplay(ContentDisplay.TOP);
        stacked_area_chart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));
        scatter_chart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                stackedArea.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        line_chart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Borrow based Seven Value Analysis");
        text.setTranslateX(520);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenNumberImplementation sevenNumberImplementation = new SevenNumberImplementation();
            try {
                sevenNumberImplementation.borrowStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart,exit,home,text,back);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);

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
            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))<4.0){
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                below4Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
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

        series1.getData().add(new XYChart.Data(sevenValueArray0,below4Count[0]));
        series1.getData().add(new XYChart.Data(sevenValueArray1,below4Count[1]));
        series1.getData().add(new XYChart.Data(sevenValueArray2,below4Count[2]));
        series1.getData().add(new XYChart.Data(sevenValueArray3,below4Count[3]));
        series1.getData().add(new XYChart.Data(sevenValueArray4,below4Count[4]));
        series1.getData().add(new XYChart.Data(sevenValueArray5,below4Count[5]));
        series1.getData().add(new XYChart.Data(sevenValueArray6,below4Count[6]));

        series2.getData().add(new XYChart.Data(sevenValueArray0,over4Count[0]));
        series2.getData().add(new XYChart.Data(sevenValueArray1,over4Count[1]));
        series2.getData().add(new XYChart.Data(sevenValueArray2,over4Count[2]));
        series2.getData().add(new XYChart.Data(sevenValueArray3,over4Count[3]));
        series2.getData().add(new XYChart.Data(sevenValueArray4,over4Count[4]));
        series2.getData().add(new XYChart.Data(sevenValueArray5,over4Count[5]));
        series2.getData().add(new XYChart.Data(sevenValueArray6,over4Count[6]));

        series3.getData().add(new XYChart.Data(sevenValueArray0,over7Count[0]));
        series3.getData().add(new XYChart.Data(sevenValueArray1,over7Count[1]));
        series3.getData().add(new XYChart.Data(sevenValueArray2,over7Count[2]));
        series3.getData().add(new XYChart.Data(sevenValueArray3,over7Count[3]));
        series3.getData().add(new XYChart.Data(sevenValueArray4,over7Count[4]));
        series3.getData().add(new XYChart.Data(sevenValueArray5,over7Count[5]));
        series3.getData().add(new XYChart.Data(sevenValueArray6,over7Count[6]));

        series4.getData().add(new XYChart.Data(sevenValueArray0,over10Count[0]));
        series4.getData().add(new XYChart.Data(sevenValueArray1,over10Count[1]));
        series4.getData().add(new XYChart.Data(sevenValueArray2,over10Count[2]));
        series4.getData().add(new XYChart.Data(sevenValueArray3,over10Count[3]));
        series4.getData().add(new XYChart.Data(sevenValueArray4,over10Count[4]));
        series4.getData().add(new XYChart.Data(sevenValueArray5,over10Count[5]));
        series4.getData().add(new XYChart.Data(sevenValueArray6,over10Count[6]));

        series5.getData().add(new XYChart.Data(sevenValueArray0,over15Count[0]));
        series5.getData().add(new XYChart.Data(sevenValueArray1,over15Count[1]));
        series5.getData().add(new XYChart.Data(sevenValueArray2,over15Count[2]));
        series5.getData().add(new XYChart.Data(sevenValueArray3,over15Count[3]));
        series5.getData().add(new XYChart.Data(sevenValueArray4,over15Count[4]));
        series5.getData().add(new XYChart.Data(sevenValueArray5,over15Count[5]));
        series5.getData().add(new XYChart.Data(sevenValueArray6,over15Count[6]));

        series6.getData().add(new XYChart.Data(sevenValueArray0,over20Count[0]));
        series6.getData().add(new XYChart.Data(sevenValueArray1,over20Count[1]));
        series6.getData().add(new XYChart.Data(sevenValueArray2,over20Count[2]));
        series6.getData().add(new XYChart.Data(sevenValueArray3,over20Count[3]));
        series6.getData().add(new XYChart.Data(sevenValueArray4,over20Count[4]));
        series6.getData().add(new XYChart.Data(sevenValueArray5,over20Count[5]));
        series6.getData().add(new XYChart.Data(sevenValueArray6,over20Count[6]));

        series7.getData().add(new XYChart.Data(sevenValueArray0,over25Count[0]));
        series7.getData().add(new XYChart.Data(sevenValueArray1,over25Count[1]));
        series7.getData().add(new XYChart.Data(sevenValueArray2,over25Count[2]));
        series7.getData().add(new XYChart.Data(sevenValueArray3,over25Count[3]));
        series7.getData().add(new XYChart.Data(sevenValueArray4,over25Count[4]));
        series7.getData().add(new XYChart.Data(sevenValueArray5,over25Count[5]));
        series7.getData().add(new XYChart.Data(sevenValueArray6,over25Count[6]));

        series8.getData().add(new XYChart.Data(sevenValueArray0,over30Count[0]));
        series8.getData().add(new XYChart.Data(sevenValueArray1,over30Count[1]));
        series8.getData().add(new XYChart.Data(sevenValueArray2,over30Count[2]));
        series8.getData().add(new XYChart.Data(sevenValueArray3,over30Count[3]));
        series8.getData().add(new XYChart.Data(sevenValueArray4,over30Count[4]));
        series8.getData().add(new XYChart.Data(sevenValueArray5,over30Count[5]));
        series8.getData().add(new XYChart.Data(sevenValueArray6,over30Count[6]));

        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);

        StackedAreaChart.setTranslateX(470);
        StackedAreaChart.setTranslateY(35);
        StackedAreaChart.setPrefSize(850,425);


        group.getChildren().add(StackedAreaChart);

        Scene scene = new Scene(group ,1400, 770);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startPricing(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410,230);
        line_chart.setPrefSize(410,230);
        stacked_area_chart.setPrefSize(410,230);

        scatter_chart.setFont(font2);
        line_chart.setFont(font2);
        stacked_area_chart.setFont(font2);
        scatter_chart.setTranslateX(30);
        scatter_chart.setTranslateY(35);
        line_chart.setTranslateX(30);
        line_chart.setTranslateY(270);
        stacked_area_chart.setTranslateX(30);
        stacked_area_chart.setTranslateY(505);

        scatter_chart.setContentDisplay(ContentDisplay.TOP);
        line_chart.setContentDisplay(ContentDisplay.TOP);
        stacked_area_chart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));
        scatter_chart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                stackedArea.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        line_chart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Price based Seven Value Analysis");
        text.setTranslateX(520);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenNumberImplementation sevenNumberImplementation = new SevenNumberImplementation();
            try {
                sevenNumberImplementation.priceStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart,exit,home,text,back);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        StackedAreaChart StackedAreaChart = new StackedAreaChart(categoryAxis,numberAxis);

        String over100,over140,over160,over180,over210,over250,over300,over350,over400,over500;

        over100 =  "100-140" ;
        over140 =  "140-160" ; over160 =  "160-180" ; over180 =  "180-210" ;
        over210=   "210-250" ;over250 =  "250-300" ; over300 =  "300-350" ;
        over350 =  "350-400" ;over400 =  "400-500" ; over500 =  "500+" ;

        double [] over100Count= new double[7];
        double[] over140Count= new double[7];
        double[] over160Count= new double[7];
        double[] over180Count= new double[7];
        double[] over210Count= new double[7];
        double[]  over250Count= new double[7];
        double[] over300Count= new double[7];
        double[] over350Count= new double[7];
        double[] over400Count= new double[7];
        double[] over500Count= new double[7];
        int iterator;

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData =  multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        List<Double> list = new ArrayList<>();
        for(iterator=0;iterator<numberOfBooks;iterator++){

            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=500.00){
                //over500Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over500Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=400.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<500.00){
                //over400Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over400Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=350.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<400.00){
                //over350Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over350Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=300.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<350.00){
                //over300Count++;
                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                over300Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=250.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<350.00){
                //over250Count++;
                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                over250Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=210.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<250.00){
                //over210Count++;
                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                over210Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=180.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<210.00){
                //over180Count++;
                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                over180Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=160.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<180.00){
                //over160Count++;
                list.add(priorityData[iterator].getMLRweight());
            }
            int sizeB = list.size();
            if(sizeB>7){
                over160Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=140.00&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<160.00){
                //over140Count++;
                list.add(priorityData[iterator].getMLRweight());

            }
            int sizeB = list.size();
            if(sizeB>7){
                over140Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }

        }
        list.clear();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if(Double.parseDouble(priorityData[iterator].bookData.bookPrice)>=100.0&&
                    Double.parseDouble(priorityData[iterator].bookData.bookPrice)<140.000){
                //over100Count++;
            }
            int sizeB = list.size();
            if(sizeB>7){
                over100Count  =  sevenValueCalculation.sevenValueCalculationMethods(list);
            }
        }
        list.clear();



        XYChart.Series series1 = new XYChart.Series();
        series1.setName(over100);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over140);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(over160);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(over180);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(over210);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(over250);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(over300);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(over350);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(over400);
        XYChart.Series series10 = new XYChart.Series();
        series10.setName(over500);
        series1.getData().add(new XYChart.Data(sevenValueArray0,over100Count[0]));
        series1.getData().add(new XYChart.Data(sevenValueArray1,over100Count[1]));
        series1.getData().add(new XYChart.Data(sevenValueArray2,over100Count[2]));
        series1.getData().add(new XYChart.Data(sevenValueArray3,over100Count[3]));
        series1.getData().add(new XYChart.Data(sevenValueArray4,over100Count[4]));
        series1.getData().add(new XYChart.Data(sevenValueArray5,over100Count[5]));
        series1.getData().add(new XYChart.Data(sevenValueArray6,over100Count[6]));
        series2.getData().add(new XYChart.Data(sevenValueArray0,over140Count[0]));
        series2.getData().add(new XYChart.Data(sevenValueArray1,over140Count[1]));
        series2.getData().add(new XYChart.Data(sevenValueArray2,over140Count[2]));
        series2.getData().add(new XYChart.Data(sevenValueArray3,over140Count[3]));
        series2.getData().add(new XYChart.Data(sevenValueArray4,over140Count[4]));
        series2.getData().add(new XYChart.Data(sevenValueArray5,over140Count[5]));
        series2.getData().add(new XYChart.Data(sevenValueArray6,over140Count[6]));

        series3.getData().add(new XYChart.Data(sevenValueArray0,over160Count[0]));
        series3.getData().add(new XYChart.Data(sevenValueArray1,over160Count[1]));
        series3.getData().add(new XYChart.Data(sevenValueArray2,over160Count[2]));
        series3.getData().add(new XYChart.Data(sevenValueArray3,over160Count[3]));
        series3.getData().add(new XYChart.Data(sevenValueArray4,over160Count[4]));
        series3.getData().add(new XYChart.Data(sevenValueArray5,over160Count[5]));
        series3.getData().add(new XYChart.Data(sevenValueArray6,over160Count[6]));

        series4.getData().add(new XYChart.Data(sevenValueArray0,over180Count[0]));
        series4.getData().add(new XYChart.Data(sevenValueArray1,over180Count[1]));
        series4.getData().add(new XYChart.Data(sevenValueArray2,over180Count[2]));
        series4.getData().add(new XYChart.Data(sevenValueArray3,over180Count[3]));
        series4.getData().add(new XYChart.Data(sevenValueArray4,over180Count[4]));
        series4.getData().add(new XYChart.Data(sevenValueArray5,over180Count[5]));
        series4.getData().add(new XYChart.Data(sevenValueArray6,over180Count[6]));

        series5.getData().add(new XYChart.Data(sevenValueArray0,over210Count[0]));
        series5.getData().add(new XYChart.Data(sevenValueArray1,over210Count[1]));
        series5.getData().add(new XYChart.Data(sevenValueArray2,over210Count[2]));
        series5.getData().add(new XYChart.Data(sevenValueArray3,over210Count[3]));
        series5.getData().add(new XYChart.Data(sevenValueArray4,over210Count[4]));
        series5.getData().add(new XYChart.Data(sevenValueArray5,over210Count[5]));
        series5.getData().add(new XYChart.Data(sevenValueArray6,over210Count[6]));

        series6.getData().add(new XYChart.Data(sevenValueArray0,over250Count[0]));
        series6.getData().add(new XYChart.Data(sevenValueArray1,over250Count[1]));
        series6.getData().add(new XYChart.Data(sevenValueArray2,over250Count[2]));
        series6.getData().add(new XYChart.Data(sevenValueArray3,over250Count[3]));
        series6.getData().add(new XYChart.Data(sevenValueArray4,over250Count[4]));
        series6.getData().add(new XYChart.Data(sevenValueArray5,over250Count[5]));
        series6.getData().add(new XYChart.Data(sevenValueArray6,over250Count[6]));

        series7.getData().add(new XYChart.Data(sevenValueArray0,over300Count[0]));
        series7.getData().add(new XYChart.Data(sevenValueArray1,over300Count[1]));
        series7.getData().add(new XYChart.Data(sevenValueArray2,over300Count[2]));
        series7.getData().add(new XYChart.Data(sevenValueArray3,over300Count[3]));
        series7.getData().add(new XYChart.Data(sevenValueArray4,over300Count[4]));
        series7.getData().add(new XYChart.Data(sevenValueArray5,over300Count[5]));
        series7.getData().add(new XYChart.Data(sevenValueArray6,over300Count[6]));

        series8.getData().add(new XYChart.Data(sevenValueArray0,over350Count[0]));
        series8.getData().add(new XYChart.Data(sevenValueArray1,over350Count[1]));
        series8.getData().add(new XYChart.Data(sevenValueArray2,over350Count[2]));
        series8.getData().add(new XYChart.Data(sevenValueArray3,over350Count[3]));
        series8.getData().add(new XYChart.Data(sevenValueArray4,over350Count[4]));
        series8.getData().add(new XYChart.Data(sevenValueArray5,over350Count[5]));
        series8.getData().add(new XYChart.Data(sevenValueArray6,over350Count[6]));

        series9.getData().add(new XYChart.Data(sevenValueArray0,over400Count[0]));
        series9.getData().add(new XYChart.Data(sevenValueArray1,over400Count[1]));
        series9.getData().add(new XYChart.Data(sevenValueArray2,over400Count[2]));
        series9.getData().add(new XYChart.Data(sevenValueArray3,over400Count[3]));
        series9.getData().add(new XYChart.Data(sevenValueArray4,over400Count[4]));
        series9.getData().add(new XYChart.Data(sevenValueArray5,over400Count[5]));
        series9.getData().add(new XYChart.Data(sevenValueArray6,over400Count[6]));

        series10.getData().add(new XYChart.Data(sevenValueArray0,over500Count[0]));
        series10.getData().add(new XYChart.Data(sevenValueArray1,over500Count[1]));
        series10.getData().add(new XYChart.Data(sevenValueArray2,over500Count[2]));
        series10.getData().add(new XYChart.Data(sevenValueArray3,over500Count[3]));
        series10.getData().add(new XYChart.Data(sevenValueArray4,over500Count[4]));
        series10.getData().add(new XYChart.Data(sevenValueArray5,over500Count[5]));
        series10.getData().add(new XYChart.Data(sevenValueArray6,over500Count[6]));

        StackedAreaChart.getData().add(series1);
        StackedAreaChart.getData().add(series2);
        StackedAreaChart.getData().add(series3);
        StackedAreaChart.getData().add(series4);
        StackedAreaChart.getData().add(series5);
        StackedAreaChart.getData().add(series6);
        StackedAreaChart.getData().add(series7);
        StackedAreaChart.getData().add(series8);
        StackedAreaChart.getData().add(series9);
        StackedAreaChart.getData().add(series10);

        StackedAreaChart.setTranslateX(470);
        StackedAreaChart.setTranslateY(35);
        StackedAreaChart.setPrefSize(850,425);



        group.getChildren().add(StackedAreaChart);
        Scene scene = new Scene(group ,1400, 770);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommendation Tool");
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
