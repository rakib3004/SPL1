package JavFX;
import Collection.WriterCollection;
import CrossValidationProcess.CrossValidation;
import CrossValidationProcess.TestingSet;
import CrossValidationProcess.TrainingSet;
import FilePackage.DateTimeWriter;
import InfoDisplay.SevenValueStatistics;
import InfoDisplay.BookInformationShow;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import RecommendationAlgorithm.PageRankAlgorithm;
import RecommendationAlgorithm.ProcessImplementation;
import LinearRegression.FourVariableRegression;
import UserInterfacePackage.SelectBookRecommendation;
import UserInterfacePackage.LibraryDesk;
import UserInterfacePackage.RemoveBookRecommendation;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterInitialMethods(className);


        Font font = new Font(36);
        Font font1 = new Font(47);
        Font font2 = new Font( 25);

        Button user = new Button("Reader");
        Button librarian = new Button("Librarian");
        Button methods = new Button("System");

        user.setPrefSize(410,230);
        librarian.setPrefSize(410,230);
        methods.setPrefSize(410,230);

        user.setFont(font);
        librarian.setFont(font);
        methods.setFont(font);
        user.setTranslateX(30);
        user.setTranslateY(35);
        librarian.setTranslateX(30);
        librarian.setTranslateY(270);
        methods.setTranslateX(30);
        methods.setTranslateY(505);

        user.setContentDisplay(ContentDisplay.TOP);
        librarian.setContentDisplay(ContentDisplay.TOP);
        methods.setContentDisplay(ContentDisplay.TOP);
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
        methods.setGraphic(new ImageView(image3));

        user.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        librarian.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();
            try {
                    libraryDesk.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        methods.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                ProcessImplementation processImplementation1 = new ProcessImplementation();
                processImplementation1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        Button more = new Button("More");
        more.setTranslateX(470);
        more.setTranslateY(520);
        more.setPrefSize(375,30);
        more.setFont(font2);
        more.setContentDisplay(ContentDisplay.LEFT);
        more.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"option.png");
        Image image5 = new Image(fileInputStream5);
        more.setGraphic(new ImageView(image5));

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
        about.setOnAction(actionEvent -> {
            About about1 = new About();
            try {
                about1.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });

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
        Text text = new Text("Library Assistant Tool ");
        text.setTranslateX(670);
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
        root.getChildren().addAll(canvas/*,welcome*/
                ,exit,more,about,
                text,user,librarian,methods);

        GraphicsContext gc = canvas.getGraphicsContext2D();
       gc.drawImage(background,0,0);
        Scene scene = new Scene(root,1400,770);
        ReadingRoom readingRoom2 = new ReadingRoom();
        LibraryDesk libraryDesk2 = new LibraryDesk();
        CrossValidation crossValidation2 = new CrossValidation();
        SevenValueStatistics sevenValueStatistics1 = new SevenValueStatistics();
        WriterCollection writerCollection = new WriterCollection();
        FourVariableRegression fourVariableRegression1 = new FourVariableRegression();
        AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm1 = new AnalyticHierarchyAlgorithm();
        PageRankAlgorithm pageRankAlgorithm1 = new PageRankAlgorithm();
        SelectBookRecommendation selectBookRecommendation = new SelectBookRecommendation();
        RemoveBookRecommendation removeBookRecommendation = new RemoveBookRecommendation();
        BookInformationShow bookInformationShow = new BookInformationShow();

        Menu menu1 = new Menu("User");
        Menu menu2 = new Menu("Librarian");
        Menu menu3 = new Menu("Analysis");
        Menu menu4 = new Menu("Process");
        Menu menu5 = new Menu("Shortcut");

        MenuItem menuItem1a = new MenuItem("Default Recommendation");
        MenuItem menuItem1b = new MenuItem("User Based Recommendation");
        menu1.getItems().addAll(menuItem1a,menuItem1b);
        menuItem1a.setOnAction(actionEvent -> {
            try {
                readingRoom2.automaticSystem(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem1b.setOnAction(actionEvent -> {
            try {
                readingRoom2.manualSystem(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        MenuItem menuItem2a = new MenuItem("Book Choosing Recommendation");
        MenuItem menuItem2b = new MenuItem("Book Information");
        MenuItem menuItem2c = new MenuItem("Book Removing Recommendation");
        menuItem2a.setOnAction(actionEvent -> {
            try {
                selectBookRecommendation.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem2b.setOnAction(actionEvent -> {
            try {
                bookInformationShow.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem2c.setOnAction(actionEvent -> {
            try {
                removeBookRecommendation.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        menu2.getItems().addAll(menuItem2a,menuItem2b,menuItem2c);

        MenuItem menuItem3a = new MenuItem("Cross Validation");
        MenuItem menuItem3b = new MenuItem("Seven Number Analysis");
        MenuItem menuItem3c = new MenuItem("Data Optimization");
        menuItem3a.setOnAction(actionEvent -> {
            try {
                crossValidation2.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem3b.setOnAction(actionEvent -> {
            try {
                sevenValueStatistics1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem3c.setOnAction(actionEvent -> {
            //     writerCollection.writerCollectionMLRMethods();
        });

        menu3.getItems().addAll(menuItem3a,menuItem3b,menuItem3c);

        MenuItem menuItem4a = new MenuItem("Multi-variable Regression");
        MenuItem menuItem4b = new MenuItem("Analytic Hierarchy Process");
        MenuItem menuItem4c = new MenuItem("Page Rank Algorithm");
        menu4.getItems().addAll(menuItem4a,menuItem4b,menuItem4c);
        menuItem4a.setOnAction(actionEvent -> {
            try {
                fourVariableRegression1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem4b.setOnAction(actionEvent -> {
            try {
                analyticHierarchyAlgorithm1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem4c.setOnAction(actionEvent -> {
            try {
                pageRankAlgorithm1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        MenuItem readingRoom1 = new MenuItem("Reading Room");
        readingRoom1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ReadingRoom readingRoom = new ReadingRoom();
                try {
                    {
                        readingRoom.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem libraryDesk1 = new MenuItem("Library Desk");
        libraryDesk1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                LibraryDesk libraryDesk = new LibraryDesk();
                try {
                    {
                        libraryDesk.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem processVisualization = new MenuItem("Process Visualization");

        processVisualization.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ProcessImplementation processImplementation = new ProcessImplementation();
                {
                    try {
                        processImplementation.start(primaryStage);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });
        MenuItem multivariableLinearRegression = new MenuItem("Multi-variable Linear Regression");
        multivariableLinearRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                FourVariableRegression fourVariableRegression = new FourVariableRegression();
                try {
                    {
                        fourVariableRegression.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem analyticHierarchyProcess = new MenuItem("AnalyticHierarchy Process");
        analyticHierarchyProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm = new AnalyticHierarchyAlgorithm();
                try {
                    {
                        analyticHierarchyAlgorithm.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem pageRankAlgorithm = new MenuItem("PageRank Algorithm");
        pageRankAlgorithm.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                PageRankAlgorithm pageRankAlgorithm = new PageRankAlgorithm();
                try {
                    {
                        pageRankAlgorithm.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem crossValidationProcess = new MenuItem("Cross ValidationProcess");
        crossValidationProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CrossValidation crossValidation = new CrossValidation();
                {
                    try {
                        crossValidation.start(primaryStage);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });
        MenuItem trainingSetView = new MenuItem("Training Set View");
        trainingSetView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TrainingSet trainingSet = new TrainingSet();
                {
                    trainingSet.start(primaryStage);
                }
            }
        });

        MenuItem testingSetView = new MenuItem("Testing Set View");
        testingSetView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TestingSet testingSet = new TestingSet();
                {
                    testingSet.start(primaryStage);
                }
            }
        });

        MenuItem bookInformationView = new MenuItem("Book Information");

        bookInformationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                BookInformationShow bookInformationShow = new BookInformationShow();
                {
                    try {
                        bookInformationShow.start(primaryStage);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });

        MenuItem systemAnalysis = new MenuItem("System Analysis");
        systemAnalysis.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ProcessAnalysis processAnalysis = new ProcessAnalysis();
                {
                    try {
                        processAnalysis.start(primaryStage);
                    } catch (Exception fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });

        menu5.getItems().addAll(readingRoom1,libraryDesk1,
                processVisualization,multivariableLinearRegression,
                analyticHierarchyProcess,pageRankAlgorithm,
                crossValidationProcess,trainingSetView,
                testingSetView,bookInformationView,systemAnalysis);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4,menu5);
        menuBar.setStyle("-fx-text-fill: #000000;");
        menuBar.setStyle("-fx-background-color: #ffffff;");
        menuBar.setStyle("-fx-padding: 1 5 1 5;");
        menuBar.setStyle(" -fx-spacing: 47;");
        menuBar.prefHeight(32);
        menuBar.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(menuBar);
        primaryStage.setScene(scene);
       primaryStage.setFullScreen(true);
        primaryStage.show();
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