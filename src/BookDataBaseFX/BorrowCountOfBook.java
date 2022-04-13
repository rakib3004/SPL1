package BookDataBaseFX;

import FilePackage.DateTimeWriter;
import InfoDisplay.BookInformationShow;
import JavFX.Main;
import Layout.ButtonDesign;
import VisualRepresentation.AnalyticChart;
import VisualRepresentation.InfoBarChart;
import VisualRepresentation.InfoPieChart;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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

public class BorrowCountOfBook extends Application {

    @Override
    public void start(Stage primaryStage) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        ButtonDesign buttonDesign = new ButtonDesign();
        Font font = new Font(14);
        Font font1 = new Font(47);
        Font font2 = new Font(26);

        Button barChart = new Button("Bar Chart");
        Button pieChart = new Button("Pie Chart");
        Button analyticChart = new Button("Analytic Chart");
        InfoBarChart infoBarChartObject = new InfoBarChart();
        InfoPieChart infoPieChartObject = new InfoPieChart();
        AnalyticChart analyticChart1Object = new AnalyticChart();
        barChart.setOnAction(actionEvent -> {
            try {
                infoBarChartObject.startBorrowCount(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        pieChart.setOnAction(actionEvent -> {
            try {
                infoPieChartObject.startBorrowCount(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        analyticChart.setOnAction(actionEvent -> {
            try {
                analyticChart1Object.startBorrowCount(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        barChart.setContentDisplay(ContentDisplay.TOP);
        pieChart.setContentDisplay(ContentDisplay.TOP);
        analyticChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "bar.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        barChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "pie.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        pieChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "all.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        analyticChart.setGraphic(new ImageView(image3));

        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Borrow Count of Books");
        text.setTranslateX(666);
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
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            BookInformationShow bookInformationShow = new BookInformationShow();
            try {
                bookInformationShow.start(primaryStage);
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
        group.getChildren().addAll(canvas, barChart,
                pieChart, exit, back, home, text, analyticChart);
        Scene scene1 = new Scene(group, 1500, 950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
        barChart = buttonDesign.systemLine(barChart, 410, 230, 30, 35, 26);
        pieChart = buttonDesign.systemLine(pieChart, 410, 230, 30, 270, 26);
        analyticChart = buttonDesign.systemLine(analyticChart, 410, 230, 30, 505, 26);
        home = buttonDesign.systemLine(home, 410, 230, 30, 35, 26);
        back = buttonDesign.systemLine(back, 410, 230, 30, 270, 26);
        exit = buttonDesign.systemLine(exit, 410, 230, 30, 505, 26);

    }
}
