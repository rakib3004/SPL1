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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
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


         Button welcome = new Button("Start");
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));

        welcome.setStyle("-fx-base: #000000;");
        welcome.setContentDisplay(ContentDisplay.TOP);
        welcome.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                welcome.setStyle("-fx-base: #00FFFF;");

            }
        });


      //  Button welcome = new Button("Welcome to RTML");
        welcome.setTranslateX(620);
        welcome.setTranslateY(370);
 //       setStyle(welcome);
        FileInputStream fileInputStream = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"power.png");
        Image image = new Image(fileInputStream);
      //  welcome.setGraphic(new ImageView(image));

        welcome.setPrefSize(125, 55);

        welcome.setOnAction(actionEvent -> {

          FxSecondWindow fxSecondWindow = new FxSecondWindow();
            try {
                fxSecondWindow.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


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
menuBar.setStyle("-fx-text-fill: #000000;");
menuBar.setStyle("-fx-background-color: #ffffff;");
menuBar.setStyle("-fx-padding: 1 5 1 5;");
menuBar.setStyle(" -fx-spacing: 47;");
menuBar.prefHeight(32);
/*.menu-item {  }
.menu { -fx-padding: 1 5 1 5; }*/
        Font font = new Font(36);
        Font font1 = new Font(47);
        Font font2 = new Font( 25);

        Button user = new Button("User");
        Button librarian = new Button("Librarian");
        Button system = new Button("System");

        user.setPrefSize(410,230);
        librarian.setPrefSize(410,230);
        system.setPrefSize(410,230);

        user.setFont(font);
        librarian.setFont(font);
        system.setFont(font);
        user.setTranslateX(30);
        user.setTranslateY(35);
        librarian.setTranslateX(30);
        librarian.setTranslateY(270);
        system.setTranslateX(30);
        system.setTranslateY(505);

        user.setContentDisplay(ContentDisplay.TOP);
        librarian.setContentDisplay(ContentDisplay.TOP);
        system.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"user.png");
        Image image1 = new Image(fileInputStream1);
        user.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"admin.png");
        Image image2 = new Image(fileInputStream2);
          librarian.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"automation.png");
        Image image3 = new Image(fileInputStream3);
        system.setGraphic(new ImageView(image3));

        user.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        librarian.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();
            try {
                    libraryDesk.start(stage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        system.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(stage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });


        Button search = new Button("Search Book");
        search.setTranslateX(470);
        search.setTranslateY(520);
        search.setPrefSize(375,30);
        search.setFont(font2);
        search.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"search.png");
        Image image5 = new Image(fileInputStream5);
        search.setGraphic(new ImageView(image5));

         Button about = new Button("About");
        about.setTranslateX(950);
        about.setTranslateY(520);
        about.setPrefSize(375,30);
        about.setFont(font2);
        about.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"about.png");
        Image image6 = new Image(fileInputStream6);
        about.setGraphic(new ImageView(image6));

        //  setStyle(exit);
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"exit.png");
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font2);
        Text text = new Text("Library Recommendation Tool ");
        text.setTranslateX(575);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");
    /*    setStyle1(welcome);
        setStyle1(exit);
*/
       Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        Group root = new Group();
        root.getChildren().addAll(canvas,menuBar/*,welcome*/
                ,exit,search,about,
                text,user,librarian,system);

        GraphicsContext gc = canvas.getGraphicsContext2D();
       gc.drawImage(background,0,0);
        Scene scene = new Scene(root,1400,770);
        menuBar.prefWidthProperty().bind(scene.widthProperty());
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
    public Button setStyle1( Button button) {
        button.setStyle("-fx-background-color:\n" +
                "        linear-gradient(#ee2100, #ff3400),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #ee0000 45%, #ff000 50%);\n" +
                "    -fx-background-radius: 6, 5;\n" +
                "    -fx-background-insets: 0, 1;\n" +
                "        -fx-font-size: 1.9em;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-text-fill: #000000;");
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