package ProjectDescription;

import FilePackage.DateTimeWriter;
import JavFX.Main;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class About extends Application {
        @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
            Font font5 =Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(50);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });

            Font font3= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);
            back.setFont(font3);
            exit.setFont(font3);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Button staticShowing = new Button("Static Showing");
        Button dynamicShowing = new Button("Dynamic Showing");
        Button projectDesign = new Button("Project Design");
        staticShowing.setTranslateX(500);
        staticShowing.setTranslateY(175);
        dynamicShowing.setTranslateX(500);
        dynamicShowing.setTranslateY(275);
        projectDesign.setTranslateX(500);
        projectDesign.setTranslateY(375);
        staticShowing.setOnAction(actionEvent -> {
            StaticStage staticStage = new StaticStage();
            try {
                staticStage.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        dynamicShowing.setOnAction(actionEvent -> {
            DynamicStage dynamicStage = new DynamicStage();
            try {
                dynamicStage.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        projectDesign.setOnAction(actionEvent -> {
            StaticStage staticStage = new StaticStage();
            try {
                staticStage.projectUML(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        staticShowing.setPrefSize(350, 80);
        dynamicShowing.setPrefSize(350, 80);
        projectDesign.setPrefSize(350, 80);
        staticShowing.setFont(font5);
        dynamicShowing.setFont(font5);
        projectDesign.setFont(font5);

        Image image = new Image("Images"+ File.separator +"libraryBackground.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,staticShowing,dynamicShowing,projectDesign);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
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
