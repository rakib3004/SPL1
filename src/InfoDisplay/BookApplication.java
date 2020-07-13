package InfoDisplay;

import FilePackage.DateTimeWriter;
import SimpleRegression.DoublyLinearRegression;
import JavFX.AuthorSystem;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class BookApplication extends Application {
   PriorityData[] priorityData;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    DoublyLinearRegression doublyLinearRegression = new DoublyLinearRegression();
UIDisplayFX uiDisplayFX = new UIDisplayFX();
    @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, 8);
        Font font1 = Font.font("Times New Roman", FontPosture.ITALIC, 18);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button typeBased = new Button("Type Based");
        Button timeBased = new Button("Time Based");
        Button borrowBased = new Button("Borrow Based");
        Button priceBased = new Button("Price Based");

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        
        typeBased.setTranslateX(500);
        typeBased.setTranslateY(200);
        timeBased.setTranslateX(500);
        timeBased.setTranslateY(300);

        borrowBased.setTranslateX(500);
        borrowBased.setTranslateY(400);
        priceBased.setTranslateX(500);
        priceBased.setTranslateY(500);

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
                typeBased.setOnAction(actionEvent -> {
                            try {
                uiDisplayFX.typeStatistics(primaryStage);

                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        });
                        borrowBased.setOnAction(actionEvent -> {
                            try {
                                uiDisplayFX.borrowStatistics(primaryStage);

                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        });

                timeBased.setOnAction(actionEvent -> {
                    try {
                        uiDisplayFX.timeStatistics(primaryStage);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                });
        priceBased.setOnAction(actionEvent -> {
            try {
                uiDisplayFX.priceStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        setStyle(exit);
        setStyle(back);

       setStyle(timeBased);
        setStyle(typeBased);

       setStyle(borrowBased);
        setStyle(priceBased);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

         timeBased.setPrefSize(200, 80);
        typeBased.setPrefSize(200, 80);
         priceBased.setPrefSize(200, 80);
        borrowBased.setPrefSize(200, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground13.jpg");
       Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,typeBased,timeBased,priceBased,borrowBased);

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
    public MenuButton setStyle( MenuButton menuButton)
    {
        menuButton.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        return  menuButton;
    }
}
