package InfoDisplay;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import BookDataBaseFX.*;
import FilePackage.DateTimeWriter;
import JavFX.MenuFX;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import UserInterfacePackage.LibraryDesk;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class BookInformationFX extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int typeCounter=6,writerCounter=350, yearCounter =12;
    int typePalse,writerPalse,yearPalse;
    int timeSec = 1;
 int bookCounter=0;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    Timeline time = new Timeline();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();

    TypesOfBookFX typesOfBookFX = new TypesOfBookFX();
    DemandsOfBookFX demandsOfBookFX = new DemandsOfBookFX();
    GenericsOfBookFX genericsOfBookFX = new GenericsOfBookFX();
    ClassesOfBookFX classesOfBookFX = new ClassesOfBookFX();

    BorrrowCountOfBookFX borrrowCountOfBookFX = new BorrrowCountOfBookFX();

    @Override
    public void start(Stage primaryStage) {


        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        UIDisplayFX uiDisplayFX = new UIDisplayFX();

        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, 8);
        Font font1 = Font.font("Times New Roman", FontPosture.ITALIC, 18);




        //  Button Start = new Button("Start");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button typesOfBook = new Button("Types Of Book");
        Button demandsOfBook = new Button("Demands Of Book");
        Button genericsOfBook = new Button("Generics Of Book");
        Button classesOfBooks = new Button("Classes of Books");
        Button borrowCountOfBook = new Button("Borrow Count Of Book");
        Button numberDisplay = new Button("Number Display");



        //  Start.setTranslateX(500);
        //  Start.setTranslateY(400);


        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        typesOfBook.setTranslateX(500);
        typesOfBook.setTranslateY(100);
        demandsOfBook.setTranslateX(500);
        demandsOfBook.setTranslateY(200);

        genericsOfBook.setTranslateX(500);
        genericsOfBook.setTranslateY(300);
        classesOfBooks.setTranslateX(500);
        classesOfBooks.setTranslateY(400);

        borrowCountOfBook.setTranslateX(500);
        borrowCountOfBook.setTranslateY(500);
        numberDisplay.setTranslateX(500);
        numberDisplay.setTranslateY(600);



        back.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();

            try {

                libraryDesk.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        typesOfBook.setOnAction(actionEvent -> {
            try {
        typesOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        genericsOfBook.setOnAction(actionEvent -> {
            try {
   genericsOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });


        demandsOfBook.setOnAction(actionEvent -> {
            try {
demandsOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        classesOfBooks.setOnAction(actionEvent -> {
            try {
classesOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });


 borrowCountOfBook.setOnAction(actionEvent -> {
            try {
borrrowCountOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        numberDisplay.setOnAction(actionEvent -> {
            BookNumberDisplayFX bookNumberDisplayFX = new BookNumberDisplayFX();
            try {
                bookNumberDisplayFX.start(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        //    setStyle(Start);
        setStyle(exit);
        setStyle(back);

        setStyle(demandsOfBook);
        setStyle(typesOfBook);

        setStyle(genericsOfBook);
        setStyle(classesOfBooks);

        setStyle(borrowCountOfBook);
        setStyle(numberDisplay);

        //  Start.setPrefSize(200, 80);
        back.setPrefSize(270, 80);
        exit.setPrefSize(270, 80);

        demandsOfBook.setPrefSize(333, 80);
        typesOfBook.setPrefSize(333, 80);

        classesOfBooks.setPrefSize(333, 80);
        genericsOfBook.setPrefSize(333, 80);

         borrowCountOfBook.setPrefSize(333, 80);
        numberDisplay.setPrefSize(333, 80);



        Image image = new Image("libraryBackground13.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,typesOfBook);
        group.getChildren().addAll(demandsOfBook,classesOfBooks,genericsOfBook);
        group.getChildren().addAll(borrowCountOfBook,numberDisplay);


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

    public Label setStyle2(Label label)
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

    public Label setStyle3(Label label)
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

    public Label setStyle4(Label label)
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
