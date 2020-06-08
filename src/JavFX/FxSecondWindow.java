package JavFX;

import FilePackage.DateTimeWriter;
import ProjectDescription.About;
import UserInterfacePackage.ChooseType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.Group;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.util.Scanner;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class FxSecondWindow extends Application {


    @Override
    public void start(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);


        Button adminSection = new Button("Admin Section");
        Button userSection = new Button("User Section");
        Button about = new Button("About");
        Button back = new Button("Back");
        Button exit = new Button("Exit");



        userSection.setTranslateX(530);
        userSection.setTranslateY(200);
        adminSection.setTranslateX(530);
        adminSection.setTranslateY(300);
        about.setTranslateX(530);
        about.setTranslateY(400);

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);


        adminSection.setOnAction(actionEvent -> {

            MenuFX menuFX = new MenuFX();
            try {
                menuFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

            userSection.setOnAction(actionEvent -> {

            ChooseType chooseType = new ChooseType();
            try {
                chooseType.start(primaryStage);
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
FxMainClass fxMainClass = new FxMainClass();
            try {
                fxMainClass.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        setStyle(adminSection);
        setStyle(userSection);
        setStyle(exit);
        setStyle(back);
        setStyle(about);

        adminSection.setPrefSize(280, 80);
        userSection.setPrefSize(280, 80);
        about.setPrefSize(280,80);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);


        Image image = new Image("libraryBackground2.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,adminSection,exit,
                back,userSection,about);

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
}
