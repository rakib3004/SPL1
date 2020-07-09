package JavFX;

import CrossValidationProcess.CrossValidationFX;
import CrossValidationProcess.CrossValidationVisualization;
import CrossValidationProcess.TestingSet;
import CrossValidationProcess.TrainingMethodology;
import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationFX;
import LibraryFunctionality.ReadingRoom;
import RankingAlgorithmFx.AnalyticHierarchyAlgorithmFx;
import RankingAlgorithmFx.PageRankAlgorithmFx;
import RankingAlgorithmFx.StatisticsFX;
import RegressionFx.FourVariableRegression;
import TableViewPackage.Book;
import UserInterfacePackage.LibraryDesk;
import VisualRepresentation.LineChartFX;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.MenuItem;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterInitialMethods(className);

        Button welcome = new Button("Welcome to RTML");
        welcome.setTranslateX(345);
        welcome.setTranslateY(450);
        setStyle(welcome);
        FileInputStream fileInputStream = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"power.png");
        Image image = new Image(fileInputStream);
        welcome.setGraphic(new ImageView(image));


        welcome.setPrefSize(340, 100);

        welcome.setOnAction(actionEvent -> {

          FxSecondWindow fxSecondWindow = new FxSecondWindow();
            try {
                fxSecondWindow.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        Button exit = new Button("Exit");

        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        setStyle(exit);

        exit.setPrefSize(200, 80);


        MenuItem readingRoomView = new MenuItem("Reading RoomView");

        readingRoomView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ReadingRoom readingRoom = new ReadingRoom();
                try {
                    {
                        readingRoom.start(stage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        MenuItem libraryDeskView = new MenuItem("Library DeskView");
        libraryDeskView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                LibraryDesk libraryDesk = new LibraryDesk();
                try {
                    {
                        libraryDesk.start(stage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

           MenuItem statisticsView = new MenuItem("Statistics View");

        statisticsView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                StatisticsFX statisticsFX = new StatisticsFX();
                {
                    statisticsFX.start(stage);
                }
            }
        });


        MenuItem fourVariableRegressionView = new MenuItem("FourVariable RegressionView");
        fourVariableRegressionView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                FourVariableRegression fourVariableRegression = new FourVariableRegression();
                try {
                    {
                        fourVariableRegression.start(stage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
 MenuItem cvVisualizationView = new MenuItem("CV VisualizationView");
        cvVisualizationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CrossValidationVisualization crossValidationVisualization = new CrossValidationVisualization();
                {
                    crossValidationVisualization.start(stage);
                }

            }
        });
 MenuItem testingSetView = new MenuItem("Testing SetView");
        testingSetView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TestingSet testingSet = new TestingSet();
                {
                    testingSet.start(stage);
                }

            }
        });

        MenuButton bootOperation1 = new MenuButton("Boot Operation1");
        bootOperation1.getItems().addAll( readingRoomView,libraryDeskView,
                statisticsView,fourVariableRegressionView,
                cvVisualizationView,testingSetView);

        bootOperation1.setTranslateX(1125);
        bootOperation1.setTranslateY(518);
        bootOperation1.setPrefSize(150, 25);


        MenuItem analyticHierarchyProcessView = new MenuItem("AnalyticHierarchy ProcessView");

        analyticHierarchyProcessView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();
                try {
                    {
                        analyticHierarchyAlgorithmFx.start(stage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        MenuItem pageRankAlgorithmView = new MenuItem("PageRank AlgorithmView");
        pageRankAlgorithmView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                PageRankAlgorithmFx pageRankAlgorithmFx = new PageRankAlgorithmFx();
                try {
                    {
                        pageRankAlgorithmFx.start(stage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

           MenuItem bookInformationView = new MenuItem("Book InformationView");

        bookInformationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                BookInformationFX bookInformationFX = new BookInformationFX();
                {
                    bookInformationFX.start(stage);
                }
            }
        });


        MenuItem crossValidationView = new MenuItem("Cross ValidationView");
        crossValidationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TrainingMethodology trainingMethodology = new TrainingMethodology();
                {
                    trainingMethodology.start(stage);
                }
            }
        });

        MenuItem systemAnalysisView = new MenuItem("System AnalysisView");
        systemAnalysisView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                SystemAnalysis systemAnalysis = new SystemAnalysis();
                {
                    systemAnalysis.start(stage);
                }
            }
        });

        MenuItem processValidationView = new MenuItem("Process ValidationView");
        processValidationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CrossValidationFX crossValidationFX = new CrossValidationFX();
                {
                    crossValidationFX.start(stage);
                }
            }
        });

        MenuItem trainingMethodologyView = new MenuItem("Training MethodologyView");
        trainingMethodologyView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TrainingMethodology trainingMethodology = new TrainingMethodology();
                {
                    trainingMethodology.start(stage);
                }
            }
        });

        MenuButton bootOperation2 = new MenuButton("Boot Operation2");
        bootOperation2.getItems().addAll( analyticHierarchyProcessView,pageRankAlgorithmView,
                bookInformationView,crossValidationView,systemAnalysisView,
                processValidationView,trainingMethodologyView);

        bootOperation2.setTranslateX(833);
        bootOperation2.setTranslateY(514.5);
        bootOperation2.setPrefSize(150, 25);

        Image background = new Image("Images"+ File.separator +"libraryBackground24.png");
        Canvas canvas = new Canvas(1400, 770);

        Group root = new Group();
        root.getChildren().addAll(canvas, welcome,exit,bootOperation1,bootOperation2);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(background,0,0);

        Scene scene = new Scene(root,1400,770);
        stage.setScene(scene);
       stage.setFullScreen(true);
        stage.show();

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

    

    public static void main(String[] args) {

        Application.launch(args);
    }


}