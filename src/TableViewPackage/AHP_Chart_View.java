package TableViewPackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import CrossValidationProcess.CombinedTrainingSet;
import CrossValidationProcess.CrossValidationVisualization;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import RankingAlgorithmFx.AnalyticHierarchyAlgorithmFx;
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
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AHP_Chart_View extends Application {

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
            AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();

            try {
                analyticHierarchyAlgorithmFx.start(primaryStage);
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
        ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
        priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");


        LineChart lineChart = new LineChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();


        series1.setName("Book Weight Show");


        int positionIndicator = 0;

        //   series1.setName("Training Set 1 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getAHPweight()));

        }


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
        group.getChildren().addAll(canvas, lineChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        // graphicsContext.drawImage(image,0,0);


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
            AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();

            try {
                analyticHierarchyAlgorithmFx.start(primaryStage);
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
        ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
        priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");


        ScatterChart scatterChart = new ScatterChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();


        series1.setName("Book Weight Show");


        int positionIndicator = 0;

        //   series1.setName("Training Set 1 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getAHPweight()));

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


        //  Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, scatterChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        // graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group, 1500, 950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
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
            AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();

            try {
                analyticHierarchyAlgorithmFx.start(primaryStage);
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
        ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
        priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");


        StackedAreaChart stackedAreaChart = new StackedAreaChart(categoryAxis, numberAxis);

        XYChart.Series series1 = new XYChart.Series();


        series1.setName("Book Weight Show");


        int positionIndicator = 0;

        //   series1.setName("Training Set 1 ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            positionIndicator++;
            series1.getData().add(new XYChart.Data(String.valueOf(positionIndicator), priorityData[iterator].getAHPweight()));

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


        //  Image image = new Image("libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, stackedAreaChart, exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        // graphicsContext.drawImage(image,0,0);


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
