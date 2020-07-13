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
import javafx.scene.control.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
        final Label response = new Label();
        final ImageView imageView = new ImageView(
                new Image("http://icons.iconarchive.com/icons/eponas-deeway/colobrush/128/heart-2-icon.png")
        );
        final Button welcome = new Button("Start", imageView);
        welcome.setStyle("-fx-base: coral;");
        welcome.setContentDisplay(ContentDisplay.TOP);
        welcome.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                response.setText("I love you too!");
            }
        });


      //  Button welcome = new Button("Welcome to RTML");
        welcome.setTranslateX(550);
        welcome.setTranslateY(370);
        setStyle(welcome);
        FileInputStream fileInputStream = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"power.png");
        Image image = new Image(fileInputStream);
        welcome.setGraphic(new ImageView(image));

        welcome.setPrefSize(100, 100);

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



        Menu menu1 = new Menu("user");
        Menu menu2 = new Menu("admin");
        Menu menu3 = new Menu("system");
        Menu menu4 = new Menu("data show");
        Menu menu5 = new Menu("shortcut");

        MenuItem menuItem1a = new MenuItem("login");
        MenuItem menuItem1b = new MenuItem("sign-up");
        menu1.getItems().addAll(menuItem1a,menuItem1b);

        MenuItem menuItem2a = new MenuItem("add book");
        MenuItem menuItem2b = new MenuItem("book info");
        MenuItem menuItem2c = new MenuItem("remove book");
        menu2.getItems().addAll(menuItem2a,menuItem2b,menuItem2c);

        MenuItem menuItem3a = new MenuItem("cross validation");
        MenuItem menuItem3b = new MenuItem("seven value showing");
        MenuItem menuItem3c = new MenuItem("data optimization");
        menu3.getItems().addAll(menuItem3a,menuItem3b,menuItem3c);

        MenuItem menuItem4a = new MenuItem("multi-variable regression");
        MenuItem menuItem4b = new MenuItem("analytic hierarchy process");
        MenuItem menuItem4c = new MenuItem("page rank algorithm");
        menu4.getItems().addAll(menuItem4a,menuItem4b,menuItem4c);
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

        menu5.getItems().addAll(readingRoomView,libraryDeskView,
                statisticsView,fourVariableRegressionView,
                cvVisualizationView,testingSetView,analyticHierarchyProcessView,pageRankAlgorithmView,
                bookInformationView,crossValidationView,systemAnalysisView,
                processValidationView,trainingMethodologyView);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4,menu5);


   //     Image background = new Image("Images"+ File.separator +"libraryBackground24.png");
        Canvas canvas = new Canvas(1400, 770);

        Group root = new Group();
        root.getChildren().addAll(canvas,menuBar,welcome,exit);

        GraphicsContext gc = canvas.getGraphicsContext2D();
       // gc.drawImage(background,0,0);
        Scene scene = new Scene(root,1400,770);
        stage.setScene(scene);
       stage.setFullScreen(true);
        stage.show();
    }

    public Button setStyle( Button button) {
        button.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "                linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "        -fx-background-radius: 5,4,3,5;\n" +
                "        -fx-background-insets: 0,1,2,0;\n" +
                "        -fx-text-fill: white;\n" +
                "        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "        -fx-font-family: \"Arial\";\n" +
                "        -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "        -fx-font-size: 1.5em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return button;
    }
    public  ToggleButton setTheme(ToggleButton toggleButton){
        toggleButton.setStyle("-fx-background-color: #A9A9A9 \n"+
                "-fx-");
        return toggleButton;
    }
    public  ToggleButton setHoverTheme(ToggleButton toggleButton){
        toggleButton.setStyle("-fx-background-color: #00FFFF \n"+
                "-fx-");
        return toggleButton;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}