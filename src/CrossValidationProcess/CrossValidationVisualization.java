package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import LibraryFunctionality.ReadingRoom;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CrossValidationVisualization extends Application {


    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    @Override
    public void start(Stage primaryStage) {

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
            TrainingObservation trainingObserVation = new TrainingObservation();
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

        Button codeValidationScatter = new Button("CodeValidation Scatter");
        Button codeValidationStackedArea = new Button("CodeValidation StackedArea");
        Button codeValidationLineChart = new Button("CodeValidation LineChart");
        codeValidationScatter.setTranslateX(500);
        codeValidationScatter.setTranslateY(250);
        codeValidationStackedArea.setTranslateX(500);
        codeValidationLineChart.setTranslateX(500);
        codeValidationLineChart.setTranslateY(350);
        codeValidationStackedArea.setTranslateY(450);

        codeValidationScatter.setOnAction(actionEvent -> {
            CombinedTrainingSet combinedTrainingSet = new CombinedTrainingSet();
            try {
                combinedTrainingSet.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        codeValidationStackedArea.setOnAction(actionEvent -> {
          CrossValidationVisualization crossValidationVisualization =  new CrossValidationVisualization();
            try {
                crossValidationVisualization.startStackedArea(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        codeValidationLineChart.setOnAction(actionEvent -> {
            CrossValidationVisualization crossValidationVisualization =  new CrossValidationVisualization();
            try {
                crossValidationVisualization.startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(codeValidationScatter);
        setStyle(codeValidationStackedArea);
        setStyle(codeValidationLineChart);
        codeValidationScatter.setPrefSize(400, 80);
        codeValidationStackedArea.setPrefSize(400, 80);
        codeValidationLineChart.setPrefSize(400, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, exit, back,
                codeValidationScatter, codeValidationStackedArea, codeValidationLineChart);
        Button administrationMood = new Button("Administration Mood");
        Button readersMood = new Button("Readers Mood");
        Button about = new Button("About");

        readersMood.setTranslateX(20);
        readersMood.setTranslateY(260);
        administrationMood.setTranslateX(20);
        administrationMood.setTranslateY(320);
        about.setTranslateX(20);
        about.setTranslateY(380);
        administrationMood.setPrefSize(160, 30);
        readersMood.setPrefSize(160, 30);
        about.setPrefSize(160,30);

        administrationMood.setOnAction(actionEvent -> {
            FXThirdWindow fxThirdWindow = new FXThirdWindow();
            try {
                fxThirdWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        readersMood.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        about.setOnAction(actionEvent -> {
            About about1 = new About();
            try {
                about1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        group.getChildren().addAll(readersMood,administrationMood,about);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startStackedArea(Stage primaryStage) throws IOException {
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

        StackedAreaChart stackedAreaChart = new StackedAreaChart(categoryAxis, numberAxis);
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();

        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");
        series3.setName("Training Set 3 ");
        series4.setName("Training Set 4 ");
        int positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {
                positionIndicator++;
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {
                positionIndicator++;

                series2.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                positionIndicator++;

                series3.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {
                positionIndicator++;

                series4.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }

        stackedAreaChart.getData().add(series1);
        stackedAreaChart.getData().add(series2);
        stackedAreaChart.getData().add(series3);
        stackedAreaChart.getData().add(series4);
        stackedAreaChart.setTranslateX(10);
        stackedAreaChart.setTranslateY(25);
        stackedAreaChart.setPrefSize(1350, 700);
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
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
    public void  startLineChart(Stage primaryStage) throws IOException {

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
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();

        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");
        series3.setName("Training Set 3 ");
        series4.setName("Training Set 4 ");

        int positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {
                positionIndicator++;
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {
                positionIndicator++;

                series2.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                positionIndicator++;

                series3.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }
        positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {
                positionIndicator++;

                series4.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getMLRweight()));
            }
        }

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        lineChart.getData().add(series4);

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

        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, lineChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

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
