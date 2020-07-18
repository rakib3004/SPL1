package BookDataBaseFX;

import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationFX;
import VisualRepresentation.InfoBarChart;
import VisualRepresentation.InfoPieChart;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class ClassesOfBook extends Application {


    InfoBarChart infoBarChart = new InfoBarChart();
    InfoPieChart infoPieChart = new InfoPieChart();

    @Override
    public void start(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button barChart = new Button("Bar Chart");
        Button pieChart = new Button("Pie Chart");

        //  add all button position
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        barChart.setTranslateX(500);
        barChart.setTranslateY(200);
        pieChart.setTranslateX(500);
        pieChart.setTranslateY(300);
// add all 4  buttons in action event
        back.setOnAction(actionEvent -> {
            BookInformationFX bookInformationFX = new BookInformationFX();
            try {
                bookInformationFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        barChart.setOnAction(actionEvent -> {
            try {
                infoBarChart.startClassBook(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        pieChart.setOnAction(actionEvent -> {
            try {
                infoPieChart.startClassBook(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        setStyle(exit);
        setStyle(back);
        setStyle(barChart);
        setStyle(pieChart);
// add buttons size
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        barChart.setPrefSize(200, 80);
        pieChart.setPrefSize(200, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground9.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,barChart,pieChart);

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
        return  button;
    }

}
