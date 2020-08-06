package CrossValidationProcess;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.Main;
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
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
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

public class TestingSet extends Application {

    PriorityData[] priorityData;
    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    @Override
    public void start(Stage primaryStage) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatterChart = new Button("Scatter Chart");
        Button stackedAreaChart = new Button("StackedArea Chart");
        Button lineChart = new Button("Line Chart");
        scatterChart.setOnAction(actionEvent -> {

            try {
                startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaChart.setOnAction(actionEvent -> {
            TrainingSetCombined trainingSetCombined =  new TrainingSetCombined();
            try {
                startStackedArea(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            TrainingSetCombined trainingSetCombined =  new TrainingSetCombined();
            try {
                startLineChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        scatterChart.setPrefSize(410, 230);
        stackedAreaChart.setPrefSize(410, 230);
        lineChart.setPrefSize(410, 230);

        scatterChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        lineChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(270);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(505);
        scatterChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
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
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        stackedAreaChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        lineChart.setGraphic(new ImageView(image3));
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
        Text text = new Text("Training Sets Comparison");
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
            TrainingObservation trainingObservation = new TrainingObservation();
            try {
                trainingObservation.start(primaryStage);
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
                stackedAreaChart, exit, back, home, text, lineChart);

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public void startScatterChart(Stage primaryStage) throws IOException {
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
            try {
                start(primaryStage);
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
        ScatterChart ScatterChart = new ScatterChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();

        series1.setName("Training Set 1 ");
        series2.setName("Training Set 2 ");
        series3.setName("Training Set 3 ");
        series4.setName("Training Set 4 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {

                series1.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {

                series2.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                series3.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }

            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {

                series4.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
        }

        ScatterChart.getData().add(series1);
        ScatterChart.getData().add(series2);
        ScatterChart.getData().add(series3);
        ScatterChart.getData().add(series4);

        ScatterChart.setTranslateX(10);
        ScatterChart.setTranslateY(25);
        ScatterChart.setPrefSize(1350, 700);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem scatterView = new MenuItem("Scatter View");
        MenuItem lineChartView = new MenuItem("LineChart View");
        MenuItem stackedAreaView = new MenuItem("StackedArea View");
        scatterView.setOnAction((event) -> {
            try {
                TrainingSetCombined trainingSetCombined =
                        new TrainingSetCombined();
                startScatterChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {

            try {
                startLineChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {

            try {
                startStackedArea(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(scatterView, lineChartView, stackedAreaView);
        ScatterChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(ScatterChart, event.getScreenX(), event.getScreenY());
            }
        });
        //  Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, ScatterChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

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

            try {
                start(primaryStage);
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
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {

                series1.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {

                series2.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                series3.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }

            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {

                series4.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
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
                TrainingSetCombined trainingSetCombined =
                        new TrainingSetCombined();
                startScatterChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {

            try {
                startLineChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {

            try {
                startStackedArea(primaryStage);
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

            try {
                start(primaryStage);
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

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("1") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("6")) {

                series1.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("2") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("7")) {

                series2.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("3") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("8")) {
                series3.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
            }

            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("4") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("9")) {

                series4.getData().add(new XYChart.Data(String.valueOf(iterator), priorityData[iterator].getMLRweight()));
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

                startScatterChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        lineChartView.setOnAction((event) -> {

            try {
                startLineChart(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stackedAreaView.setOnAction((event) -> {

            try {
                startStackedArea(primaryStage);
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
