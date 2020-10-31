package CrossValidationProcess;
import Collection.WriterCollection;
import DataComparing.CrossValidationShowing;
import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationShow;
import InfoDisplay.SevenValueStatistics;
import JavFX.AuthorSystem;
import JavFX.Main;
import JavFX.ProcessAnalysis;
import JavFX.ProjectDescription;
import LibraryFunctionality.ReadingRoom;
import LinearRegression.FourVariableRegression;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import RecommendationAlgorithm.PageRankAlgorithm;
import RecommendationAlgorithm.ProcessImplementation;
import UserInterfacePackage.SelectBookRecommendation;
import UserInterfacePackage.LibraryDesk;
import UserInterfacePackage.RemoveBookRecommendation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CrossValidation extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font( 20);
        Button crossValidationImplementation = new Button("CrossValidation Implementation");
        Button crossValidationVisualization = new Button("CrossValidation Visualization");
        Button crossValidationDescription = new Button("CrossValidation Description");
        crossValidationImplementation.setPrefSize(410,230);
        crossValidationVisualization.setPrefSize(410,230);
        crossValidationDescription.setPrefSize(410,230);

        crossValidationImplementation.setFont(font2);
        crossValidationVisualization.setFont(font2);
        crossValidationDescription.setFont(font2);
        crossValidationImplementation.setTranslateX(30);
        crossValidationImplementation.setTranslateY(35);
        crossValidationVisualization.setTranslateX(30);
        crossValidationVisualization.setTranslateY(270);
        crossValidationDescription.setTranslateX(30);
        crossValidationDescription.setTranslateY(505);

        crossValidationImplementation.setContentDisplay(ContentDisplay.TOP);
        crossValidationVisualization.setContentDisplay(ContentDisplay.TOP);
        crossValidationDescription.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"implement.png");
        Image image1 = new Image(fileInputStream1);
        crossValidationImplementation.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"analysis.png");
        Image image2 = new Image(fileInputStream2);
        crossValidationVisualization.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"description.png");
        Image image3 = new Image(fileInputStream3);
        crossValidationDescription.setGraphic(new ImageView(image3));

        crossValidationImplementation.setOnAction(actionEvent -> {
            CrossValidationShowing crossValidationShowing = new CrossValidationShowing();
            try {
                crossValidationShowing.start(primaryStage,1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        crossValidationVisualization.setOnAction(actionEvent -> {
            finish(primaryStage);
        });
        crossValidationDescription.setOnAction(actionEvent -> {
            try {
                ProjectDescription projectDescription = new ProjectDescription();
                projectDescription.start(primaryStage,2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

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
        exit.setFont(font);
        Text text = new Text("Cross Validation Process");
        text.setTranslateX(600);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"home.png");
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"back.png");
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
        ProcessAnalysis processAnalysis = new ProcessAnalysis();
        try {
            processAnalysis.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });

        Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background,0,0);
        Group group = new Group();
        group.getChildren().addAll(canvas,crossValidationImplementation,
                crossValidationVisualization,exit,back,home,text,crossValidationDescription);
        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
public void finish(Stage primaryStage){
    String  className = this.getClass().getSimpleName();
    DateTimeWriter dateTimeWriter =  new DateTimeWriter();
    dateTimeWriter.dateTimeWriterMethods(className);
    Font font = new Font(14);
    Font font1 = new Font(47);
    Font font2 = new Font( 26);
    Font font4 = new Font( 20);

    Button training_set = new Button("Training Set");
    Button testing_set = new Button("Testing Set");
    Button trainingTestingComparison1 = new Button("Training Testing Comparison");
    training_set.setPrefSize(410,230);
    testing_set.setPrefSize(410, 230);
    trainingTestingComparison1.setPrefSize(410, 230);

    training_set.setFont(font2);
    testing_set.setFont(font2);
    trainingTestingComparison1.setFont(font4);
    training_set.setTranslateX(30);
    training_set.setTranslateY(35);
    testing_set.setTranslateX(30);
    testing_set.setTranslateY(270);
    trainingTestingComparison1.setTranslateX(30);
    trainingTestingComparison1.setTranslateY(505);

    training_set.setContentDisplay(ContentDisplay.TOP);
    testing_set.setContentDisplay(ContentDisplay.TOP);
    trainingTestingComparison1.setContentDisplay(ContentDisplay.TOP);
    FileInputStream fileInputStream1 = null;
    try {
        fileInputStream1 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "training.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image1 = new Image(fileInputStream1);
    training_set.setGraphic(new ImageView(image1));

    FileInputStream fileInputStream2 = null;
    try {
        fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"testing.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image2 = new Image(fileInputStream2);
    testing_set.setGraphic(new ImageView(image2));

    FileInputStream fileInputStream3 = null;
    try {
        fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"compare.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image3 = new Image(fileInputStream3);
    trainingTestingComparison1.setGraphic(new ImageView(image3));

    trainingTestingComparison1.setOnAction(actionEvent -> {

        TrainingTestingComparison trainingTestingComparison = new TrainingTestingComparison();
        try {
            trainingTestingComparison.start(primaryStage);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    });
    training_set.setOnAction(actionEvent -> {
        TrainingObservation trainingObserVation = new TrainingObservation();
        try {
            trainingObserVation.start(primaryStage);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    });
    testing_set.setOnAction(actionEvent -> {

        TestingSet testingSet1 = new TestingSet();
        try {
            testingSet1.start(primaryStage);
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
                "src"+ File.separator +"Images"+ File.separator +"exit.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image4 = new Image(fileInputStream4);
    exit.setGraphic(new ImageView(image4));
    exit.setPrefSize(120, 20);
    exit.setContentDisplay(ContentDisplay.LEFT);
    exit.setFont(font);
    Text text = new Text("Cross Validation Visualization");
    text.setTranslateX(520);
    text.setTranslateY(500);
    text.setFont(font1);
    text.setFill(Color.BLACK);
    text.setTextAlignment(TextAlignment.RIGHT);
    text.setStyle("-fx-font-weight: bold;");

    Button home = new Button("Home");
    home.setTranslateX(470);
    home.setTranslateY(520);
    home.setPrefSize(375,30);
    home.setFont(font2);
    home.setContentDisplay(ContentDisplay.LEFT);
    FileInputStream fileInputStream5 = null;
    try {
        fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"home.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image5 = new Image(fileInputStream5);
    home.setGraphic(new ImageView(image5));
    home.setOnAction(actionEvent -> {
        Main main = new Main();
        try {
            main.start(primaryStage);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    });
    Button back = new Button("Back");
    back.setTranslateX(950);
    back.setTranslateY(520);
    back.setPrefSize(375,30);
    back.setFont(font2);
    back.setContentDisplay(ContentDisplay.LEFT);
    FileInputStream fileInputStream6 = null;
    try {
        fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"back.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Image image6 = new Image(fileInputStream6);
    back.setGraphic(new ImageView(image6));
    back.setOnAction(actionEvent -> {
        AuthorSystem authorSystem = new AuthorSystem();
        try {
            authorSystem.start(primaryStage);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    });

    Image background = new Image("Images"+ File.separator +"framework.jpg");
    Canvas canvas = new Canvas(850, 425);
    canvas.setTranslateX(470);
    canvas.setTranslateY(35);
    GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    graphicsContext.drawImage(background,0,0);
    Group group = new Group();
    group.getChildren().addAll(canvas, training_set,
            testing_set, exit, back, home, text, trainingTestingComparison1);
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


    MenuItem menuItem2a = new MenuItem("Add book");
    MenuItem menuItem2b = new MenuItem("Book Info");
    MenuItem menuItem2c = new MenuItem("Remove Book");
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
                } catch (FileNotFoundException fileNotFoundException) {
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
    group.getChildren().add(menuBar);
    Scene scene1 = new Scene(group,1500,950);
    menuBar.prefWidthProperty().bind(scene1.widthProperty());
    primaryStage.setScene(scene1);
    primaryStage.setTitle("Recommendation Tool");
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
