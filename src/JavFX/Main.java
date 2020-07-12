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
        MenuButton bootOperation1 = new MenuButton("ShortCut 1");
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
        MenuButton bootOperation2 = new MenuButton("ShortCut 2");
        bootOperation2.getItems().addAll( analyticHierarchyProcessView,pageRankAlgorithmView,
                bookInformationView,crossValidationView,systemAnalysisView,
                processValidationView,trainingMethodologyView);
        bootOperation2.setTranslateX(833);
        bootOperation2.setTranslateY(514.5);
        bootOperation2.setPrefSize(150, 25);

        ToggleButton toggleButton1 = new ToggleButton("Left");
        ToggleButton toggleButton2 = new ToggleButton("Right");
        ToggleButton toggleButton3 = new ToggleButton("Up");
        ToggleButton toggleButton4 = new ToggleButton("Down");
toggleButton1.setPrefWidth(300);
toggleButton2.setPrefWidth(300);
toggleButton3.setPrefWidth(300);
toggleButton4.setPrefWidth(300);
setTheme(toggleButton1);
setTheme(toggleButton2);
setTheme(toggleButton3);
setTheme(toggleButton4);
toggleButton1.setOnMouseDragOver(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        setHoverTheme(toggleButton1);
    }
});toggleButton2.setOnMouseDragOver(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        setHoverTheme(toggleButton2);
    }
});toggleButton3.setOnMouseDragOver(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        setHoverTheme(toggleButton3);
    }
});toggleButton4.setOnMouseDragOver(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        setHoverTheme(toggleButton4);
    }
});

        ToggleGroup toggleGroup = new ToggleGroup();

        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        toggleButton4.setToggleGroup(toggleGroup);

        HBox hbox = new HBox(toggleButton1, toggleButton2, toggleButton3, toggleButton4);


   //     Image background = new Image("Images"+ File.separator +"libraryBackground24.png");
        Canvas canvas = new Canvas(1400, 770);

        Group root = new Group();
        root.getChildren().addAll(canvas, hbox,welcome,exit,bootOperation1,bootOperation2);

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