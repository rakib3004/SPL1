package InfoDisplay;

import BookDataBaseFX.*;
import Collection.WriterCollection;
import CrossValidationProcess.CrossValidation;
import CrossValidationProcess.TestingSet;
import CrossValidationProcess.TrainingSet;
import FilePackage.DateTimeWriter;
import JavFX.Main;
import JavFX.ProcessAnalysis;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import RecommendationAlgorithm.PageRankAlgorithm;
import RecommendationAlgorithm.ProcessImplementation;
import LinearRegression.FourVariableRegression;
import UserInterfacePackage.AddBook;
import UserInterfacePackage.LibraryDesk;
import UserInterfacePackage.RemoveBook;
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

public class BookInformationShow extends Application {

    TypesOfBook typesOfBook = new TypesOfBook();
    DemandsOfBook demandsOfBook = new DemandsOfBook();
    GenericsOfBook genericsOfBook = new GenericsOfBook();
    ClassesOfBook classesOfBook = new ClassesOfBook();

    BorrowCountOfBook borrowCountOfBook = new BorrowCountOfBook();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(26);
        Font font1 = new Font(47);
        Font font2 = new Font( 23);
        Button typesOfBook = new Button("Types Of Book");
        Button demandsOfBook = new Button("Demands Of Book");
        Button genericsOfBook = new Button("Generics Of Book");
        Button classesOfBooks = new Button("Classes of Books");
        Button borrowCountOfBook = new Button("Borrow Count Of Book");
        Button numberDisplay = new Button("Number Display");

        typesOfBook.setPrefSize(370,110);
        demandsOfBook.setPrefSize(370,110);
        genericsOfBook.setPrefSize(370,110);
        classesOfBooks.setPrefSize(370,110);
        borrowCountOfBook.setPrefSize(370,110);
        numberDisplay.setPrefSize(370,110);
        typesOfBook.setFont(font2);
        demandsOfBook.setFont(font2);
        genericsOfBook.setFont(font2);
        classesOfBooks.setFont(font2);
        borrowCountOfBook.setFont(font2);
        numberDisplay.setFont(font2);

        typesOfBook.setTranslateX(30);
        typesOfBook.setTranslateY(35);
        demandsOfBook.setTranslateX(30);
        demandsOfBook.setTranslateY(150);
        genericsOfBook.setTranslateX(30);
        genericsOfBook.setTranslateY(265);
        classesOfBooks.setTranslateX(30);
        classesOfBooks.setTranslateY(380);
        borrowCountOfBook.setTranslateX(30);
        borrowCountOfBook.setTranslateY(495);
        numberDisplay.setTranslateX(30);
        numberDisplay.setTranslateY(610);
        typesOfBook.setContentDisplay(ContentDisplay.LEFT);
        demandsOfBook.setContentDisplay(ContentDisplay.LEFT);
        genericsOfBook.setContentDisplay(ContentDisplay.LEFT);
        classesOfBooks.setContentDisplay(ContentDisplay.LEFT);
        borrowCountOfBook.setContentDisplay(ContentDisplay.LEFT);
        numberDisplay.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"types.png");
        Image image1 = new Image(fileInputStream1);
        typesOfBook.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"types.png");
        Image image2 = new Image(fileInputStream2);
        demandsOfBook.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"time.png");
        Image image3 = new Image(fileInputStream3);
      genericsOfBook.setGraphic(new ImageView(image3));

        FileInputStream fileInputStream4 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"time.png");
        Image image4 = new Image(fileInputStream4);
        classesOfBooks.setGraphic(new ImageView(image4));

        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"display.png");
        Image image5 = new Image(fileInputStream5);
        borrowCountOfBook.setGraphic(new ImageView(image5));

        FileInputStream fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"display.png");
        Image image6 = new Image(fileInputStream6);
        numberDisplay.setGraphic(new ImageView(image6));

        typesOfBook.setOnAction(actionEvent -> {
            try {
                this.typesOfBook.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        genericsOfBook.setOnAction(actionEvent -> {
            try {
                this.genericsOfBook.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        demandsOfBook.setOnAction(actionEvent -> {
            try {
                this.demandsOfBook.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        classesOfBooks.setOnAction(actionEvent -> {
            try {
                classesOfBook.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        borrowCountOfBook.setOnAction(actionEvent -> {
            try {
                this.borrowCountOfBook.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        numberDisplay.setOnAction(actionEvent -> {
            BookNumberDisplay bookNumberDisplay = new BookNumberDisplay();
            try {
                bookNumberDisplay.start(primaryStage);
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
        FileInputStream fileInputStream7 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"exit.png");
        Image image7 = new Image(fileInputStream7);
        exit.setGraphic(new ImageView(image7));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font2);
        Text text = new Text("System/Process");
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
        FileInputStream fileInputStream8 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"home.png");
        Image image8 = new Image(fileInputStream8);
        home.setGraphic(new ImageView(image8));
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
        FileInputStream fileInputStream9 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"back.png");
        Image image9 = new Image(fileInputStream9);
        back.setGraphic(new ImageView(image9));
        back.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();

            try {
                libraryDesk.start(primaryStage);
            } catch (Exception exception) {
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
        group.getChildren().addAll(canvas,typesOfBook,
                demandsOfBook,exit,back,home,text,genericsOfBook,classesOfBooks,borrowCountOfBook,numberDisplay);
        ReadingRoom readingRoom2 = new ReadingRoom();
        LibraryDesk libraryDesk2 = new LibraryDesk();
        CrossValidation crossValidation2 = new CrossValidation();
        SevenValueStatistics sevenValueStatistics1 = new SevenValueStatistics();
        WriterCollection writerCollection = new WriterCollection();
        FourVariableRegression fourVariableRegression1 = new FourVariableRegression();
        AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm1 = new AnalyticHierarchyAlgorithm();
        PageRankAlgorithm pageRankAlgorithm1 = new PageRankAlgorithm();
        AddBook addBook = new AddBook();
        RemoveBook removeBook = new RemoveBook();
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
                addBook.start(primaryStage);
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
                removeBook.start(primaryStage);
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
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public Button setStyle( Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }

    public Label setStyle1(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: #00FFFF \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 0.6em;");
        return  label;
    }
}
