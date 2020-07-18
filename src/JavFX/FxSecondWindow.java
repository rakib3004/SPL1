package JavFX;

import FilePackage.DateTimeWriter;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class FxSecondWindow extends Application {


    @Override
    public void start(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button administrationMood = new Button("Administration Mood");
        Button readersMood = new Button("Readers Mood");
        Button about = new Button("About");
        Button back = new Button("Back");
        Button exit = new Button("Exit");

        int positionVariable=150;
        readersMood.setTranslateX(200);
        readersMood.setTranslateY(200-positionVariable);
        administrationMood.setTranslateX(530);
        administrationMood.setTranslateY(200-positionVariable);
        about.setTranslateX(860);
        about.setTranslateY(200-positionVariable);
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
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

        back.setOnAction(actionEvent -> {
Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setStyle(administrationMood);
        setStyle(readersMood);
        setStyle(exit);
        setStyle(back);
        setStyle(about);
        administrationMood.setPrefSize(320, 80);
        readersMood.setPrefSize(320, 80);
        about.setPrefSize(320,80);
       back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

       // Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,administrationMood,exit,
                back,readersMood,about);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
      //  graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
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
                "        -fx-font-size: 1.9em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return button;
    }
}
