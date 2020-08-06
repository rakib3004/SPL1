package InfoDisplay;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.AuthorSystem;
import JavFX.Main;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BookNumberDisplay extends Application {

    int numberOfBooks;
    int typeCounter = 6, writerCounter = 350, yearCounter = 12;
    @Override
    public void start(Stage primaryStage) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 40);
        Font times_new_roman = Font.font("Times New Roman", FontPosture.REGULAR, 5);
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
        Text text = new Text("BOOK INFORMATION DISPLAY");
        text.setTranslateX(550);
        text.setTranslateY(500);
        text.setFont(font2);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
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
           BookInformationShow bookInformationShow = new BookInformationShow();
            try {
                bookInformationShow.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });

        Label BookNumbers = new Label("Total "+(numberOfBooks) + " Books");
        BookNumbers.setAlignment(Pos.CENTER);
        BookNumbers.setFont(times_new_roman);
        BookNumbers.setPrefSize(110, 80);
        BookNumbers.setTextAlignment(TextAlignment.CENTER);
        BookNumbers.setTranslateX(50);
        BookNumbers.setTranslateY(0);
        BookNumbers.setTextFill(Color.WHITE);
        BookNumbers.setScaleX(6);
        BookNumbers.setScaleY(3.4);

        Label WriterNumbers = new Label("No. of Writers : "+(writerCounter));
        WriterNumbers.setAlignment(Pos.CENTER);
        WriterNumbers.setPrefSize(110, 80);
        WriterNumbers.setTextAlignment(TextAlignment.CENTER);
        WriterNumbers.setFont(times_new_roman);
        WriterNumbers.setTranslateX(600);
        WriterNumbers.setTranslateY(0);
        WriterNumbers.setTextFill(Color.WHITE);
        WriterNumbers.setScaleX(6);
        WriterNumbers.setScaleY(3.4);

        Label YearsNumbers = new Label("Total "+(yearCounter) + " Years ");
        YearsNumbers.setAlignment(Pos.CENTER);
        YearsNumbers.setPrefSize(110, 80);
        YearsNumbers.setTextAlignment(TextAlignment.CENTER);
        YearsNumbers.setFont(times_new_roman);
        YearsNumbers.setTranslateX(50);
        YearsNumbers.setTranslateY(130);
        YearsNumbers.setTextFill(Color.WHITE);
        YearsNumbers.setScaleX(6);
        YearsNumbers.setScaleY(3.4);
        Label TypeNumbers = new Label(""+(typeCounter) + " different types Books");
        TypeNumbers.setAlignment(Pos.CENTER);
        TypeNumbers.setFont(times_new_roman);
        TypeNumbers.setTextAlignment(TextAlignment.CENTER);
        TypeNumbers.setPrefSize(110, 80);
        TypeNumbers.setTranslateX(600);
        TypeNumbers.setTranslateY(130);
        TypeNumbers.setTextFill(Color.WHITE);
        TypeNumbers.setScaleX(6);
        TypeNumbers.setScaleY(3.4);
        Group semiGroup = new Group();

        semiGroup.getChildren().addAll(BookNumbers, WriterNumbers, YearsNumbers, TypeNumbers);
        Image image = new Image("Images"+ File.separator +"numberDisplay.JPG");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back, semiGroup,text,home);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

}
