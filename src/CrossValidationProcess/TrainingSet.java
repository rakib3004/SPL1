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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
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

public class TrainingSet extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    int iterator;

    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    @Override
    public void start(Stage primaryStage){
/*
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

        Button trainingSet1 = new Button("Training Set 1");
        Button trainingSet2 = new Button("Training Set 2");
        Button trainingSet3 = new Button("Training Set 3");
        Button trainingSet4 = new Button("Training Set 4");

        trainingSet1.setTranslateX(500);
        trainingSet1.setTranslateY(200);
        trainingSet2.setTranslateX(500);
        trainingSet2.setTranslateY(300);
        trainingSet3.setTranslateX(500);
        trainingSet3.setTranslateY(400);
        trainingSet4.setTranslateX(500);
        trainingSet4.setTranslateY(500);

        trainingSet1.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet2.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
trainingSet3.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,3);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet4.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,4);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(trainingSet1);
        setStyle(trainingSet2);
        setStyle(trainingSet3);
        setStyle(trainingSet4);
       trainingSet1.setPrefSize(350,80);
        trainingSet2.setPrefSize(350,80);
        trainingSet3.setPrefSize(350,80);
        trainingSet4.setPrefSize(350,80);
        Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,trainingSet1,trainingSet2,trainingSet3,trainingSet4);
                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();*/

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font(26);
        Button trainingSet11 = new Button("Training Set1");
        Button trainingSet2 = new Button("Training Set2");
        Button trainingSet3 = new Button("Training Set3");
        trainingSet11.setOnAction(actionEvent -> {
            TrainingSet trainingSet1 = new TrainingSet();
            try {
                trainingSet1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet2.setOnAction(actionEvent -> {
            //on process
        });
        trainingSet3.setOnAction(actionEvent -> {
            TrainingSetCombined trainingSetCombined1 = new TrainingSetCombined();
            try {
                trainingSetCombined1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet11.setPrefSize(410, 230);
        trainingSet2.setPrefSize(410, 230);
        trainingSet3.setPrefSize(410, 230);

        trainingSet11.setFont(font2);
        trainingSet2.setFont(font2);
        trainingSet3.setFont(font2);
        trainingSet11.setTranslateX(30);
        trainingSet11.setTranslateY(35);
        trainingSet2.setTranslateX(30);
        trainingSet2.setTranslateY(270);
        trainingSet3.setTranslateX(30);
        trainingSet3.setTranslateY(505);
        trainingSet11.setContentDisplay(ContentDisplay.TOP);
        trainingSet2.setContentDisplay(ContentDisplay.TOP);
        trainingSet3.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "implement.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        trainingSet11.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "analysis.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        trainingSet2.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "description.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        trainingSet3.setGraphic(new ImageView(image3));
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
        Text text = new Text("Training Set");
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
        group.getChildren().addAll(canvas, trainingSet11,
                trainingSet2, exit, back, home, text, trainingSet3);        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public void trainingSet1(Stage primaryStage,int a) throws IOException {
        int b=a+5;
        String aString=Integer.toString(a);
        String bString=Integer.toString(b);
        
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
            if (priorityData[iterator].bookData.bookId.substring(13,14).contains(aString)||
                    priorityData[iterator].bookData.bookId.substring(13,14).contains(bString)) {
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

        trainingSet1.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        trainingSet2.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet3.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,3);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        trainingSet4.setOnAction(actionEvent -> {
            try {
                trainingSet1(primaryStage,4);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        contextMenu.getItems().addAll(trainingSet1,trainingSet2,trainingSet3,trainingSet4);
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

    public void trainingSetAll(Stage primaryStage) throws IOException {

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
        ScatterChart.setPrefSize(1350, 800);

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
