package RankingAlgorithmFx;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import TableViewPackage.AHP_TableViewFX;
import TableViewPackage.PRA_TableViewFX;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AnalyticHierarchyAlgorithmFx extends Application {
    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();

    @Override
    public void start(Stage primaryStage) throws IOException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button tableView = new Button("Table View");
        tableView.setTranslateX(550);
        tableView.setTranslateY(300);
        tableView.setOnAction(actionEvent -> {
            AHP_TableViewFX ahpTableViewFX = new AHP_TableViewFX();
            try {

                ahpTableViewFX.start(primaryStage);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        setStyle(tableView);
        tableView.setPrefSize(200,80);




        Button consoleView = new Button("Console View");

        consoleView.setTranslateX(550);
        consoleView.setTranslateY(400);
        consoleView.setOnAction(actionEvent -> {

            try {

                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
                ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);

                ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,
                        priorityData,numberOfBooks);

                System.exit(0);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        consoleView.setPrefSize(200, 80);
        setStyle(consoleView);






        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            StatisticsFX statisticsFX = new StatisticsFX();

            try {
                statisticsFX.start(primaryStage);
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

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);



        Image image = new Image("libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,consoleView,exit,back,tableView);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
      /*  HBox hBox = new HBox();
        hBox.getChildren().addAll(exit,menu,back);

    //    hBox.setSpacing(60);*/



      /*  VBox vBox3 = new VBox();
        vBox3.getChildren().addAll(vBox2,group);

        vBox3.setMaxSize(850, 650);
        vBox3.setSpacing(5);*/

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
}
