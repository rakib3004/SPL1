package RankingAlgorithmFx;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import PageRankAlgorithm.PageRankCalculation;
import PageRankAlgorithm.PageRankProcessData;
import RegressionFx.MultiVaribleRegressionFX;
import TableViewPackage.AHP_Chart_View;
import TableViewPackage.PRA_Chart_View;
import TableViewPackage.PRA_TableViewFX;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PageRankAlgorithmFx extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();

    @Override
    public void start(Stage primaryStage) throws IOException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button consoleView = new Button("Console View");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button tableView = new Button("Table View");
        tableView.setTranslateX(550);
        tableView.setTranslateY(300);
        tableView.setOnAction(actionEvent -> {
            PRA_TableViewFX pra_tableViewFX = new PRA_TableViewFX();
            try {
                pra_tableViewFX.start(primaryStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(tableView);
        tableView.setPrefSize(200,80);

        consoleView.setTranslateX(550);
        consoleView.setTranslateY(400);
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        consoleView.setOnAction(actionEvent -> {
            PageRankCalculation pageRankCalculation = new PageRankCalculation();
            try {
                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
                //   priorityData = pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
                PageRankProcessData pageRankProcessData = new PageRankProcessData();
                priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);                System.exit(0);
                priorityData = pageRankProcessData.PageRankProcessDataMethods(priorityData,numberOfBooks);                System.exit(0);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        back.setOnAction(actionEvent -> {
            StatisticsFX statisticsFX = new StatisticsFX();

            try {
                statisticsFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setStyle(consoleView);
        setStyle(exit);
        setStyle(back);

        consoleView.setPrefSize(200, 80);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Button graphView = new Button("Graph View");
        graphView.setTranslateX(550);
        graphView.setTranslateY(500);
        graphView.setOnAction(actionEvent -> {
            PRA_Chart_View pra_chart_view = new PRA_Chart_View();
            try {

                pra_chart_view.start(primaryStage);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        setStyle(graphView);
        graphView.setPrefSize(200,80);


        Image image = new Image("Images"+ File.separator +"libraryBackground6.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,tableView,consoleView,graphView,exit,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public Button setStyle( Button button)
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
