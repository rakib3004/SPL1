package RegressionFx;

import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import TableViewPackage.AHP_Chart_View;
import TableViewPackage.MLR_Chart_View;
import TableViewPackage.MLR_TableViewFX;
import MultiVariableRegression.MultipleLinearRegression;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
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

public class FourVariableRegression extends Application {
    PriorityData[] priorityData;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button consoleView = new Button("Console View");
        Button tableView = new Button("Table View");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        tableView.setTranslateX(860);
        tableView.setTranslateY(50);
        consoleView.setTranslateX(140);
        consoleView.setTranslateY(50);
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        tableView.setOnAction(actionEvent -> {
            try {

                MLR_TableViewFX MLRTableViewFX = new MLR_TableViewFX();

                MLRTableViewFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        consoleView.setOnAction(actionEvent -> {
            try {
                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
                priorityData =     multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
                System.exit(0);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        back.setOnAction(actionEvent -> {
            MultiVaribleRegressionFX multiVaribleRegressionFX = new MultiVaribleRegressionFX();
            try {
                multiVaribleRegressionFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        setStyle(tableView);
        setStyle(consoleView);
        setStyle(exit);
        setStyle(back);
        tableView.setPrefSize(350, 80);
        consoleView.setPrefSize(350, 80);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Button graphView = new Button("Graph View");
        graphView.setTranslateX(500);
        graphView.setTranslateY(50);
        graphView.setOnAction(actionEvent -> {
            MLR_Chart_View mlr_chart_view = new MLR_Chart_View();
            try {

                mlr_chart_view.start(primaryStage);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(graphView);
        graphView.setPrefSize(350,80);

        Image image = new Image("Images"+ File.separator +"libraryBackground22.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas,tableView,consoleView,graphView,exit,back);

        Button administrationMood = new Button("Administration Mood");
        Button readersMood = new Button("Readers Mood");
        Button about = new Button("About");

        readersMood.setTranslateX(20);
        readersMood.setTranslateY(260);
        administrationMood.setTranslateX(20);
        administrationMood.setTranslateY(320);
        about.setTranslateX(20);
        about.setTranslateY(380);


        administrationMood.setPrefSize(160, 30);
        readersMood.setPrefSize(160, 30);
        about.setPrefSize(160,30);

        administrationMood.setOnAction(actionEvent -> {

            FXThirdWindow fxThirdWindow = new FXThirdWindow();
            try {
                fxThirdWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        readersMood.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        about.setOnAction(actionEvent -> {
            About about1 = new About();
            try {
                about1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        group.getChildren().addAll(readersMood,administrationMood,about);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Scene scene1 = new Scene(group, 1500, 950);


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
