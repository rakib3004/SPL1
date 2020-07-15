package JavFX;

import FilePackage.DateTimeWriter;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import UserInterfacePackage.LibraryDesk;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class FXThirdWindow extends Application {


    @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button authorsMood = new Button("Authors Mood");
        Button librarianMood = new Button("Librarian Mood");
        Button systemAnalysis = new Button("System Analysis");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        librarianMood.setTranslateX(200);
        librarianMood.setTranslateY(50);
        authorsMood.setTranslateX(530);
        authorsMood.setTranslateY(50);
        systemAnalysis.setTranslateX(860);
        systemAnalysis.setTranslateY(50);

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        authorsMood.setOnAction(actionEvent -> {

            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        librarianMood.setOnAction(actionEvent -> {

            LibraryDesk libraryDesk = new LibraryDesk();
            try {
                libraryDesk.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        systemAnalysis.setOnAction(actionEvent -> {
            SystemAnalysis systemAnalysis1 = new SystemAnalysis();
            try {
                systemAnalysis1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        back.setOnAction(actionEvent -> {
            FxSecondWindow fxSecondWindow = new FxSecondWindow();
            try {
                fxSecondWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setStyle(authorsMood);
        setStyle(librarianMood);
        setStyle(exit);
        setStyle(back);
        setStyle(systemAnalysis);
        authorsMood.setPrefSize(320, 80);
        librarianMood.setPrefSize(320, 80);
        systemAnalysis.setPrefSize(320,80);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);


        Image image = new Image("Images"+ File.separator +"libraryBackground2.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,authorsMood,exit,
                back,librarianMood,systemAnalysis);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
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
                "        -fx-font-size: 1.5em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return button;
    }
}
