package RankingAlgorithmFx;

import FilePackage.DateTimeWriter;
import JavFX.AuthorSystem;
import RegressionFx.MultiVaribleRegressionFX;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class StatisticsFX extends Application {


    @Override
    public void start(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button multiVariableRegression = new Button("MultiVariable Regression");
        Button analyticHierarchy = new Button("Analytic Hierarchy Process");
        Button pageRankAlgorithm = new Button("Page Rank Algorithm");
        multiVariableRegression.setTranslateX(140);
        multiVariableRegression.setTranslateY(150);
        analyticHierarchy.setTranslateX(500);
        analyticHierarchy.setTranslateY(150);
        pageRankAlgorithm.setTranslateX(860);
        pageRankAlgorithm.setTranslateY(150);

        multiVariableRegression.setOnAction(actionEvent -> {

            MultiVaribleRegressionFX multiVaribleRegressionFX = new MultiVaribleRegressionFX();
            try {

                multiVaribleRegressionFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        analyticHierarchy.setOnAction(actionEvent -> {
AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();
        try {
                analyticHierarchyAlgorithmFx.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });


        pageRankAlgorithm.setOnAction(actionEvent -> {

PageRankAlgorithmFx pageRankAlgorithmFx = new PageRankAlgorithmFx();

try {
                pageRankAlgorithmFx.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        setStyle(multiVariableRegression);
        setStyle(analyticHierarchy);
        setStyle(pageRankAlgorithm);


        multiVariableRegression.setPrefSize(350, 80);
        analyticHierarchy.setPrefSize(350, 80);
        pageRankAlgorithm.setPrefSize(350, 80);


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
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

        setStyle(exit);
        setStyle(back);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Image image = new Image("Images"+ File.separator +"libraryBackground4.jpg");
        Canvas canvas = new Canvas(1400,800);
        Group group = new Group();
        group.getChildren().addAll(canvas,multiVariableRegression,pageRankAlgorithm,
                analyticHierarchy,exit,back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1400,800);
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
