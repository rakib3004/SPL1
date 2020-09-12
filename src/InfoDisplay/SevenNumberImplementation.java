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
    public void typeStatistics(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);


        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");

        scatterChart.setPrefSize(410,230);
        lineChart.setPrefSize(410,230);
        stackedAreaChart.setPrefSize(410,230);

        scatterChart.setFont(font2);
        lineChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(270);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(505);

        scatterChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatterChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        lineChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stackedAreaChart.setGraphic(new ImageView(image3));
        
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTyping(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTyping(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTyping(primaryStage);
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
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Type based Seven Value Analysis");
        text.setTranslateX(520);
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
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
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
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(primaryStage);
            } catch (Exception exception) {
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
        group.getChildren().addAll(canvas,scatterChart,
                lineChart,
                stackedAreaChart,exit,home,text,back);


        Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void timeStatistics(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");

        scatterChart.setPrefSize(410,230);
        lineChart.setPrefSize(410,230);
        stackedAreaChart.setPrefSize(410,230);

        scatterChart.setFont(font2);
        lineChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(270);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(505);

        scatterChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatterChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        lineChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stackedAreaChart.setGraphic(new ImageView(image3));
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startTiming(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startTiming(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startTiming(primaryStage);

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
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Time based Seven Value Analysis");
        text.setTranslateX(520);
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
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
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
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(primaryStage);
            } catch (Exception exception) {
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
        group.getChildren().addAll(canvas,scatterChart,
                lineChart,
                stackedAreaChart,exit,home,text,back);


        Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void borrowStatistics(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button scatterChart = new Button("Scatter Chart");
        Button lineChart = new Button("Line Chart");
        Button stackedAreaChart = new Button("Stacked Area Chart");

        scatterChart.setPrefSize(410,230);
        lineChart.setPrefSize(410,230);
        stackedAreaChart.setPrefSize(410,230);

        scatterChart.setFont(font2);
        lineChart.setFont(font2);
        stackedAreaChart.setFont(font2);
        scatterChart.setTranslateX(30);
        scatterChart.setTranslateY(35);
        lineChart.setTranslateX(30);
        lineChart.setTranslateY(270);
        stackedAreaChart.setTranslateX(30);
        stackedAreaChart.setTranslateY(505);

        scatterChart.setContentDisplay(ContentDisplay.TOP);
        lineChart.setContentDisplay(ContentDisplay.TOP);
        stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"scatter.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        scatterChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"line.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        lineChart.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"area.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        stackedAreaChart.setGraphic(new ImageView(image3));
        scatterChart.setOnAction(actionEvent -> {
            try {
                this.scatterChart.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        stackedAreaChart.setOnAction(actionEvent -> {
            try {
                stackedArea.startBorrowing(primaryStage);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        lineChart.setOnAction(actionEvent -> {
            try {
                this.lineChart.startBorrowing(primaryStage);

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
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Borrow based Seven Value Analysis");
        text.setTranslateX(520);
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
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
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
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src"+ File.separator +"Images"+ File.separator +"back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
            try {
                sevenValueStatistics.start(primaryStage);
            } catch (Exception exception) {
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
        group.getChildren().addAll(canvas,scatterChart,
                lineChart,
                stackedAreaChart,exit,home,text,back);


        Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
     public void priceStatistics(Stage primaryStage) {

         String  className = this.getClass().getSimpleName();
         DateTimeWriter dateTimeWriter =  new DateTimeWriter();
         dateTimeWriter.dateTimeWriterMethods(className);

         Font font = new Font(19);
         Font font1 = new Font(47);
         Font font2 = new Font( 26);

         Button scatterChart = new Button("Scatter Chart");
         Button lineChart = new Button("Line Chart");
         Button stackedAreaChart = new Button("Stacked Area Chart");

         scatterChart.setPrefSize(410,230);
         lineChart.setPrefSize(410,230);
         stackedAreaChart.setPrefSize(410,230);

         scatterChart.setFont(font2);
         lineChart.setFont(font2);
         stackedAreaChart.setFont(font2);
         scatterChart.setTranslateX(30);
         scatterChart.setTranslateY(35);
         lineChart.setTranslateX(30);
         lineChart.setTranslateY(270);
         stackedAreaChart.setTranslateX(30);
         stackedAreaChart.setTranslateY(505);

         scatterChart.setContentDisplay(ContentDisplay.TOP);
         lineChart.setContentDisplay(ContentDisplay.TOP);
         stackedAreaChart.setContentDisplay(ContentDisplay.TOP);
         FileInputStream fileInputStream1 = null;
         try {
             fileInputStream1 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"scatter.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image1 = new Image(fileInputStream1);
         scatterChart.setGraphic(new ImageView(image1));

         FileInputStream fileInputStream2 = null;
         try {
             fileInputStream2 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"line.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image2 = new Image(fileInputStream2);
         lineChart.setGraphic(new ImageView(image2));

         FileInputStream fileInputStream3 = null;
         try {
             fileInputStream3 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"area.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image3 = new Image(fileInputStream3);
         stackedAreaChart.setGraphic(new ImageView(image3));
         scatterChart.setOnAction(actionEvent -> {
             try {
                 this.scatterChart.startBorrowing(primaryStage);

             } catch (Exception exception) {
                 exception.printStackTrace();
             }

         });
         stackedAreaChart.setOnAction(actionEvent -> {
             try {
                 stackedArea.startBorrowing(primaryStage);

             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         });

         lineChart.setOnAction(actionEvent -> {
             try {
                 this.lineChart.startBorrowing(primaryStage);

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
         FileInputStream fileInputStream4 = null;
         try {
             fileInputStream4 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"exit.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image4 = new Image(fileInputStream4);
         exit.setGraphic(new ImageView(image4));
         exit.setPrefSize(120, 20);
         exit.setContentDisplay(ContentDisplay.LEFT);
         exit.setFont(font);
         Text text = new Text("Price based Seven Value Analysis");
         text.setTranslateX(520);
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
         FileInputStream fileInputStream5 = null;
         try {
             fileInputStream5 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"home.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image5 = new Image(fileInputStream5);
         home.setGraphic(new ImageView(image5));
         home.setOnAction(actionEvent -> {
             Main main = new Main();
             try {
                 main.start(primaryStage);
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
         FileInputStream fileInputStream6 = null;
         try {
             fileInputStream6 = new FileInputStream(
                     "src"+ File.separator +"Images"+ File.separator +"back.png");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Image image6 = new Image(fileInputStream6);
         back.setGraphic(new ImageView(image6));
         back.setOnAction(actionEvent -> {
             SevenValueStatistics sevenValueStatistics = new SevenValueStatistics();
             try {
                 sevenValueStatistics.start(primaryStage);
             } catch (Exception exception) {
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
         group.getChildren().addAll(canvas,scatterChart,
                 lineChart,
                 stackedAreaChart,exit,home,text,back);


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
