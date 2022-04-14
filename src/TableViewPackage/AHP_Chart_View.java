package TableViewPackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import InfoDisplay.SevenValueStatistics;
import JavFX.Main;
import Layout.ButtonDesign;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import javafx.application.Application;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AHP_Chart_View extends Application {
    ButtonDesign buttonDesign = new ButtonDesign();
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
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410, 230);
        line_chart.setPrefSize(410, 230);
        stacked_area_chart.setPrefSize(410, 230);

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
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));

        scatter_chart.setOnAction(actionEvent -> {
            try {
                startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                startStackedAreaChart(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        line_chart.setOnAction(actionEvent -> {
            try {
                startLineChart(primaryStage);

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
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Analytic Hierarchy Algorithm");
        text.setTranslateX(520);
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
            AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm = new AnalyticHierarchyAlgorithm();
            try {
                analyticHierarchyAlgorithm.start(primaryStage);
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
        group.getChildren().addAll(canvas, scatter_chart,
                line_chart,
                stacked_area_chart, exit, home, text, back);

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startScatterChart(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410, 230);
        line_chart.setPrefSize(410, 230);
        stacked_area_chart.setPrefSize(410, 230);

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
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));

        scatter_chart.setOnAction(actionEvent -> {
            try {
                startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                startStackedAreaChart(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        line_chart.setOnAction(actionEvent -> {
            try {
                startLineChart(primaryStage);

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
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Analytic Hierarchy Algorithm");
        text.setTranslateX(520);
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
            try {
                start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart, exit, home, text, back);
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        ahPcriteriaWeight = ahPcalculation.AHPcalculationMethods(
                priorityData, numberOfBooks);
        priorityData = ahPprocessImplementation.ahpProcessImplementationMethods(
                ahPcriteriaWeight, priorityData, numberOfBooks);
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 10);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Index");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Book Priority Data");
        categoryAxis.setTickLabelFont(font3);
        numberAxis.setTickLabelFont(font3);

        ScatterChart scatterChart = new ScatterChart(categoryAxis, numberAxis);
        XYChart.Series series1 = new XYChart.Series();

        series1.setName("Book Weight Show");

        int positionIndicator = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            if (priorityData[iterator].getRankValue() < 2.00) {

                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        (35.00 * priorityData[iterator].getRankValue())));
            } else {
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        priorityData[iterator].getRankValue()));
            }

        }
        scatterChart.getData().add(series1);
        scatterChart = buttonDesign.systemLine(scatterChart, 850, 350, 470, 35);
        group.getChildren().add(scatterChart);

        double getWeightAverage = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                getWeightAverage = getWeightAverage + (35.00 * priorityData[iterator].getRankValue());
            } else {
                getWeightAverage = getWeightAverage + (18.00 * priorityData[iterator].getRankValue());

            }
        }
        getWeightAverage = getWeightAverage / numberOfBooks;
        double standardDeviation = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                standardDeviation = standardDeviation
                        + Math.pow(35.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            } else {
                standardDeviation = standardDeviation
                        + Math.pow(18.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            }
        }

        standardDeviation /= numberOfBooks;
        standardDeviation = Math.sqrt(standardDeviation);
        Label labelMean = new Label("Mean : " + getWeightAverage);
        Label labelDeviation = new Label("Standard Deviation : " + standardDeviation);
        labelMean = buttonDesign.systemLine(labelMean, 750, 380, 25);
        labelDeviation = buttonDesign.systemLine(labelDeviation, 750, 410, 25);

        group.getChildren().addAll(labelMean, labelDeviation);
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startLineChart(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410, 230);
        line_chart.setPrefSize(410, 230);
        stacked_area_chart.setPrefSize(410, 230);

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
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));

        scatter_chart.setOnAction(actionEvent -> {
            try {
                startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                startStackedAreaChart(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        line_chart.setOnAction(actionEvent -> {
            try {
                startLineChart(primaryStage);

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
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Analytic Hierarchy Algorithm");
        text.setTranslateX(520);
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
            try {
                start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart, exit, home, text, back);
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        ahPcriteriaWeight = ahPcalculation.AHPcalculationMethods(priorityData, numberOfBooks);
        priorityData = ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight, priorityData,
                numberOfBooks);

        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 10);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Index");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Book Priority Data");
        categoryAxis.setTickLabelFont(font3);
        numberAxis.setTickLabelFont(font3);

        LineChart lineChart = new LineChart(categoryAxis, numberAxis);
        XYChart.Series series1 = new XYChart.Series();

        series1.setName("Book Weight Show");
        int positionIndicator = 0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            if (priorityData[iterator].getRankValue() < 2.00) {
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        (35.00 * priorityData[iterator].getRankValue())));
            } else {
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        18.00 * priorityData[iterator].getRankValue()));
            }

        }

        lineChart.getData().add(series1);
        lineChart = buttonDesign.systemLine(lineChart, 850, 350, 470, 35);
        group.getChildren().add(lineChart);

        double getWeightAverage = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                getWeightAverage = getWeightAverage + (35.00 * priorityData[iterator].getRankValue());
            } else {
                getWeightAverage = getWeightAverage + (18.00 * priorityData[iterator].getRankValue());

            }
        }
        getWeightAverage = getWeightAverage / numberOfBooks;
        double standardDeviation = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                standardDeviation = standardDeviation
                        + Math.pow(35.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            } else {
                standardDeviation = standardDeviation
                        + Math.pow(18.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            }
        }

        standardDeviation /= numberOfBooks;
        standardDeviation = Math.sqrt(standardDeviation);
        Label labelMean = new Label("Mean : " + getWeightAverage);
        Label labelDeviation = new Label("Standard Deviation : " + standardDeviation);
        labelMean = buttonDesign.systemLine(labelMean, 750, 380, 25);
        labelDeviation = buttonDesign.systemLine(labelDeviation, 750, 410, 25);

        group.getChildren().addAll(labelMean, labelDeviation);
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void startStackedAreaChart(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button scatter_chart = new Button("Scatter Chart");
        Button line_chart = new Button("Line Chart");
        Button stacked_area_chart = new Button("Stacked Area Chart");

        scatter_chart.setPrefSize(410, 230);
        line_chart.setPrefSize(410, 230);
        stacked_area_chart.setPrefSize(410, 230);

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
                    "src" + File.separator + "Images" + File.separator + "scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatter_chart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        line_chart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stacked_area_chart.setGraphic(new ImageView(image3));

        scatter_chart.setOnAction(actionEvent -> {
            try {
                startScatterChart(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stacked_area_chart.setOnAction(actionEvent -> {
            try {
                startStackedAreaChart(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        line_chart.setOnAction(actionEvent -> {
            try {
                startLineChart(primaryStage);

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
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Analytic Hierarchy Algorithm");
        text.setTranslateX(520);
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
            try {
                start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(scatter_chart,
                line_chart,
                stacked_area_chart, exit, home, text, back);

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        ahPcriteriaWeight = ahPcalculation.AHPcalculationMethods(priorityData, numberOfBooks);
        priorityData = ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight, priorityData,
                numberOfBooks);
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 10);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Index");
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Book Priority Data");
        categoryAxis.setTickLabelFont(font3);
        numberAxis.setTickLabelFont(font3);

        StackedAreaChart stackedAreaChart = new StackedAreaChart(categoryAxis, numberAxis);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Book Weight Show");

        int positionIndicator = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            if (priorityData[iterator].getRankValue() < 2.00) {
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        (35.00 * priorityData[iterator].getRankValue())));
            } else {
                series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator / 4),
                        18.00 * priorityData[iterator].getRankValue()));
            }
        }

        stackedAreaChart.getData().add(series1);
        stackedAreaChart = buttonDesign.systemLine(stackedAreaChart, 850, 350, 470, 35);
        group.getChildren().add(stackedAreaChart);

        double getWeightAverage = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                getWeightAverage = getWeightAverage + (35.00 * priorityData[iterator].getRankValue());
            } else {
                getWeightAverage = getWeightAverage + (18.00 * priorityData[iterator].getRankValue());

            }
        }
        getWeightAverage = getWeightAverage / numberOfBooks;
        double standardDeviation = 0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].getRankValue() < 2.00) {
                standardDeviation = standardDeviation
                        + Math.pow(35.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            } else {
                standardDeviation = standardDeviation
                        + Math.pow(18.00 * priorityData[iterator].getRankValue() - getWeightAverage, 2);
            }
        }

        standardDeviation /= numberOfBooks;
        standardDeviation = Math.sqrt(standardDeviation);
        Label labelMean = new Label("Mean : " + getWeightAverage);
        Label labelDeviation = new Label("Standard Deviation : " + standardDeviation);
        labelMean = buttonDesign.systemLine(labelMean, 750, 380, 25);
        labelDeviation = buttonDesign.systemLine(labelDeviation, 750, 410, 25);

        Scene scene1 = new Scene(group, 1500, 950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
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
