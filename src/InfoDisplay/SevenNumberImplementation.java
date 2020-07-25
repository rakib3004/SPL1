package InfoDisplay;

import CrossValidationProcess.CrossValidation;
import FilePackage.DateTimeWriter;
import JavFX.AuthorSystem;
import JavFX.Main;
import LibraryFunctionality.ReadingRoom;
import VisualRepresentation.ScatterChart;
import VisualRepresentation.LineChart;
import VisualRepresentation.StackedArea;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SevenNumberImplementation extends Application {

ScatterChart scatterChart = new ScatterChart();
LineChart lineChart = new LineChart();
StackedArea stackedArea = new StackedArea();
    @Override
    public void start(Stage typeStatisticsStage) {
    }
    public void typeStatistics(Stage typeStatisticsStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");
        
    /*    Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, 8);
        Font font1 = Font.font("Times New Roman", FontPosture.ITALIC, 18);

        //  Button Start = new Button("Start");
        Button back = new Button("Back");
        Button exit = new Button("Exit");

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        scatterChart.setTranslateX(500);
        scatterChart.setTranslateY(200);
        lineChart.setTranslateX(500);
        lineChart.setTranslateY(300);
        stackedAreaChart.setTranslateX(500);
        stackedAreaChart.setTranslateY(400);

        back.setOnAction(actionEvent -> {
SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(typeStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTyping(typeStatisticsStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTyping(typeStatisticsStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTyping(typeStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        setStyle(exit);
        setStyle(back);

        setStyle(lineChart);
        setStyle(scatterChart);

        setStyle(stackedAreaChart);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        lineChart.setPrefSize(275, 80);
        scatterChart.setPrefSize(275, 80);

        stackedAreaChart.setPrefSize(275, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground3.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,scatterChart,lineChart,stackedAreaChart);
*/

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);
        Button crossValidationAnalysis = new Button("Cross Validation Analysis");
        Button sevenValueStatistics = new Button("Seven Value Statistics");
        Button dataOptimization = new Button("Data Optimization");

        crossValidationAnalysis.setPrefSize(410,230);
        sevenValueStatistics.setPrefSize(410,230);
        dataOptimization.setPrefSize(410,230);

        crossValidationAnalysis.setFont(font);
        sevenValueStatistics.setFont(font);
        dataOptimization.setFont(font2);
        crossValidationAnalysis.setTranslateX(30);
        crossValidationAnalysis.setTranslateY(35);
        sevenValueStatistics.setTranslateX(30);
        sevenValueStatistics.setTranslateY(270);
        dataOptimization.setTranslateX(30);
        dataOptimization.setTranslateY(505);

        crossValidationAnalysis.setContentDisplay(ContentDisplay.TOP);
        sevenValueStatistics.setContentDisplay(ContentDisplay.TOP);
        dataOptimization.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"cross.png");
        Image image1 = new Image(fileInputStream1);
        crossValidationAnalysis.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"7value.png");
        Image image2 = new Image(fileInputStream2);
        sevenValueStatistics.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"optimization.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        dataOptimization.setGraphic(new ImageView(image3));

        crossValidationAnalysis.setOnAction(actionEvent -> {
            try {
                CrossValidation crossValidation = new CrossValidation();
                crossValidation.start(typeStatisticsStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        sevenValueStatistics.setOnAction(actionEvent -> {
            SevenValueStatistics bookApplication = new SevenValueStatistics();
            try {
                bookApplication.start(typeStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        dataOptimization.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(typeStatisticsStage);
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
                "src"+ File.separator +"Images"+ File.separator +"exit.png");
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
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"home.png");
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(typeStatisticsStage);
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
        FileInputStream fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"back.png");
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(typeStatisticsStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background,0,0);
        Group group = new Group();
        group.getChildren().addAll(canvas,crossValidationAnalysis,
                sevenValueStatistics,
                dataOptimization,exit,home,text,back);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);

        typeStatisticsStage.setScene(scene1);
        typeStatisticsStage.setTitle("Books Statistics");
        typeStatisticsStage.setFullScreen(true);
        typeStatisticsStage.show();
    }

    public void timeStatistics(Stage timeStatisticsStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        scatterChart.setTranslateX(500);
        scatterChart.setTranslateY(200);
        lineChart.setTranslateX(500);
        lineChart.setTranslateY(300);

        stackedAreaChart.setTranslateX(500);
        stackedAreaChart.setTranslateY(400);


        back.setOnAction(actionEvent -> {
            SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(timeStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTiming(timeStatisticsStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTiming(timeStatisticsStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTiming(timeStatisticsStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(exit);
        setStyle(back);

        setStyle(lineChart);
        setStyle(scatterChart);

        setStyle(stackedAreaChart);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        lineChart.setPrefSize(275, 80);
        scatterChart.setPrefSize(275, 80);

        stackedAreaChart.setPrefSize(275, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground20.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,scatterChart,lineChart,stackedAreaChart);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);

        timeStatisticsStage.setScene(scene1);
        timeStatisticsStage.setTitle("Books Statistics");
        timeStatisticsStage.setFullScreen(true);
        timeStatisticsStage.show();
    }

    public void borrowStatistics(Stage borrowStatisticsStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        scatterChart.setTranslateX(500);
        scatterChart.setTranslateY(200);
        lineChart.setTranslateX(500);
        lineChart.setTranslateY(300);
        stackedAreaChart.setTranslateX(500);
        stackedAreaChart.setTranslateY(400);
        back.setOnAction(actionEvent -> {
            SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(borrowStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startBorrowing(borrowStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startBorrowing(borrowStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startBorrowing(borrowStatisticsStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        setStyle(exit);
        setStyle(back);
        setStyle(lineChart);
        setStyle(scatterChart);
        setStyle(stackedAreaChart);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        lineChart.setPrefSize(275, 80);
        scatterChart.setPrefSize(275, 80);

        stackedAreaChart.setPrefSize(275, 80);
        Image image = new Image("Images"+ File.separator +"libraryBackground21.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,scatterChart,lineChart,stackedAreaChart);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
        borrowStatisticsStage.setScene(scene1);
        borrowStatisticsStage.setTitle("Books Statistics");
        borrowStatisticsStage.setFullScreen(true);
        borrowStatisticsStage.show();
    }
     public void priceStatistics(Stage priceStatisticsStage) {

         String  className = this.getClass().getSimpleName();
         DateTimeWriter dateTimeWriter =  new DateTimeWriter();
         dateTimeWriter.dateTimeWriterMethods(className);

         Button back = new Button("Back");
         Button exit = new Button("Exit");
         Button scatterChart = new Button("Scatter Chart");
         Button lineChart = new Button("Line Chart");
         Button stackedAreaChart = new Button("Stacked Area Chart");
         back.setTranslateX(0);
         back.setTranslateY(650);
         exit.setTranslateX(1100);
         exit.setTranslateY(650);

         scatterChart.setTranslateX(500);
         scatterChart.setTranslateY(200);
         lineChart.setTranslateX(500);
         lineChart.setTranslateY(300);
         stackedAreaChart.setTranslateX(500);
         stackedAreaChart.setTranslateY(400);
         back.setOnAction(actionEvent -> {
             SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
             try {
                 sevenValueStatistics.start(priceStatisticsStage);
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });
         exit.setOnAction(actionEvent -> {
             System.exit(0);
         });
         scatterChart.setOnAction(actionEvent -> {
             try {
                 this.scatterChart.startPricing(priceStatisticsStage);
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });
         stackedAreaChart.setOnAction(actionEvent -> {
             try {
                 stackedArea.startPricing(priceStatisticsStage);
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });
         lineChart.setOnAction(actionEvent -> {
             try {
                 this.lineChart.startPricing(priceStatisticsStage);
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });
         setStyle(exit);
         setStyle(back);
         setStyle(lineChart);
         setStyle(scatterChart);
         setStyle(stackedAreaChart);
         back.setPrefSize(200, 80);
         exit.setPrefSize(200, 80);
         lineChart.setPrefSize(275, 80);
         scatterChart.setPrefSize(275, 80);
         stackedAreaChart.setPrefSize(275, 80);

         Image image = new Image("Images"+ File.separator +"libraryBackground17.jpg");
         Canvas canvas = new Canvas(1500,950);
         Group group = new Group();
         group.getChildren().addAll(canvas,exit,back,scatterChart,lineChart,stackedAreaChart);
         GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
         graphicsContext.drawImage(image,0,0);
         Scene scene1 = new Scene(group,1500,950);

         priceStatisticsStage.setScene(scene1);
         priceStatisticsStage.setTitle("Books Statistics");
         priceStatisticsStage.setFullScreen(true);
         priceStatisticsStage.show();
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
    public MenuButton setStyle(MenuButton menuButton)
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
