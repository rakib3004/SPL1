package JavFX;

import CombinedChartView.CombinedLineChart;
import CombinedChartView.CombinedScatterChart;
import CombinedChartView.CombinedStackedAreaChart;
import CrossValidationProcess.CombinedTrainingSet;
import CrossValidationProcess.CrossValidationFX;
import CrossValidationProcess.CrossValidationVisualization;
import FilePackage.DateTimeWriter;
import InfoDisplay.BookApplication;
import LibraryFunctionality.ReadingRoom;
import ProjectDescription.About;
import RankingAlgorithmFx.StatisticsFX;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SystemAnalysis extends Application {
        @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button processValueAreaChart = new Button("ProcessValue AreaChart");
        Button processValueLineArt = new Button("ProcessValue LineArt");
        Button processValuePlotting = new Button("ProcessValue Plotting");

        processValueAreaChart.setTranslateX(100);
        processValueAreaChart.setTranslateY(50);
        processValueLineArt.setTranslateX(460);
        processValueLineArt.setTranslateY(50);
        processValuePlotting.setTranslateX(820);
        processValuePlotting.setTranslateY(50);
        processValueAreaChart.setOnAction(actionEvent -> {
            CombinedStackedAreaChart combinedStackedAreaChart = new CombinedStackedAreaChart();
            try {
                combinedStackedAreaChart.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        processValueLineArt.setOnAction(actionEvent -> {
            CombinedLineChart crossValidationVisualization = new CombinedLineChart();
            try {
                crossValidationVisualization.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        processValuePlotting.setOnAction(actionEvent -> {
            CombinedScatterChart combinedScatterChart = new CombinedScatterChart();
            try {
                combinedScatterChart.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        setStyle(processValueAreaChart);
        setStyle(processValueLineArt);
        setStyle(processValuePlotting);
        processValueAreaChart.setPrefSize(350, 80);
        processValueLineArt.setPrefSize(350, 80);
        processValuePlotting.setPrefSize(350, 80);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            FXThirdWindow fxThirdWindow = new FXThirdWindow();
            try {
                fxThirdWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);

        });
        setStyle(exit);
        setStyle(back);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);


        Image image = new Image("Images"+ File.separator +"libraryBackground14.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,processValueAreaChart,
                processValueLineArt,
                processValuePlotting,exit,back);
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
