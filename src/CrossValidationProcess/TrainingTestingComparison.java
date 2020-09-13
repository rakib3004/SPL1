package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import Collection.WriterCollection;
import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationShow;
import InfoDisplay.SevenValueStatistics;
import JavFX.AuthorSystem;
import JavFX.Main;
import JavFX.ProcessAnalysis;
import LibraryFunctionality.ReadingRoom;
import LinearRegression.FourVariableRegression;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import RecommendationAlgorithm.PageRankAlgorithm;
import RecommendationAlgorithm.ProcessImplementation;
import UserInterfacePackage.AddBook;
import UserInterfacePackage.LibraryDesk;
import UserInterfacePackage.RemoveBook;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TrainingTestingComparison extends Application {
        PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    int positionIndicatorSet1 = 0;
    int positionIndicatorSet2 = 0;
    int positionIndicatorSet3 = 0;
    int positionIndicatorSet4 = 0;
    int minimumRange;
    double [] averageTrainingData = new double[200];
    double [] TrainingData1 = new double[200];
    double [] TrainingData2 = new double[200];
    double [] TrainingData3 = new double[200];
    double [] TrainingData4 = new double[200];

    @Override
    public void start(Stage primaryStage){

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");
        scatterChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startStackedAreaChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        scatterChart.setPrefSize(410, 230);
        lineChart.setPrefSize(410, 230);
        stackedAreaChart.setPrefSize(410, 230);

        scatterChart.setFont(font2);
        lineChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(270);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(505);

        scatterChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatterChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        lineChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stackedAreaChart.setGraphic(new ImageView(image3));

        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Training Testing Comparison");
        text.setTranslateX(600);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375, 30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375, 30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            CrossValidation crossValidation = new CrossValidation();
            try {
                crossValidation.finish(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Image background = new Image("Images" + File.separator + "framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background, 0, 0);
        Group group = new Group();
        group.getChildren().addAll(canvas, scatterChart,
                lineChart, exit, back, home, text, stackedAreaChart);

        Scene scene1 = new Scene(group, 1500, 950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startScatterChart(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");
        scatterChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaChart.setOnAction(actionEvent -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startStackedAreaChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        scatterChart.setPrefSize(410, 230);
        lineChart.setPrefSize(410, 230);
        stackedAreaChart.setPrefSize(410, 230);

        scatterChart.setFont(font2);
        lineChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(270);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(505);

        scatterChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatterChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        lineChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stackedAreaChart.setGraphic(new ImageView(image3));

        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Training Testing Comparison");
        text.setTranslateX(600);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375, 30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375, 30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            CrossValidation crossValidation = new CrossValidation();
            try {
                crossValidation.finish(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatterChart,
                lineChart, exit, back, home, text, stackedAreaChart);

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");
        ScatterChart ScatterChart = new ScatterChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {
                TrainingData1[positionIndicatorSet1] = priorityData[iterator].getMLRweight();
                positionIndicatorSet1++;
            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {
                TrainingData2[positionIndicatorSet2] = priorityData[iterator].getMLRweight();
                positionIndicatorSet2++;

            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                TrainingData3[positionIndicatorSet3] = priorityData[iterator].getMLRweight();
                positionIndicatorSet3++;

            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {
                TrainingData4[positionIndicatorSet4] = priorityData[iterator].getMLRweight();
                positionIndicatorSet4++;
            }
        }
minimumRange = Math.min(positionIndicatorSet1,positionIndicatorSet2);
        minimumRange = Math.min(minimumRange,positionIndicatorSet3);
        minimumRange = Math.min(minimumRange,positionIndicatorSet4);
        for(iterator=0;iterator<minimumRange;iterator++){

            averageTrainingData[iterator]  = .25 * (TrainingData1[iterator]+TrainingData2[iterator]+
                    TrainingData3[iterator]+TrainingData4[iterator]);
            series1.getData().add(new XYChart.Data(String.valueOf(iterator),averageTrainingData[iterator]));
        }

        int positionIndicatorSetPro=0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                positionIndicatorSetPro++;
                series2.getData().add(new XYChart.Data(String.valueOf(positionIndicatorSetPro), priorityData[iterator].getMLRweight()));
            }
        }
        ScatterChart.getData().add(series1);
        ScatterChart.getData().add(series2);

        ScatterChart.setTranslateX(10);
        ScatterChart.setTranslateY(25);
        ScatterChart.setPrefSize(1350, 800);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterChartView = new MenuItem("ScatterChart View");
        MenuItem lineChartView = new MenuItem("LineChart View");
        MenuItem stackedAreaView = new MenuItem("StackedArea View");
        scatterChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startStackedAreaChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(scatterChartView, lineChartView, stackedAreaView);
        ScatterChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(ScatterChart, event.getScreenX(), event.getScreenY());
            }
        });

        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, ScatterChart, exit, back);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startLineChart(Stage primaryStage) throws Exception{

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
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.start(primaryStage);
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
        XYChart.Series series2 = new XYChart.Series();

        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {
                TrainingData1[positionIndicatorSet1] = priorityData[iterator].getMLRweight();
                positionIndicatorSet1++;
            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {
                TrainingData2[positionIndicatorSet2] = priorityData[iterator].getMLRweight();
                positionIndicatorSet2++;
            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                TrainingData3[positionIndicatorSet3] = priorityData[iterator].getMLRweight();
                positionIndicatorSet3++;

            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {
                TrainingData4[positionIndicatorSet4] = priorityData[iterator].getMLRweight();
                positionIndicatorSet4++;

            }
        }
        minimumRange = Math.min(positionIndicatorSet1,positionIndicatorSet2);
        minimumRange = Math.min(minimumRange,positionIndicatorSet3);
        minimumRange = Math.min(minimumRange,positionIndicatorSet4);
        for(iterator=0;iterator<minimumRange;iterator++){

            averageTrainingData[iterator]  = .25 * (TrainingData1[iterator]+TrainingData2[iterator]+
                    TrainingData3[iterator]+TrainingData4[iterator]);
            series1.getData().add(new XYChart.Data(String.valueOf(iterator),averageTrainingData[iterator]));

        }
        int positionIndicatorSetPro=0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                positionIndicatorSetPro++;
                series2.getData().add(new XYChart.Data(String.valueOf(positionIndicatorSetPro), priorityData[iterator].getMLRweight()));
            }
        }
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);

        lineChart.setTranslateX(10);
        lineChart.setTranslateY(25);
        lineChart.setPrefSize(1350, 800);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterChartView = new MenuItem("ScatterChart View");
        MenuItem lineChartView = new MenuItem("LineChart View");
        MenuItem stackedAreaView = new MenuItem("StackedArea View");
        scatterChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startStackedAreaChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        contextMenu.getItems().addAll(scatterChartView, lineChartView, stackedAreaView);
        lineChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(lineChart, event.getScreenX(), event.getScreenY());
            }
        });

        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, lineChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startStackedAreaChart(Stage primaryStage) throws Exception{

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
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.start(primaryStage);
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
        StackedAreaChart stackedAreaChart = new StackedAreaChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {
                TrainingData1[positionIndicatorSet1] = priorityData[iterator].getMLRweight();
                positionIndicatorSet1++;
            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {
                TrainingData2[positionIndicatorSet2] = priorityData[iterator].getMLRweight();
                positionIndicatorSet2++;

            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                TrainingData3[positionIndicatorSet3] = priorityData[iterator].getMLRweight();
                positionIndicatorSet3++;

            }
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {
                TrainingData4[positionIndicatorSet4] = priorityData[iterator].getMLRweight();
                positionIndicatorSet4++;

            }
        }
        minimumRange = Math.min(positionIndicatorSet1,positionIndicatorSet2);
        minimumRange = Math.min(minimumRange,positionIndicatorSet3);
        minimumRange = Math.min(minimumRange,positionIndicatorSet4);
        for(iterator=0;iterator<minimumRange;iterator++){
            averageTrainingData[iterator]  = .25 * (TrainingData1[iterator]+TrainingData2[iterator]+
                    TrainingData3[iterator]+TrainingData4[iterator]);
            series1.getData().add(new XYChart.Data(String.valueOf(iterator),averageTrainingData[iterator]));

        }
        int positionIndicatorSetPro=0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                positionIndicatorSetPro++;

                series2.getData().add(new XYChart.Data(String.valueOf(positionIndicatorSetPro), priorityData[iterator].getMLRweight()));
            }
        }

        stackedAreaChart.getData().add(series1);
        stackedAreaChart.getData().add(series2);

        stackedAreaChart.setTranslateX(10);
        stackedAreaChart.setTranslateY(25);
        stackedAreaChart.setPrefSize(1350, 800);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterChartView = new MenuItem("ScatterChart View");
        MenuItem lineChartView = new MenuItem("LineChart View");
        MenuItem stackedAreaView = new MenuItem("StackedArea View");

        scatterChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {
            TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
            try {
                trainingTestingComparison.startStackedAreaChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(scatterChartView, lineChartView, stackedAreaView);

        stackedAreaChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(stackedAreaChart, event.getScreenX(), event.getScreenY());
            }
        });
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, stackedAreaChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Scene scene1 = new Scene(group, 1500, 950);

        primaryStage.setScene(scene1);
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
