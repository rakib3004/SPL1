package InfoDisplay;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.AuthorSystem;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
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

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BookNumberDisplay extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int typeCounter = 6, writerCounter = 350, yearCounter = 12;
    int typePalse, writerPalse, yearPalse;
    int timeSec = 1;
    int bookCounter = 0;
    Timeline time = new Timeline();

    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    @Override
    public void start(Stage primaryStage) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Font font1 = Font.font("Times New Roman", FontPosture.REGULAR, 5);

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        try {
            numberOfBooks = bookNumber.bookNumberFindingMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Label BookNumbers = new Label((numberOfBooks) + " Books");
        BookNumbers.setAlignment(Pos.CENTER);
        BookNumbers.setFont(font1);
        BookNumbers.setPrefSize(110, 80);
        BookNumbers.setTextAlignment(TextAlignment.CENTER);
        BookNumbers.setTranslateX(200);
        BookNumbers.setTranslateY(30);
        BookNumbers.setTextFill(Color.WHITE);
        BookNumbers.setScaleX(6);
        BookNumbers.setScaleY(3.4);

        Label WriterNumbers = new Label((writerCounter) + " Writers ");
        WriterNumbers.setAlignment(Pos.CENTER);
        WriterNumbers.setPrefSize(110, 80);
        WriterNumbers.setTextAlignment(TextAlignment.CENTER);
        WriterNumbers.setFont(font1);
        WriterNumbers.setTranslateX(500);
        WriterNumbers.setTranslateY(30);
        WriterNumbers.setTextFill(Color.WHITE);
        WriterNumbers.setScaleX(6);
        WriterNumbers.setScaleY(3.4);

        Label YearsNumbers = new Label((yearCounter) + " Years ");
        YearsNumbers.setAlignment(Pos.CENTER);
        YearsNumbers.setPrefSize(110, 80);
        YearsNumbers.setTextAlignment(TextAlignment.CENTER);
        YearsNumbers.setFont(font1);
        YearsNumbers.setTranslateX(200);
        YearsNumbers.setTranslateY(130);
        YearsNumbers.setTextFill(Color.WHITE);
        YearsNumbers.setScaleX(6);
        YearsNumbers.setScaleY(3.4);
        Label TypeNumbers = new Label((typeCounter) + " types");
        TypeNumbers.setAlignment(Pos.CENTER);
        TypeNumbers.setFont(font1);
        TypeNumbers.setTextAlignment(TextAlignment.CENTER);
        TypeNumbers.setPrefSize(110, 80);
        TypeNumbers.setTranslateX(500);
        TypeNumbers.setTranslateY(130);
        TypeNumbers.setTextFill(Color.WHITE);
        TypeNumbers.setScaleX(6);
        TypeNumbers.setScaleY(3.4);
        Group semiGroup = new Group();

        semiGroup.getChildren().addAll(BookNumbers, WriterNumbers, YearsNumbers, TypeNumbers);
        Image image = new Image("Images"+ File.separator +"numberDisplay.JPG");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back, semiGroup);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

}
