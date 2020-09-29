package TableViewPackage;

import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import PageRankAlgorithm.PageRankCalculation;
import PageRankAlgorithm.PageRankProcessData;
import RecommendationAlgorithm.PageRankAlgorithm;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;


public class PRA_Chart_View extends Application {
    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    PageRankCalculation pageRankCalculation = new PageRankCalculation();
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
            PageRankAlgorithm pageRankAlgorithm = new PageRankAlgorithm();
            try {
                pageRankAlgorithm.start(primaryStage);
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
     //   priorityData = pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
        PageRankProcessData pageRankProcessData = new PageRankProcessData();
        priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD,10);
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
        double getWeightAverage=0.0;

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getPRAweight()));

            getWeightAverage = getWeightAverage+ priorityData[iterator].getPRAweight();
        }

        getWeightAverage = getWeightAverage/numberOfBooks;

        double standardDeviation=0.0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            standardDeviation = standardDeviation+ Math.pow(priorityData[iterator].getPRAweight()-getWeightAverage,2);
        }
        standardDeviation/=numberOfBooks;
        standardDeviation=Math.sqrt(standardDeviation);
        Label labelMean = new Label("Mean : "+getWeightAverage);
        Label labelDeviation = new Label("Standard Deviation : "+standardDeviation);
        Font fontModel = Font.font(Font.getFontNames().get(0), FontWeight.BOLD,25);
        labelMean.setFont(fontModel);
        labelDeviation.setFont(fontModel);
        labelMean.setTranslateX(500);
        labelMean.setTranslateY(350);
        labelMean.setPrefSize(300,50);
        labelDeviation.setTranslateX(500);
        labelDeviation.setTranslateY(400);
        labelDeviation.setPrefSize(300,50);

        lineChart.getData().add(series1);
        lineChart.setTranslateX(10);
        lineChart.setTranslateY(25);
        lineChart.setPrefSize(1350, 700);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem mlr_process = new MenuItem("MLR Process");
        MenuItem ahp_process = new MenuItem("AHP Process");
        MenuItem pra_process = new MenuItem("PRA Process");

        mlr_process.setOnAction((event) -> {
            try {
                MLR_Chart_View mlr_chart_view = new MLR_Chart_View();
                mlr_chart_view.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ahp_process.setOnAction((event) -> {
            AHP_Chart_View ahp_chart_view = new AHP_Chart_View();
            try {
                ahp_chart_view.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pra_process.setOnAction((event) -> {
            PRA_Chart_View pra_chart_view = new PRA_Chart_View();
            try {
                pra_chart_view.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(mlr_process, ahp_process, pra_process);
        lineChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(lineChart, event.getScreenX(), event.getScreenY());
            }
        });
                //  Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, lineChart, exit, back,labelMean,labelDeviation);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

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

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        back.setOnAction(actionEvent -> {
            PageRankAlgorithm pageRankAlgorithm = new PageRankAlgorithm();
            try {
                pageRankAlgorithm.start(primaryStage);
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
     //   priorityData = pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
        PageRankProcessData pageRankProcessData = new PageRankProcessData();
      priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);

      Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD,10);
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
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getPRAweight()));
        }

        scatterChart.getData().add(series1);
        scatterChart.setTranslateX(10);
        scatterChart.setTranslateY(25);
        scatterChart.setPrefSize(1350, 700);


        ContextMenu contextMenu = new ContextMenu();
        MenuItem mlr_process = new MenuItem("MLR Process");
        MenuItem ahp_process = new MenuItem("AHP Process");
        MenuItem pra_process = new MenuItem("PRA Process");

      mlr_process.setOnAction((event) -> {
          try {
              MLR_Chart_View mlr_chart_view = new MLR_Chart_View();
              mlr_chart_view.startScatterChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });

      ahp_process.setOnAction((event) -> {
          AHP_Chart_View ahp_chart_view = new AHP_Chart_View();
          try {
              ahp_chart_view.startScatterChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
      pra_process.setOnAction((event) -> {
          PRA_Chart_View pra_chart_view = new PRA_Chart_View();
          try {
              pra_chart_view.startScatterChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
      contextMenu.getItems().addAll(mlr_process, ahp_process, pra_process);
       scatterChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(scatterChart, event.getScreenX(), event.getScreenY());
            }
        });
      Button lineChartView = new Button("LineChart View");
      Button stackedAreaChartView = new Button("StackedAreaChart View");
      lineChartView.setTranslateX(30);
      lineChartView.setTranslateY(0);
      stackedAreaChartView.setTranslateX(1170);
      stackedAreaChartView.setTranslateY(0);
      lineChartView.setOnAction(actionEvent -> {
          try {
              startScatterChart(primaryStage);
          } catch (Exception exception) {
              exception.printStackTrace();
          }

      });
      stackedAreaChartView.setOnAction(actionEvent -> {
          try {
              startStackedAreaChart(primaryStage);
          } catch (Exception exception) {
              exception.printStackTrace();
          }

      });
      Canvas canvas = new Canvas(1500, 950);
      Group group = new Group();
      group.getChildren().addAll(canvas, scatterChart,
              exit, back,lineChartView,stackedAreaChartView);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Scene scene1 = new Scene(group, 1500, 950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
  public void startStackedAreaChart(Stage primaryStage) throws IOException {
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
            PageRankAlgorithm pageRankAlgorithm = new PageRankAlgorithm();
            try {
                pageRankAlgorithm.start(primaryStage);
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
     //   priorityData = pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
      PageRankProcessData pageRankProcessData = new PageRankProcessData();
      priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);
      Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD,10);
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
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator),
                    priorityData[iterator].getPRAweight()));
       }
        stackedAreaChart.getData().add(series1);

        stackedAreaChart.setTranslateX(10);
        stackedAreaChart.setTranslateY(25);
        stackedAreaChart.setPrefSize(1350, 700);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem mlr_process = new MenuItem("MLR Process");
        MenuItem ahp_process = new MenuItem("AHP Process");
        MenuItem pra_process = new MenuItem("PRA Process");
        mlr_process.setOnAction((event) -> {
          try {
              MLR_Chart_View mlr_chart_view = new MLR_Chart_View();
              mlr_chart_view.startStackedAreaChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
      ahp_process.setOnAction((event) -> {
          AHP_Chart_View ahp_chart_view = new AHP_Chart_View();
          try {
              ahp_chart_view.startStackedAreaChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
      pra_process.setOnAction((event) -> {
          PRA_Chart_View pra_chart_view = new PRA_Chart_View();
          try {
              pra_chart_view.startStackedAreaChart(primaryStage);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
        contextMenu.getItems().addAll(mlr_process, ahp_process, pra_process);
        stackedAreaChart.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(stackedAreaChart, event.getScreenX(), event.getScreenY());
            }
        });

      Button scatterChartView = new Button("ScatterChart View");
      Button lineChartView = new Button("LineChart View");
      scatterChartView.setTranslateX(30);
      scatterChartView.setTranslateY(0);
      lineChartView.setTranslateX(1170);
      lineChartView.setTranslateY(0);
      scatterChartView.setOnAction(actionEvent -> {
          try {
              startScatterChart(primaryStage);
          } catch (Exception exception) {
              exception.printStackTrace();
          }
      });
      lineChartView.setOnAction(actionEvent -> {
          try {
              start(primaryStage);
          } catch (Exception exception) {
              exception.printStackTrace();
          }
      });
      Canvas canvas = new Canvas(1500, 950);
      Group group = new Group();
      group.getChildren().addAll(canvas, stackedAreaChart, exit, back
              ,scatterChartView,lineChartView);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
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
