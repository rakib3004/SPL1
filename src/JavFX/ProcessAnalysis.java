package JavFX;

import CombinedChartView.CombinedLineChart;
import CrossValidationProcess.*;
import FilePackage.DateTimeWriter;
import InfoDisplay.SevenValueStatistics;
import LibraryFunctionality.ReadingRoom;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProcessAnalysis extends Application {
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(26);
        Button crossValidationAnalysis = new Button("Cross Validation Analysis");
        Button sevenValueStatistics = new Button("Seven Value Statistics");
        Button methodsComparison = new Button("Methods Comparison");

        crossValidationAnalysis.setPrefSize(410, 230);
        sevenValueStatistics.setPrefSize(410, 230);
        methodsComparison.setPrefSize(410, 230);

        crossValidationAnalysis.setFont(font);
        sevenValueStatistics.setFont(font);
        methodsComparison.setFont(font2);
        crossValidationAnalysis.setTranslateX(30);
        crossValidationAnalysis.setTranslateY(35);
        sevenValueStatistics.setTranslateX(30);
        sevenValueStatistics.setTranslateY(270);
        methodsComparison.setTranslateX(30);
        methodsComparison.setTranslateY(505);

        crossValidationAnalysis.setContentDisplay(ContentDisplay.TOP);
        sevenValueStatistics.setContentDisplay(ContentDisplay.TOP);
        methodsComparison.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "cross.png");
        Image image1 = new Image(fileInputStream1);
        crossValidationAnalysis.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "7value.png");
        Image image2 = new Image(fileInputStream2);
        sevenValueStatistics.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "algorithm.png");
        Image image3 = new Image(fileInputStream3);
        methodsComparison.setGraphic(new ImageView(image3));

        crossValidationAnalysis.setOnAction(actionEvent -> {
            try {
                CrossValidation crossValidation = new CrossValidation();
                crossValidation.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        sevenValueStatistics.setOnAction(actionEvent -> {
            SevenValueStatistics bookApplication = new SevenValueStatistics();
            try {
                bookApplication.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        methodsComparison.setOnAction(actionEvent -> {
            CombinedLineChart combinedLineChart = new CombinedLineChart();
            try {
                combinedLineChart.start(primaryStage, 0);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "exit.png");
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Process Analysis");
        text.setTranslateX(575);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375, 30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "home.png");
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375, 30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = new FileInputStream(
                "src" + File.separator + "Images" + File.separator + "back.png");
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Image background = new Image("Images" + File.separator + "framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background, 0, 0);
        Group group = new Group();
        group.getChildren().addAll(canvas, crossValidationAnalysis,
                sevenValueStatistics,
                methodsComparison, exit, home, text, back);
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public Button setStyle(Button button) {
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
